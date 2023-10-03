package fp.shootings;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import utiles.Checkers;

public class Shootings {

    // Fields
    private Set<Shooting> shootings;

    // Constructors
    public Shootings() {
        this.shootings = new HashSet<>();
    }

    public Shootings(Stream<Shooting> st) {
        shootings = st.collect(Collectors.toSet());
    }

    // Observers
    public Set<Shooting> geShootings() {
        return this.shootings;
    }

    public int numberShootings() {
		return shootings.size();
	}
    
    public void setShootings(Set<Shooting> shootings) {
		this.shootings = shootings;
    }

    // Modifiers
	public void addShooting(Shooting av) {
		this.shootings.add(av);
	}
    
	//counts the number of shootings in a given state
	public Integer getNumberShootingsState(String state) {
		Integer res = 0;
		for(Shooting s:this.shootings) {
			if(s.getState().equals(state)) {
				res++;
			}
		}
		return res;
	}

	//returns a list with the names of the victims
	public List<String> getNamesVictims() {
		return shootings.stream().map(Shooting::getName).collect(Collectors.toList());
	}
    
	//returns true if a crime was commited in the given city
	public Boolean existsShooting(String city) {
		Predicate<Shooting> pr = s -> s.getCity().equals(city);
		return shootings.stream().anyMatch(pr);
	}

	//returns the most recent shooting on a given state
	public Shooting getMostRecentInState(String state) {
		Comparator<Shooting> cmp = Comparator.comparing(Shooting::getDate);
		return shootings.stream().filter(s -> s.getState().equals(state)).max(cmp).get();
	}
	
	//returns a list with the shootings between two given dates
	public List<Shooting> getShootingsBetweenDate(LocalDate start, LocalDate end) {
		Checkers.check("The start date can't be more recent than the end date", end.isAfter(start));
		return shootings.stream().filter(s->s.getDate().isAfter(start) && s.getDate().isBefore(end)).collect(Collectors.toList());
	}

	//returns a set with all the weapons used on a given date
	public Set<String> getWeapons(LocalDate date) {
		return shootings.stream().filter(x->x.getDate().equals(date)).map(Shooting::getArmed).distinct().collect(Collectors.toSet());
	}

	//returns a dictionary with the ages as keys and the number of victims of that age as values
	public Map<Integer, Long> getVictimsByAge() {
		return shootings.stream().collect(Collectors.groupingBy(Shooting::getAge, Collectors.counting()));
	}

	//returns true if there is a victim of the given age, using the previous method
	public Boolean wasThereAVictim(Integer age) {
		Map<Integer, Long> m = getVictimsByAge();
		return m.entrySet().stream().anyMatch(s->s.getKey().equals(age));
	}

	//returns the mean age of the victims by state
	public Map<String, Double> getMeanAgeByState() {
		return shootings.stream().collect(Collectors.groupingBy(Shooting::getState, Collectors.averagingDouble(Shooting::getAge)));
	}

	//returns the shootings in given a state on a given day
	public List<Shooting> getShootingsStateDate(String state, LocalDate date) {
		return shootings.stream().filter(s->s.getState().equals(state) && s.getDate().equals(date)).collect(Collectors.toList());
	}

	//returns a dictionary with the names of the victims arranged by their race
	public Map<Race, Set<String>> getShootingsperRace() {
		return shootings.stream().collect(Collectors.groupingBy(Shooting::getRace, Collectors.mapping(Shooting::getName, Collectors.toSet())));
	}

	//returns a dictionary with the names of the victims divided by if they showed signs of mental illness or not 
	public Map<Boolean, Long> didTheyShowMentalIllness() {
		return shootings.stream().collect(Collectors.partitioningBy(s -> s.getSigns_of_mental_illness(), Collectors.mapping(Shooting::getName, Collectors.counting())));
	}

	//auxiliar to next one
	public Map<String, Long> getNumberShootingsByState() {
		return shootings.stream().collect(Collectors.groupingBy(Shooting::getState, Collectors.counting()));
	} 

	//returns the state where more shootings took place
	public String getStateMoreShootings() {
		Map<String, Long> m = getNumberShootingsByState();
		return m.entrySet().stream().max(Comparator.comparing(x -> x.getValue())).get().getKey();
	}

    @Override
	public String toString() {
		return "Shootings [shootings=" + shootings + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shootings == null) ? 0 : shootings.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shootings other = (Shootings) obj;
		if (shootings == null) {
			if (other.shootings != null)
				return false;
		} else if (!shootings.equals(other.shootings))
			return false;
		return true;
	}

}