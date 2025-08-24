package br.com.crud.aplication;

import br.com.crud.dao.UsuarioDAO;
import br.com.crud.factory.DatabaseConnection;
import br.com.crud.model.Usuarios;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Usuarios usuario = new Usuarios();
        usuario.setNome("john C");
        usuario.setIdade(32);

        DatabaseConnection data = null;
        UsuarioDAO usuarioDAO = null;


        try {
            data = new DatabaseConnection();
            usuarioDAO = new UsuarioDAO();

            usuarioDAO.save(usuario);                                   // save- Realiza a operação de salvar no banco.

            for (Usuarios user : usuarioDAO.getUsuarios()) {            //getUsuarios - tras a lista de usuarios
                System.out.println("Usuário: " + user.getNome());
            }

/*
            Usuarios usuarioAtt = new Usuarios();                       //atualizar usuarios
            usuarioAtt.setNome("Cleiton Rasta");
            usuarioAtt.setIdade(12);
            usuarioAtt.setId(1);
            usuarioDAO.update(usuarioAtt);


            //usuarioDAO.deleteById(1);                                 //deletar o contato pelo ID

*/

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (data != null) {
                data.closeConnection();                                  // Garante o fechamento da conexão.
            }

        }


    }
}
