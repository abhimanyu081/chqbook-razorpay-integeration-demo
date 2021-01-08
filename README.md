# Chqbook.com and Razorpay payement gateway integeration demo

## application url
APP URL - https://chqbook-razorpay-integeration.herokuapp.com/


## Application flow:

Create Order on Chqbook server ------> PAY -----> Pay with RazorPay -----> update payment status on Chqbook server

## Database used
Posgres DB (because it could easily be configured on Heroku)

### DB credentials and Razorpay credentials are saved into environment variable for security reasons.

## Assumption:-
1. A service is already available which generates the transaction id for each order created.
2. Payment is auto captured.
3. Amount will be entered in paisa, i.e. amount entered can not be less than 100 (1 rupee).
4. No frontend validation being done as of now.
5. No unit tests written as of now.

## Application Features (with coding point of view)
1. uses spring boot
2. Restful APIs
3. Coding Best practices has been followed.
4. Razorpay services and Chqbook services are loosly coupled.
5. JPA/Hibernate has been used as ORM for easier entity management.
6. HTML/JS/Jquery has been used for frontend.

## Things to take care:
### Order create form
1. transaction Id filed - This is assumed that some other service has already generated this transaction id, and we will pass it in background when this service becomes available.
2. order details - details of ordered items, for simplicict I have used a string filed, otherwise this should have been implemented using objects like LineItems
3. amount - the amount is in the paise. For example, if you want to enter 100 rupees, you need to enter 100*100=10000 paisa. That means you can not enter amount lass than 100.
4. receipt - receipt details if any available

## Instruction to run on local machine
1. Save Payment gateway credentials and database JDBC url in environment variable. Which depends on operation system, which can be easily googled.
2. clone the project
3. build and run
4. Go to localhost:8080

## TODO
1. improve frontend with validations
2. Implement full payment cycle of Razorpay like taking care of Lazy Authorization, Double Paymmetns, Refunds, Retries etc.
3. Proper input validation at backend also.
4. Implement logging and session management for user using spring security.
5. Proper logging
