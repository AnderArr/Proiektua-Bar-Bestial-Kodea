package packProiektua;

public class KrokodiloKarta extends Karta{
	
	public KrokodiloKarta(String pKolorea){
		super("Krokodiloa",10,true,pKolorea, "<html>Jokoan sartzean,<br> bera baino balio<br> txikiagoak dituen kartak<br> jan, eta kalera<br> botatzen ditu.<br> Beti ere Zebra<br> bat aurretik ez badauka.<br> Errepikakorra da.</html>",3,"C:/Kartak/Krokodilo"+pKolorea+".png");
		this.ia= new KrokodiloAnimalada();
	}
	
	public void gaitasunaBurutu(int a, int b,Karta k){
		this.ia.gaitasunaBurutu(a,b,this);
	}
}
