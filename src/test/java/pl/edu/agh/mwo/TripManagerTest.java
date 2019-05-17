package pl.edu.agh.mwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;

	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
	}

	@Test
	public void testAdd() throws TripAlreadyExistsException {
		// najpierw kolekcja ma size = 0
		assertEquals(0, tripManager.getTrips().size());
		// dodajemy trip
		tripManager.add(trip);
		// teraz kolekcja ma size = 1
		assertEquals(1, tripManager.getTrips().size());
	}

	// spodziewamy sie ze poleci wyjatek
	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		// najpierw kolekcja ma size = 0
		assertEquals(0, tripManager.getTrips().size());
		// dodajemy trip
		tripManager.add(trip);
		// teraz kolekcja ma size = 1
		assertEquals(1, tripManager.getTrips().size());
		// dodajemy ten sam trip: ma poleciec wyjatek
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		// dodajemy trip
		tripManager.add(trip);
		// teraz kolekcja ma size = 1
		assertEquals(1, tripManager.getTrips().size());
		// usuwamy trip
		tripManager.remove(trip.getName());
		// teraz kolekcja ma size = 0
		assertEquals(0, tripManager.getTrips().size());
		// fail("chcemy zespuc");
	}

	@Test
	public void testFind() {
//		tripManager.add(trip);
//		
//		assertEquals(1, tripManager.getTrips().size());
//		
//		if (tripList.get(name) != null) {
//			System.out.println("trip istnieje w kolekcji");
//		} else {
//			System.out.println("trip NIE istnieje w kolekcji");
//		}
	}
}
