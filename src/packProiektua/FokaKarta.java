package packProiektua;

import java.util.Iterator;

public class FokaKarta extends Karta{
	
	
	public FokaKarta(String pKolorea){
		super("Foka",6,false,pKolorea,"<html>Jokoan sartzean,<br>ilararen ordena aldatzen<br>  du buelta emanez.<br> <br><br><br><br><br></html>",2,"C:/Kartak/Foka"+pKolorea+".png");
		this.ia= new FokaAnimalada();
	}
	
	public void gaitasunaBurutu(int a,int b, Karta k){
				ia.gaitasunaBurutu(a,b,this);
	}

	
}
