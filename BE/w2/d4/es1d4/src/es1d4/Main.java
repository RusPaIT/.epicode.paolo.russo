package es1d4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void printFilteredProducts(List<Product> products) {
		List<Product> filteredProducts = products.stream()
				.filter(product -> product.getCategory() == Category.BOOKS && product.getPrice() > 100)
				.collect(Collectors.toList());

		filteredProducts.forEach(product -> System.out.println(
				"\tes1\n\tLista Libri con prezzo superiore a 100 dollari: " + product.getName() + " - " + product.getPrice() + "\n\t--------------------------------------"));
	}

	public static void printOrders(List<Order> orders) {
		List<Product> babyProduct = orders.stream().flatMap(order -> order.getProduct().stream())
				.filter(product -> product.getCategory() == Category.BABY).collect(Collectors.toList());

		babyProduct.forEach(product -> {
			System.out.println("\tes2");
			System.out.println("\tProduct Name: " + product.getName());
			System.out.println("\tProduct Category: " + product.getCategory());
			System.out.println("\tProduct Price: " + product.getPrice());
		});
	}

	List<Product> products = new ArrayList<>();

	public static void printBoysProducts(List<Product> products) {
		List<Product> boysProduct = products.stream().filter(product -> product.getCategory() == Category.BOYS)
				.peek(product -> product.setPrice(product.getPrice() * 0.9)).collect(Collectors.toList());

		boysProduct.forEach(product -> {
			System.out.println("\tes3");
			System.out.println("\tProduct Name: " + product.getName());
			System.out.println("\tProduct Category: " + product.getCategory());
			System.out.println("\tProduct Price: " + product.getPrice());
		});

	}

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Book 1");
		product1.setCategory(Category.BOOKS);
		product1.setPrice(10.99);
		products.add(product1);

		Product product2 = new Product();
		product2.setId(2L);
		product2.setName("Baby Toy");
		product2.setCategory(Category.BABY);
		product2.setPrice(15.99);
		products.add(product2);

		Product product3 = new Product();
		product3.setId(3L);
		product3.setName("Boys Toy");
		product3.setCategory(Category.BOYS);
		product3.setPrice(20.99);
		products.add(product3);

		Product product4 = new Product();
		product4.setId(4L);
		product4.setName("Book 2");
		product4.setCategory(Category.BOOKS);
		product4.setPrice(200.99);
		products.add(product4);

		Product product5 = new Product();
		product5.setId(5L);
		product5.setName("Toy");
		product5.setCategory(Category.BABY);
		product5.setPrice(20.99);
		products.add(product5);

		Product product6 = new Product();
		product6.setId(6L);
		product6.setName("Boys Game");
		product6.setCategory(Category.BOYS);
		product6.setPrice(20.99);
		products.add(product6);

		List<Order> orders = new ArrayList<>();

		Order order = new Order();
		order.setId(1L);
		order.setStatus("Shipped");
		order.setOrderDate(LocalDate.now());
		order.setDeliveryDate(LocalDate.now().plusDays(5));

		List<Product> _products = new ArrayList<>();
		_products.add(product2);
		_products.add(product5);

		order.setProduct(_products);
		orders.add(order);

		// es1
		printFilteredProducts(products);

		// es2
		printOrders(orders);
		
		//es3
		printBoysProducts(products);
	}

}
