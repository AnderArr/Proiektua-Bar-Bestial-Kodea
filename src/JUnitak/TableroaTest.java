package JUnitak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;

import packProiektua.Karta;
import packProiektua.KartaFactory;
import packProiektua.Tableroa;

public class TableroaTest {
	private Tableroa t;	

	@Before
	public void setUp() throws Exception {
		t = Tableroa.getNireTableroa();
		t.jokoaHasieratu();
	}

	@After
	public void tearDown() throws Exception {
		t.kolakReseteatu();
		t=null;
	}

	@Test
	public void testDaudeKartak() {
		assertFalse(t.daudeKartak());
		t.txandaJokatu(0, 0, 0);
		assertTrue(t.daudeKartak());
	}

	@Test
	public void testTxandaJokatu() {
		assertFalse(t.daudeKartak());
		t.txandaJokatu(0, 0, 0);
		assertTrue(t.daudeKartak());
	}

	@Test
	public void testKamalehoiaDa() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Kamalehoia", "Gorria");
		t.getEskuanJ1().kartaGehitu(k1);
		assertTrue(t.kamalehoiaDa(4));
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		t.getEskuanJ1().kartaGehitu(k2);
		assertFalse(t.kamalehoiaDa(5));
	}

	@Test
	public void testLoroaDaKolan() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Kamalehoia", "Gorria");
		t.getKola().kartaGehitu(k1);
		assertFalse(t.loroaDaKolan(0));
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		t.getKola().kartaGehitu(k2);
		assertTrue(t.loroaDaKolan(1));
	}

	@Test
	public void testKanguroaDaKolan() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Kamalehoia", "Gorria");
		t.getKola().kartaGehitu(k1);
		assertFalse(t.kanguroaDaKolan(0));
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Gorria");
		t.getKola().kartaGehitu(k2);
		assertTrue(t.kanguroaDaKolan(1));
	}

	@Test
	public void testLoroaDa() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		t.getEskuanJ1().kartaGehitu(k1);
		assertTrue(t.loroaDa(4));
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Gorria");
		t.getEskuanJ1().kartaGehitu(k2);
		assertFalse(t.loroaDa(5));
	}

	@Test
	public void testKartakGeratuEskuan() {
		assertTrue(t.kartakGeratuEskuan());
		assertFalse(t.bukatuta());
	}

	@Test
	public void testKartakGeratuBarajan() {
		assertTrue(t.kartakGeratuBarajan());
	}

	@Test
	public void testKanguroaDa() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		t.getEskuanJ1().kartaGehitu(k1);
		assertFalse(t.kanguroaDa(4));
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Gorria");
		t.getEskuanJ1().kartaGehitu(k2);
		assertTrue(t.kanguroaDa(5));
	}

	@Test
	public void testAnimaladaRekurrenteak() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Tximinoa", "Gorria");
		Karta k3 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Gorria");
		Karta k4 = KartaFactory.getKartaFactory().createKarta("Krokodiloa", "Gorria");
		Karta k5 = KartaFactory.getKartaFactory().createKarta("Zebra", "Gorria");
		t.getKola().kartaGehitu(k1);
		t.getKola().kartaGehitu(k2);
		t.getKola().kartaGehitu(k3);
		t.getKola().kartaGehitu(k4);
		t.getKola().kartaGehitu(k5);
		t.animaladaRekurrenteak();
		assertTrue(t.getKola().luzera()==2);
		
	}

	@Test
	public void testBukatuta() {
		assertFalse(t.bukatuta());
		for (int i=0; i<4; i++){
			t.getEskuanJ1().kartaKendu(0);
			t.getEskuanCPU().kartaKendu(0);
		}
		assertTrue(t.bukatuta());
	}

	@Test
	public void testKolaEguneratu() {
		assertTrue(t.getKola().luzera()==0);
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Gorria");
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Tximinoa", "Gorria");
		Karta k3 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Gorria");
		Karta k4 = KartaFactory.getKartaFactory().createKarta("Lehoia", "Gorria");
		Karta k5 = KartaFactory.getKartaFactory().createKarta("Zebra", "Gorria");
		t.getKola().kartaGehitu(k1);
		t.getKola().kartaGehitu(k2);
		t.getKola().kartaGehitu(k3);
		t.getKola().kartaGehitu(k4);
		t.getKola().kartaGehitu(k5);
		t.kolaEguneratu();
		assertTrue(t.getKola().luzera()==2);
	}

	@Test
	public void testIrabazleaLortu() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Urdina");
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Tximinoa", "Urdina");
		Karta k3 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Urdina");
		Karta k4 = KartaFactory.getKartaFactory().createKarta("Lehoia", "Urdina");
		Karta k5 = KartaFactory.getKartaFactory().createKarta("Zebra", "Urdina");
		t.getKola().kartaGehitu(k1);
		t.getKola().kartaGehitu(k2);
		t.getKola().kartaGehitu(k3);
		t.getKola().kartaGehitu(k4);
		t.getKola().kartaGehitu(k5);
		t.kolaEguneratu();
		assertTrue(t.irabazleaLortu().equals("J1 irabazi du   J1:7   CPU:0"));
	}

	@Test
	public void testSartuBereLekuan() {
		Karta k1 = KartaFactory.getKartaFactory().createKarta("Loroa", "Urdina");
		Karta k2 = KartaFactory.getKartaFactory().createKarta("Tximinoa", "Urdina");
		Karta k3 = KartaFactory.getKartaFactory().createKarta("Kanguroa", "Berdea");
		Karta k4 = KartaFactory.getKartaFactory().createKarta("Lehoia", "Berdea");
		Karta k5 = KartaFactory.getKartaFactory().createKarta("Zebra", "Urdina");
		t.sartuBereLekuan(k1);
		t.sartuBereLekuan(k2);
		t.sartuBereLekuan(k3);
		t.sartuBereLekuan(k4);
		t.sartuBereLekuan(k5);
		assertTrue(t.getSartuakJ1().luzera()==3);
		assertTrue(t.getSartuakCPU().luzera()==2);
	}

	@Test
	public void testJokoaHasieratu() {
		t.kolakReseteatu();
		t.jokoaHasieratu();
		assertTrue(t.getJ1().luzera()==8);
		assertTrue(t.getCPU().luzera()==8);
		assertTrue(t.getEskuanJ1().luzera()==4);
		assertTrue(t.getEskuanCPU().luzera()==4);
		assertTrue(t.getSartuakJ1().luzera()==0);
		assertTrue(t.getSartuakCPU().luzera()==0);
		assertTrue(t.getKola().luzera()==0);
	}

}
