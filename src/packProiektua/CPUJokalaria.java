package packProiektua;

public class KanguroAnimalada implements InterfaceAnimalada {

	public KanguroAnimalada(){}
	@Override
	public void gaitasunaBurutu(int salto) {
		Tableroa t =  Tableroa . getNireTableroa ();
		Karta k= t.getKola().azkenaLortu();
		 KartaZerrenda kZ = t . getKola ();
		 if (kZ . luzera () > 1 ) {
				 Karta aux = kZ . getKarta (kZ . luzera () - 1 );
				 kZ . elkartrukatu (aux, k , kZ . posizioaLortu (aux), kZ . posizioaLortu ( k ));
				 if (salto == 2 && kZ . luzera () > 2) {
					 aux = kZ . getKarta (kZ . posizioaLortu ( k ) - 1 );
					 kZ . elkartrukatu (aux, k , kZ . posizioaLortu (aux), kZ . posizioaLortu ( k ));
				 }
		 }
	}

}

