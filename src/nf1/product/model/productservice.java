package nf1.product.model;

import java.util.List;

public class productservice {
    private List<product> products;

    public productservice(List<product> products) {
        this.products = products;
    }

    public void addProduct(product p) {
        products.add(p);
    }

    public String productList() {
        if (products.isEmpty()) {
            return "No products available.";
        }
        StringBuilder sb = new StringBuilder();
        for (product p : products) {
            sb.append("Name: ").append(p.name())
              .append(", Price: ").append(p.price())
              .append(", Quantity: ").append(p.quantity())
              .append("\n");
        }
        return sb.toString();
    }
}
