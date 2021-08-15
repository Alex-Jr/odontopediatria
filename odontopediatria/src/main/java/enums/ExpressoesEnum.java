package enums;

public enum ExpressoesEnum {
	TRISTE(-3), FELIZ(3);
	
	private int ansiedade;
	
	ExpressoesEnum(int ansiedade) {
		this.ansiedade = ansiedade;
	}
	
	public int getAnsiedade() {
		return ansiedade;
	}
}
