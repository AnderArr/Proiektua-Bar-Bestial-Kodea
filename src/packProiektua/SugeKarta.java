package packProiektua;

public class SugeKarta extends Karta{
	
	
	public SugeKarta(String pKolorea){
		super("Sugea",9,true,pKolorea,"<html>Jokoan sartzean,<br> ilara ordenatzen du,<br> balio handienak atetik <br>hurbil uzten eta <br>txikienak kaletik <br>hurbil.<br><br><br></html>",2);
		this.ia=new SugeAnimalada();
		}
	
	public void gaitasunaBurutu(int a){
		this.ia.gaitasunaBurutu(a);
	}
	

}
