package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import util.Conexao;

import java.sql.SQLException;

public class UsuarioDao {

    public void cadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO usuario(nome, email, senha, idade, sexo, telefone) VALUES(?,?,?,?,?,?)";

        try (
                Connection conn = Conexao.conectar();

                PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenhaHash());
            st.setInt(4, usuario.getIdade());
            st.setString(5, usuario.getSexo());
            st.setString(6, usuario.getTelefone());

            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário", e);

        }


    }

    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.conectar();

             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senhaHash = rs.getNString("senha");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");

                Usuario usuario = new Usuario(
                        id, nome, email, senhaHash, idade, sexo, telefone);

                usuarios.add(usuario);


            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO LER DADOS", e);


        }
        return usuarios;

    }
}
