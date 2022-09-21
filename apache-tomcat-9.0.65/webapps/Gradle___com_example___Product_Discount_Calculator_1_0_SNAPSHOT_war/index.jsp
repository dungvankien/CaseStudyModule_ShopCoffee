<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<br>
<form action="/displayDiscount" method="post">
    <label for="description">Product Description:</label><br>
    <textarea name="description" id="description" cols="30" rows="10"></textarea><br>
    <h3>List Price: </h3>
    <label for="price">List Price:</label><br>
    <input type="text" name="myPrice" id="price" placeholder="Enter Price"><br>
    <label for="discount">Discount Percent (%): </label><br>
    <input type="text" name="myDiscount" id="discount" placeholder="Enter discount"> <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>