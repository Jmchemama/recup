
package model;

import java.sql.SQLException;
import static model.Client.getClient;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmche
 */
public class ClientTest {
	
	@Test
	public void testConstructorClient() {
		Client instance = new Client(1,"Dupont","dupont@interpol.com", null);
		assertEquals(1,instance.getNoClient());
		assertEquals("Dupont",instance.getNom());
		assertEquals("dupont@interpol.com",instance.getEmail());
	}
	
	@Test
	public void testGetClient() throws SQLException{
		Client expected = getClient(1);
		assertEquals(1,expected.getNoClient());
		assertEquals("Dupont",expected.getNom());
		assertEquals("dupont@interpol.com",expected.getEmail());
	}
	
	@Test public void testGetByEmailMdp() throws SQLException{
		Client expected = new Client(2, "Tintin", "tintin@herge.be", "Tintin" );
		Client result = Client.getByEmailMpd("tintin@herge.be", "Tintin");
		assertEquals(expected, result);
	}
	
	@Test public void testGetByEmailMdpEchecEmail() throws SQLException{
		Client expected = null;
		Client result = Client.getByEmailMpd("lanpion@mondass.com", "tintin");
		assertEquals(expected, result);
	}
	
	@Test public void testGetByEmailMdpEchecMdp() throws SQLException{
		Client expected = null;
		Client result = Client.getByEmailMpd("tintin@herge.be", "amatole");
		assertEquals(expected, result);
	}
}
