package packProiektua;

public class KamalehoiKarta extends Karta{
	
	
	public KamalehoiKarta(String pKolorea){
		super("Kamalehoia",5,false,pKolorea,"<html>Jokoan sartzean,<br> ilarako beste animalia<br> baten gaitasuna<br> bereganatzen du,<br> ondoren kamalehoi bat<br> izatera bueltatzen da.<br><br><br></html>",3);
	}
	
	public void gaitasunaBurutu(int pErabiltzailea){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		Karta aux = kZ.getKarta(pErabiltzailea);
		KartaFactory kF = KartaFactory.getKartaFactory();
		Karta k = kF.createKarta(aux.getIzena(), this.getKolorea());
		kZ.kartaEzabatu(this);
		kZ.kartaGehitu(k);
		//k.gaitasunaBurutu();
		int pos = kZ.posizioaLortu(k);
		kZ.kartaEzabatu(k);
		kZ.kartaPosizioanGehitu(pos, this);
	}
}