#Installation

* Maven
* IdeaJ or Eclipse
* Mysql

#Database Setup
* Import todos.sql into a database
* Configure mysql creds into application.properties


#Requests

* Get a list of all todos
GET http://localhost:8080/todos

* Create a new Todo
POST: http://localhost:8080/todos/create
Body:

{
	"title": "Hello",
	"description": "world"
}

* Delete an individual todo
GET: http://localhost:8080/todos/delete/{id}

* Delete Multilple todos
POST: http://localhost:8080/todos/delete
Body: 
{
	"todoIds": [ 1,2 ]
}

* Update
Post: http://localhost:8080/todos/edit

body: 

{

	"id": 3,
	"title": "hello",
	"desc": "World"

}





