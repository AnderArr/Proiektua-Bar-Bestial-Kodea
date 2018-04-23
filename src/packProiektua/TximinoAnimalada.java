package packProiektua;

import java.util.Iterator;

public class TximinoAnimalada implements InterfaceAnimalada {

	public TximinoAnimalada(){}
	@Override
	public void gaitasunaBurutu(int a) {
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		Karta k= t.getKola().azkenaLortu();
			Iterator<Karta> itr = kZ.getIteradorea();
			Karta k1=itr.next();
			boolean irten=false;
			while((k1!=k) && (!irten)){
				if (k1.getIzena().equals(k.izena)){
					irten=true;
				}
				k1=itr.next();
			}
			if (irten){
				Iterator<Karta> itr2 = kZ.getIteradorea();
				Karta aux = itr2.next();
				while(aux!=k){
					if (aux.getIzena().equals("Hipotamoa")||aux.getIzena().equals("Kokodriloa")){
						kZ.kartaEzabatu(aux);
					}
					aux=itr2.next();
				}
				kZ.hasieranJarri(k1);
				kZ.hasieranJarri(k);
			}

	}

}
