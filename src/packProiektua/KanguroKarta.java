package packProiektua;

public class KanguroKarta extends Karta{
		
	public KanguroKarta(String pKolorea){
		super("Kanguroa",3,false,pKolorea,"<html>Jokoan sartzean,<br> aurretik dituen animalia<br> bat edo biren gainetik<br> pasatuko da,<br> jokalariaren araberakoa.<br><br><br><br></html>",4,"C:/Kartak/Kanguro"+pKolorea+".png");
		this.ia= new KanguroAnimalada();
	}
	
	public void gaitasunaBurutu(int salto,int b, Karta k){
		this.ia.gaitasunaBurutu(salto,b,this);
	
	}
}
