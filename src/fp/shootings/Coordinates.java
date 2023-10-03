package fp.shootings;

import utiles.Checkers;

public class Coordinates implements Comparable<Coordinates> {

	// Fields
	private Double latitude, longitude;
	
	
	// Constructors
	public Coordinates(Double latitude, Double longitude) {
		
		Checkers.check("The longitude has to be negative, as we are only working with locations in USA.", longitude<0);
		Checkers.check("The latitude has to be positive as we are only working with locations in USA.", latitude>0);
		
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordinates(String s) {
		String[] values = s.split(",");
		if (values.length != 2) {
			throw new IllegalArgumentException("The number of value provided is not the correct one" + s);
		}
		Double latitude = Double.parseDouble(values[0]);
		Double longitude = Double.parseDouble(values[1]);
		Checkers.check("The longitude has to be negative, as we are only working with locations in USA.", longitude<0);
		Checkers.check("The latitude has to be positive as we are only working with locations in USA.", latitude>0);
		
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	
	// Observers
	public Double getLatitude() {
		return this.latitude;
	}
	
	public Double getLongitude() {
		return this.longitude;
	}

	
	//Modifiers
	public void setLongitude(Double longitude) {
		Checkers.check("The longitude has to be negative, as we are only working with locations in USA.", longitude<0);
		this.longitude = longitude;
	}
	
	public void setLatitude(Double latitude) {
		Checkers.check("The latitude has to be positive as we are only working with locations in USA.", latitude>0);
		this.latitude = latitude;
	}
	
	public Double getDistance(Coordinates c) {  
        Double distance = Math.sqrt(Math.pow(latitude-c.latitude,2) + Math.pow(longitude-c.longitude,2));
        return distance;  
    } 
	

	//toString
	public String toString() {
		return "Coordinates (latitude=" + latitude + ", longitude=" + longitude + ")";
	}

	
	//hashCode and equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}

	
	// compareTo
    public int compareTo(Coordinates b) {
        int res = latitude.compareTo(b.latitude);
        if (res == 0) {
            res = longitude.compareTo(b.longitude);
        }
        return res;
    }
	
}
	
