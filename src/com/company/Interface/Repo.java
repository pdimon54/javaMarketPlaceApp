package com.company.Interface;

public interface Repo<E> {
    public void addElement(E elem);
    public  void deleteElement(E elem);
    public void getAll();


}
