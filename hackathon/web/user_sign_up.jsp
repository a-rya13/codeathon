<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <style>
        /* Basic styling for the entire page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding-top: 20px;
            background-image: url("abc.jpeg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }

        /* Center the header and add spacing below */
        header h2 {
            color: #ffffff;
            font-size: 30px;
            text-align: center;
            margin-bottom: 20px;
            margin-top: 50px;
        }

        /* Styling for the form box */
        #loginForm {
            background-color: #ffffff;
            padding: 20px;
            width: 300px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 50px;
        }

        /* Styling for labels and input fields */
        label {
            display: block;
            font-weight: bold;
            color: #f8f8f8;
            text-align: left;
            margin-bottom: 5px;
        }

        select,
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Styling for the submit button */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
    <header>
        <h2>SignUp Page</h2><br><br>
    </header>
    <form id="signForm" method="post" action="user">
        <label for="CUST_id">Id:</label><br>
        <input type="text" id="CUST_id" name="cid" required><br><br>
        
        <label for="CUST_NAME">Name:</label><br>
        <input type="text" id="CUST_NAME" name="cname" required><br><br>

        <label for="EMAIL">Email:</label><br>
        <input type="text" id="EMAIL" name="email" required><br><br>

        <label for="CUST_NUM">Phone Number:</label><br>
        <input type="text" id="CUST_NUM" name="cnum" required><br><br>

        <label for="PASSWORD">Password:</label><br>
        <input type="password" id="PASSWORD" name="pass" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>