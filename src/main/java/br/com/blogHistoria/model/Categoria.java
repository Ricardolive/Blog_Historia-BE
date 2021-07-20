package br.com.blogHistoria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull(message="O atributo nome é obrigatorio")
	@Size(min=3, max=100, message="O atributo titulo deve conter de 3 a 100 caracteres")
	private String titulo;
	
	
	private String imagem;
	
	
	@NotNull(message="O atributo descricao é obrigatorio")
	@Size(min=3, max=200, message="O atributo descricao deve conter de 3 a 200 caracteres ")
	private String descricao;
	
	
	@OneToMany(mappedBy="categoria",cascade= CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Tema> tema;


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


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Tema> getTema() {
		return tema;
	}


	public void setTema(List<Tema> tema) {
		this.tema = tema;
	}
	
	
	
 
}
