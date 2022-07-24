package com.company.Repo;

import com.company.DB.DBLists;
import com.company.Interface.Repo;
import com.company.Item.Product;

public class ProductRepo implements Repo<Product> {    //class for connecting Product and DB

    @Override
    public void addElement(Product elem) {
        DBLists.addItem(elem,DBLists.getProductList());
        DBLists.addItem(elem.getId(),DBLists.getProductID());
    }

    @Override
    public void deleteElement(Product elem) {
        DBLists.deleteItem(elem,DBLists.getProductList());
        DBLists.deleteItem(elem.getId(),DBLists.getProductID());
    }

    public void editElement(Product elem) {

    }

    @Override
    public void showElement() {
        DBLists.showProductList();
    }


}
