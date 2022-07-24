package com.company.Manager;

import com.company.DB.DBLists;
import com.company.Item.Product;
import com.company.Item.User;
import com.company.Repo.ProductRepo;
import com.company.Repo.UserRepo;

import java.util.Objects;
import java.util.Scanner;

public class Manager {
    UserRepo userRepo = new UserRepo();
    ProductRepo productRepo = new ProductRepo();

    public void addNewUser(){                            //method added new User to DB(connect User and DB)
        String firstName,lastName;
        int money;
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name:");
        firstName = scanner.nextLine();
        while(firstName.isEmpty()) {//null field check
            System.out.println("Nothing was entered. Please try again");
            System.out.println("First name:");
            firstName = scanner.nextLine();
        }
        System.out.println("Last name:");
        lastName = scanner.nextLine();
        while(lastName.isEmpty()) {                          //null field check
            System.out.println("Nothing was entered. Please try again");
            System.out.println("Last name:");
            lastName = scanner.nextLine();
        }
        System.out.println("Money:");
        money = scanner.nextInt();
        while(money<0) {                                    //>0 field check
            System.out.println("Money must be > 0. Please try again");
            System.out.println("Money:");
            money = scanner.nextInt();
        }
        User user = new User(firstName,lastName,money);
        userRepo.addElement(user);
    }

    public void addNewProduct(){                           //added new Product to DB(connect Product and DB)
        String name;
        int price;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        name = scanner.nextLine();
        while(name.isEmpty()) {                            //null field check
            System.out.println("Nothing was entered. Please try again");
            System.out.println("Name:");
            name = scanner.nextLine();
        }
        System.out.println("Price:");
        price = scanner.nextInt();
        while(price<0) {                                        //>0 field check
            System.out.println("Price must be > 0. Please try again");
            System.out.println("Price:");
            price = scanner.nextInt();
        }
        Product product = new Product(name,price);
        productRepo.addElement(product);
    }

    public void deleteUser(){                               //delete info about User from DB(connect User and DB)
        String deleteId = checkID();
        boolean deleteFlag = false;
        for (int i = 0; i < DBLists.getUserList().size();i++) {
            User user = DBLists.getUserList().get(i);
            if(user.getId().equals(deleteId)) {
                userRepo.deleteElement(user);
                for (int n = 0;n < DBLists.getProductList().size();n++) {
                    Product product = DBLists.getProductList().get(n);
                    product.getThisProductBuyers().remove(user);
                    deleteFlag = true;
                }
            }

        }
        if(!deleteFlag)
            System.out.println("We doesnt have this user");
    }
    public void deleteProduct(){                                    //delete info about Product from DB(connect Product and DB)
        String deleteId = checkID();
        boolean deleteFlag = false;
        for (int i = 0;i<DBLists.getProductList().size();i++) {
            Product product = DBLists.getProductList().get(i);
            if(product.getId().equals(deleteId)){
                productRepo.deleteElement(product);
                for (int n = 0;n< DBLists.getUserList().size();n++) {
                    User user = DBLists.getUserList().get(n);
                    user.getUserProductList().remove(product);
                }
                deleteFlag = true;
            }
        }
        if(!deleteFlag)
            System.out.println("We doesnt have this user");
    }

    private String checkID() {                                  //check for correct input Id
        String deleteId;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write id:");
        deleteId = scanner.nextLine();
        while (deleteId.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("Write id to delete user:");
            deleteId = scanner.nextLine();
        }
        return deleteId;
    }

    public void showList(String item){                              //display List of Users or Products
        if(Objects.equals(item, "Users list"))
            userRepo.showElement();
        if (Objects.equals(item, "Product list"))  
            productRepo.showElement();
    }
    public void showUserProductList(){                              //display list of buying products
        String Id = checkID();
        for (User user:DBLists.getUserList()) {

            if(Objects.equals(Id, user.getId())){
                for (Product product: user.getUserProductList()) {
                    System.out.println("Id:" + product.getId());
                    System.out.println("Name:" + product.getName());
                    System.out.println("Price:" + product.getPrice());
                }
            }
        }

    }
    public void showProductsListUser(){                         //display list with info about users who buy this product
        String Id = checkID();
        for (Product product:DBLists.getProductList()) {

            if(Objects.equals(Id, product.getId())){
                for (User user: product.getThisProductBuyers()) {
                    System.out.println("Id:" + user.getId());
                    System.out.println("First name:" + user.getFirstName());
                    System.out.println("Last name:" + user.getLastName());
                    System.out.println("Money:" + user.getMoney());
                }
            }
        }
    }

    public void buyProduct(){                                       //method purchases product
        System.out.println("User ID");
        String userId = checkID();
        System.out.println("Product ID");
        String productId = checkID();
        boolean checkUserFlag = false;
        boolean checkProductFlag = false;
        int tempPrice = -1;

        for (Product product:DBLists.getProductList()) {
            if(product.getId().equals(productId)){
                tempPrice = product.getPrice();
                checkProductFlag = true;
            }
        }
        if(!checkProductFlag)
            System.out.println("We doesnt have this product");
        else{
            for (int i = 0; i<DBLists.getUserList().size();i++){
                User user = DBLists.getUserList().get(i);
                if(user.getId().equals(userId)){
                    userRepo.editElement(user,tempPrice);
                    checkUserFlag = true;
                }
            }
            if(!checkUserFlag)
                System.out.println("We doesnt have this user");
            }
        }

}
