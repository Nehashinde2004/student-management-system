<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            font-family: sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .profile-container {
            background-color: #fff;
            padding: 30px; 
            border-radius: 10px; 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
            width: 450px; 
        }

        .profile-icon {
            font-size: 5em; 
            color: #3498db; 
            margin-bottom: 20px;
            text-align: center;
        }

        h1 {
            text-align: center;
            color: #2c3e50; 
            margin-bottom: 25px; 
        }

        h3 {
            color: #7f8c8d; 
            margin-bottom: 15px;
        }

        p {
            margin-bottom: 20px; 
        }

        .info {
            font-weight: 600;
            color: #2c3e50;
        }

        
        h3 {
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
        }

        
        p:last-of-type {
            margin-bottom: 0; 
        }

        
        @media (max-width: 500px) {
            .profile-container {
                width: 90%; /
                padding: 20px;
            }
            .profile-icon {
                font-size: 4em; 
            }
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <div class="profile-icon">
            <i class="fas fa-user-circle"></i>
        </div>
        <h1>Student Profile</h1>

        <h3>Name:</h3>
        <p class="info">${name}</p>

        <h3>Email:</h3>
        <p class="info">${email}</p>

        <h3>City:</h3>
        <p class="info">${city}</p>

        
    </div>
</body>
</html>