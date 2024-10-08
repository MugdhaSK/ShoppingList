# ShoppingList
This Project is created to generate a Shopping list for the user using REST Api
Below is the list of the API that will be executed using this project: -
•	API to add User
o	API - http://localhost:8080/api/user
o	Method – POST
o	Request Body – 
{
    	 "username": "admin",
    	 "password": "password"
}
•	API to Get the information about the user added
o	API - http://localhost:8080/api/user/all
o	Method – GET
•	API to add Shopping List for the user added priorly
o	API - http://localhost:8080/api/shopping-lists?userId=1
o	Method – POST
o	Request Body –
{
  "title": "Groceries",
  "creationTime": "2024-10-07T10:30:00"
}
•	API to add item in the shopping list
o	API - http://localhost:8080/api/user
o	Method – POST
o	Request Body –
{
  "name": "Gauva",
  "category":"Fruit"
}
•	API to Get the information about the Shopping List
o	API - http://localhost:8080/api/user
o	Method – POST

WE collect user details and all the shopping list for that user and individually add the item into the shopping list.
  
