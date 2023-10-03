package fp.shootings.test;

import java.time.LocalDate;

import fp.shootings.*;

public class TestShootings {

	public static void main(String[] args) {
		Shooting s1 = new Shooting("Nathaniel Wilks", LocalDate.of(2015, 8, 12),Manner.SHOT, "gun", 27, Gender.MALE, Race.BLACK, "Oakland", "CA", false, Flee.CAR, true, -122.271, 37.804, true);
		Shooting s2 = new Shooting("Charles Ballard,13/03/2019,SHOT,vehicle,41,MALE,BLACK,Ashland,CA,FALSE,CAR,TRUE,-122.34,38.98,FALSE");
		Shooting s3 = new Shooting("Nathaniel Wilks", LocalDate.of(2015, 8, 12),Manner.SHOT, "gun", 27, Gender.MALE, Race.BLACK, "Oakland", "CA", false, Flee.CAR, true, -122.271, 37.804, true);
		Shooting s4 = s1;
		Shootings shootings = Factory.readShootings("data/fatal-police-shootings-data.csv");
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s3);
		//System.out.println(s4);
		System.out.println("Are s1 and s2 equals? " + s1.equals(s2));
		System.out.println("Are s1 and s3 equals? " + s1.equals(s3));
		System.out.println("Are s1 and s4 equals? " + s1.equals(s4));
		System.out.println("Are s1 and s2 identical? " + (s1 == s2));
		System.out.println("Are s1 and s3 identical? " + (s1 == s3));
		System.out.println("Are s1 and s4 identical? " + (s1 == s4));
		System.out.println("Compare s1 and s2: " + s1.compareTo(s2));
		System.out.println("Compare s1 and s3: " + s1.compareTo(s3));
		System.out.println("Compare s1 and s4: " + s1.compareTo(s4));
		System.out.println("Compare s2 and s3: " + s2.compareTo(s3));
		System.out.println("Compare s2 and s4: " + s2.compareTo(s4));
		System.out.println("Date of s1: " + s1.getDate());
		System.out.println("Coordinates of s1: " + s1.getCoordinates());
		System.out.println("Distance between s1 and s2: " + s1.getDistance(s2));
		//System.out.println(shootings);
		System.out.println("Number of shootings in California: " + shootings.getNumberShootingsState("CA"));
		System.out.println("List with the names of the victims: " + shootings.getNamesVictims());
		System.out.println("Was there a shooting in Victorville?: " + shootings.existsShooting("Victorville"));
		System.out.println("Most recent shooting in Nebraska: " + shootings.getMostRecentInState("NE"));
		System.out.println("Shootings between 5/2/2017 and 5/3/2017: " + shootings.getShootingsBetweenDate(LocalDate.of(2017, 2, 5), LocalDate.of(2017, 3, 5)));
		System.out.println("All the weapons used by victims on 25/12/2016: " + shootings.getWeapons(LocalDate.of(2016, 12, 25)));
		System.out.println("Victims by age: " + shootings.getVictimsByAge());
		System.out.println("Was there a victim of age 7? " + shootings.wasThereAVictim(7));
		System.out.println("Mean age of the victims by state: " + shootings.getMeanAgeByState());
		System.out.println("Shootings in North Carolina on 2/2/2021: " + shootings.getShootingsStateDate("NC", LocalDate.of(2021, 2, 2)));
		System.out.println("Shootings arranged by race of the victim: " + shootings.getShootingsperRace());
		System.out.println("Shootings divided by if they showed signs of mental illness or not: " + shootings.didTheyShowMentalIllness());
		System.out.println("State with the most shootings: " +  shootings.getStateMoreShootings());
	}
}
