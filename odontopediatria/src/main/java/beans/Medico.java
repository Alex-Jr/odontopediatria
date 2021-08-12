package beans;

public class Medico {
	
	public Medico(int id, String nome, String crm) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
	}


	private int id;
	private String nome;
	private String crm;

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
	public String getCrm() {
		return crm;
	}
	public void setSexo(String crm) {
		this.crm = crm;
	}
}