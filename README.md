# projectone

This is a Shopping App Application that is created with the use of java, spring boot, maven, and multiple jpa repositories. The application allows a user to run the app using postman. Users can place order, add item to cart, regiser new users and login users.


This application can be operated by pulling or clonning this repository to your local machine, run the application on JVM/JRE of your choosing, download postman and run the following ;

CART
Create cart: localhost:8085/cart
Add item to cart: localhost:8085/cart/10/items/9
Get Cart Item: localhost:8085/cart/1/items/

ITEM:
New Request: localhost:8085/item
Create Item: localhost:8085/item

Order
Create Oreder: localhost:8085/order
Get Order:   localhost:8085/order/{orderId}

User
Register User: localhost:8085/user
Login User:   localhost:8085/user/login
Get All Users: localhost:8085/user


This project is managed and hosted through AWS server, the url is https://revatureaws.s3.amazonaws.com/shoppingapp-0.0.1-SNAPSHOT.jar, you have to enable it to work by uncommenting it in the Application.Property. 

