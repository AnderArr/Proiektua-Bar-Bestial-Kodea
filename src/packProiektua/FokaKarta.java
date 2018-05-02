package packProiektua;

public class FokaKarta extends Karta{
	
	public FokaKarta(String pKolorea){
		super("Foka",6,false,pKolorea,"<html>Jokoan sartzean,<br>ilararen ordena aldatzen<br>  du buelta emanez.<br> <br><br><br><br><br></html>",2);
		this.ia= new FokaAnimalada();
	}
	
	public void gaitasunaBurutu(int a,int b, Karta k){
				ia.gaitasunaBurutu(a,b,this);
	}
}
