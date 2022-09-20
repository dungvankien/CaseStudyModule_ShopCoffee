<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2022
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
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
                            <h3> <a class="nav-link" href="#">PRODUCT LIST</a></h3>
                        </li>
                    </ul>
                    <form class="d-flex" method="post" action="/products?action=search">
                        <input class="form-control me-2" type="text" placeholder="Search by name" name="searchName">
                        <button class="btn btn-primary" type="submit" value="search">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <td colspan="12"><a href="/products?action=create">
                    <button style="width:100%" type="button" class="btn btn-outline-success" title="Add New Customer" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content"><i class="fa-solid fa-plus"></i></button></a></td>
            </tr>
            <tr class="text-center">
                <th scope="col">ID PRODUCT</th>
                <th scope="col">NAME PRODUCT</th>
                <th scope="col">PRICE</th>
                <th scope="col">AMOUNT</th>
                <th scope="col">IMAGE</th>
                <th SCOPE="col">ACTION</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${productList}">
                <tr class="text-center">
                    <th scope="row">${item.getIdProduct()}</th>
                    <td >${item.getNameProduct()}</td>
                    <td>
                        <fmt:setLocale value = "vi_VN"/>
                        <fmt:formatNumber value = "${item.getPrice()}" type = "currency"/>
                    </td>
                    <td>
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.getAmount()}" />
                    </td>
                    <td ><img height="100px" width="150px" src="${item.getImage()}" alt=""></td>
                    <td >
                        <a href="/products?action=edit&id=${item.getIdProduct()}" >
                            <button type="button" class="btn btn-outline-secondary" title="Edit" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content" ><i class="fa-solid fa-pen-to-square"></i></button></a>
                        <a href="/products?action=delete&id=${item.getIdProduct()}" >
                            <button type="button" class="btn btn-outline-danger" title="Delete" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content"><i class="fa-solid fa-trash-can"></i></button></a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div style="position: fixed; bottom: 42px">
            <ul class="pagination">
                <li class="page-item"><a class="page-link">Page: </a></li>
                <c:forEach begin="1" end="${endPage}" var="index">
                    <li class="page-item"><a class="page-link" href="products?action=search&index=${index}&searchName=${search}">${index}</a></li>
                </c:forEach>
            </ul>
        </div>
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