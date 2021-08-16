package beans;

import java.util.Date;
import java.util.Random;

public class Avaliacao {
	private int id;
	private int ansiedade;
	private String expressoes;
	private Paciente paciente;
	private Medico medico;
	public Date data;
	
	public Avaliacao(int id, Paciente paciente, Medico medico, String expressoes, Date data, int ansiedade) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.expressoes = expressoes;
		this.data = data;
		this.ansiedade = ansiedade;
	}
	
	public Avaliacao() {
		return;
	}
	
	public void setData(Date d) {
		this.data = d;
	}
	
	public Date getData() {
		return this.data;
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
		
		Random rand = new Random();
		
		int ansiedade = 0;
		for(int i = 0; i < expreArray.length; i++) {
			String expre = expreArray[i];
			/*if(expre.equals("raiva")) ansiedade += 5;
			if(expre.equals("triste")) ansiedade += 3;
			if(expre.equals("chateado")) ansiedade += 1;
			if(expre.equals("normal")) ansiedade -= 1;
			if(expre.equals("feliz")) ansiedade -= 3;
			if(expre.equals("animado")) ansiedade -= 5;*/
		}
		
		ansiedade = rand.nextInt(10);
		
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
