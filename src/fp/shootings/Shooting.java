package fp.shootings;

import java.time.*;
import java.time.format.*;
import utiles.*;

public class Shooting {
	
	
	// Fields
	private String name;
	private LocalDate date;
	private Manner manner_of_death;
	private String armed;
	private Integer age;
	private Gender gender;
	private Race race;
	private String city;
	private String state;
	private Boolean signs_of_mental_illness;
	private Flee flee;
	private Boolean body_camera;
	private Double longitude;
	private Double latitude;
	private Boolean is_geocoding_exact;
	
	
	// Constructors
	public Shooting(String name, LocalDate date, Manner manner_of_death, String armed, Integer age, Gender gender, Race race, String city, String state, Boolean signs_of_mental_illness, Flee flee, Boolean body_camera, Double longitude, Double latitude, Boolean is_geocoding_exact) {
		
		Checkers.check("The longitude has to be negative, as we are only working with locations in USA.", longitude<0);
		Checkers.check("The latitude has to be positive as we are only working with locations in USA.", latitude>0);
		
		this.name = name;
		this.date = date;
		this.manner_of_death = manner_of_death;
		this.armed = armed;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.city = city;
		this.state = state;
		this.signs_of_mental_illness = signs_of_mental_illness;
		this.flee = flee;
		this.body_camera = body_camera;
		this.longitude = longitude;
		this.latitude = latitude;
		this.is_geocoding_exact = is_geocoding_exact;
		
	}
	
	public Shooting(String s) {
		String[] values = s.split(",");
		
		Checkers.check("Wrong number of values introduced. You need 15 values.", values.length == 15);
		
		String name = values[0];
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(values[1], dateTimeFormatter);
		Manner manner_of_death = Manner.valueOf(values[2]);
		String armed = values[3];
		Integer age = Integer.valueOf(values[4]);
		Gender gender = Gender.valueOf(values[5]);
		Race race = Race.valueOf(values[6]);
		String city = values[7];
		String state = values[8];
		Boolean signs_of_mental_illness = Boolean.valueOf(values[9]);
		Flee flee = Flee.valueOf(values[10]);
		Boolean body_camera = Boolean.valueOf(values[11]);
		Double longitude = Double.valueOf(values[12]);
		Double latitude = Double.valueOf(values[13]);
		Boolean is_geocoding_exact = Boolean.valueOf(values[14]);
		
		Checkers.check("This date is not valid", date.compareTo(LocalDate.now())<=0);
		Checkers.check("The longitude has to be negative.", longitude<0);
		Checkers.check("The latitude has to be positive", latitude>0);
		
		this.name = name;
		this.date = date;
		this.manner_of_death = manner_of_death;
		this.armed = armed;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.city = city;
		this.state = state;
		this.signs_of_mental_illness = signs_of_mental_illness;
		this.flee = flee;
		this.body_camera = body_camera;
		this.longitude = longitude;
		this.latitude = latitude;
		this.is_geocoding_exact = is_geocoding_exact;

	}

	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Manner getManner_of_death() {
		return manner_of_death;
	}

	public void setManner_of_death(Manner manner_of_death) {
		this.manner_of_death = manner_of_death;
	}

	public String getArmed() {
		return armed;
	}

	public void setArmed(String armed) {
		this.armed = armed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getSigns_of_mental_illness() {
		return signs_of_mental_illness;
	}

	public void setSigns_of_mental_illness(Boolean signs_of_mental_illness) {
		this.signs_of_mental_illness = signs_of_mental_illness;
	}

	public Flee getFlee() {
		return flee;
	}

	public void setFlee(Flee flee) {
		this.flee = flee;
	}

	public Boolean getBody_camera() {
		return body_camera;
	}

	public void setBody_camera(Boolean body_camera) {
		this.body_camera = body_camera;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Boolean getIs_geocoding_exact() {
		return is_geocoding_exact;
	}

	public void setIs_geocoding_exact(Boolean is_geocoding_exact) {
		this.is_geocoding_exact = is_geocoding_exact;
	}
	
	
	//Others
	public Coordinates getCoordinates() {
		Coordinates coordinates = new Coordinates(latitude, longitude);
		return coordinates;
		
	}
		
	public Double getDistance(Shooting c) {  
	    Coordinates a = this.getCoordinates();
	    Coordinates b = c.getCoordinates();
	    return a.getDistance(b);

	}

	
	// toString
	public String toString() {
		return "Shooting [name=" + name + ", date=" + date + ", manner_of_death=" + manner_of_death + ", armed=" + armed
				+ ", age=" + age + ", gender=" + gender + ", race=" + race + ", city=" + city + ", state=" + state
				+ ", signs_of_mental_illness=" + signs_of_mental_illness + ", flee=" + flee + ", body_camera="
				+ body_camera + ", longitude=" + longitude + ", latitude=" + latitude + ", is_geocoding_exact="
				+ is_geocoding_exact + "]";
	}

	
	//hashCode and equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shooting other = (Shooting) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (race != other.race)
			return false;
		return true;
	}
	
	
	// compareTo
	public int compareTo(Shooting s) {
    	int res = city.compareTo(s.city);
    	if (res==0) {
    		res=getCoordinates().compareTo(s.getCoordinates());
    	}
    	return res;
    }
	
}
