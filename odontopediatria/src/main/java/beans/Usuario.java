package beans;

public class Usuario {
	public Usuario() {
		
	}
	
	private String info;
	private String senha; 
	private String tipo;
	private Medico medico;

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	@Override
	public String toString() {
		return "tipo=" + tipo + ",nome=" + medico.getNome() + ",crm=" + medico.getCrm() + ",id=" + medico.getId();
	}
}
