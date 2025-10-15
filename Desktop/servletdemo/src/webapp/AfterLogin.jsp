<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("https://cdn.pixabay.com/photo/2015/01/08/18/27/laptop-593673_1280.jpg"); /* laptop image */
            background-size: cover;       /* cover entire screen */
            background-position: center;  /* center the image */
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.85); /* semi-transparent overlay */
            padding: 40px 60px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.3);
        }
        h1 {
            color: #00796b;
            font-size: 48px;
            margin-bottom: 20px;
        }
        h3 {
            color: #004d40;
            font-size: 24px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome!</h1>
    <h3>To Front End</h3>
    <h3>Good to Go</h3>
     <form action="Welcome.jsp" method="get">
            <button type="submit">Go to Login</button>
        </form>
</div>
</body>
</html>
