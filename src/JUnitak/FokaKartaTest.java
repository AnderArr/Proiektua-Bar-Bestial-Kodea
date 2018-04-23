package JUnitak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packProiektua.Karta;
import packProiektua.KartaFactory;
import packProiektua.KartaZerrenda;
import packProiektua.Tableroa;

public class FokaKartaTest {
	private Tableroa t;
	private Karta k1;
	private Karta k2;
	private Karta k3;
	private Karta k4;
	private Karta k5;
	private KartaZerrenda kZ;
	private KartaFactory kF;

	@Before
	public void setUp() throws Exception {
		t=Tableroa.getNireTableroa();
		t.jokoaHasieratu();
		kF=KartaFactory.getKartaFactory();
		k1= kF.createKarta("Tximinoa", "Urdina");
		k2= kF.createKarta("Lehoia", "Urdina");
		k3= kF.createKarta("Kanguroa", "Gorria");
		k4= kF.createKarta("Lehoia", "Urdina");
		k5= kF.createKarta("Foka", "Urdina");
		kZ=t.getKola();
	}

	@After
	public void tearDown() throws Exception {
		t=null;
		k1=null;
		k2=null;
		k3=null;
		k4=null;
		k5=null;
		kF=null;
		kZ=null;
	}

	@Test
	public void testGaitasunaBurutu() {
		//Proba karta bakarra.
		kZ.kartaGehitu(k5);
		k5.gaitasunaBurutu(0);
		assertTrue(kZ.getKarta(0).equals(k5));
		kZ.kartaEzabatu(k5);
		
		//Proba 2 karta.
		kZ.kartaGehitu(k1);
		kZ.kartaGehitu(k5);
		k5.gaitasunaBurutu(0);
		assertTrue(kZ.getKarta(0).equals(k5));
		assertTrue(kZ.getKarta(1).equals(k1));
		kZ.kartaEzabatu(k1);
		kZ.kartaEzabatu(k5);
		
		//Proba 3 karta.
		kZ.kartaGehitu(k1);
		kZ.kartaGehitu(k2);
		kZ.kartaGehitu(k5);
		k5.gaitasunaBurutu(0);
		assertTrue(kZ.getKarta(0).equals(k5));
		assertTrue(kZ.getKarta(1).equals(k2));
		assertTrue(kZ.getKarta(2).equals(k1));
		kZ.kartaEzabatu(k1);
		kZ.kartaEzabatu(k2);
		kZ.kartaEzabatu(k5);
		
		//Proba 4 karta.
		kZ.kartaGehitu(k1);
		kZ.kartaGehitu(k2);
		kZ.kartaGehitu(k3);
		kZ.kartaGehitu(k5);
		k5.gaitasunaBurutu(0);
		assertTrue(kZ.getKarta(0).equals(k5));
		assertTrue(kZ.getKarta(1).equals(k3));
		assertTrue(kZ.getKarta(2).equals(k2));
		assertTrue(kZ.getKarta(3).equals(k1));
		kZ.kartaEzabatu(k1);
		kZ.kartaEzabatu(k2);
		kZ.kartaEzabatu(k3);
		kZ.kartaEzabatu(k5);
		
		//Proba 5 karta.
		kZ.kartaGehitu(k1);
		kZ.kartaGehitu(k2);
		kZ.kartaGehitu(k3);
		kZ.kartaGehitu(k4);
		kZ.kartaGehitu(k5);
		k5.gaitasunaBurutu(0);
		assertTrue(kZ.getKarta(0).equals(k5));
		assertTrue(kZ.getKarta(1).equals(k4));
		assertTrue(kZ.getKarta(2).equals(k3));
		assertTrue(kZ.getKarta(3).equals(k2));
		assertTrue(kZ.getKarta(4).equals(k1));
		assertFalse(kZ.getKarta(3).equals(k5));
		assertFalse(kZ.getKarta(2).equals(k5));
		kZ.kartaEzabatu(k1);
		kZ.kartaEzabatu(k2);
		kZ.kartaEzabatu(k3);
		kZ.kartaEzabatu(k4);
		kZ.kartaEzabatu(k5);

	}
}
