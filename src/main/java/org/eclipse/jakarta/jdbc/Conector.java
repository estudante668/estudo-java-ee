package org.eclipse.jakarta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	public static Connection conexao() {
		
Connection con = null;
		        try {
		        	Class.forName("org.postgresql.Driver");
		            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdagenda", "postgres", "1cbt89q");
		            System.out.println("CONEXAO REALIZADA");
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }
	  return con;
   }
}
