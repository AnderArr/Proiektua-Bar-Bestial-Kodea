package packProiektua;
import java.util.ArrayList;
import java.util.Collections;

public class KartaZerrenda {
	
	private ArrayList<Karta> kartaZerrenda;
	private int kartaKop;
	
	public KartaZerrenda(){
		this.kartaZerrenda=new ArrayList<Karta>();
		this.kartaKop=0;
	}
	
	public void kartaGehitu(Karta pKarta){
		this.kartaZerrenda.add(pKarta);
		this.kartaKop=this.kartaKop+1;
	}
	
	public void kartaKendu(int pos){
		if (pos<kartaZerrenda.size()){
			this.kartaZerrenda.remove(pos);
			this.kartaKop--;
		}
	}

	public Karta kartaHartu(){
		Karta k=null;
		if (kartaZerrenda.size()!=0){
			k=this.kartaZerrenda.get(0);
			this.kartaZerrenda.remove(0);
			this.kartaKop--;
		}
		return k;
	}
	
	public void barajatu(){
		Collections.shuffle(this.kartaZerrenda);
	}
	public int luzera(){
		return kartaZerrenda.size();
	}
	public Karta getKarta(int i){
	
		return this.kartaZerrenda.get(i);
	}
}
