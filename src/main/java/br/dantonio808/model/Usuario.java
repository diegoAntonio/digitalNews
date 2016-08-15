package br.dantonio808.model;


/**
 * @author Diego
 *	Classe que representa o usu�rio no sistema.
 */
public class Usuario {
		private String login;//represena o usuario no sistema
		private String senha;//representa a senha do usuario
		private int tipo;//representa o tipo do usuario no sistema.
		private int id;
		
		/*Construtor Default*/
		public Usuario(){
			super();
			this.tipo = 0;
		}
		/* Construtor com login e senha*/
		public Usuario(String login, String senha) {
			super();
			this.login = login;
			this.senha = senha;
		}
		
		
		/*Construtor com todos os campos*/
		public Usuario(String login, String senha, int tipo, int id) {
			super();
			this.login = login;
			this.senha = senha;
			this.tipo = tipo;
			this.id = id;
		}
		/* Getters e Setters */
		public String getLogin() {
			return login;
		}
		
		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public int getTipo() {
			return tipo;
		}
		
		public void setTipo(int tipo) {
			this.tipo = tipo;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}	
		/* Fim dos Getters e Setters */
		
}
