package product.controller;

import product.model.productservice;
import product.view.productview;

public class productcontroller {
    private productservice service;
    private productview view;

    public productcontroller(productservice service) {
        this.service = service;
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
                    service.addProduct(new product.model.product(name, price, quantity));
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
