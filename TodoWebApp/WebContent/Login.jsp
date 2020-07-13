<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>login</title>

    <link rel="stylesheet" href="css/signup.css" />
  </head>
  <body>
    <header class="main-container">
      <div class="form-container">
        <form action="" method="POST">
          <div class="row">
            <label>Email</label><br />
            <input type="email" name="email" />
          </div>

          <div class="row">
            <label>Password</label><br />
            <input type="password" name="password" />
          </div>

          <div class="row btn">
            <input type="submit" value="Login" />
          </div>
        </form>
      </div>
    </header>
  </body>
</html>
