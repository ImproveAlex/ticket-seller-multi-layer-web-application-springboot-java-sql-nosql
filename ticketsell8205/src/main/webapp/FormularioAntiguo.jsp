<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>SignUp Form</title>
  <link rel="stylesheet" href="resources/styles/formulario.css">
</head>
<body>
  <div class="signupFrm">
    <div class="wrapper">
    <form action="SignUpUser.html" class="form" method="post">
      <h1 class="title">Sign up</h1>

      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="name">
        <label for="" class="label">Name</label>
      </div>

      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="first_surname">
        <label for="" class="label">Surname 1</label>
      </div>
      
      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="second_surname">
        <label for="" class="label">Surname 2</label>
      </div>

      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="phone">
        <label for="" class="label">Phone Number</label>
      </div>
     
      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="address">
        <label for="" class="label">Address</label>
      </div>

      <div class="inputContainer">
        <input type="text" class="input" placeholder="a" name="username">
        <label for="" class="label">Username</label>
      </div>
      
      <div class="inputContainer">
        <input type="password" class="input" placeholder="a" name="password">
        <label for="" class="label">Password</label>
      </div>

      <div class="inputContainer">
        <input type="password" class="input" placeholder="a">
        <label for="" class="label">Confirm Password</label>
      </div>

      <input type="submit" class="submitBtn" value="Sign up">
    </form>
    </div>
  </div>
</body>
</html>
