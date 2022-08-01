package com.company;

import com.company.Manager.ProductManager;
import com.company.Manager.UserManager;
import com.company.Menu.Menu;
import com.company.Repo.ProductRepo;
import com.company.Repo.UserRepo;

public class Main {

    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        UserManager userManager = new UserManager(userRepo);
        ProductRepo productRepo = new ProductRepo();
        ProductManager productManager = new ProductManager(productRepo);
        Menu.MainMenu(userManager,productManager);
    }

}
