
package model;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import static model.Compte.getCompte;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompteTest {
	
	public CompteTest() {
	}
	
	@Test
	public void testGetByIdOk() throws SQLException, InstantiationException {
		System.out.print("getCompteOk");
		ArrayList <Compte> expected = new ArrayList();
		Compte compte1 = new Compte(1, 1000.0, 1);
		Compte compte2 = new Compte(2, 1500.0, 1);
		expected.add(compte1);
		expected.add(compte2);
		assertEquals(expected, getCompte(1));
	}

	@Test
	public void testGetByIdFailed() throws SQLException, InstantiationException {
		System.out.print("getByIdFailed");
		Compte result = Compte.getById(100);
		assertNull(result);
	}

}
