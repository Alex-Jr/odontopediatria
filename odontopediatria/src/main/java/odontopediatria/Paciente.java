package odontopediatria;

public class Paciente {
	
	public Paciente(String nome, String genero, String nomeResponsavel, String dataNasc) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.nomeResponsavel = nomeResponsavel;
		this.dataNasc = dataNasc;
	}

	private String nome;
	private String genero;
	private String nomeResponsavel;
	private String dataNasc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
