package com.company.DB;


import com.company.Item.Product;
import com.company.Item.User;

import java.util.*;


public class DBLists {

    private static List<User> userList = new ArrayList<>();// list of users
    private static List<Product> productList = new ArrayList<>();//list of products
    private static Set<String> userID = new HashSet<>();//list user ID
    private static Set<String> productID = new HashSet<>();//list product ID

    public static <E> void addItem(E elem,Collection <E> collection){
        collection.add(elem);
    }

    public static <E> void deleteItem(E elem, Collection<E> collection){
        collection.remove(elem);
    }
    public static <E> void update(E elem, Collection<E> collection,int option){
        if(option == 0){}//buying
        if(option == 1){}
    }

    public static List<User> getUserList() {
        return  userList;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static Set<String> getUserID() {
        return userID;
    }

    public static Set<String> getProductID() {
        return productID;
    }


    public static void showUserList(){
        for (User user: userList) {
            System.out.println("=====================================");
            System.out.println("Id:" + user.getId());
            System.out.println("First name:" + user.getFirstName());
            System.out.println("Last name:" + user.getLastName());
            System.out.println("Money:" + user.getMoney());
            System.out.println("=====================================");
        }
    }

    public static void showProductList(){
        for (Product product: productList) {
            System.out.println("=====================================");
            System.out.println("Id:" + product.getId());
            System.out.println("Name:" + product.getName());
            System.out.println("Price:" + product.getPrice());
            System.out.println("=====================================");
        }
    }

    public static boolean buyProduct(){
        String userId;
        String productId;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Users id:");
        userId = scanner.nextLine();
        System.out.println("Products id:");
        productId = scanner.nextLine();
        if(!userID.contains(userId)){
            System.out.println("Doesn`t have this user ");
            return false;
        }
        if(!productID.contains(productId)){
            System.out.println("Doesn`t have this product ");
            return false;
        }
        return true;

    }
    /*for (Map.Entry<String, User> entry : buyersList.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue().getFirstName());
        }*/



}
