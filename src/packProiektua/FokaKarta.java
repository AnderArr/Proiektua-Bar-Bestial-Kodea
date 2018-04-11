package packProiektua;

import java.util.Iterator;

public class FokaKarta extends Karta{
	
	
	public FokaKarta(String pKolorea){
		super("Foka",6,false,pKolorea,"<html>Jokoan sartzean,<br>ilararen ordena aldatzen<br>  du buelta emanez.<br> <br><br><br><br><br></html>",2);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		if (kZ.luzera()>1){
			Iterator<Karta> itr= kZ.getIteradorea();
			Karta k1=itr.next();
			kZ.elkartrukatu(k1, this, kZ.posizioaLortu(k1), kZ.posizioaLortu(this));
			if (kZ.luzera()>3){
				k1=itr.next();
				Karta aux=null;
				if (kZ.luzera()==4){
					aux = itr.next();
				} else {
					if (kZ.luzera()==5){
						itr.next();
						aux = itr.next();
					}
				}
				kZ.elkartrukatu(k1, aux, kZ.posizioaLortu(k1), kZ.posizioaLortu(aux));
			}
		}
	}
}