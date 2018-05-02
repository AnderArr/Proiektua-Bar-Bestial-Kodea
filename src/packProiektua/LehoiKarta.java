package packProiektua;

public class LehoiKarta extends Karta{
	
	public LehoiKarta(String pKolorea){
		super("Lehoia",12,false,pKolorea,"<html>Jokoan sartzean, ilaran<br> beste lehoirik ez badago,<br> lehendabizikoa kokatzen <br>da eta tximinoak kalera<br> botatzen ditu baina<br> beste lehoi bat<br> baldin badago karta<br> bera kalera doa.</html>",2);
		this.ia= new LehoiAnimalada();
	}
	
	public void gaitasunaBurutu(int a, int b, Karta k){
		this.ia.gaitasunaBurutu(a,b, this);
	}
}
