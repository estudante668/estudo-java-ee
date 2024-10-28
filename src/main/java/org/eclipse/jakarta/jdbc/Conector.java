package org.eclipse.jakarta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	public static Connection conexao() {
		Connection con = null;
		try {
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdagenda", "postgres", "1cbt89q");
			 System.out.println("sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
