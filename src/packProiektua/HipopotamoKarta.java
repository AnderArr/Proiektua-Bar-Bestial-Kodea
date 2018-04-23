package packProiektua;

public class HipopotamoKarta extends Karta{
	
	public HipopotamoKarta(String pKolorea){
		super("Hipopotamoa",11,true,pKolorea,"<html>Jokoan sartzean,<br> bere balioa baino<br> txikiagoak diren<br> karten aurretik<br> kokatzen da,<br> beti ere Zebra<br> bat aurretik ez badago.<br> Errepikakorra da.</html>",2);
		this.ia= new HipopotamoAnimalada();
	}
	
	public void gaitasunaBurutu(int a){
		this.ia.gaitasunaBurutu(a);
	}

}
