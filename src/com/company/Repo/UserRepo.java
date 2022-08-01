package com.company.Repo;

import com.company.DB.DBLists;
import com.company.Item.Product;
import com.company.Item.User;
import com.company.Interface.Repo;

public final class UserRepo implements Repo<User> {               //class for connecting User and DB


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

    public boolean editElement(User elem,int price) {

        for (User user : DBLists.getUserList()) {
            if (user.equals(elem)) {
                if (user.getMoney() >= price) {
                    user.setMoney(user.getMoney() - price);
                    for (Product product : DBLists.getProductList()) {
                        if (price == product.getPrice()) {
                            if (user.getUserProductList().containsKey(product)){
                                user.getUserProductList().put(product,+1);
                            }
                            else {
                            user.getUserProductList().put(product,1);
                            product.getThisProductBuyers().add(elem);
                            }
                            return true;

                        }
                    }
                }
                else{
                    System.out.println("You doesnt have money for this, try to buy another product");
                    return false;
                }

            }

        }
        return false;
    }
    @Override
    public void getAll() {
        DBLists.showUserList();
    }
}
