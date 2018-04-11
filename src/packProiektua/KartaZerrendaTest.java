package packProiektua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void testBarajatu() {
		kz.kartaGehitu(kf.createKarta("Loroa", "Gorria"));
		kz.kartaGehitu(kf.createKarta("Sugea", "Urdina"));
		System.out.println(kz.getKarta(0).getIzena());
		kz.barajatu();
		System.out.println(kz.getKarta(0).getIzena());
		kz.barajatu();
		System.out.println(kz.getKarta(0).getIzena());
	}

	@Test
	public void testLuzera() {
		assertTrue(kz.luzera()==3);
		kz.kartaGehitu(kf.createKarta("Sugea", "Urdina"));
		assertTrue(kz.luzera()==4);
		kz.kartaGehitu(kf.createKarta("Loroa", "Gorria"));
		assertTrue(kz.luzera()==5);
	}
}