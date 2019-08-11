<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Aldana Louzan</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
    rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/one-page-wonder.min.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
    <div class="container">
      <a class="navbar-brand" href="home.jsp">Book a class</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="home.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="teacherAccount.jsp">MyAccount</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./index.jsp">Log Out</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <header class="masthead text-center text-white">
    <div class="masthead-content">
      <div class="container">
        <h1 class="masthead-heading mb-0">Emily´s classes</h1>
      </div>
    </div>
    <div class="bg-circle-1 bg-circle"></div>
    <div class="bg-circle-2 bg-circle"></div>
    <div class="bg-circle-3 bg-circle"></div>
    <div class="bg-circle-4 bg-circle"></div>
  </header>

  <section>

    <div class="controls">
        <label for="date" class="label-date"><i class="fa fa-calendar"></i>Select a date</label>
        <input type="date" id="date" class="floatLabel" name="date">
    </div> 
      <%
            
            ResultSet rs = (ResultSet)session.getAttribute("bookingsResultSet");
            
            
        %>

     <table class="table table-bordered table-hover">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Date</th>
            <th scope="col">Time</th>
            <th scope="col">Class Type</th>
            <th scope="col">Quantity of Students</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Subject</th>
            <th scope="col">Price</th>
        </tr>
        <% 
            while(rs.next()){ 
        %>
           <td><%=rs.getInt("idbooking") %></td>
           <td><%=rs.getString("date") %></td>
           <td><%=rs.getInt("time") %></td>
           <td><%=rs.getString("type") %></td>
           <td><%=rs.getInt("quantity_students") %></td>
           <td><%=rs.getString("s_name") %></td>
           <td><%=rs.getString("s_surname") %></td>
           <td><%=rs.getString("subject") %></td>
           <td><%=rs.getInt("price") %></td>
        <% } %>
    </table>
  </section>


  <!-- Footer -->
  <footer class="py-5 bg-black">
    <div class="container">
      <p class="m-0 text-center text-white small">Copyright &copy; Book a Class 2019 all rights reserved</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>