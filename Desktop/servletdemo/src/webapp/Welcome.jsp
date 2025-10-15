<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            background-image: url("https://t4.ftcdn.net/jpg/02/83/46/33/360_F_283463385_mfnrx6RPU3BqObhVuVjYZjeZ5pegE7xq.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        .container {
            text-align: center;
            background-color: rgba(255,255,255,0.85);
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h1 { color: #00796b; margin-bottom: 10px; }
        h3 { color: #004d40; margin-bottom: 20px; }
        button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            background-color: #00796b;
            color: white;
            border-radius: 6px;
            cursor: pointer;
        }
        button:hover { background-color: #004d40; }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome!</h1>
    <h3>Nice to Meet You</h3>
    <!-- Button to go to login page -->
    <form action="Login.jsp" method="get">
        <button type="submit">Go to Login</button>
    </form>
</div>
</body>
</html>
