package academia.dao;

import academia.academia.Equipamento;

import java.sql.SQLException;
import java.util.ArrayList;

public class EquipamentoDAO extends ConnectionDAO {

    public boolean insertEquipamento(Equipamento equipamento){
        connectToDb();

        String sql = "INSERT INTO equipamento(nome, status) VALUES(?, ?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, equipamento.getNome());
            pst.setString(2, equipamento.getStatus());
            pst.execute();

            System.out.println("Equipamento inserido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao inserir equipamento: " + e.getMessage());
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

    public boolean updateEquipamento(int id, Equipamento equipamento){
        connectToDb();

        String sql = "UPDATE equipamento SET nome = ?, status = ? WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, equipamento.getNome());
            pst.setString(2, equipamento.getStatus());
            pst.setInt(3, id);
            pst.execute();

            System.out.println("Equipamento atualizado com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao atualizar equipamento: " + e.getMessage());
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

    public boolean deleteEquipamento(int id){
        connectToDb();

        String sql = "DELETE FROM equipamento WHERE id = ?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            System.out.println("Equipamento removido com sucesso!");
            return true;

        } catch(SQLException e){
            System.out.println("Erro ao remover equipamento: " + e.getMessage());
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

    public ArrayList<Equipamento> selectEquipamento(){
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        connectToDb();

        String sql = "SELECT id, nome, status FROM equipamento";

        try{
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){

                Equipamento equipamento = new Equipamento(
                        rs.getString("nome"),
                        rs.getString("status")
                );

                equipamento.setId(rs.getInt("id"));
                equipamentos.add(equipamento);
            }

        } catch(SQLException e){
            System.out.println("Erro ao buscar equipamentos: " + e.getMessage());

        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(connection != null) connection.close();
            } catch(SQLException e){
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return equipamentos;
    }
}