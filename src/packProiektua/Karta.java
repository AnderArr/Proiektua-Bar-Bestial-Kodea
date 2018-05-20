package packProiektua;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Karta implements InterfaceAnimalada{
	protected InterfaceAnimalada ia;
	protected int zenbakia;
	protected String izena;
	protected boolean errepikatu;
	protected String gaitasuna;
	protected String kolorea;
	protected String deskribapena;
	protected int balioa;
	protected String karta;
	
	
	public Karta(String pIzena,int pZenbakia, boolean pErrepikatu, String pKolorea, String pDeskribapena,int pBalioa, String pKarta){
		this.izena=pIzena;
		this.balioa=pBalioa;
		this.errepikatu=pErrepikatu;
		this.kolorea=pKolorea;
		this.deskribapena=pDeskribapena;
		this.zenbakia=pZenbakia;
		this.karta=pKarta;
	}
	
	public void setZenbakia(int z){
		this.zenbakia=z;
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
		
	public boolean getErrepikatu(){
		return this.errepikatu;
	}
	
	public String getKartaIrudia(){
		String s1="<html>"+String.valueOf(this.zenbakia)+"<br>"+this.izena+"<br>"+this.kolorea+"<br>"+this.deskribapena+"</html>";
		return s1;
	}
	
	public String getKarta(){
		return this.karta;
	}
}
