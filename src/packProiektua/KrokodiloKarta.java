package packProiektua;

public class KrokodiloKarta extends Karta{
	
	
	public KrokodiloKarta(String pKolorea){
		super("Krokodiloa",10,true,pKolorea, "<html>Jokoan sartzean,<br> bera baino balio<br> txikiagoak dituen kartak<br> jan, eta kalera<br> botatzen ditu.<br> Beti ere Zebra<br> bat aurretik ez badauka.<br> Errepikakorra da.</html>",3);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		if (kZ.luzera()>1){
			boolean irten=false;
			Karta aux= kZ.getKarta(kZ.luzera()-1);
			while ((aux.getBalioa()<this.balioa)&&(!irten)){
				kZ.kartaEzabatu(aux);
				int ind=kZ.posizioaLortu(this);
				if (ind>1){
					aux=kZ.getKarta(ind-1);
				} else {
					irten=true;
				}
				
			}
		}
	}
}