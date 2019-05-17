package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trip {
	
	//membry
	private String name;
	private String description;
	
	List<Photo> photoCollection = null;
	
	//constructor
	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
		
		//zakladamy kolekcje photos
		photoCollection = new ArrayList<>();
	}

	//get, set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addPhoto(Photo photo) {
		photoCollection.add(photo);
	}
	
	public List<Photo> getPhotos() {
		return photoCollection;
	}
	
	public void removePhoto(int photoNumber) {
		photoCollection.remove(photoNumber);
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(name, trip.name) && Objects.equals(description, trip.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
