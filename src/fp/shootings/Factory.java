package fp.shootings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Factory {

	public static Shooting parseShooting(String s) {
		return new Shooting(s);	
	}
	
	public static Shootings readShootings(String fileName) {
		Shootings res = null;
		try {
			Stream<Shooting> sts = Files.lines(Paths.get(fileName)).skip(1).map(Factory::parseShooting);
			res = new Shootings(sts);
		}
		catch (IOException e) {
			System.out.println("File not found: " + fileName);
			e.printStackTrace();
		}
		return res;
	}
}
