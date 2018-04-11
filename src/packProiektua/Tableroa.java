package packProiektua;




public class Tableroa {
	private KartaZerrenda J1;
	private KartaZerrenda CPU;
	private KartaZerrenda kola;
	private KartaZerrenda sartuakJ1;
	private KartaZerrenda sartuakCPU;
	private KartaZerrenda eskuanJ1;
	private KartaZerrenda eskuanCPU;
	private static Tableroa nireTableroa;
	
	private Tableroa(){
		J1=new KartaZerrenda();
		CPU=new KartaZerrenda();
		kola=new KartaZerrenda();
		sartuakJ1=new KartaZerrenda();
		sartuakCPU=new KartaZerrenda();
		eskuanJ1=new KartaZerrenda();
		eskuanCPU=new KartaZerrenda();	
	}
	
	public KartaZerrenda getJ1(){
		return this.J1;
	}
	
	public KartaZerrenda getEskuanJ1(){
		return this.eskuanJ1;
	}
	
	public KartaZerrenda getCPU(){
		return this.CPU;
	}
	
	public KartaZerrenda getEskuanCPU(){
		return this.eskuanCPU;
	}
	
	public KartaZerrenda getSartuakJ1(){
		return this.sartuakJ1;
	}
	
	public KartaZerrenda getSartuakCPU(){
		return this.sartuakCPU;
	}
	
	public KartaZerrenda getKola(){
		return this.kola;
	}
	
	public static Tableroa getNireTableroa(){
		if(nireTableroa==null){
			nireTableroa=new Tableroa();
		}
		return nireTableroa;
	}
	
	
	private void sortuEskua(KartaZerrenda e1,KartaZerrenda b1){
		
		Karta k1=b1.kartaHartu();
		Karta k2=b1.kartaHartu();
		Karta k3=b1.kartaHartu();
		Karta k4=b1.kartaHartu();
		e1.kartaGehitu(k1);
		e1.kartaGehitu(k2);
		e1.kartaGehitu(k3);
		e1.kartaGehitu(k4);
	}
	
	public void jokoaHasieratu(){
		Tableroa t=Tableroa.getNireTableroa();
		t.sortuBaraja("Urdina", J1);
		t.sortuBaraja("Gorria", CPU);
		t.sortuEskua(eskuanJ1, J1);
		t.sortuEskua(eskuanCPU, CPU);
	}
}
