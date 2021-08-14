package beans;

public class Avatar {
	private int boca; 
	private int cabelo; 
	private int nariz; 
	private int olho; 
	private int orelha; 
	private int rosto;
	private int roupa;
	private int sobrancelha;
	private String corPele;
	private String corOlho;
	private int id;
	private Paciente paciente;
	
	public Avatar () {
		return;
	}

	public void setBoca(String boca) {
		this.boca = Integer.parseInt(boca);
	}

	public void setCabelo(String cabelo) {
		this.cabelo = Integer.parseInt(cabelo);
	}

	public void setNariz(String nariz) {
		this.nariz = Integer.parseInt(nariz);
	}

	public void setOlho(String olho) {
		this.olho = Integer.parseInt(olho);
	}

	public void setOrelha(String orelha) {
		this.orelha = Integer.parseInt(orelha);
	}

	public void setRosto(String rosto) {
		this.rosto = Integer.parseInt(rosto);
	}

	public void setRoupa(String roupa) {
		this.roupa = Integer.parseInt(roupa);
	}

	public void setSobrancelha(String sobrancelha) {
		this.sobrancelha = Integer.parseInt(sobrancelha);
	}
	
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}	
	public void setId(int id) {
		this.id = id;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getBoca() {
		return boca;
	}

	public void setBoca(int boca) {
		this.boca = boca;
	}

	public int getCabelo() {
		return cabelo;
	}

	public void setCabelo(int cabelo) {
		this.cabelo = cabelo;
	}

	public int getNariz() {
		return nariz;
	}

	public void setNariz(int nariz) {
		this.nariz = nariz;
	}

	public int getOlho() {
		return olho;
	}

	public void setOlho(int olho) {
		this.olho = olho;
	}

	public int getOrelha() {
		return orelha;
	}

	public void setOrelha(int orelha) {
		this.orelha = orelha;
	}

	public int getRosto() {
		return rosto;
	}

	public void setRosto(int rosto) {
		this.rosto = rosto;
	}

	public int getRoupa() {
		return roupa;
	}

	public void setRoupa(int roupa) {
		this.roupa = roupa;
	}

	public int getSobrancelha() {
		return sobrancelha;
	}

	public void setSobrancelha(int sobrancelha) {
		this.sobrancelha = sobrancelha;
	}

	public int getId() {
		return id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String getCorPele() {
		return corPele;
	}

	public void setCorPele(String corPele) {
		this.corPele = corPele;
	}

	public String getCorOlho() {
		return corOlho;
	}

	public void setCorOlho(String corOlho) {
		this.corOlho = corOlho;
	}
}
