package academia.dao;

import academia.pessoas.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO extends PessoaDAO {

    public boolean insertFuncionario(Funcionario funcionario){
        connectToDb();

        // VERIFICA CPF ANTES
        if (cpfExiste(funcionario.getCpf())) {
            System.out.println("CPF já cadastrado: " + funcionario.getCpf());
            return false;
        }

        // insere pessoa e pega o ID gerado
        int pessoaId = insertPessoa(funcionario);

        if(pessoaId == -1){
            return false;
        }

        String sql = "INSERT INTO funcionario(id, salario) VALUES(?, ?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pessoaId);
            pst.setDouble(2, funcionario.getSalario());
            pst.execute();

            System.out.println("Funcionário inserido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
            return false;

        } finally{
            try{
                if(pst != null) pst.close();
                if(connection != null) connection.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public boolean updateFuncionario(Funcionario funcionario) {

        connectToDb();

        try {

            // 1 - atualiza pessoa
            String sql1 = "UPDATE pessoa SET nome = ?, cpf = ?, idade = ? WHERE id = ?";
            pst = connection.prepareStatement(sql1);

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getCpf());
            pst.setInt(3, funcionario.getIdade());
            pst.setInt(4, funcionario.getId());

            pst.executeUpdate();

            // 2 - atualiza funcionario
            String sql2 = "UPDATE funcionario SET salario = ? WHERE id = ?";
            pst = connection.prepareStatement(sql2);

            pst.setDouble(1, funcionario.getSalario());
            pst.setInt(2, funcionario.getId());

            pst.executeUpdate();

            System.out.println("Funcionário atualizado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFuncionario(int id){
        connectToDb();

        String sql = "DELETE FROM pessoa WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            System.out.println("Funcionário removido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao remover funcionário: " + e.getMessage());
            return false;

        } finally{
            try{
                if(pst != null) pst.close();
                if(connection != null) connection.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public ArrayList<Funcionario> selectFuncionario(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDb();

        String sql = "SELECT pessoa.id, nome, cpf, idade, salario\n" +
                "FROM pessoa\n" +
                "INNER JOIN funcionario ON pessoa.id = funcionario.id";

        try{
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Funcionario funcionario = new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getInt("idade"),
                        rs.getDouble("salario")
                );

                funcionario.setId(rs.getInt("id"));
                funcionarios.add(funcionario);
            }

        } catch(SQLException e){
            System.out.println("Erro ao buscar funcionários: " + e.getMessage());

        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(connection != null) connection.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return funcionarios;
    }
}