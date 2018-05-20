package packProiektua;

public class ZebraKarta extends Karta{
	
	
	public ZebraKarta(String pKolorea){
		super("Zebra",7,true,pKolorea,"<html>Jokoan sartzean,<br> Hipopotamoen eta<br> Krokodiloen mugimendua<br> gelditzen du.<br> Errepikakorra da.<br><br><br><br></html>",4,"C:/Kartak/Zebra"+pKolorea+".png");
		this.ia= new ZebraAnimalada();
	}

	public void gaitasunaBurutu(int a,int b, Karta k){
		this.ia.gaitasunaBurutu(a,b, this);
	}
}
