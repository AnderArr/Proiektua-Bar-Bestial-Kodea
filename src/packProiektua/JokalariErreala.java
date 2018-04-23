package packProiektua;

public class JokalariErreala extends Jokalaria {

	public JokalariErreala(){
		super();
	}
	
	public void kartaMahairaBota(int pPos, int aux){
		Tableroa t= Tableroa.getNireTableroa();
		Karta k= this.eskuan.getKarta(pPos);
		this.eskuan.kartaEzabatu(k);
		t.getKola().kartaGehitu(k);
		if(t.getKola().luzera()>1){
			k.gaitasunaBurutu(aux);
		}
	}
}
