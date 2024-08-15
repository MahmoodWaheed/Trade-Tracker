package org.example.dao;

import javafx.collections.ObservableList;

import org.example.model.Product;

import java.util.List;

public interface ProductDao {
    void saveItem(Product product);
    ObservableList<Product> getAllItemsByName(String itemName);

    void updateItem(Product product);
    void deleteItem(Product product);
    Product getItemById(int id);
    List<Product> getAllItems();
    int lastId();
}
