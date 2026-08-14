package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {

       /* try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/saude_bd",
                    "root",
                    "password"

            );
            return connection;
        }
        catch (SQLException e){
            throw new RuntimeException("ERRO A CONECTAR BANCO" + e.getMessage());

        }*/

        private static final String url = "jdbc:mysql://localhost:3306/saude_bd";
        private static final String usuario = "root";
        private static final String senha = "password";

        public static Connection conectar(){
            try{

                return DriverManager.getConnection(url,usuario,senha);
            }catch(SQLException e){
                throw new RuntimeException("Erro ao conectar com o banco de dados" + e.getMessage());
            }


    }
}
