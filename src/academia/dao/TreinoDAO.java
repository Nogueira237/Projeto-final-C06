package academia.dao;

import academia.treino.Treino;

import java.sql.SQLException;
import java.util.ArrayList;

public class TreinoDAO extends ConnectionDAO {

    public boolean insertTreino(Treino treino){
        connectToDb();

        String sql = "INSERT INTO treino(nome) VALUES(?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, treino.getNome());
            pst.execute();

            System.out.println("Treino inserido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao inserir treino: " + e.getMessage());
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

    public boolean updateTreino(int id, Treino treino){
        connectToDb();

        String sql = "UPDATE treino SET nome = ? WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, treino.getNome());
            pst.setInt(2, id);
            pst.execute();

            System.out.println("Treino atualizado com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao atualizar treino: " + e.getMessage());
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

    public boolean deleteTreino(int id){
        connectToDb();

        String sql = "DELETE FROM treino WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            System.out.println("Treino removido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao remover treino: " + e.getMessage());
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

    public ArrayList<Treino> selectTreino(){
        ArrayList<Treino> treinos = new ArrayList<>();
        connectToDb();

        String sql = "SELECT * FROM treino";

        try{
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Treino treino = new Treino(
                        rs.getString("nome")
                );

                treinos.add(treino);
            }

        } catch(SQLException e){
            System.out.println("Erro ao buscar treinos: " + e.getMessage());

        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(connection != null) connection.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return treinos;
    }
}