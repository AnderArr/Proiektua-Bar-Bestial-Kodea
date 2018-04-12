package packProiektua;

public class JirafaKarta extends Karta{

	
	public JirafaKarta(String pKolorea){
		super("Jirafa",8,true,pKolorea,"<html>Jokoan sartzean,<br> aurrean duen kartaren<br> gainetik pasako da,<br> bere balioa Jirafarena<br> baino txikiagoa bada.<br> Errepikakorra da.<br><br><br></html>",3);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		if (kZ.luzera()>1){
			boolean irten=false;
			Karta aux= kZ.getKarta(kZ.luzera()-1);
			while ((aux.getBalioa()<this.balioa)&&(!irten)){
				kZ.elkartrukatu(aux, this, kZ.posizioaLortu(aux), kZ.posizioaLortu(this));
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
