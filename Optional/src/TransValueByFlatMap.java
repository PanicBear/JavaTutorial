import java.util.ArrayList;
import java.util.Optional;

public class TransValueByFlatMap {
	
	
	TransValueByFlatMap(){
		ArrayList<FlatMapProduct> products = new ArrayList<>();
		FlatMapProduct product;

		for (int i = 40; i < 60; i++) {
			product = new FlatMapProduct();
			product.setName(String.valueOf("FlatMapProduct"+i));
			product.setPrice(i);
			products.add(product);
		}

		String name = products.stream()
				.filter(p -> p.getPrice() < 50)
				.findFirst()
				.flatMap(FlatMapProduct::getName)
				.map(String::toUpperCase)
				.orElse("NOT FOUND");
		System.out.println("Optional.flatMap requires argument with Optional Object");
		System.out.println("Stream class could be treated by Optional.stream()");
		System.out.println("this is useful, in case Api need both Optional and Stream");
		System.out.println(name);
		System.out.println("------------");
	}

}
