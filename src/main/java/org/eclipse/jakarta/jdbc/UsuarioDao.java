package org.eclipse.jakarta.jdbc;

public class UsuarioDao {

	Integer idcon;
	String nome;
	String fone;
	String email;
	Integer senha;
	String login;
	
	public UsuarioDao() {
		super();
	}

	public Integer getIdcon() {
		return idcon;
	}

	public void setIdcon(Integer idcon) {
		this.idcon = idcon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
