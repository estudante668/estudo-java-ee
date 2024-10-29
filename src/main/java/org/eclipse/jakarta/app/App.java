package org.eclipse.jakarta.app;

import org.eclipse.jakarta.jdbc.Conector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.jdbc.*;

public class App {

	public static void main(String[] args) {
		//buscarUsuarios();
		//inserirUsuarios();
		//atualizarUsuarios();'
		//deletarUsuario();
		//buscarPorId();	
		autenticador();
	}

	private static void autenticador() {
		DAO dao = new DAO();
		UsuarioDao usuario = new UsuarioDao();
		usuario.setLogin("vava");
		usuario.setSenha(317);
		UsuarioDao aluno =	dao.autenticador(usuario);
		   System.out.println("Id do aluno requerido: " + aluno.getIdcon() + "\n" + "Nome do aluno requerido: " + aluno.getNome() + "\n" + "Email: " + aluno.getEmail());
	}
	
	private static void buscarPorId() {
		DAO dao = new DAO();
		UsuarioDao usuario = dao.selecionarId(12);
	   System.out.println(usuario.getIdcon() + " " + usuario.getNome());
	}
	
	private static void deletarUsuario() {
		DAO dao = new DAO();
		dao.deletarUsuarios(16);
	}

	private static void buscarUsuarios() {
		DAO dao = new DAO();
		List<UsuarioDao> lista = dao.buscarUsuarios();
		for(UsuarioDao usuarios : lista) {
			System.out.println(usuarios.getIdcon() + " " + usuarios.getNome() + " " + usuarios.getFone() + " " + usuarios.getEmail());
		}
	}
	
	private static void inserirUsuarios() {
		DAO dao = new DAO();
		UsuarioDao ud = new UsuarioDao();
		ud.setNome("Vantuir");
		ud.setFone("(11) 3788-2234");
		ud.setEmail("brnl@gmail.com");
		ud.setLogin("vava");
		ud.setSenha(317);
		dao.inserirUsuarios(ud); 
	}
	
	private static void atualizarUsuarios() {
		DAO dao = new DAO();
		UsuarioDao ud = new UsuarioDao();
		ud.setNome("Carla");
		ud.setFone("(33) 8998-33421");
		ud.setEmail("catla@gmail.com");
		ud.setIdcon(7);
		dao.atualizarUsuarios(ud);
	}
}
