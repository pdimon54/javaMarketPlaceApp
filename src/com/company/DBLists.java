package com.company;


import java.util.*;


public class DBLists {

    private static List<User> userList = new ArrayList<>();// list of users
    private static List<Product> productList = new ArrayList<>();//list of products
    private static Set<String> userID = new HashSet<>();//list user ID
    private static Set<String> productID = new HashSet<>();
    private static Map<String ,List<Product>> userShoppingList = new HashMap<>();//user buying last
    private static Map<String ,List<User>> buyersList = new HashMap<>();//users who buy this product


    public static void  addNewUser(User user){
        userList.add(user);
        userID.add(user.getId());
    }
    public static void addNewProduct(Product product){
        productList.add(product);
        productID.add(product.getId());
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
        //

    }
    /*for (Map.Entry<String, User> entry : buyersList.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue().getFirstName());
        }*/
    public static void deleteUser(User user){

        userList.remove(user);
        userShoppingList.remove(user.getId());
        buyersList.remove(user.getId());

    }


}
