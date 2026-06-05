package academia.dao;

import academia.pagamentos.PagamentoCartao;
import academia.pagamentos.PagamentoDinheiro;
import academia.pagamentos.PagamentoPix;
import academia.pagamentos.Pagavel;
import academia.pessoas.Aluno;
import academia.planos.Plano;
import academia.planos.PlanoAnual;
import academia.planos.PlanoMensal;
import academia.treino.Treino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AlunoDAO extends PessoaDAO{

    public boolean insertAluno(Aluno aluno){
        connectToDb();

        // VERIFICA CPF ANTES
        if (cpfExiste(aluno.getCpf())) {
            System.out.println("CPF já cadastrado: " + aluno.getCpf());
            return false;
        }

        // insere pessoa e pega o ID gerado
        int pessoaId = insertPessoa(aluno);

        if(pessoaId == -1) {
            return false;
        }

        String sql = "INSERT INTO Aluno(id, matricula, peso, altura, tipo_plano, tipo_pagamento, nome_treino) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pessoaId);
            pst.setInt(2, aluno.getMatricula());
            pst.setDouble(3, aluno.getPeso());
            pst.setDouble(4, aluno.getAltura());
            pst.setString(5, aluno.getPlano().getTipo());
            pst.setString(6, aluno.getPagamento().getTipo());
            pst.setString(7, aluno.getTreino().getNome());
            pst.execute();
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
            return false;

        } finally{
            // SEMPRE EXECUTA - libera recursos na ordem correta
            try{
                if (pst != null) pst.close();       // fecha statment primeiro
                if (connection != null) connection.close(); // depois fecha connection
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public boolean updateAluno(int id, Aluno aluno) {

        connectToDb();

        try {

            // 1 - atualiza pessoa
            String sqlPessoa = "UPDATE pessoa SET nome = ?, cpf = ?, idade = ? WHERE id = ?";
            pst = connection.prepareStatement(sqlPessoa);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getCpf());
            pst.setInt(3, aluno.getIdade());
            pst.setInt(4, id);
            pst.executeUpdate();

            // 2 - atualiza aluno
            String sqlAluno = "UPDATE aluno SET matricula = ?, peso = ?, altura = ?, tipo_plano = ?, tipo_pagamento = ?, nome_treino = ? WHERE id = ?";
            pst = connection.prepareStatement(sqlAluno);

            pst.setInt(1, aluno.getMatricula());
            pst.setDouble(2, aluno.getPeso());
            pst.setDouble(3, aluno.getAltura());
            pst.setString(4, aluno.getPlano().getTipo());
            pst.setString(5, aluno.getPagamento().getTipo());
            pst.setString(6, aluno.getTreino().getNome());
            pst.setInt(7, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteAluno(int id){
        connectToDb();

        String sql = "DELETE FROM pessoa WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Aluno removido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao remover aluno: " + e.getMessage());
            return false;

        } finally{
            // SEMPRE EXECUTA - libera recursos na ordem correta
            try{
                if (pst != null) pst.close();       // fecha statment primeiro
                if (connection != null) connection.close(); // depois fecha connection
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public ArrayList<Aluno> selectAluno(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        connectToDb();
        String sql = "SELECT \n" +
                "    p.nome,\n" +
                "    p.cpf,\n" +
                "    p.idade,\n" +
                "    a.matricula,\n" +
                "    a.peso,\n" +
                "    a.altura,\n" +
                "    a.tipo_plano,\n" +
                "    a.tipo_pagamento,\n" +
                "    a.nome_treino\n" +
                "FROM pessoa p\n" +
                "INNER JOIN aluno a ON p.id = a.id;";


        try{
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){

                // reconstruindo objetos

                Plano plano;

                if(rs.getString("tipo_plano")
                        .equals("Anual")) {

                    plano = new PlanoAnual(120);

                } else {

                    plano = new PlanoMensal(80);
                }

                Pagavel pagamento;

                if(rs.getString("tipo_pagamento")
                        .equals("Pix")) {

                    pagamento = new PagamentoPix();

                } else if(rs.getString("tipo_pagamento")
                        .equals("Cartão")) {

                    pagamento =
                            new PagamentoCartao();

                } else {

                    pagamento =
                            new PagamentoDinheiro();
                }

                Treino treino =
                        new Treino(
                                rs.getString(
                                        "nome_treino"
                                )
                        );
                Aluno aluno = new Aluno(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getInt("idade"),
                        rs.getInt("matricula"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        plano,
                        pagamento,
                        treino
                );
                alunos.add(aluno);
            }
        } catch(SQLException e){
            System.out.println("Erro ao buscar alunos: " + e.getMessage());
        } finally {
            try{
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();

            }catch (SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            };
        };
        return alunos;
    };

}
