package pl.edu.agh.mwo;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//testy klasy Trip
public class TripTest {

	Trip trip = null;
	Photo photo = null;
	Photo photo1 = null;

	@Before
	public void setUp() throws Exception {

		// wywolanie zdefiniowanego konstruktora
		trip = new Trip("nazwa", "opis");
		
		photo = new Photo("nowa fotka");
		photo1 = new Photo("kolejna fotka");
	}

	// test konstruktora
	@Test
	public void testConstructor() {

		// sprawdzenie czy konstruktor wpisal do membrow podane argumenty
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
	public void testGetName() {
		assertEquals("nazwa", trip.getName());
	}

	@Test
	public void testSetName() {
		trip.setName("nowa nazwa");
		assertEquals("nowa nazwa", trip.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("opis", trip.getDescription());
	}

	@Test
	public void testSetDescription() {
		trip.setDescription("nowy opis");
		assertEquals("nowy opis", trip.getDescription());
	}

	@Test
	public void testAddPhoto() {
		assertEquals(0, trip.getPhotos().size());
		trip.addPhoto(photo);
		assertEquals(1, trip.getPhotos().size());
	}

	@Test
	public void testGetPhotos() {
		//dodajemy dwie fotki
		assertEquals(0, trip.getPhotos().size());
		trip.addPhoto(photo);
		trip.addPhoto(photo1);
		
		assertThat(trip.getPhotos(), hasItems(
                new Photo("nowa fotka"),
                new Photo("kolejna fotka")
        ));
	}

	@Test
	public void testRemovePhoto() throws Exception {
		 trip.addPhoto(photo);
		 assertEquals(1, trip.getPhotos().size());
		 trip.removePhoto(0);
		 assertEquals(0, trip.getPhotos().size());
	}
}
