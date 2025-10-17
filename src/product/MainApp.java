package product;

import product.controller.productcontroller;
import product.model.product;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<product> products = new ArrayList<>();

        productcontroller controller = new productcontroller(products);
        controller.run();
    }
}