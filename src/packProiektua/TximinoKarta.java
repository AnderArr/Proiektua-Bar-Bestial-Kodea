package packProiektua;

import java.util.Iterator;

public class TximinoKarta extends Karta{
	
	
	public TximinoKarta(String pKolorea){
		super("Tximinoa",4,false,pKolorea,"<html>Jokoan sartzean,<br> beste tximino bat<br> aurrean badauka,<br> hipopotamoak eta <br>krokodiloak kalera  <br>botatzen ditu eta  <br>tximinoak lehendabizikoak <br>jartzen dira.<br></html>",3);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		Iterator<Karta> itr = kZ.getIteradorea();
		Karta k1=itr.next();
		boolean irten=false;
		while((k1!=this) && (!irten)){
			if (k1.getIzena().equals(this.izena)){
				irten=true;
			}
			k1=itr.next();
		}
		if (irten){
			Iterator<Karta> itr2 = kZ.getIteradorea();
			Karta aux = itr2.next();
			while(aux!=this){
				if (aux.getIzena().equals("Hipotamoa")||aux.getIzena().equals("Kokodriloa")){
					kZ.kartaEzabatu(aux);
				}
				aux=itr2.next();
			}
			kZ.hasieranJarri(k1);
			kZ.hasieranJarri(this);
		}
	}
	

}
