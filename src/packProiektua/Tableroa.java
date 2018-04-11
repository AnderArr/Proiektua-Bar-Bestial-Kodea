package packProiektua;




public class Tableroa {
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
	
	
	public void jokoaHasieratu(){
		J1.jokalariaHasieratu("Urdina");
		CPU.jokalariaHasieratu("Berdea");
	}
	
}
