package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe de conexao com banco.

public class DatabaseConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "edinalramysql";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/meu_banco";


    private static Connection conn;


    public static Connection getConectionMysql() throws SQLException, ClassNotFoundException {

        if (conn == null) {
            synchronized (DatabaseConnection.class) {                                                            // Bloqueia para evitar problemas de concorrência

                if (conn == null) {
                    try {

                        Class.forName("com.mysql.jdbc.Driver");                                        //-> Carregar driver explicitamente (se necessário em versões mais antigas)
                        conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);                   //-> Conexão banco de dados
                        System.out.println("Conexao estabelecida!");

                    } catch (SQLException | ClassNotFoundException e) {
                        throw new SQLException("Erro ao conectar com banco de dados (GRR!!!)", e);
                    }
                }

            }

        }
        return conn;
    }


    public static void closeConnection() {                                                                     //-> metodo pra fechar conexao
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexao fechada!");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }


}
