package pl.edu.agh.mwo;

import java.util.*;

public class TripManager {

	// kolekcja trip-ow
	// key: Trip.name
	// value: Trip
	private HashMap<String, Trip> tripMap;

	// konstruktor
	public TripManager() {
		tripMap = new HashMap<String, Trip>();
	}

	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripMap.get(trip.getName()) != null) {
			// if(trip exists) throw TripAlreadyExistsException
			throw new TripAlreadyExistsException();
		} else {
			// dodanie trip-u do kolekcji
			tripMap.put(trip.getName(), trip);
		}
	}

	// zwraca kolekcje
	public HashMap<String, Trip> getTrips() {
		return tripMap;
	}

	// usuwa z kolekcji po key
	public void remove(String name) {
		tripMap.remove(name);
	}

	public boolean find(String keyword) {

		// trip spełnia kryteria wyszukiwania jeśli prawdziwe jest przynajmniej jedno z
		// twierdzeń:
		// keyword to pusty string
		if (keyword.equals("")) {
			return true;
		}
		// Trip.name zawiera keyword
		// ktorys klucz w mapie contains keyword
		if (tripMap.containsKey(keyword) == true) {
			return true;
		}
		// Trip.description zawiera keyword
		// description ktoregos Trip w mapie zawiera keyword
		if (tripMap.containsValue(new Trip("nazwa", keyword)) == true) {
			return true;
		}
		// Photo.comment jednego ze zdjęć obecnego w danym Trip zawiera keyword
		Iterator<Map.Entry<String, Trip>> it = tripMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, Trip> pair = (HashMap.Entry<String, Trip>) it.next();
			if (pair.getValue().getPhotos().contains(new Photo(keyword))) {
				return true;
			}
			it.remove(); // avoids a ConcurrentModificationException
		}

		return false;
	}

}
