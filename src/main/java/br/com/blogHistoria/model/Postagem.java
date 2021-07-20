package br.com.blogHistoria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 

@Entity
@Table(name="tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Atributo titulo é obrigatorio")
	@Size(min=3, max=100, message="O atributo titulo deve conter 3 a 100 caracteres")
	private String titulo;
	
	@Size(min=3, max=200, message="O atributo descricao deve conter de 3 a 200 caracteres")
	private String descricao;
	
	
	@Column(columnDefinition= "text")
	@NotNull(message="O Atributo texto é obrigatorio")
	@Size(min=3, message="O atributo texto deve conter no minimo 3 caracteres")
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPost = new java.sql.Date(System.currentTimeMillis());
	
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public Date getDataPost() {
		return dataPost;
	}


	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
}
