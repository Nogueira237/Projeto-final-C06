package academia.dao;

import academia.pessoas.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDAO extends ConnectionDAO {

    public int insertPessoa(Pessoa pessoa) {

        connectToDb();

        String sql = "INSERT INTO pessoa(nome, cpf, idade) VALUES (?, ?, ?)";

        try {
            pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getCpf());
            pst.setInt(3, pessoa.getIdade());
            pst.execute();

            // pega o ID gerado automaticamente
            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;

        } catch(SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
            return -1;
        }
    }

    // metodo para evitar cpf duplicados
    public boolean cpfExiste(String cpf){
        connectToDb();

        String sql = "SELECT id FROM pessoa WHERE cpf = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            return rs.next(); // se tiver resultado, CPF existe

        } catch(Exception e){
            System.out.println("Erro ao verificar CPF: " + e.getMessage());
            return false;

        } finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(connection != null) connection.close();
            } catch(Exception e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}