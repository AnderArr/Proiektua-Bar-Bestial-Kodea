package packProiektua;

public class KamalehoiKarta extends Karta{
	
	
	public KamalehoiKarta(String pKolorea){
		super("Kamalehoia",5,false,pKolorea,"<html>Jokoan sartzean,<br> ilarako beste animalia<br> baten gaitasuna<br> bereganatzen du,<br> ondoren kamalehoi bat<br> izatera bueltatzen da.<br><br><br></html>",3);
		this.ia= new KamalehoiAnimalada();
	}
	
	public void gaitasunaBurutu(int pos){
		this.ia.gaitasunaBurutu(pos);
	}

}
