package packProiektua;

public class LoroKarta extends Karta{
	
	
	public LoroKarta(String pKolorea){
		super("Loroa",2,false,pKolorea,"<html>Jokoan sartzean,<br> jokalariak nahi duen<br> animalia kanporatzen<br> du.<br><br><br><br><br></html>",4);
	}
	
	public void gaitasunaBurutu(int pErabiltzailea){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		kZ.kartaKendu(pErabiltzailea);
	}
}