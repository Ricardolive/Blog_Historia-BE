package br.com.blogHistoria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="O atributo nome é obrigatorio")
	@Size(min=3, max=100, message="O atributo nome deve conter de 3 a 100 caracteres")
	private String nome;
	
	@NotNull(message="O atributo email é obrigatorio")
	@Size(min=10, message="O atributo email deve conter no minimo 10 caracteres")
	private String email;
	
	@NotNull(message="O atributo senha é obrigatorio")
	private String senha;
	
	
	private String fotoPerfil;
	
	 
	private boolean tipo;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


	public boolean isTipo() {
		return tipo;
	}


	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
