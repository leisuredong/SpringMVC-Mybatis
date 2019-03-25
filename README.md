# SpringMVC-Mybatis
A shopping website implemented with SpringMVC and Mybatis only has two users, one buyer and one seller. Every content's quantity is 1.  
  
Buyer can do:
+ View all the contents which publiced by seller and can only view the contents bought before. 
+ View the specific content.
+ Add the contents in stock to shopping-cart.
+ Settle accounts.
  
 Seller can do:
 + View all the contents.
 + Delete the contents in stock.
 + Edit the old contents.
 + Public the new contents.
   
 There are 3 tables:
 + Table users(id, username, password) saves the infomation of buyer and seller.
 + Table contents(id, title, summary, image, file, detail, price, sold) saves the infomation of all the contents.
 + Table items(id, time, number, price) saves the infomation of contents which bought by buyer.
