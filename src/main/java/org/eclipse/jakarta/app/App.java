package org.eclipse.jakarta.app;

import org.eclipse.jakarta.jdbc.Conector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.jdbc.*;

public class App {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		List<UsuarioDao> lista = dao.buscarUsuarios();
		for(UsuarioDao usuarios : lista) {
			System.out.println(usuarios.getIdcon() + " " + usuarios.getNome() + " " + usuarios.getFone() + " " + usuarios.getEmail());
		}
		
	}

}
