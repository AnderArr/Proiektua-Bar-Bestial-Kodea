package packProiektua;

import java.util.ArrayList;
import java.util.Observable;

public class Tableroa extends Observable{
	private JokalariErreala J1;
	private CPUJokalaria CPU;
	private KartaZerrenda kola;
	private KartaZerrenda sartuakJ1;
	private KartaZerrenda sartuakCPU;
	private static Tableroa nireTableroa;
	
	private Tableroa(){
		J1=new JokalariErreala();
		CPU=new CPUJokalaria();
		kola=new KartaZerrenda();
		sartuakJ1=new KartaZerrenda();
		sartuakCPU=new KartaZerrenda();
		
	}
	
	public JokalariErreala get(){
		return this.J1;
	}
	public KartaZerrenda getJ1(){
		return this.J1.getBaraja();
	}
	public KartaZerrenda getEskuanJ1(){
		return this.J1.getEskuan();
	}
	public KartaZerrenda getCPU(){
		return this.CPU.getBaraja();
	}
	public KartaZerrenda getEskuanCPU(){
		return this.CPU.getEskuan();
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
	
	public boolean daudeKartak(){
		if(this.kola.luzera()==0){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	public void txandaJokatu(int pos,int aux){
	    J1.kartaMahairaBota(pos,aux);
	    J1.kartaBarajatikHartu();
	    //animaladaRekurrenteak();
	    if(this.kola.luzera()==5){
	    	this.kolaEguneratu();
	    }
	    
		//CPU.kartaMahairaBota();
		//CPU.kartaBarajatikHartu();
		//animaladaRekurrenteak();
		if(this.kola.luzera()==5){
	    	this.kolaEguneratu();
	    }
		ArrayList<String> bz=new ArrayList<String>();
		for(int i=0;i<this.kola.luzera();i++){
			bz.add(this.kola.getKarta(i).getKartaIrudia());
		}
		bz.add("/");
		for(int ind=0;ind<this.J1.getEskuan().luzera();ind++){
			bz.add(this.J1.getEskuan().getKarta(ind).getKartaIrudia());
		}
		setChanged();
		notifyObservers(bz);
}

	public boolean kamalehoiaDa(int pPos){
		return this.getEskuanJ1().kamalehoiaDa(pPos);
	}
	
	public boolean loroaDaKolan(int pPos){
		return this.kola.loroaDa(pPos);
	}
	
	public boolean kanguroaDaKolan(int pPos){
		return this.kola.kanguroaDa(pPos);
	}
	
	
	
	public boolean loroaDa(int pPos){
		return this.getEskuanJ1().loroaDa(pPos);
	}
	
	public boolean kartakGeratuEskuan(){
		return this.getEskuanJ1().luzera()!=0;
	}
	
	public boolean kartakGeratuBarajan(){
		return this.J1.kartakGeratuBarajan();
	}
	
	public boolean kanguroaDa(int pPos){
		return this.getEskuanJ1().kanguroaDa(pPos);
	}

public void animaladaRekurrenteak(){
	for(int i=0;i<this.kola.luzera();i++){
		Karta k= this.kola.getKarta(i);
		if (k.getErrepikatu() && this.kola.luzera()>1){
			k.gaitasunaBurutu(0);
		}
	}
}

public boolean bukatuta(){
	return ((this.J1.getEskuan().luzera()==0)&&(this.CPU.getEskuan().luzera()==0));
}

public void kolaEguneratu(){
	this.kola.kartaKendu(4);
	Karta k1= this.kola.kartaHartu();
	Karta k2= this.kola.kartaHartu();
	this.sartuBereLekuan(k1);
	this.sartuBereLekuan(k2);
	
}

public String irabazleaLortu(){
	int punt1=0;
	int punt2=0;
	for(int i=0;i<this.sartuakJ1.luzera();i++){
		punt1=punt1+this.sartuakJ1.getKarta(i).getBalioa();
	}
	for(int j=0;j<this.sartuakCPU.luzera();j++){
		punt2=punt2+this.sartuakCPU.getKarta(j).getBalioa();
	}
	if (punt1>punt2){
		return "J1 irabazi du";
	}
	else{
		if(punt1<punt2){
			return "CPU irabazi du";
		}
		else{
			return "Berdinketa egon da";
		}
	}
	
}


public void sartuBereLekuan(Karta k1){
	if(k1.getKolorea().equals("Urdina")){
		this.sartuakJ1.kartaGehitu(k1);
	}else{
		this.sartuakCPU.kartaGehitu(k1);
	}
}

public boolean kamalehoiaDa(String a){
	KamalehoiKarta k=new KamalehoiKarta("berdea");
	if(a.equals(k.getKartaIrudia())){
		return true;
	}else{
		return false;
	}
}






	
	
	public void jokoaHasieratu(){
		J1.jokalariaHasieratu("Urdina");
		CPU.jokalariaHasieratu("Berdea");
		ArrayList<String> bz=new ArrayList<String>();
		for(int i=0;i<this.kola.luzera();i++){
			bz.add(this.kola.getKarta(i).getKartaIrudia());
		}
		bz.add("/");
		for(int ind=0;ind<this.J1.getEskuan().luzera();ind++){
			bz.add(this.J1.getEskuan().getKarta(ind).getKartaIrudia());
		}
		setChanged();
		notifyObservers(bz);
		
		
	}
	
}
