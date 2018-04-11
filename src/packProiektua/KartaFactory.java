package packProiektua;

public class KartaFactory {
	private static KartaFactory nKartaFactory;
	
	private KartaFactory(){}
	
	public static KartaFactory getKartaFactory(){
		if(nKartaFactory==null){
			nKartaFactory=new KartaFactory();
		}
		return nKartaFactory;
	}
	
	public Karta createKarta(String pIzena, String pKolorea){
		Karta nireKarta=null;
		if(pIzena=="Mofeta"){
			nireKarta=new MofetaKarta(pKolorea);
		}else if(pIzena=="Loroa"){
			nireKarta=new LoroKarta(pKolorea);
		} else if(pIzena=="Kanguroa"){
			nireKarta=new KanguroKarta(pKolorea);
		} else if(pIzena=="Tximinoa"){
			nireKarta=new TximinoKarta(pKolorea);
		} else if(pIzena=="Kamalehoia"){
			nireKarta=new KamalehoiKarta(pKolorea);
		} else if(pIzena=="Foka"){
			nireKarta=new FokaKarta(pKolorea);
		} else if(pIzena=="Zebra"){
			nireKarta=new ZebraKarta(pKolorea);
		} else if(pIzena=="Jirafa"){
			nireKarta=new JirafaKarta(pKolorea);
		} else if(pIzena=="Sugea"){
			nireKarta=new SugeKarta(pKolorea);
		} else if(pIzena=="Krokodiloa"){
			nireKarta=new KrokodiloKarta(pKolorea);
		} else if(pIzena=="Hipopotamoa"){
			nireKarta=new HipopotamoKarta(pKolorea);
		} else if(pIzena=="Lehoia"){
			nireKarta=new LehoiKarta(pKolorea);
		}
		return nireKarta;
	}
}