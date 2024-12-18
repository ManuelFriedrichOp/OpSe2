package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VolkshochschuleTest {
	Volkshochschule volkshochschule;

	@BeforeEach
	void setUp() throws Exception {
		volkshochschule = new Volkshochschule(name:"", wochentag:"", startuhrzeit:"", kursbeitrag:"", new String[] {""});
	}

	@AfterEach
	void tearDown() throws Exception {
		volkshochschule = null;
	}

	@Test
	void test() {
		this.volkshochschule.setName("kurs");
		assertTrue(this.volkshochschule.getName().equals("kurs") == true, () -> "Der Name ist nicht kurs");
		
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> {new Volkshochschule(null, null, null, null, null);});
//		assertEquals("Fehler", exc.getMessage());
	}

}
