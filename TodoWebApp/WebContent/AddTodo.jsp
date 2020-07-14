<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AddTodo</title>
    <link rel="stylesheet" href="css/todo.css" />
  </head>

  <body>
    <header class="main-container">
      <div class="form-container">
        <h1>Add Todo</h1>
        <form class="main-form" method="post" action="addtodo">
          <input type="text" placeholder="subject" name="subject" required="required"/>
          <input type="text" placeholder="description" name="description"  required="required"/>
          <input type="Date" placeholder="YYYY-MM-DD" name="date"  required="required"/>
          <input type="submit" value="Add" />
        </form>
      </div>
    </header>
  </body>
</html>
