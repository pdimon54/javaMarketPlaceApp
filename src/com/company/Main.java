package com.company;

import com.company.Manager.Manager;
import com.company.Repo.ProductRepo;
import com.company.Repo.UserRepo;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        String input;
        do {
            Menu.createMainMenu();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();


            switch (input) {
                case "1" -> {//Add new user
                    System.out.println("1)Add new user");
                    manager.addNewUser();
                }
                case "2" -> {//Add new product
                    System.out.println("2)/Add new product");
                    manager.addNewProduct();
                }
                case "3" -> {//Show list of users
                    System.out.println("3)Show list of users");
                    manager.showList("Users list");
                    System.out.println("You want delete some user?");
                    System.out.println("Write yes or no");
                    String deleteUserOption = scanner.nextLine();
                    if (Objects.equals(deleteUserOption, "yes"))
                        manager.deleteUser();
                }
                case "4" -> {//Show list of products
                    System.out.println("4)Show list of products");
                    manager.showList("Product list");
                    System.out.println("You want delete some product?");
                    System.out.println("Write yes or no");
                    String deleteProductOption = scanner.nextLine();
                    if (Objects.equals(deleteProductOption, "yes"))
                        manager.deleteProduct();
                }
                case "5" -> {//Show list of users products
                    System.out.println("5)Show list of users products");
                    manager.showUserProductList();
                }
                case "6" -> {//Show list of users who buy choose product
                    System.out.println("6)Show list of users who buy choose product");
                    manager.showProductsListUser();
                }
                case "7" -> {//Buy product
                    System.out.println("7)Buy product");
                    manager.buyProduct();
                }
                case "8" ->//exit
                        System.out.println("Thanks for using our shop!");
                default -> System.out.println("Please, choose correct option(1-8)");
            }
        }
        while(!input.equals("8"));


    }
}
