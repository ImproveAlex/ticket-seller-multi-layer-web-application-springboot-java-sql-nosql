<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>
<link rel="stylesheet" href="resources/styles/login.css"> <!--resources/styles/login.css-->
</head>
<body>
	<div class="signin">
		<div class="back-img">
			<div class="sign-in-text">
				<h2 class="active">Log In</h2>
			</div>
			<!--/.sign-in-text-->
			<div class="layer"></div>
			<!--/.layer-->
			<p class="point">&#9650;</p>
		</div>
		<!--/.back-img-->
		<div class="form-section">

			<form action="LoginUser.html" method="post">
				<!--Username-->
				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<input class="mdl-textfield__input" type="text" id="sample3" name="username" value="">
					<label class="mdl-textfield__label" for="sample3">Username</label>
				</div>
				<br /> <br />
				<!--Password-->
				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<input class="mdl-textfield__input" type="password" id="sample3" name="password" value=""> 
					<label class="mdl-textfield__label" for="sample3">Password</label> 
				</div>
				<br />
				<!--Button-->
				<input type="submit" class="submitBtn" value="Log in">
			</form>
			<!--/Guest-->
  			<a href="Guest.html" class="extraBtn"><b>Continue as guest</b></a>
			<!--/Create account-->
  			<a href="SignUpUser.html" class="extraBtn"><b>Create an account</b></a>
		</div>
		<!--/.form-section-->
	</div>
</body>
</html>

