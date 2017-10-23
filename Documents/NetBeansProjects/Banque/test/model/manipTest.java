package model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author jmche
 */
public class manipTest {

	@Test
	public void testInstanceOf() {
		Object instance = new Commercial(1, "peu importe", null, null);
		assertTrue(instance instanceof Commercial);
		assertTrue(instance instanceof Object);
		assertFalse(instance instanceof Client);
	}

	@Test
	public void testITranstypage() {
		Commercial expected = new Commercial(1, "peu importe", null, null);
		Object instance = expected;
		//change le type déclaré de l'instance si c'est possible
		Commercial result = (Commercial) instance;
		assertTrue(result == expected);
	}
	
	@Test (expected = ClassCastException.class)
	public void testTranstypageException(){
		Client client = new Client(1," nom","email ", null);
		Object instance = client;
		Commercial result = (Commercial) instance;
	}
}
