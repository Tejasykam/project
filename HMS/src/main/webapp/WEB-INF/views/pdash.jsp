<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="hms-login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdC:\Users\tejsaika\Desktop\Patient\hms-login.csselivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/20c5629a29.js" crossorigin="anonymous"></script>
  </head>
  <style>
  .icon{
  color:grey
  }
  button{
  border-width:0px
  }
  
  </style>
  <body><nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">
      <img src="https://res.cloudinary.com/dgk4dcbo6/image/upload/c_thumb,w_200,g_face/v1648912715/hospital-management-system_lczxqn.png"
            class="logo-hms"/>

    </a>
    <h3 style="color:red;margin-left:40px;">Patient DashBoard</h3>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav ml-auto">
      
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
       
        
      </ul>
      <form class="form-inline my-2 my-lg-0" action="doc-name-search" method="post">
        <input class="form-control mr-sm-2" type="text" name="search" placeholder="Search for doctors or sepcialities or qualification" aria-label="Search">
    <button type="submit" ><i class="fa fa-search icon" ></i></button>
      </form>
    </div>
  </nav>
  
  </body>
  </html>