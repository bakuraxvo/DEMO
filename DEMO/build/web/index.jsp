<!DOCTYPE html>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="style.css">
        <title>Học Bootstrap</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-4 row-container">
                    <form action="Controller" method="POST">

                        <h3 class="text-center">Login</h3>
                        <div class="form-group">
                            <label for="username" class="control-label">Username:</label>
                            <input type="text" id="username" name="username" class="form-control " value="" tabindex="1" required>
         
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label">Password:</label>
                            <input type="password" id="password" name="password" class="form-control" value="" tabindex="2" required>

                        </div>
                        <div class="form-group form-check">
                            <input  type="checkbox" id="checkbox" class="form-check-input" name="remember" value="1">
                                <label class="form-check-label" for="checkbox">Remember Me</label>
                        </div>
                        <button type="submit" name="btAction" value="Login" class="btn btn-success" tabindex="3">Login</button>
                        <button type="reset" class="btn btn-secondary">Reset</button>
                        <div class="form-group mt-3">
                            <p>Quên mật khẩu? <a href="#">click here</a></p>
                            <p>Đăng Ký? <a href="#">Tạo tài khoản</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>