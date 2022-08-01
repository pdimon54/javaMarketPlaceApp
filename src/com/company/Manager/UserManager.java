package com.company.Manager;

import com.company.DB.DBLists;
import com.company.Item.Product;
import com.company.Item.User;
import com.company.Repo.ProductRepo;
import com.company.Repo.UserRepo;

import java.util.Objects;
import java.util.Scanner;

public class UserManager {

    private final UserRepo userRepo;

    public UserManager(UserRepo userRepo){
        this.userRepo = userRepo;
    }

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

    public void getList(){                              //display List of Users
        userRepo.getAll();
    }
    public void getUserProductList(){                              //display list of buying products
        String Id = checkID();
        for (User user:DBLists.getUserList()) {

            if(Objects.equals(Id, user.getId())){
                for (Product product: user.getUserProductList().keySet()) {
                    System.out.println("Id:" + product.getId());
                    System.out.println("Name:" + product.getName());
                    System.out.println("Price:" + product.getPrice());
                }
            }
        }

    }


    public boolean buyProduct(){                                       //method purchases product
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

                    checkUserFlag = userRepo.editElement(user,tempPrice);
                }
            }
            if(!checkUserFlag)
                System.out.println("We doesnt have this user");
            }
        return checkUserFlag && checkProductFlag;
    }

}
