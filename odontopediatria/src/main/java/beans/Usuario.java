package beans;

public class Usuario {
	private static int qnt = 0;
	
	private int id;
	private String nome;
	private String cpf;
	private String genero;
	
	public Usuario(String nome, String cpf, String genero) {
		this.id = Usuario.qnt;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		
		Usuario.qnt++;
	}
	
	public int getId() {
		return this.id;
	}


	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getGenero() {
		return this.genero;
	}

}
