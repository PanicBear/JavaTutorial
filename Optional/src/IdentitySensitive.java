import java.util.Optional;

public class IdentitySensitive {

	public IdentitySensitive() {
		MapProduct product = new MapProduct();
		Optional<MapProduct> opt1 = Optional.of(product);
		Optional<MapProduct> opt2 = Optional.of(product);
		System.out.println("never use synchronized");
		System.out.println("opt1==opt2 : " + String.valueOf(opt1==opt2));
		System.out.println("opt1.equals(opt2) : " + String.valueOf(opt1.equals(opt2)));
		System.out.println("------------");
	}
}
