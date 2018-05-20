package packProiektua;

public class LoroKarta extends Karta{
	
	public LoroKarta(String pKolorea){
		super("Loroa",2,false,pKolorea,"<html>Jokoan sartzean,<br> jokalariak nahi duen<br> animalia kanporatzen<br> du.<br><br><br><br><br></html>",4,"C:/Kartak/Loro"+pKolorea+".png");
		this.ia= new LoroAnimalada();
	}
	
	public void gaitasunaBurutu(int pos,int b, Karta k){
		this.ia.gaitasunaBurutu(pos,b, this);
	}
}
