import java.util.ArrayList;
import java.util.Optional;

public class FlatMapProduct {
	private int price;
	private String name;

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public Optional<String> getName() {
	    return Optional.ofNullable(name);
	}
	
}
