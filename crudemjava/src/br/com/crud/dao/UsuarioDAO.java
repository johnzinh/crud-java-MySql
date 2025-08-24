package br.com.crud.dao;

import br.com.crud.factory.DatabaseConnection;
import br.com.crud.model.Usuarios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*
- CRUD -

  CREATE  (INSERT OK)
  READ    (SELECT OK)
  UPDATE  (OK)
  DELETE  (OK)

  toda a regra de negocio
*/

public class UsuarioDAO {

    public void save(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nome, idade) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConectionMysql();              //-> cria conexao com banco
            pstm = conn.prepareStatement(sql);                          //-> executa uma query

            pstm.setString(1, usuario.getNome());         //-> adiciona os valores esperados pela query
            pstm.setInt(2, usuario.getIdade());

            pstm.execute();                                           //executa a query
            System.out.println("dados salvos com sucesso!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {                                                     //fechar as conexoes
            try {
                if (pstm != null) {
                    pstm.close();
                }
                /*
                if (conn != null) {
                    conn.close();
                }
                */
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public List<Usuarios> getUsuarios() {                                         //para a listagem de usuarios List<>
        String sql = "SELECT * FROM usuarios";

        List<Usuarios> usuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;                                                     //-> Classe que vai recuperar os dados do banco. ***SELECT**

        try {

            conn = DatabaseConnection.getConectionMysql();
            pstm = conn.prepareStatement(sql);
            rst = pstm.executeQuery();

            while (rst.next()) {

                Usuarios usuario = new Usuarios();
                usuario.setNome(rst.getString("nome"));
                usuario.setIdade(rst.getInt("idade"));
                usuario.setId(rst.getInt("id"));
                usuarios.add(usuario);

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {

                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                /*
                if (conn != null) {
                    conn.close();
                }
                */

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }



    public void update(Usuarios usuarios) {
        String sql = "UPDATE usuarios SET nome = ?, idade = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = DatabaseConnection.getConectionMysql();
            pstm = conn.prepareStatement(sql);

            //adicionar os valores para atualizar
            pstm.setString(1, usuarios.getNome());
            pstm.setInt(2, usuarios.getIdade());
            pstm.setInt(3, usuarios.getId()); //qual id desejar atualizar

            pstm.execute();  //executa a query

            System.out.println("Alteração feita com sucesso");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try{
               if (pstm != null) {
                   pstm.close();
               }
                 /*
                if (conn != null) {
                    conn.close();
                }
                */
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }

    public void deleteById(int id) {
        String sql = " DELETE FROM usuarios WHERE id = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConectionMysql();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
            System.out.println("Contato deletado com sucesso");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if (pstm != null) {
                    pstm.close();
                }
                  /*
                if (conn != null) {
                    conn.close();
                }
                */
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }












}