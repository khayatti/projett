package G_Livres;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class livresTest {
@Test
public void testlivres() {
    livres lvr = new livres("jg123", "java", "james");
    assertNotEquals(null, lvr);
}


//Test of getCode method, of class livres.
@Test
public void testgetCode() {
    livres lvr = new livres("jg123", "java", "james");
    assertEquals("jg123", lvr.getCode());
}

//Test of getTitre method, of class livres.
@Test
public void testgetTitre() {
	 livres lvr = new livres("jg123", "java", "james");
	    assertEquals("java", lvr.getTitre());
}

//Test of getAuteur method, of class livres.
@Test
public void testgetAuteur() {
	 livres lvr = new livres("jg123", "java", "james");
	    assertEquals("james", lvr.getAuteur());
}
}
 
