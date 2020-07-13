<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <nav>
      <div class="logo">
          <a href="#"><img src="images/logo.png" /></a>
        <h2>TODO</h2>
      </div>
      
    </nav>
    <section class="main-container">
       <div class="todobtn">
           <a href="#">Add-Todo</a>
           <a href="#">logout</a>
       </div>
       <div class="table-container">
        <table class="table"> 
            <thead><tr>
                <td>SUBJECT</td>
                <td>DESCRIPTION</td>
                <td>DATE</td>
                <td>EDIT</td>
                <td>DELETE</td>
                </tr>
            </thead>
            <tbody><tr>
                <td>LEARN JAVA</td>
                <td>LEARN JAVA</td>
                <td> DATE</td>
                <td><a href="#">EDIT</a></td>
                <td><a href="#">DELETE</a></td>
                </tr>
            </tbody>
        </table>
       </div>
    </section>
  </body>
</html>
