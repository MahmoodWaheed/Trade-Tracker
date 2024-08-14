package org.example;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import org.example.model.Category;
//import org.example.model.Supplier;
//import org.example.service.CategoryService;

//import org.example.service.ItemService;
//import org.example.service.SupplierService;
import javafx.application.Application;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainPage.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }
    public static void main(String[] args) {

////        System.out.println("Hello world!");
//
////        Product product = new Product("ksa",12.0,95,"for cleaning");
////        Product product1;
////        ProductService productServi564655ce = new ProductService();
////        product1 = productService.getProduct(52);
//////        product1.setProductName("ksall");
////        productService.deleteProduct(product1);
//
//        Employee employee = new Employee("Ahmed","cat1");
//        EmployeeService employeeService = new EmployeeService();
//        List<Employee> list = employeeService.getAllEmployee();
//        ObservableList<Employee> list1 = employeeService.getAllEmployeesByName("bilal");
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i).getEmployeeName());
//        }
//        Category category = new Category("electronics",Date.valueOf(LocalDate.now()));
//        CategoryService categoryService = new CategoryService();
//        categoryService.saveCategory(category);
//        Supplier supplier = new Supplier("ibrahim",Date.valueOf(LocalDate.now()));
//        SupplierService supplierService = new SupplierService();
//        supplierService.saveSupplier(supplier);
//        Item item = new Item("mosfet",category,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.of(2026,8,30)),21,"3852",supplier,60,5,15);
//        ItemService itemService = new ItemService();
//        itemService.saveItem(item);
        launch(args);



    }


}