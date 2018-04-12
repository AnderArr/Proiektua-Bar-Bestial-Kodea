package packProiektua;

import java.util.Iterator;

public class LehoiKarta extends Karta{
	
	
	public LehoiKarta(String pKolorea){
		super("Lehoia",12,true,pKolorea,"<html>Jokoan sartzean, ilaran<br> beste lehoirik ez badago,<br> lehendabizikoa kokatzen <br>da eta tximinoak kalera<br> botatzen ditu baina<br> beste lehoi bat<br> baldin badago karta<br> bera kalera doa.</html>",2);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		Iterator<Karta> itr = kZ.getIteradorea();
		Karta aux=itr.next();
		boolean irten = true;
		while ((aux!=this)&&(!irten)){
			if (aux.getIzena().equals(this.izena)){
				irten=true;
			}
			aux=itr.next();
		}
		if (!irten){
			Iterator<Karta> itr2= kZ.getIteradorea();
			aux=itr2.next();
			while (aux!=this){
				if (aux.getIzena().equals("Tximinoa")){
					kZ.kartaEzabatu(aux);
				}
				aux=itr2.next();
			}
			kZ.hasieranJarri(this);
		}
	}
}