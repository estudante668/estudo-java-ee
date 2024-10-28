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
}
