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
		if(t.getKola().luzera()>1){
			if (e instanceof KamalehoiKarta){
				if (t.getKola().getKarta(0) instanceof KamalehoiKarta){
					if (t.getKola().luzera()>2){
						e.gaitasunaBurutu(1,0,e);
					}
				}else{
					e.gaitasunaBurutu(0,0,e);
				}
			}else{
				e.gaitasunaBurutu(0,0,e);
			}
		}
	}
}
