package packProiektua;

public class JirafaKarta extends Karta{

	
	public JirafaKarta(String pKolorea){
		super("Jirafa",8,true,pKolorea,"<html>Jokoan sartzean,<br> aurrean duen kartaren<br> gainetik pasako da,<br> bere balioa Jirafarena<br> baino txikiagoa bada.<br> Errepikakorra da.<br><br><br></html>",3,"C:/Kartak/Jirafa"+pKolorea+".png");
		this.ia=new JirafaAnimalada();
	}
	
	public void gaitasunaBurutu(int a,int b, Karta k){
		this.ia.gaitasunaBurutu(a,b, this);
	}
}
