# ItemOrderAPI RESTful Web Services with Spring Boot and MySql
- Creating Product, Order and OrderProduct bean.
- Implementing GET Methods for Product Controller
- Implementing POST Method to create Product Controller
- Enhancing POST Method to return correct HTTP Status Code and Location URI as 201 response status
- Implementing Exception Handling - 404 (if Resource Not Found)
- Implementing customize Exception format.
- Implementing DELETE Method to delete a Product
- Implementing Item count for keep records of items.
- Updating item count in table after orderd.
- Implementing out of stock if item count is less throw exception with ### HTTP_STATUS.NO_CONTENT
- Implementing all order details.
- Implementing Validations for RESTful Services

## What You Will Need?

- Java 8
- Mysql
- Eclipse/STS
- Maven
- Embedded Tomcat
- Postman REST Services Client

## API Documentation
- Try to open (http://localhost:8080/v2/api-docs)

## MySql credential change
-- change MySql credential (user name and password)

## URLs (Products)
-- http://localhost:8080/api/products
  * end points (/{id},/save,/delete/{id},)
## URLs (Orders)
-- http://localhost:8080/api/order/
  * end points (/create)
