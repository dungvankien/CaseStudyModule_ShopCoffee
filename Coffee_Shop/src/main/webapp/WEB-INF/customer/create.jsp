<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2022
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Customer</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/all.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"><i  class="fa-solid fa-house"></i></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <h3> <a class="nav-link" href="#">CREATE CUSTOMER </a></h3>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <form method="post">
            <div class="mb-3">
                <label for="Name" class="form-label">Name Customer:</label>
                <input type="text" class="form-control" name="name" id="Name" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email: </label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required>
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="Phone" class="form-label">Phone:</label>
                <input type="tel" class="form-control" id="Phone" name="phone" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Address:</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="address" required>
            </div>
            <button type="submit" class="btn btn-primary" value="create customers">Submit</button>
            <button class="btn btn-primary"><a href="/customers" style="color: white"> Comeback Customer List</a></button>
        </form>
    </div>
    <div class="container" style="position: fixed; bottom: 0; margin: 0; padding: 0" >
        <div>
            <nav class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end footer" style="right: 10px">
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#"><i class="fa-regular fa-address-card"></i> Contact Info</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Address: </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Email: </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script src="/assets/js/bootstrap.bundle.js"></script>
<script>
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
        return new bootstrap.Popover(popoverTriggerEl)
    })
</script>
</body>
</html>
