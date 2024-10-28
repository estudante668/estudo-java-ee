package org.eclipse.jakarta.jdbc;

import org.eclipse.jakarta.jdbc.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	public static List<UsuarioDao> buscarUsuarios() {
		
		Connection con = Conector.conexao();
		String sql = "select*from contatos";
		List<UsuarioDao> listUsuario = new ArrayList<UsuarioDao>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
		    ResultSet rs =	ps.executeQuery();
		    while(rs.next()) {
		    UsuarioDao ud = new UsuarioDao();
			    ud.setIdcon(rs.getInt("idcon"));
			    ud.setNome(rs.getString("nome"));	
			    ud.setFone(rs.getString("fone"));	
			    ud.setEmail(rs.getString("email"));
			    listUsuario.add(ud);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUsuario;
		
	}
	
	public static void inserirUsuarios(UsuarioDao usuarios) {
		
		Connection con = Conector.conexao();
		String sql = "Insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuarios.getNome());
			ps.setString(2, usuarios.getFone());
			ps.setString(3, usuarios.getEmail());
			ps.executeUpdate();
			System.out.println("Dados inseridos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizarUsuarios(UsuarioDao usuarios) {
		  
		Connection con = Conector.conexao();
		String sql = "Update contatos set nome=?,fone=?,email=? where idcon=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuarios.getNome());
			ps.setString(2, usuarios.getFone());
			ps.setString(3, usuarios.getEmail());
			ps.setInt(4, usuarios.getIdcon());
			ps.executeUpdate();
			System.out.println("Dados atualizados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
