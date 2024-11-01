package org.eclipse.jakarta.controle;

import jakarta.servlet.ServletException;
import  java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.eclipse.jakarta.jdbc.Conector;
import org.eclipse.jakarta.jdbc.DAO;
import org.eclipse.jakarta.jdbc.UsuarioDao;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/controlador") 
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DAO dao = new DAO();
    public Controle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     
		List<UsuarioDao>listaUser = dao.buscarUsuarios();
	    for(UsuarioDao user : listaUser) {
	    	PrintWriter saida = response.getWriter();
	    	System.out.println("Id: " + user.getIdcon() + " Nome: " + user.getNome() + " Login: " + user.getLogin());
	    	//saida.println("Id: " + user.getIdcon() + " Nome: " + user.getNome() + " Login: " + user.getLogin());
	    }
		/*String nome = request.getParameter("nome");
        String emp = request.getParameter("emp");
        
        PrintWriter saida = response.getWriter();
        saida.println("Nome:" + nome + " Empresa: " + emp);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("METODO POST");
		
		String id = request.getParameter("txtidcon");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		//PrintWriter saida = response.getWriter();
		//saida.println(txtnome +"  "+txtsenha);
		UsuarioDao usuario = new UsuarioDao();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(Integer.parseInt(senha));
		if(id !="") {
			usuario.setIdcon(Integer.parseInt(id));
		}
		dao.salvar(usuario); 
		
		PrintWriter saida = response.getWriter();
		saida.println( "Dados cadastrados");
	}

}
