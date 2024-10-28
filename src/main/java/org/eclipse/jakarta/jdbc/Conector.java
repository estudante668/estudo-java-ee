package org.eclipse.jakarta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	public static Connection conexao() {
		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdagenda", "postgres", "");
			 System.out.println("sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
