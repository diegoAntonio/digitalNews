package model;


/**
 * @author Diego
 *	Classe que representa um topico no sistema de noticias.
 */
public class Topico {
	private int id;//id que representa o topico no banco
	private String nome;//nome do topico.
	
	
	public Topico() {
		super();
	}

	//Getters e Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}	
