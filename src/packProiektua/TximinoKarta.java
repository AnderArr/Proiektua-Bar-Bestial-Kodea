package packProiektua;

public class TximinoKarta extends Karta{
	
	public TximinoKarta(String pKolorea){
		super("Tximinoa",4,false,pKolorea,"<html>Jokoan sartzean,<br> beste tximino bat<br> aurrean badauka,<br> hipopotamoak eta <br>krokodiloak kalera  <br>botatzen ditu eta  <br>tximinoak lehendabizikoak <br>jartzen dira.<br></html>",3,"C:/Kartak/Tximino"+pKolorea+".png");
		this.ia= new TximinoAnimalada();
	}
	
	public void gaitasunaBurutu(int a,int b, Karta k){
		this.ia.gaitasunaBurutu(a, b,this);
	}
}
