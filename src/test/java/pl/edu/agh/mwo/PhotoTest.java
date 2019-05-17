package pl.edu.agh.mwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoTest {
	
	Photo photo;
	
	@Before
	public void setUp() throws Exception {
		photo = new Photo("ustaw komentarz");
	}
	
	@Test
	public void testConstructor() {

		// sprawdzenie czy konstruktor wpisal do membrow podane argumenty
		assertEquals("ustaw komentarz", photo.getComment());
	}

	@Test
	public void testSetComment() {
		photo.setComment("buety photo");
		assertEquals("buety photo", photo.getComment());
	}
	
	@Test
	public void testRemoveComment() {
		photo.setComment("buety photo");
		photo.removeComment();
		assertEquals("", photo.getComment());
	}
	
	@Test
	public void testUpdateComment() {
		photo.setComment("buety photo");
		photo.updateComment("buety photo updated");
		assertEquals("buety photo updated", photo.getComment());
	}
	
	@Test
	public void testGetComment() {
		photo.setComment("buety photo");
		assertEquals("buety photo", photo.getComment());
	}

}
