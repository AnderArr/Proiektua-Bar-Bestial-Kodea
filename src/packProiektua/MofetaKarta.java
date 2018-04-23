package packProiektua;


public class MofetaKarta extends Karta{
	
	public MofetaKarta(String pKolorea){
		super("Mofeta",1,false,pKolorea,"<html>Jokoan sartzean,<br> ilarako balio altueneko<br> bi espezieak<br> kanporatzen ditu.<br><br><br><br><br></html>",4);
		this.ia=new MofetaAnimalada();
		}
	
	public void gaitasunaBurutu(int a){
		this.ia.gaitasunaBurutu(a);		
	}
}
