package pl.edu.agh.mwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	Photo photo;

	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		photo = new Photo("super");
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

	// keyword to pusty string
	@Test
	public void testFindKeywordEmpty() throws TripAlreadyExistsException {

		tripManager.add(trip);
		assertEquals(true, tripManager.find(""));
	}

	// Trip.name zawiera keyword
	// ktorys klucz w mapie contains keyword
	@Test
	public void testFindKeywordInName() throws TripAlreadyExistsException {

		tripManager.add(trip);
		assertEquals(true, tripManager.find("nazwa"));
	}

	// Trip.description zawiera keyword
	// description ktoregos Trip w mapie zawiera keyword
	@Test
	public void testFindKeywordInDescription() throws TripAlreadyExistsException {

		tripManager.add(trip);
		assertEquals(true, tripManager.find("opis"));
	}

	// Photo.comment jednego ze zdjęć obecnego w danym Trip zawiera keyword
	@Test
	public void testFindKeywordAnyPhotoDescription() throws TripAlreadyExistsException {

		trip.addPhoto(photo);
		tripManager.add(trip);
		assertEquals(true, tripManager.find("super"));
	}
}
