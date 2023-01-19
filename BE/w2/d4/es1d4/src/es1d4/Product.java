package es1d4;

import java.util.List;
import java.util.stream.Collectors;

class Product {
    private Long id;
    private java.lang.String name;
    private Category category;
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setCategory(Category books) {
        this.category = books;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public java.lang.String getName() {
        return name;
    }

    
    public Category getCategory() {
            return category;
        }

    public Double getPrice() {
            return price;
        }
	
    
    

}


