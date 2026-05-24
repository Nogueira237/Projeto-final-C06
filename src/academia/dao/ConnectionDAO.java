package academia.dao;

import java.sql.*;

public class ConnectionDAO {

    Connection connection;      // conexao com o banco

    // Parametros utilizados nas subclasses

    PreparedStatement pst;      // comando sql com parametros
    Statement st;               // comando sql simples (com parametros)
    ResultSet rs;               // resultado das consultas sql

    // informações de acesso ao banco de dados:
    String database = "academia";
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database;

    // Estabelecer a conexao com o banco
    public Connection connectToDb(){
      try{
          connection = DriverManager.getConnection(url, user, password);
          //System.out.println("Conectado com sucesso ao banco de dados!");
          return connection;
      }catch(SQLException e) {
          System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
          return null;
        }
    };

}
