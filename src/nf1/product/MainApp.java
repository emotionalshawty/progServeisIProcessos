package nf1.product;

import nf1.product.controller.productcontroller;
import nf1.product.model.product;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<product> products = new ArrayList<>();

        productcontroller controller = new productcontroller(products);
        controller.run();
    }
}