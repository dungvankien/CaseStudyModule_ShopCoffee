<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
    <style>
        input {
            margin: 10px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="<c:url value="/CalculatorServlet"/>" method="post">
    <label for="firstNumber">First Operand: </label>
    <input type="text" id="firstNumber" name="firstOperand" placeholder="Number"> <br>
    <label for="operator">Operator: </label>
    <select name="operator" id="operator">
        <option value="+">Add</option>
        <option value="-">Sub</option>
        <option value="*">Mul</option>
        <option value="/">Div</option>
    </select> <br>
    <label for="secondOperand">Second Operand</label>
    <input type="text" id="secondOperand" name="secondOperand" placeholder="Number"> <br>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>