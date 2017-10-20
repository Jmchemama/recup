/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import static model.Commercial.getCommercial;
import static model.Commercial.getListCommercial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmche
 */
public class CommercialTest {
	
	public CommercialTest() {
	}

	@Test
	public void testConstructeurCommercial() {
		Commercial commercial = new Commercial(1,"nom", null, null);
		assertEquals(1,commercial.getNoCommercial());
		assertEquals("nom",commercial.getNom());
	}
	
	@Test
	public void testGetCommercial() throws SQLException{
		Commercial expected = getCommercial(1);
		assertEquals(1,expected.getNoCommercial());
		assertEquals("Lampion",expected.getNom());
	}
	
	@Test
	public void testGetListClient() throws SQLException{
		Commercial commercial = Commercial.getCommercial(1);
		ArrayList<Client> listClient = new ArrayList();
		Client client2 = Client.getClient(2);
		Client client3 = Client.getClient(3);
		listClient.add(client2);
		listClient.add(client3);
		assertEquals(listClient,commercial.getListClient());
	}
	
	@Test
	public void testGetListCommerciaux() throws SQLException{
		ArrayList <Commercial> expected = new ArrayList();
		Commercial c1 = Commercial.getCommercial(1);
		Commercial c2 = Commercial.getCommercial(2);
		Commercial c3 = Commercial.getCommercial(3);	
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		assertEquals(expected,getListCommercial());
	}
	
	
	@Test public void testGetByEmailMdp() throws SQLException{
		Commercial expected = new Commercial(1, "Lampion", "lampion@mondass.com", "anatole" );
		Commercial result = Commercial.getByEmailMpd("lampion@mondass.com", "anatole");
		assertEquals(expected, result);
	}
	
	@Test public void testGetByEmailMdpEchecEmail() throws SQLException{
		Commercial expected = null;
		Commercial result = Commercial.getByEmailMpd("lanpion@mondass.com", "anatole");
		assertEquals(expected, result);
	}
	
	@Test public void testGetByEmailMdpEchecMdp() throws SQLException{
		Commercial expected = null;
		Commercial result = Commercial.getByEmailMpd("lampion@mondass.com", "amatole");
		assertEquals(expected, result);
	}
}
