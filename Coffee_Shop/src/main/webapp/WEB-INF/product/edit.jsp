<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2022
  Time: 2:29 PM
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
    <title>Edit Customer</title>
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
                            <h3> <a class="nav-link" href="#">EDIT PRODUCT </a></h3>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <c:if test="${message != null}">
            <div class="alert alert-primary" role="alert">${message}</div>
        </c:if>

        <c:if test="${err != null}">
            <c:forEach var="item" items="${err}">
                <div class="alert alert-danger" role="alert">${item}</div>
            </c:forEach>
        </c:if>

        <form method="post" enctype="multipart/form-data">
            <div class="mb-3" >
                <label for="ID" class="form-label">ID Product:</label>
                <p>
                    <input  value="${requestScope["product"].getIdProduct()}" type="text" class="form-control" name="id" id="ID" required >
                </p>
            </div>
            <div class="mb-3">
                <label for="Name" class="form-label">Name Product:</label>
                <p>
                    <input value="${requestScope["product"].getNameProduct()}" type="text" class="form-control" name="name" id="Name" required >
                </p>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Price :</label>
                <p>
                    <input value="${requestScope["product"].getPrice()}" type="number" class="form-control" id="exampleInputEmail1"  name="price" required >

                </p>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Amount:</label>
                <p>
                    <input value="${requestScope["product"].getAmount()}" type="number" class="form-control" id="phone" name="amount" required >

                </p>
            </div>
            <div class="input-group mb-3">
                <label class="input-group-text" for="inputGroupFile01">Upload Image</label>
                <input value="${requestScope["product"].getImage()}" type="file" class="form-control" id="inputGroupFile01" name="image1" >
            </div>
            <div class="input-group mb-3" hidden>
                <label class="input-group-text" for="inputGroupFile02">Upload Image</label>
                <input value="${requestScope["product"].getImage()}" type="text" class="form-control" id="inputGroupFile02" name="image2" >
            </div>

            <button type="submit" class="btn btn-primary" value="edit products">Edit</button>
            <button class="btn btn-primary"><a href="/products" style="color: white"> Comeback Customer List</a></button>
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
                    <li class="nav-item">
                        <a class="nav-link" href="/logins"><i class="fa-solid fa-right-from-bracket"></i> Sign Out </a>
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
