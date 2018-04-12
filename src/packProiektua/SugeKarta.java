package packProiektua;

public class SugeKarta extends Karta{
	
	
	public SugeKarta(String pKolorea){
		super("Sugea",9,true,pKolorea,"<html>Jokoan sartzean,<br> ilara ordenatzen du,<br> balio handienak atetik <br>hurbil uzten eta <br>txikienak kaletik <br>hurbil.<br><br><br></html>",2);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		int luzera=kZ.luzera();
		Karta aux1=null;
		Karta aux2=null;
		for (int ind=0; ind<luzera;ind++){
			aux1=kZ.getKarta(ind);
			for (int ind2=ind; ind2<luzera; ind2++){
				aux2=kZ.getKarta(ind2);
				if (aux2.getBalioa()>aux1.getBalioa()){
					aux1=aux2;
				}
			}
			kZ.elkartrukatu(kZ.getKarta(0), aux1, ind, kZ.posizioaLortu(aux1));
		}
		
	}
}