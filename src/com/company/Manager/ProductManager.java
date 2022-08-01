package com.company.Manager;

import com.company.DB.DBLists;
import com.company.Item.Product;
import com.company.Item.User;
import com.company.Repo.ProductRepo;
//import com.company.Repo.UserRepo;

import java.util.Objects;
import java.util.Scanner;

public class ProductManager {

    public final ProductRepo productRepo;

    public ProductManager(ProductRepo productRepo){
        this.productRepo = productRepo;
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

    public void deleteProduct(){                                    //delete info about Product from DB(connect Product and DB)
        String deleteId = checkID();
        boolean deleteFlag = false;
        for (int i = 0; i< DBLists.getProductList().size(); i++) {
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

    public void getProductsListUser(){                         //display list with info about users who buy this product
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
    public void getList(){                              //display List of Products
        productRepo.getAll();
    }
}
