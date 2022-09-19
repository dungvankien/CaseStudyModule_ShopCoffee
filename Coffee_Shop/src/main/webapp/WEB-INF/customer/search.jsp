<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2022
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <a class="navbar-brand" href="javascript:void(0)">Logo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Link</a>
                        </li>
                    </ul>
                    <form class="d-flex" method="post" action="/customers?action=search">
                        <input class="form-control me-2" type="text" placeholder="Search by Name/Id" name="searchName">
                        <button class="btn btn-primary" type="submit" value="search">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <td colspan="12"><a href="/customers?action=create">
                    <button style="width:100%" type="button" class="btn btn-outline-success" title="Add New Customer" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content"><i class="fa-solid fa-plus"></i></button></a></td>
            </tr>
            <tr class="text-center">
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">PHONE</th>
                <th scope="col">ADDRESS</th>
                <th SCOPE="col">ACTION</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${customerList}">
                <tr class="text-center">
                    <th scope="row">${item.getIdCustomer()}</th>
                    <td >${item.getNameCustomer()}</td>
                    <td >${item.getEmail()}</td>
                    <td >${item.getPhone()}</td>
                    <td >${item.getAddress()}</td>
                    <td >
                        <a href="/customers?action=edit&id=${item.getIdCustomer()}" >
                            <button type="button" class="btn btn-outline-secondary" title="Edit" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content" ><i class="fa-solid fa-pen-to-square"></i></button></a>
                        <a href="/customers?action=delete&id=${item.getIdCustomer()}" >
                            <button type="button" class="btn btn-outline-danger" title="Delete" data-bs-toggle="popover" data-bs-trigger="hover" data-bs-placement="top" data-content="Content"><i class="fa-solid fa-trash-can"></i></button></a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-end">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
                </li>
            </ul>
        </nav>
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