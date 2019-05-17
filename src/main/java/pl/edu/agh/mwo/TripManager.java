package pl.edu.agh.mwo;

import java.util.*;

public class TripManager {

	// kolekcja trip-ow
	// key: Trip.name
	// value: Trip
	private HashMap<String, Trip> tripList;

	// konstruktor
	public TripManager() {
		tripList = new HashMap<String, Trip>();
	}

	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			//if(trip exists) throw TripAlreadyExistsException
			throw new TripAlreadyExistsException();
		} else {
			//dodanie trip-u do kolekcji
			tripList.put(trip.getName(), trip);
		}
	}

	// zwraca kolekcje
	public HashMap<String, Trip> getTrips() {
		return tripList;
	}

	// usuwa z kolekcji po key
	public void remove(String name) {
		tripList.remove(name);
	}
	
	public void find(String name) {
		if( tripList.get(name) != null ) {
			System.out.println("trip istnieje w kolekcji");
		}
		else {
			System.out.println("trip NIE istnieje w kolekcji");
		}
	}

}
