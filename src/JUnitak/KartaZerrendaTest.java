package JUnitak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packProiektua.Karta;
import packProiektua.KartaFactory;
import packProiektua.KartaZerrenda;

public class KartaZerrendaTest {
	private KartaZerrenda kz;
	private Karta k1;
	private Karta k2;
	private Karta k3;
	private KartaFactory kf;

	@Before
	public void setUp() throws Exception {
		kz= new KartaZerrenda();
		kf= KartaFactory.getKartaFactory();
		k1= kf.createKarta("Tximinoa", "Urdina");
		k2= kf.createKarta("Jirafa", "Urdina");
		k3= kf.createKarta("Tximinoa", "Gorria");
		kz.kartaGehitu(k1);
		kz.kartaGehitu(k2);
		kz.kartaGehitu(k3);
	}

	@After
	public void tearDown() throws Exception {
		kz=null;
		k1=null;
		k2=null;
		k3=null;
		kf=null;
	}

	@Test
	public void testKartaGehitu() {
		assertTrue(kz.luzera()==3);
		kz.kartaGehitu(kf.createKarta("Sugea", "Urdina"));
		assertTrue(kz.luzera()==4);
		kz.kartaGehitu(kf.createKarta("Loroa", "Gorria"));
		assertTrue(kz.luzera()==5);
	}

	@Test
	public void testKartaKendu() {
		assertTrue(kz.luzera()==3);
		kz.kartaKendu(2);
		assertTrue(kz.luzera()==2);
		kz.kartaKendu(0);
		assertTrue(kz.luzera()==1);
	}

	@Test
	public void testKartaHartu() {
		assertTrue(kz.luzera()==3);
		kz.kartaHartu();
		assertTrue(kz.luzera()==2);
		kz.kartaHartu();
		assertTrue(kz.luzera()==1);
	}

	@Test
	public void testKamalehoiaDa() {
		kz.kartaGehitu(kf.createKarta("Kamalehoia", "Urdina"));
		assertTrue(kz.kamalehoiaDa(3));
		kz.kartaGehitu(kf.createKarta("Kamalehoia", "Berdea"));
		assertTrue(kz.kamalehoiaDa(4));
		assertFalse(kz.kamalehoiaDa(0));
		assertFalse(kz.kamalehoiaDa(1));
		assertFalse(kz.kamalehoiaDa(2));
	}

	@Test
	public void testKanguroaDa() {
		kz.kartaGehitu(kf.createKarta("Kanguroa", "Urdina"));
		assertTrue(kz.kanguroaDa(3));
		assertFalse(kz.kanguroaDa(0));
		kz.kartaGehitu(kf.createKarta("Kanguroa", "Berdea"));
		assertTrue(kz.kanguroaDa(4));
		assertFalse(kz.kanguroaDa(1));
		assertFalse(kz.kanguroaDa(2));
	}

	@Test
	public void testLoroaDa() {
		kz.kartaGehitu(kf.createKarta("Loroa", "Urdina"));
		assertTrue(kz.loroaDa(3));
		assertFalse(kz.kanguroaDa(0));
		kz.kartaGehitu(kf.createKarta("Loroa", "Berdea"));
		assertTrue(kz.loroaDa(4));
		assertFalse(kz.loroaDa(1));
		assertFalse(kz.loroaDa(2));
	}

	@Test
	public void testBarajatu() {
		kz.kartaGehitu(kf.createKarta("Loroa", "Gorria"));
		kz.kartaGehitu(kf.createKarta("Sugea", "Urdina"));
		kz.barajatu();
		assertTrue(!k1.equals(kz.getKarta(0)));
		kz.barajatu();
		assertTrue(!k1.equals(kz.getKarta(0)));
	}

	@Test
	public void testLuzera() {
		assertTrue(kz.luzera()==3);
		kz.kartaGehitu(kf.createKarta("Sugea", "Urdina"));
		assertTrue(kz.luzera()==4);
		kz.kartaGehitu(kf.createKarta("Loroa", "Gorria"));
		assertTrue(kz.luzera()==5);
	}

	@Test
	public void testKartaEzabatu() {
		assertTrue(kz.luzera()==3);
		kz.kartaEzabatu(k1);
		assertTrue(kz.luzera()==2);
		assertFalse(kz.getKarta(0).equals(k1));
		assertFalse(kz.getKarta(1).equals(k1));
		kz.kartaEzabatu(k2);
		assertTrue(kz.luzera()==1);
		assertFalse(kz.getKarta(0).equals(k2));
	}

	@Test
	public void testHasieranJarri() {
		assertTrue(kz.luzera()==3);
		Karta k4= kf.createKarta("Lehoia", "Urdina");
		kz.hasieranJarri(k4);
		assertTrue(kz.luzera()==4);
		assertTrue(kz.getKarta(0).equals(k4));
		Karta k5= kf.createKarta("Zebra", "Urdina");
		kz.hasieranJarri(k5);
		assertTrue(kz.luzera()==5);
		assertFalse(kz.getKarta(0).equals(k4));
		assertTrue(kz.getKarta(0).equals(k5));
	}

	@Test
	public void testElkartrukatu() {
		assertTrue(kz.getKarta(0).equals(k1));
		assertTrue(kz.getKarta(1).equals(k2));
		kz.elkartrukatu(k1, k2, 0, 1);
		assertFalse(kz.getKarta(0).equals(k1));
		assertFalse(kz.getKarta(1).equals(k2));
		assertTrue(kz.getKarta(0).equals(k2));
		assertTrue(kz.getKarta(1).equals(k1));
		kz.elkartrukatu(k2, k3, 0, 2);
		assertFalse(kz.getKarta(0).equals(k2));
		assertFalse(kz.getKarta(2).equals(k3));
		assertTrue(kz.getKarta(0).equals(k3));
		assertTrue(kz.getKarta(2).equals(k2));
	}

	@Test
	public void testPosizioaLortu() {
		assertTrue(kz.posizioaLortu(k1)==0);
		assertTrue(kz.posizioaLortu(k2)==1);
		assertTrue(kz.posizioaLortu(k3)==2);
	}

	@Test
	public void testKamalehoiZenbakia() {
		Karta k4= kf.createKarta("Kamalehoia", "Urdina");
		k4.setZenbakia(8);
		assertFalse(k4.getZenbakia()==5);
		kz.kartaGehitu(k4);
		kz.kamalehoiZenbakia();
		assertTrue(k4.getZenbakia()==5);
	}

	@Test
	public void testKartaPosizioanGehitu() {
		assertTrue(kz.luzera()==3);
		Karta k4= kf.createKarta("Lehoia", "Urdina");
		kz.kartaPosizioanGehitu(3,k4);
		assertTrue(kz.luzera()==4);
		assertTrue(kz.getKarta(3).equals(k4));
		Karta k5= kf.createKarta("Loroa", "Urdina");
		kz.kartaPosizioanGehitu(3,k5);
		assertTrue(kz.luzera()==5);
		assertTrue(kz.getKarta(3).equals(k5));
		assertTrue(kz.getKarta(4).equals(k4));
	}

	@Test
	public void testAzkenaLortu() {
		assertTrue(kz.azkenaLortu().equals(k3));
		kz.kartaEzabatu(k3);
		assertFalse(kz.azkenaLortu().equals(k3));
		assertTrue(kz.azkenaLortu().equals(k2));
		kz.kartaEzabatu(k2);
		assertFalse(kz.azkenaLortu().equals(k2));
		assertTrue(kz.azkenaLortu().equals(k1));
	}

}
