package packProiektua;

public abstract class Karta {
	private int zenbakia;
	private String izena;
	private boolean errepikatu;
	private String gaitasuna;
	private String kolorea;
	private String deskribapena;
	private int balioa;
	
	public Karta(String pIzena,int pZenbakia, boolean pErrepikatu, String pKolorea, String pDeskribapena,int pBalioa){
		this.izena=pIzena;
		this.balioa=pBalioa;
		this.errepikatu=pErrepikatu;
		this.kolorea=pKolorea;
		this.deskribapena=pDeskribapena;
		this.zenbakia=pZenbakia;
	}
	
	public void gaitasunaBurutu(KartaZerrenda kZ){	
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
