package packProiektua;

public class CPUJokalaria extends Jokalaria {
	
	public CPUJokalaria(){
		super();
	}

	public void kartaMahairaBota(){
		Tableroa t=Tableroa.getNireTableroa();
		this.eskuan.barajatu();
		Karta e=this.eskuan.kartaHartu();
		t.getKola().kartaGehitu(e);
	}
}
