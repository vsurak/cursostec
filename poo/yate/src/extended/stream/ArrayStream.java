package extended.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStream {

	public static void testWithPrimitives() {
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.forEach(p -> System.out.println(p));
		
		stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
		stream.forEach(p -> System.out.println(p));
		
		List<Integer> list = new ArrayList<Integer>();

		for(int i = 1; i< 10; i++){
		      list.add(i);
		}

		stream = list.stream();
		stream.forEach(p -> System.out.println(p));	
		
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
		randomNumbers.limit(20).forEach(System.out::println);		
	}
	
	public static void testChars() {
		IntStream stream = "12345_abcdefg".chars();
		stream.forEach(p -> System.out.println(p));

		//OR

		Stream<String> streamS = Stream.of("A$B$C".split("\\$"));
		streamS.forEach(p -> System.out.println(p));		
	}
	
	public static void testLists() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		memberNames.stream().filter((s) -> s.startsWith("A"))
        .forEach(System.out::println);
		
		memberNames.stream().filter((s) -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
		memberNames.stream().sorted()
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
		List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());	
		
	}
	
	public static void main(String args[]) {
		testWithPrimitives();
		testChars();
		testLists();
	}
}
