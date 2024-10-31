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
			    ud.setLogin(rs.getString("login"));
			    ud.setSenha(rs.getInt("senha"));
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
		String sql = "Insert into contatos (nome,login,senha) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuarios.getNome());
			ps.setString(2, usuarios.getLogin());
			ps.setInt(3, usuarios.getSenha());
			ps.executeUpdate();
			System.out.println("Dados inseridos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void salvar(UsuarioDao usuario) {
		   if(usuario.getIdcon() != null && usuario.getIdcon() != 0) {
			   atualizarUsuarios(usuario);
			} else {
				inserirUsuarios(usuario);
			}
	   }
	
	public static void atualizarUsuarios(UsuarioDao usuarios) {	  
		Connection con = Conector.conexao();
		String sql = "Update contatos set nome=?,login=?,senha=? where idcon=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuarios.getNome());
			ps.setString(2, usuarios.getLogin());
			ps.setInt(3, usuarios.getSenha());
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
		String sql = "select  * from contatos where login=? and senha=?";
		UsuarioDao ud = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setInt(2, user.getSenha());
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				ud = new UsuarioDao();
				String login = rs.getString("login");
				Integer senha = rs.getInt("senha");
				if(login.equals(user.getLogin()) && senha.equals(user.getSenha())) {
					ud.setIdcon(rs.getInt("idcon"));
				    ud.setNome(rs.getString("nome"));	
					
				} 
				}
		} catch (SQLException e) {
			System.out.println("ID não exite: " + e);
		}
		return ud;
   }
   
   public List<UsuarioDao> buscarPorNome(String nome){
	   Connection con = Conector.conexao();
		String sql = "select  * from contatos where nome like ?";
		List<UsuarioDao> lista = new ArrayList<UsuarioDao>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			UsuarioDao ud = new UsuarioDao();
				ud.setIdcon(rs.getInt("idcon"));
			    ud.setNome(rs.getString("nome"));	
				lista.add(ud);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;   
   }
}
