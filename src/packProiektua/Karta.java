package packProiektua;

public abstract class Karta {
	protected int zenbakia;
	protected String izena;
	protected boolean errepikatu;
	protected String gaitasuna;
	protected String kolorea;
	protected String deskribapena;
	protected int balioa;
	
	public Karta(String pIzena,int pZenbakia, boolean pErrepikatu, String pKolorea, String pDeskribapena,int pBalioa){
		this.izena=pIzena;
		this.balioa=pBalioa;
		this.errepikatu=pErrepikatu;
		this.kolorea=pKolorea;
		this.deskribapena=pDeskribapena;
		this.zenbakia=pZenbakia;
	}
	
	public void gaitasunaBurutu(){
		
	}
	public String getIzena(){
		return this.izena;
	}
	public int getZenbakia(){
		return this.zenbakia;
	}
	public int getBalioa(){
		return this.balioa;
	}
	public String getKolorea(){
		return this.kolorea;
	}
	public String getDeskribapena(){
		return this.deskribapena;
	}
	
	

}
