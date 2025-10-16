package product;

import product.controller.productcontroller;
import product.model.product;
import product.model.productservice;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<product> products = new ArrayList<>();

        productservice service = new productservice(products);
        productcontroller controller = new productcontroller(service);
        controller.run();
    }
}
