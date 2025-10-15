<% if(request.getAttribute("errorMessage") != null) { %>
    <div style="color:red; text-align:top; margin-bottom:20px;">
        <%= request.getAttribute("errorMessage") %>
    </div>
<% } %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            background-image: url("https://t4.ftcdn.net/jpg/02/83/46/33/360_F_283463385_mfnrx6RPU3BqObhVuVjYZjeZ5pegE7xq.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            width: 300px;
        }
        h2 { text-align: center; margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="password"] {
            width: 100%; padding: 8px 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%; padding: 10px; background-color: #4CAF50; border: none; color: white; font-size: 16px; border-radius: 5px; cursor: pointer;
        }
        input[type="submit"]:hover { background-color: #45a049; }
    </style>
</head>
<body>
<form action="login" method="post">
    <h2>Login Form</h2>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" value="Login">
</form>
</body>
</html>
