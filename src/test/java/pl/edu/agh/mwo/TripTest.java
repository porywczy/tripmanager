package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

//testy klasy Trip
public class TripTest {

	//test konstruktora
	@Test
	public void testConstructor() {
		//wywolanie zdefiniowanego konstruktora
		Trip trip = new Trip("nazwa", "opis");
		//sprawdzenie czy konstruktor wpisal do membrow podane argumenty
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

}
