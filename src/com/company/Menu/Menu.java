package com.company.Menu;

import com.company.Manager.ProductManager;
import com.company.Manager.UserManager;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void MainMenuElem(){
        System.out.println("1)Add new user");
        System.out.println("2)Add new product");
        System.out.println("3)Show list of users");
        System.out.println("4)Show list of products");
        System.out.println("5)Show list of users products");
        System.out.println("6)Show list of users who buy choose product");
        System.out.println("7)Buy product");
        System.out.println("8)Exit");
    }

    public static void MainMenu(UserManager userManager, ProductManager productManager){
        String input;
        do {
            Menu.MainMenuElem();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();


            switch (input) {
                case "1" -> {//Add new user
                    System.out.println("1)Add new user");
                    userManager.addNewUser();
                }
                case "2" -> {//Add new product
                    System.out.println("2)/Add new product");
                    productManager.addNewProduct();
                }
                case "3" -> {//Show list of users
                    System.out.println("3)Show list of users");
                    userManager.getList();
                    System.out.println("You want delete some user?");
                    System.out.println("Write yes or no");
                    String deleteUserOption = scanner.nextLine();
                    if (Objects.equals(deleteUserOption, "yes"))
                        userManager.deleteUser();
                }
                case "4" -> {//Show list of products
                    System.out.println("4)Show list of products");
                    productManager.getList();
                    System.out.println("You want delete some product?");
                    System.out.println("Write yes or no");
                    String deleteProductOption = scanner.nextLine();
                    if (Objects.equals(deleteProductOption, "yes"))
                        productManager.deleteProduct();
                }
                case "5" -> {//Show list of users products
                    System.out.println("5)Show list of users products");
                    userManager.getUserProductList();
                }
                case "6" -> {//Show list of users who buy choose product
                    System.out.println("6)Show list of users who buy choose product");
                    productManager.getProductsListUser();
                }
                case "7" -> {//Buy product
                    System.out.println("7)Buy product");
                    userManager.buyProduct();
                }
                case "8" ->//exit
                        System.out.println("Thanks for using our shop!");
                default -> System.out.println("Please, choose correct option(1-8)");
            }
        }
        while(!input.equals("8"));

    }


}
