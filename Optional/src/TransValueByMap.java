import java.util.ArrayList;

public class TransValueByMap {

	public TransValueByMap() {


		ArrayList<MapProduct> products = new ArrayList<>();
		MapProduct product;

		for (int i = 40; i < 60; i++) {
			product = new MapProduct();
			product.setName(String.valueOf("MapProduct"+i));
			product.setPrice(i);
			products.add(product);
		}
		
		String name = products.stream()
				.filter(p -> p.getPrice() < 50)
				.findFirst()
				.map(MapProduct::getName)
				.map(String::toUpperCase)
				.orElse("NOT FOUND");
		
		System.out.println("Optional.Map requires argument with value");
		System.out.println(name);
		System.out.println("------------");
	}

}
