package nf1.product.controller;

import nf1.product.model.productservice;
import nf1.product.view.productview;
import java.util.List;

public class productcontroller {
    private productservice service;
    private productview view;

    public productcontroller(List<nf1.product.model.product> productList) {
        this.service = new productservice(productList);
        this.view = new productview();
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = view.mainmenu();
            switch (choice) {
                case 1:
                    String name = view.getProductName();
                    float price = view.getProductPrice();
                    int quantity = view.getProductQuantity();
                    service.addProduct(new nf1.product.model.product(name, price, quantity));
                    break;
                case 2:
                    String products = service.productList();
                    view.displayProducts(products);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    view.errorMessage();
            }
        }
    }
}