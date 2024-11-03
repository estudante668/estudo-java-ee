<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="org.eclipse.jakarta.jdbc.*" %>
<%@page import="org.eclipse.jakarta.entidades.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LISTA JSP</h1>
<% String nome = (String) request.getAttribute("meunome"); 
out.print(nome);
%>
<table border="1">
<tr bgcolor="#CCCCCC">
<th> Id</th><th> Nome</th><th> Login</th><th> Senha</th><th> Acao</th>
</tr>
<% List<UsuarioDao> listaUser = (List<UsuarioDao>) request.getAttribute("usuarios");
for(UsuarioDao listaDao : listaUser){
%>
<tr>
   <td><%= listaDao.getIdcon() %></td>
   <td><%= listaDao.getNome() %></td>
   <td><%= listaDao.getLogin() %></td>
   <td><%= listaDao.getSenha() %></td>
   <td><a href="controlador?acao=exc&id=<%= listaDao.getIdcon() %>">Excluir</a></td>
 <td><a href="index.html?acao=alterar&id=<%= listaDao.getIdcon() %>">Alterar</a></td>
</tr>
<%
} 
%>
</table>
</body>
</html>