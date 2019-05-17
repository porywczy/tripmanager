package pl.edu.agh.mwo;

import java.util.Objects;

public class Photo {

	String comment;

	public Photo(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void removeComment() {
		this.comment = "";
	}

	public void updateComment(String comment) {
		setComment(comment);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Photo photo = (Photo) o;
		return Objects.equals(comment, photo.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment);
	}

}
