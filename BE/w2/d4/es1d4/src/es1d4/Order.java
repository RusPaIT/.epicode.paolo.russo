package es1d4;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> product;
    private Customer customer;
    
	public void setId(Long id) {
		this.id = id;
		
	}

	public void setStatus(String status) {
		this.status = status;
		
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
		
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
		
	}

	public void setProduct(List<Product> product) {
		this.product = product;
		
	}

	public Collection<Product> getProduct() {
		return product;
	}

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

    //getters and setters
    
    
}
