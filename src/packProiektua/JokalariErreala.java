package packProiektua;

public class JokalariErreala extends Jokalaria {

	public JokalariErreala(){
		super();
	}
	
	public void kartaMahairaBota(int pPos, int aux, int aux2){
		Tableroa t= Tableroa.getNireTableroa();
		Karta k= this.eskuan.getKarta(pPos);
		this.eskuan.kartaEzabatu(k);
		t.getKola().kartaGehitu(k);
		if(t.getKola().luzera()>1){
			k.gaitasunaBurutu(aux,aux2,k);
		}
	}
}
