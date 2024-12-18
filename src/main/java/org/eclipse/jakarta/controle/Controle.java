package org.eclipse.jakarta.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import  java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.eclipse.jakarta.entidades.UsuarioDao;
import org.eclipse.jakarta.jdbc.Conector;
import org.eclipse.jakarta.jdbc.DAO;


@WebServlet("/controlador") 
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DAO dao = new DAO();
	UsuarioDao user = new UsuarioDao();
    public Controle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("metodo doGet");
		String acao = request.getParameter("acao");
		if(acao != null && acao.equals("exc")) {
			
			String id = request.getParameter("id");
			user.setIdcon(Integer.parseInt(id));   
		    System.out.println("Qual id cap:" + user.getIdcon());
		    dao.deletarUsuarios(user.getIdcon());
		
		} 
		
		if (acao != null && acao.equals("alt")) {
			
			String id = request.getParameter("id");
			UsuarioDao ususario = dao.selecionarId(Integer.parseInt(id));
			request.setAttribute("user", ususario);
			RequestDispatcher despachar = request.getRequestDispatcher("formulario.jsp");
		    despachar.forward(request, response);
		} 
        
		if (acao != null && acao.equals("cad")) {
			
			
			UsuarioDao ususario = new UsuarioDao();
			ususario.setIdcon(0);
			ususario.setNome("");
			ususario.setLogin("");
			ususario.setSenha(0);
			request.setAttribute("user", ususario);
			RequestDispatcher despachar = request.getRequestDispatcher("formulario.jsp");
		    despachar.forward(request, response);
		}
			
	    if (acao.equals("lista")) {
			
			List<UsuarioDao>listaUser = dao.buscarUsuarios();
			request.setAttribute("usuarios", listaUser);
		    RequestDispatcher rd = request.getRequestDispatcher("pagina.jsp");
	        rd.forward(request, response);
		}
		
		
      
		/*String nome = request.getParameter("nome");
        String emp = request.getParameter("emp");
        
        PrintWriter saida = response.getWriter();
        saida.println("Nome:" + nome + " Empresa: " + emp);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("METODO POST");
		
		
		String id = request.getParameter("txtidcon");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		

			UsuarioDao usuario = new UsuarioDao();
			usuario.setIdcon(Integer.parseInt(id));
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(Integer.parseInt(senha));
		
		    dao.atualizarUsuarios(usuario);
		    
			
			List<UsuarioDao>listaUser = dao.buscarUsuarios();
		
			request.setAttribute("usuarios", listaUser);
			request.setAttribute("meunome", "Jose");
		    RequestDispatcher rd = request.getRequestDispatcher("pagina.jsp");
	        rd.forward(request, response);
		    
		    /*	//PrintWriter saida = response.getWriter();
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
			saida.println("Dados cadastrados");*/
		
  }
}
