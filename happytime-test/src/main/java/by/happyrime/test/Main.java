package by.happyrime.test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.happytime.domain.Order;
import by.happytime.domain.OrderStatus;
import by.happytime.domain.OrderUnit;
import by.happytime.domain.User;
import by.happytime.repository.CategoryRepo;
import by.happytime.repository.OrderRepo;
import by.happytime.repository.OrderUnitRepo;
import by.happytime.repository.ProductRepo;
import by.happytime.repository.RoleRepo;
import by.happytime.repository.SubcategoryRepo;
import by.happytime.repository.UserRepo;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println(TimeZone.getDefault().getDisplayName());
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserRepo userRepo = context.getBean(UserRepo.class);
        CategoryRepo categoryRepo = context.getBean(CategoryRepo.class);
        SubcategoryRepo subcategoryRepo = context.getBean(SubcategoryRepo.class);
        ProductRepo productRepo = context.getBean(ProductRepo.class);
        RoleRepo roleRepo = context.getBean(RoleRepo.class);
        OrderRepo orderRepo = context.getBean(OrderRepo.class);
        OrderUnitRepo orderUnitRepo = context.getBean(OrderUnitRepo.class);
        /*
        Order balloonOrder = orderRepo.findOne(2L);
        balloonOrder.getOrderUnits().get(0).setQuantity((int) (Math.random() * 1000));
        balloonOrder.setStatus(OrderStatus.SENT);
        orderRepo.save(balloonOrder);
        */
        
        Order order = new Order();

        order.setFirstName("Максим");
        order.setLastName("Драгун");
        order.setPhone("+375 29 312 08 55");
        order.setStatus(OrderStatus.NEW);
        order.setEmail("max-hellfire@mail.ru");
        order.setOrderDate(new Date());
        
        OrderUnit orderUnit1 = new OrderUnit();
        orderUnit1.setProduct(productRepo.findOne(1L));
        orderUnit1.setQuantity(36);
        orderUnit1.setOrder(order);
        
        OrderUnit orderUnit2 = new OrderUnit();
        orderUnit2.setProduct(productRepo.findOne(3L));
        orderUnit2 .setQuantity(35);
        orderUnit2.setOrder(order);
        
//        order.setOrderUnits(Arrays.asList(orderUnit1, orderUnit2));
        orderRepo.save(order);
        
        /*
        User user = new User();
        user.setLogin("Makseemka");
        user.setPasswordDetails(PasswordHash.createHash("password"));
        user.setBirthDate(new Date());
        user.setEnabled(true);
        user.setEmail("max-hellfire@mail.ru");
        Role roleUser = roleRepo.findByValue(Role.ROLE_USER);
        Role roleAdmin = roleRepo.findByValue(Role.ROLE_ADMIN);
        user.setRoles(Arrays.asList(roleAdmin, roleUser));
        userRepo.save(user);
        
        Category category = new Category();
        category.setTitle("Аксессуары");
        categoryRepo.save(category);
        
        Subcategory subcategory = new Subcategory();
        subcategory.setTitle("Новогодние аксессуары");
        subcategory.setCategory(category);
        subcategoryRepo.save(subcategory);
        
        Product product = new Product();
        product.setTitle("Елка новогодняя 55см");
        product.setCost(new BigDecimal(110000));
        product.setQuantity(50);
        product.getCategories().add(category);
        product.getSubcategories().add(subcategory);
        productRepo.save(product);
        */
        
        context.close();
    }

}
