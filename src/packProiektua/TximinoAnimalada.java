package packProiektua;

public class TximinoAnimalada implements InterfaceAnimalada {

	public TximinoAnimalada(){}
	
	public void gaitasunaBurutu(int a,int b, Karta k) {
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		boolean tximinoak=false;
		Karta aux3=null;
		kZ.kartaEzabatu(k);
		for(int ind=0;ind<kZ.luzera();ind++){
			Karta aux=kZ.getKarta(ind);
			if (aux instanceof TximinoKarta){
				tximinoak=true;
				aux3=aux;
				kZ.kartaEzabatu(aux);
			}
		}		
		if (tximinoak){
			for(int i=0;i<kZ.luzera();i++){
				Karta aux2 = kZ.getKarta(i);
				if((aux2 instanceof HipopotamoKarta)||(aux2 instanceof KrokodiloKarta)){
					kZ.kartaEzabatu(aux2);
				}
					
			}
			kZ.hasieranJarri(aux3);
			kZ.hasieranJarri(k);
		}else{
			kZ.kartaGehitu(k);
		}
	}
}
