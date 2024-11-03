<%@page import="org.eclipse.jakarta.entidades.UsuarioDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% UsuarioDao ud = (UsuarioDao) request.getAttribute("user"); %>
<form action="controlador" method="post" value="">
	<label>Id:</label>
	<input type="text" name="txtidcon" value="<%=ud.getIdcon() %>" ud.>
	<label> Nome: </label>
	<input type="text" name="txtnome" value="<%=ud.getNome() %>" size="10">
	<label> Login: </label>
	<input type="text" name="txtlogin" value="<%=ud.getLogin() %>">
	<label> Senha: </label>
	<input type="password" name="txtsenha" maxlength="6" value="<%=ud.getSenha() %>">
	
	<input type="submit" value="salvar">
	</form>
</body>
</html>