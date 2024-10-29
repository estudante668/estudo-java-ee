package org.eclipse.jakarta.jdbc;

import org.eclipse.jakarta.jdbc.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;
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
	
	public static void deletarUsuarios(Integer id) {
		
		Connection con = Conector.conexao();
		String sql = "Delete from contatos where idcon=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   public UsuarioDao selecionarId(Integer id) {
 		Connection con = Conector.conexao();
 		String sql = "select  * from contatos where idcon=?";
 		UsuarioDao ud = null;
 		try {
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setInt(1, id);
 			ResultSet rs = ps.executeQuery();
 		if(rs.next()) {
 				ud = new UsuarioDao();
 				ud.setIdcon(rs.getInt("idcon"));
 			    ud.setNome(rs.getString("nome"));	
 				ud.setFone(rs.getString("fone"));	
 				ud.setEmail(rs.getString("email"));
 				}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return ud;
 	}
   
   /*public UsuarioDao selecionarIds(Integer id) {
		Connection con = Conector.conexao();
		String sql = "select  * from contatos where idcon=?";
		UsuarioDao ud = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				ud = new UsuarioDao();
				int uu = rs.getInt("idcon");
				if(id == uu) {
					ud.setIdcon(rs.getInt("idcon"));
				    ud.setNome(rs.getString("nome"));	
					ud.setFone(rs.getString("fone"));	
					ud.setEmail(rs.getString("email"));
				} 
					System.out.println("ID não exiteppppp");
				
				}
		} catch (SQLException e) {
			System.out.println("ID não exite: " + e);
		}
		return ud;
	}*/
   
   public UsuarioDao autenticador(UsuarioDao user) {
	   Connection con = Conector.conexao();
		String sql = "select  * from contatos where nome=? and email=?";
		UsuarioDao ud = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				ud = new UsuarioDao();
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				if(nome.equals(user.getNome()) && email.equals(user.getEmail())) {
					ud.setIdcon(rs.getInt("idcon"));
				    ud.setNome(rs.getString("nome"));	
					ud.setFone(rs.getString("fone"));	
					ud.setEmail(rs.getString("email"));
				} 
				}
		} catch (SQLException e) {
			System.out.println("ID não exite: " + e);
		}
		return ud;
   }
}
