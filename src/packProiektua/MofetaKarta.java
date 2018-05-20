package packProiektua;

import java.util.Iterator;

public class MofetaKarta extends Karta{
	
	public MofetaKarta(String pKolorea){
		super("Mofeta",1,false,pKolorea,"<html>Jokoan sartzean,<br> ilarako balio altueneko<br> bi espezieak<br> kanporatzen ditu.<br><br><br><br><br></html>",4,"C:/Kartak/Mofeta"+pKolorea+".png");
		this.ia=new MofetaAnimalada();
	}

	public void gaitasunaBurutu(int a,int b, Karta k){
		this.ia.gaitasunaBurutu(a,b, this);		
	}
}
