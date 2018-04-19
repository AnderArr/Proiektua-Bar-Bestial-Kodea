package packProiektua;

public class KanguroKarta extends Karta{
	
	
	public KanguroKarta(String pKolorea){
		super("Kanguro",3,false,pKolorea,"<html>Jokoan sartzean,<br> aurretik dituen animalia<br> bat edo biren gainetik<br> pasatuko da,<br> jokalariaren araberakoa.<br><br><br><br></html>",4);
	}
	
	public void gaitasunaBurutu(){
		Tableroa t= Tableroa.getNireTableroa();
		KartaZerrenda kZ = t.getKola();
		if (kZ.luzera()>1){
			String galdera="Zenbat karten gainetik egin nahi duzu salto?";
			int salto=kZ.galdetu(galdera);
			Karta aux= kZ.getKarta(kZ.luzera()-1);
			kZ.elkartrukatu(aux, this, kZ.posizioaLortu(aux), kZ.posizioaLortu(this));
			if (salto==2){
				aux= kZ.getKarta(kZ.posizioaLortu(this)-1);
				kZ.elkartrukatu(aux, this, kZ.posizioaLortu(aux), kZ.posizioaLortu(this));
			}
		}		
	}
}