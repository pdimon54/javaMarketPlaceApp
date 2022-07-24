package com.company.Repo;

import com.company.DB.DBLists;
import com.company.Item.Product;
import com.company.Item.User;
import com.company.Interface.Repo;

public class UserRepo implements Repo<User> {

    @Override
    public void addElement(User elem) {
        DBLists.addItem(elem,DBLists.getUserList());
        DBLists.addItem(elem.getId(),DBLists.getUserID());
    }


    @Override
    public void deleteElement(User elem) {
        DBLists.deleteItem(elem,DBLists.getUserList());
        DBLists.deleteItem(elem.getId(),DBLists.getUserID());

    }

    public void editElement(User elem,int price) {

        for (User user : DBLists.getUserList()) {
            if (user.equals(elem)) {
                if (user.getMoney() >= price) {
                    user.setMoney(user.getMoney() - price);
                    for (Product product : DBLists.getProductList()) {
                        if (price == product.getPrice()) {
                            user.getUserProductList().add(product);
                            product.getThisProductBuyers().add(elem);
                        }
                    }
                }
                else
                    System.out.println("You doesnt have money for this, try to buy another product");
            }

        }
    }
    @Override
    public void showElement() {
        DBLists.showUserList();
    }
}
