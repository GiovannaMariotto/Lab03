package model;

public class RichWord {

	private String parola;
	private boolean correta;
	/**
	 * JAVA BEAN
	 * @param parola:String
	 * @param correta: boolean
	 */
	public RichWord(String parola, boolean correta) {
		super();
		this.parola = parola;
		this.correta = correta;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
	
	
}
