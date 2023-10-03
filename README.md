
Name of the dataset: Fatal police shootings data
URL: https://github.com/washingtonpost/data-police-shootings/blob/master/fatal-police-shootings-data.csv


Dataset description: 
The dataset displays information about every citizen killed by police from January 2015 until 14th March 2021 as recorded by The Washington Post. It shows the basic personal information about the victims, and details about the shootings, such as location, if the victim was armed or if they were fleeing the scene.
I deleted the first column of the original dataset(id), as it did not give any useful information, and the column “threat_level”, as the information was confusing and not really useful for this project.


Columns description:
The dataset contains 15 columns.

1. Name: It contains all the victims’ names. Type string data.

2. Date: Date of the fatal shooting in dd/MM/yyyy format. Type LocalDate data.

3. Manner of death: Type enum data. Can be SHOT or SHOT_AND_TASERED.

4. Armed: Indicates if the victim was armed or not, and it case they were, what weapon it was. If it is “undetermined”, it means that it is not known whether or not the victim had a weapon, while if it is “unknown”, then the victim is armed, but the object is unknown. Type string data.

5. Age: Age of every victim. Type integer data.

6. Gender: Gender of every victim. Type enum data. It can be MALE or FEMALE.

7. Race: Race of the victim. Type enum data. It can be ASIAN, BLACK, HISPANIC, NATIVE_AMERICAN, OTHER, WHITE, or UNKNOWN.

8. City: City (or county) where the shooting took place. Type string data.

9. State: State where the shooting took place. Type string data. It is written as a two-letter postal code abbreviation.

10. Signs of mental illness: If the victim had a history of mental health issues, expressed suicidal intentions or was experiencing mental distress at the time of the shooting. Type Boolean data.

11. Flee: If the victim was fleeing the scene or not. Type enum data. It can be FOOT, CAR or NOT_FLEEING.

12. Body camera: If the officer was wearing a recording body camera or not. Type boolean data.

13. Longitude: Longitude where the attack took place. Type double data.

14. Latitude: Latitude where the attack took place. Type double data.

15. Is geocoding exact: It shows whether the coordinates (latitude and longitude) are accurate (within approximately 100 meters), or if they are the center of the city or county where it happened. Type boolean data.


Methods:

·getNumberShootingsState: returns the number of
shootings on a given state.

·getNamesVictims: returns a list with the names of the victims

·existsShooting: returns true if a crime was commited in the given city

·getMostRecentInState: returns the most recent shooting on a given state

·getShootingsBetweenDate: returns a list with the shootings between two given dates

·getWeapons: returns a list with the shootings between two given dates

·getVictimsByAge: returns a dictionary with the ages as keys and the number of victims of that age as values

·wasThereAVictim: returns true if there is a victim of the given age, using the previous method

·getMeanAgeByState: returns the mean age of the victims by state

·getShootingsStateDate: returns the shootings in a given state on a given day

·getShootingsperRace: returns a dictionary with the names of the victims arranged by their race

·didTheyShowMentalIllness: returns a dictionary with the names of the victims divided by if they showed signs of mental illness or not, using partitioningBy()

·getNumberShootingsByState: returns a dictionary with the number of shootings by state

·getStateMoreShootings: returns the state where more shootings took place, using the previous method
