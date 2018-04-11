package packProiektua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroaTest {
	private Tableroa t;

	@Before
	public void setUp() throws Exception {
		t=Tableroa.getNireTableroa();
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testJokoaHasieratu() {
		t.jokoaHasieratu();
		assertTrue(t.getJ1().luzera()==8);
		assertTrue(t.getCPU().luzera()==8);
		assertTrue(t.getEskuanJ1().luzera()==4);
		assertTrue(t.getEskuanCPU().luzera()==4);
		assertTrue(t.getSartuakJ1().luzera()==0);
		assertTrue(t.getSartuakCPU().luzera()==0);
		assertTrue(t.getKola().luzera()==0);
		System.out.println("Jokalariari hurrengo kartak egokitu zaizkio:");
		for (int i=0;i<t.getEskuanJ1().luzera();i++){
			System.out.println(t.getEskuanJ1().getKarta(i).getIzena());
		}
		System.out.println("CPUari hurrengo kartak egokitu zaizkio:");
		for (int i=0;i<t.getEskuanCPU().luzera();i++){
			System.out.println(t.getEskuanCPU().getKarta(i).getIzena());
		}
	}
}