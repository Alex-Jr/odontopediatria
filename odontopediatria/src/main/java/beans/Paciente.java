package beans;

import java.util.Date;

public class Paciente {
	
	public Paciente(int id, String nome, String sexo, Date dataNasc, String nomeResponsavel, String telefoneResponsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.nomeResponsavel = nomeResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;
	}

	private int id;
	private String nome;
	private String sexo;
	private Date dataNasc;
	private String nomeResponsavel;
	private String telefoneResponsavel;

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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}
	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}
}
