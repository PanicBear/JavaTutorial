import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class GenerateStream {

	public GenerateStream() {

		String[] arr = new String[] { "a", "b", "c" };
		List<String> list = Arrays.asList("a", "b", "c");

		// Array Stream
		System.out.println("Array Stream");
		Stream<String> stringStream = Arrays.stream(arr);
		stringStream.forEach(System.out::println);
		System.out.println("-----");

		stringStream = Arrays.stream(arr, 1, 3); // 1~2 ¿ä¼Ò [b, c]
		stringStream.forEach(System.out::println);
		System.out.println("-----");

		// Collection Stream
		System.out.println("Collection Stream");
		stringStream = list.stream();
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(System.out::println);
		System.out.println("-----");

		// Empty Stream
		System.out.println("Empty Stream");
		Stream<String> streamEmpty = Stream.empty();

		if (streamEmpty.count() == 0) {
			System.out.println("empty stream");
		} else {
			streamEmpty.forEach(System.out::println);
		}
		System.out.println("-----");

//		Stream<String> streamEmpty = list.isEmpty() ? Stream.empty() : list.stream();

		// Generate Stream by Builder
		System.out.println("Generate Stream by Builder");
		Stream<String> builderStream = Stream.<String>builder().add("a").add("b").add("c").build();
		builderStream.forEach(System.out::println);
		System.out.println("-----");

		// Generate Stream by generate()
		System.out.println("Generate Stream by generate()");
		Stream<String> methodStream = Stream.generate(() -> "generate()").limit(5);
		methodStream.forEach(System.out::println);
		System.out.println("-----");

		// Generate Stream by iterate()
		System.out.println("Generate Stream by iterate()");
		IntStream iterateStream = IntStream.iterate(0, n -> n + 2).limit(5);
		iterateStream.forEach(System.out::println);
		System.out.println("-----");

		// <T>Stream(int, long, double)
		IntStream intStream = IntStream.range(1, 5);
		LongStream longStream = LongStream.rangeClosed(1, 5);
		System.out.println("range");
		intStream.forEach(System.out::println);
		System.out.println();

		System.out.println("rangeClosed");
		longStream.forEach(System.out::println);
		System.out.println();

		// Stream<T> == <T>Stream.boxed()
		System.out.println("Stream<T> == <T>Stream.boxed()");
		Stream<Integer> boxedIntStream = IntStream.rangeClosed(1, 5).boxed();
		boxedIntStream.forEach(System.out::println);
		System.out.println("-----");

		// Stream with Random()
		System.out.println("Stream with Random()");
		intStream = new Random().ints(1);
		longStream = new Random().longs(1);
		DoubleStream doubleStream = new Random().doubles(1);

		intStream.forEach(System.out::println);
		longStream.forEach(System.out::println);
		doubleStream.forEach(System.out::println);
		System.out.println("-----");

		// String Stream
		System.out.println("String Stream, 'Example'.chars");
		intStream = "Example".chars();
		intStream.forEach(System.out::println);
		System.out.println("-----");

		// String Stream with RegEx
		System.out.println("String Stream with RegEx");
		stringStream = Pattern.compile(", ").splitAsStream("A, B, C");
		stringStream.forEach(System.out::println);
		System.out.println("-----");

		// File Stream
		System.out.println("File Stream");
		try {
			stringStream = Files.lines(Paths.get("src/test.txt"), Charset.forName("UTF-8"));
			stringStream.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----");

		// Parallel Stream
		System.out.println("Parallel Stream");
		System.out.println("Collection, Stream : .parallelStream()");
		System.out.println("Array, <T>Stream : .parallel()");
		ArrayList<Product> productList = new ArrayList<>();
		Stream<Product> parallelStream2 = productList.parallelStream();
		System.out.println(parallelStream2.isParallel());
		System.out.println(parallelStream2.map(product -> productList.size() * 10).anyMatch(amount -> amount > 200));

		Arrays.stream(arr).parallel();
		intStream = IntStream.range(1, 150).parallel();
		System.out.println("sequential mode by .sequential");
		intStream = intStream.sequential();
		System.out.println("-----");

		// Concat
		System.out.println("Concat");
		Stream<String> stream1 = Stream.of("A", "B", "C");
		Stream<String> stream2 = Stream.of("D", "E", "F");
		Stream<String> concat = Stream.concat(stream1, stream2);
		concat.forEach(System.out::println);
		System.out.println("-----");

		// Filtering
		System.out.println("Filter");
		Stream<String> filterStream = list.stream().filter(letter -> letter.contains("a"));
		filterStream.forEach(System.out::println);
		System.out.println("-----");

		// Mapping
		System.out.println("Mapping");
		Stream<String> mappingStream = list.stream().map(String::toUpperCase);
		mappingStream.forEach(System.out::println);
		System.out.println("-----");

		// Mapping with FlatMap
		System.out.println("(flat)Mapping");
		List<List<String>> listFlatMap = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		List<String> flatList = listFlatMap.stream().flatMap(Collection::stream).collect(Collectors.toList());
		flatList.forEach(System.out::println);
		System.out.println("-----");

		// Sorting
		System.out.println("sort");
		List<Integer> nums = IntStream.of(14, 11, 20, 39, 23).sorted().boxed().collect(Collectors.toList());
		nums.forEach(System.out::println);
		System.out.println("-----");
		nums = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		nums.forEach(System.out::println);
		System.out.println("-----");

		List<String> lang = Arrays.asList("B", "C", "A", "D", "G", "E");

		lang = lang.stream().sorted().collect(Collectors.toList());
		lang.forEach(System.out::println);
		System.out.println("-----");
		lang = lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		lang.forEach(System.out::println);
		System.out.println("-----");

		lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		// Peek
		System.out.println("Peek");
		int sum = IntStream.of(1, 3, 5, 7, 9)
				  .peek(System.out::println)
				  .sum();
		System.out.println(sum);

	}
}
