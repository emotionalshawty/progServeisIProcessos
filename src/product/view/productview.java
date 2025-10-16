package product.view;
import java.util.Scanner;

public class productview {
    Scanner sc = new  Scanner(System.in);

    public int mainmenu() {
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public String getProductName() {
        System.out.print("Enter product name: ");
        return sc.nextLine();
    }
    public float getProductPrice() {
        System.out.print("Enter product price: ");
        return sc.nextFloat();
    }
    public int getProductQuantity() {
        System.out.print("Enter product quantity: ");
        return sc.nextInt();
    }
    public void displayProducts(String products) {
        System.out.println("Product List:");
        System.out.println(products);
    }
    public String errorMessage() {
        System.out.println("Invalid choice. Please try again.");
        return sc.nextLine();
    }



}

