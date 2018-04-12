package packProiektua;

public class HipopotamoKarta extends Karta{
	
	public HipopotamoKarta(String pKolorea){
		super("Hipopotamoa",11,true,pKolorea,"<html>Jokoan sartzean,<br> bere balioa baino<br> txikiagoak diren<br> karten aurretik<br> kokatzen da,<br> beti ere Zebra<br> bat aurretik ez badago.<br> Errepikakorra da.</html>",2);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		if (kZ.luzera()>1){
			boolean irten=false;
			Karta aux = kZ.getKarta(kZ.luzera()-1);
			while((aux.getBalioa()<this.balioa)&&(!aux.getIzena().equals("Zebra")&&(!irten))){
				kZ.elkartrukatu(aux, this, kZ.posizioaLortu(aux), kZ.posizioaLortu(this));
				int ind =kZ.posizioaLortu(this);
				if (ind<1){
					aux=kZ.getKarta(ind);
				} else {
					irten=true;
				}
			}
		}
	}
	

}
