package packProiektua;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
	
	public boolean kamalehoiaDa(int pPos){
		if (this.getKarta(pPos) instanceof KamalehoiKarta){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean kanguroaDa(int pPos){
		if (this.getKarta(pPos) instanceof KanguroKarta){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean loroaDa(int pPos){
		if (this.getKarta(pPos) instanceof LoroKarta){
			return true;
		}else{
			return false;
		}
	}
	
	public void barajatu(){
		Collections.shuffle(this.kartaZerrenda);
	}
	
	public int luzera(){
		return kartaKop;
	}
	
	public Karta getKarta(int i){
		return this.kartaZerrenda.get(i);
	}
	
	public Iterator<Karta> getIteradorea(){
		return this.kartaZerrenda.iterator();
	}
	
	public void kartaEzabatu(Karta k1){
		this.kartaZerrenda.remove(k1);
		this.kartaKop--;
	}
	
	public void hasieranJarri(Karta k1){
		this.kartaZerrenda.add(0, k1);
		this.kartaKop++;
	}
	
	public void elkartrukatu (Karta k1, Karta k2, int pos1, int pos2){
		this.kartaZerrenda.set(pos2, k1);
		this.kartaZerrenda.set(pos1, k2);
	}
	
	public int posizioaLortu(Karta k1){
		
		return this.kartaZerrenda.indexOf(k1);
	}
	
	public int galdetu(String pGaldera){
		System.out.println(pGaldera);
		int aux=0;
		return aux;
	}
	
	public void kamalehoiZenbakia(){
		for (int i=0;i<this.kartaKop;i++){
			if(this.kartaZerrenda.get(i) instanceof KamalehoiKarta){
				this.kartaZerrenda.get(i).setZenbakia(5);
			}
		}
	}
	
	public void kartaPosizioanGehitu(int ind, Karta pKarta){
		this.kartaZerrenda.add(ind, pKarta);
		this.kartaKop++;
	}
	
	public Karta azkenaLortu(){
		return this.getKarta(kartaKop-1);
	}
}
