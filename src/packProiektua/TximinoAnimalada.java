package packProiektua;

public class TximinoAnimalada implements InterfaceAnimalada {

	public TximinoAnimalada(){}
	
	public void gaitasunaBurutu(int a,int b, Karta k) {
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		boolean tximinoak=false;
		Karta aux3=null;
		Karta aux=null;
		kZ.kartaEzabatu(k);
		for(int ind=0;ind<kZ.luzera();ind++){
			aux=kZ.getKarta(ind);
			if (aux instanceof TximinoKarta){
				tximinoak=true;
				aux3=aux;
				kZ.kartaEzabatu(aux);
			}
		}		
		if (tximinoak){
			int ind=0;
			Karta aux2 = null;
			while (ind<kZ.luzera()){
				aux2 = kZ.getKarta(ind);
				if((aux2 instanceof HipopotamoKarta)||(aux2 instanceof KrokodiloKarta)){
					kZ.kartaEzabatu(aux2);
				} else {
					ind++;
				}
					
			}
			kZ.hasieranJarri(aux3);
			kZ.hasieranJarri(k);
		}else{
			kZ.kartaGehitu(k);
		}
	}
}
