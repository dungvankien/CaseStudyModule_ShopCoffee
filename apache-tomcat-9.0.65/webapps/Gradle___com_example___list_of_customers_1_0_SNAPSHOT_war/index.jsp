<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Of Customers</title>
</head>
<body>
    <h1>Danh Sách Khách Hàng</h1>
    <table>
        <thead>
            <tr>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Ảnh</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="item" >
                <tr>
                    <td>${item.fullName}</td>
                    <td>${item.birthDate}</td>
                    <td>${item.address}</td>
                    <td><img src="${item.image}" alt=""></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>