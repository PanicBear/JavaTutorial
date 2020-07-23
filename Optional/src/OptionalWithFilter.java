import java.util.Optional;

public class OptionalWithFilter {

	public OptionalWithFilter() {

		Optional<String> pwd = Optional.of("20200723");
		
		System.out.println("use filter with optional is quite convenient");
		System.out.println("right pwd :  "+pwd.filter((p) -> p.length() >= 8).isPresent());
		System.out.println("------------");
	}

}
