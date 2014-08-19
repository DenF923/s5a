Dennis Fung

Github Repository URL: https://github.com/DenF923/s5a.git


============
Exercise 1
============
Please See com/s5a/interview/ProductTest.java





============
Exercise 2
============
Please see the following files:

com/sample/dao/UserService.java
com/sample/dao/userServiceTest.java





============
Exercise 3
============

 1 package com.s5a.interview;
 2 
 3 public class ProductController {
 4 
 5   Product product = ServiceProduct.add("Saks-brand-name");
 6
 7    private String showProduct() {
 8        product.getBrandName()
 9    }
10
11    public boolean addProduct(String brandName) {
12        product = serviceProduct.add(brandName);
13
14        return true;
15    }
16
17    public static void formatedBrandName() {
18        System.out.println("Current product: " + product.getBrandName)
19    }
20
21 }

Code Review:
1. line 5 - although Java doesn't require you to do so, it is good practice to explicitly declare the
            "product" object as either public, private, or protected.
2. line 5 - this "product" object should be instantiated in the constructor.
3. line 7 - showProduct() method should be public, since there are no other areas within the class is
            using it, which means this method is intended to be accessible by other classes.
4. line 8 - there is a missing semicolon here at the end of the line.
5. line 8 - this method needs to return a String, so it should be "return product.getBrandName();"
6. line 12 - assuming "serviceProduct.add()" is a static method, the first "s" should be capitalized,
             as class names should generally start with a capital letter. But if this is an object
             instance, and serviceProduct is a variable, then this variable must be declared somewhere,
             which it is not at the moment.
7. line 12 - ServiceProduct.add() should return a boolean, to denote whether or not the add was
             successful. There is no purpose in returning the Product object of the product you just
             added.
8. line 17 - a static method can only access static variables. If this method was meant to be static,
             then the "product" object that's being used in line 18 needs to be static as well.
             Otherwise, this method should not be static.
9. line 17 - typo with the word "formatted" in the method name. It is generally a good idea to spell a
             word correctly so other developers can read your code easier.
10. line 18 - based on line 8, getBrandName is a method of Product. All methods must have parentheses,
              even if there are no arguments to pass. So it should be product.getBrandName().
11. line 18 - there is a missing semicolon here at the end of the line.
12. line 18 - System.out.println() should not be used here, as this class isn't necessarily only meant
              for outputting to system out. It can be used for other "views" too, such as Swing GUI,
              or as an HTTP response. So instead, this method should not return "void", but instead,
              should return "String" to allow flexibility on how this data can be outputted.
13. ServiceProduct has not been implemented.
14. Please see the following fixed classes:
          com/s5a/interview/ProductController.java
          com/s5a/interview/ServiceProduct.java
