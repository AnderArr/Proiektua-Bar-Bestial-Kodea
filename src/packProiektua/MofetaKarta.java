package packProiektua;

import java.util.Iterator;

public class MofetaKarta extends Karta{
	
	public MofetaKarta(String pKolorea){
		super("Mofeta",1,false,pKolorea,"<html>Jokoan sartzean,<br> ilarako balio altueneko<br> bi espezieak<br> kanporatzen ditu.<br><br><br><br><br></html>",4);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ=t.getKola();
		if ((kZ.luzera()>=2) && (!kZ.getKarta(0).getIzena().equals(this.izena))){
			Karta k1=null;
			k1=kZ.getKarta(0);
			if ((kZ.luzera()>=3) && (!kZ.getKarta(1).getIzena().equals(this.izena))){
				Karta k2=null;
				k2=kZ.getKarta(1);
				if (kZ.luzera()>=4){
					Karta aux=null;
					Karta k3=null;
					Karta k4=null;
					if (k1.getBalioa()>k2.getBalioa()){
						aux=k1;
						k1=k2;
						k2=aux;
					}
					Iterator<Karta> itr = kZ.getIteradorea();
					itr.next();
					itr.next();
					aux=itr.next();
					while (aux!=this){
						if (aux.getZenbakia()>k1.getZenbakia()){
							k2=k1;
							k1=aux;
							k4=k3;
							k3=null;
						} else {
							if (aux.getIzena().equals(k1.getIzena())){
								k3=aux;
							} else {
								if (aux.getZenbakia()>k2.getZenbakia()){
									k2=aux;
									k4=null;
								} else {
									if (aux.getIzena().equals(k2.getIzena())){
										k4=aux;
									}
								}
							}
						}
						aux=itr.next();
					}
					if (k4!=null){
						kZ.kartaEzabatu(k4);
					} else {
						if (k3!=null){
							kZ.kartaEzabatu(k3);
						}
					}
				}
				kZ.kartaEzabatu(k2);
			}
			kZ.kartaEzabatu(k1);
		}		
	}
}