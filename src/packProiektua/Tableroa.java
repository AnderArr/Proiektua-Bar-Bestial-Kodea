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
	
	private void sortuBaraja(String pKolorea,KartaZerrenda b1){
		KartaFactory kf=KartaFactory.getKartaFactory();
		
		Karta k1=kf.createKarta("Mofeta", pKolorea);
		Karta k2=kf.createKarta("Loroa", pKolorea);
		Karta k3=kf.createKarta("Kanguroa", pKolorea);
		Karta k4=kf.createKarta("Tximinoa", pKolorea);
		Karta k5=kf.createKarta("Kamalehoia", pKolorea);
		Karta k6=kf.createKarta("Foka", pKolorea);
		Karta k7=kf.createKarta("Zebra", pKolorea);
		Karta k8=kf.createKarta("Jirafa", pKolorea);
		Karta k9=kf.createKarta("Sugea", pKolorea);
		Karta k10=kf.createKarta("Krokodiloa", pKolorea);
		Karta k11=kf.createKarta("Hipopotamoa", pKolorea);
		Karta k12=kf.createKarta("Lehoia", pKolorea);
		
		b1.kartaGehitu(k1);
		b1.kartaGehitu(k2);
		b1.kartaGehitu(k3);
		b1.kartaGehitu(k4);
		b1.kartaGehitu(k5);
		b1.kartaGehitu(k6);
		b1.kartaGehitu(k7);
		b1.kartaGehitu(k8);
		b1.kartaGehitu(k9);
		b1.kartaGehitu(k10);
		b1.kartaGehitu(k11);
		b1.kartaGehitu(k12);
		
		b1.barajatu();		
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