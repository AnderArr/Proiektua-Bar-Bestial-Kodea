package packProiektua;

public class Jokalaria {
	protected KartaZerrenda eskuan;
	protected KartaZerrenda baraja;
	
	public Jokalaria(){
		this.baraja= new KartaZerrenda();
		this.eskuan= new KartaZerrenda();
	}
	
	private void sortuBaraja(String pKolorea){
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
		
		baraja.kartaGehitu(k1);
		baraja.kartaGehitu(k2);
		baraja.kartaGehitu(k3);
		baraja.kartaGehitu(k4);
		baraja.kartaGehitu(k5);
		baraja.kartaGehitu(k6);
		baraja.kartaGehitu(k7);
		baraja.kartaGehitu(k8);
		baraja.kartaGehitu(k9);
		baraja.kartaGehitu(k10);
		baraja.kartaGehitu(k11);
		baraja.kartaGehitu(k12);
		
		baraja.barajatu();
	}
	
	public KartaZerrenda getBaraja(){
		return this.baraja;
	}
	
	public KartaZerrenda getEskuan(){
		return this.eskuan;
	}
	
	private void sortuEskua(){
		Karta k1=baraja.kartaHartu();
		Karta k2=baraja.kartaHartu();
		Karta k3=baraja.kartaHartu();
		Karta k4=baraja.kartaHartu();
		eskuan.kartaGehitu(k1);
		eskuan.kartaGehitu(k2);
		eskuan.kartaGehitu(k3);
		eskuan.kartaGehitu(k4);	
	}
	
	public void jokalariaHasieratu(String pKolorea){
		this.sortuBaraja(pKolorea);
		this.sortuEskua();
}

	public void kartaMahairaBota(){

	}

	public void kartaBarajatikHartu(){
		this.eskuan.kartaGehitu(this.baraja.kartaHartu());
	}
}
