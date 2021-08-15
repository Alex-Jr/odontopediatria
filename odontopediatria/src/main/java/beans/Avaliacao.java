package beans;

public class Avaliacao {
	private int id;
	private int ansiedade;
	private String expressoes;
	private Paciente paciente;
	private Medico medico;
	
	public Avaliacao() {
		return;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public void setAnsiedade(String ansiedade) {
		this.ansiedade = Integer.parseInt(ansiedade);
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAnsiedade(int ansiedade) {
		this.ansiedade = ansiedade;
	}
	public void setExpressoes(String expressoes) {
		String expreArray[] = expressoes.split("&");
		
		int ansiedade = 0;
		for(int i = 0; i < expreArray.length; i++) {
			String expre = expreArray[i];
			if(expre.equals("raiva")) ansiedade += 5;
			if(expre.equals("triste")) ansiedade += 3;
			if(expre.equals("chateado")) ansiedade += 1;
			if(expre.equals("normal")) ansiedade -= 1;
			if(expre.equals("feliz")) ansiedade -= 3;
			if(expre.equals("animado")) ansiedade -= 5;
		}
		
		this.expressoes = expressoes;
		this.setAnsiedade(ansiedade);
	}
	public int getAnsiedade() {
		return ansiedade;
	}
	public String getExpressoes() {
		return expressoes;
	}
	public int getId() {
		return id;
	}
}
