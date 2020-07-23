import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class GetOptionalObject {

	public GetOptionalObject() {

		Optional<String> opt = Optional.empty();
		String str = "Optional Object";

		System.out.println("empty()");
		try {
			System.out.println(opt.get());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(opt.orElse("Empty value"));

		try {
			System.out.println(opt.orElseThrow());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("------------");
		

		System.out.println("ofNullable with null");
		System.out.println("null instead of \"empty value\" also available if you need to null reference");
		opt = Optional.ofNullable(null);
		System.out.println(opt.orElse("Empty value"));
		System.out.println(opt.orElseGet(this::getValMethod));
		System.out.println("------------");
		

		System.out.println("not null with of");
		
		opt = Optional.of(str);
		
		System.out.println(opt.orElse("Empty value"));
		System.out.println(opt.orElseGet(this::getValMethod));
		System.out.println("------------");

		
		System.out.println("replace if(oopt.ispresent){} with opt.ifPresent()");
		opt.ifPresent(System.out::println);
		System.out.println("------------");
		
		
		System.out.println("Avoid Optional<T>");
		OptionalInt optInt = OptionalInt.of(50);
		OptionalLong optLong = OptionalLong.of(50L);
		OptionalDouble optDouble = OptionalDouble.of(50.43d);
		System.out.println("OptionalInt : " + optInt.getAsInt());
		System.out.println("OptionalLong : " + optLong.getAsLong());
		System.out.println("OptionalDouble : " + optDouble.getAsDouble());
		System.out.println("------------");
		
		
		System.out.println("no need to unwrap for comparison");
		
		Optional optString1 = Optional.of("value");
		Optional optString2 = Optional.of("value");
		
		System.out.println(optString1.equals(optString2));
		System.out.println("------------");
		
		
		System.out.println("transform value by map");
		Optional<String> optTrans = opt.map(String::toUpperCase);
		System.out.println(optTrans.orElseGet(this::getValMethod));
		System.out.println("------------");
	}

	public String getValMethod() {
		return "Empty value";
	}

}
