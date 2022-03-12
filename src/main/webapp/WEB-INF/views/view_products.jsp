<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>This page with all products</h3>

<a href="/cart">Cart</a><br>
<a href="/login">Log In</a><br>
<a href="/logout">Log Out</a><br>
<ul>
    <li>
        <a href="/products/category/phone">Phones</a>
    </li>
    <li>
        <a href="/products/category/laptop">Laptops</a>
    </li>
    <li>
        <a href="/products/category/headphones">Headphones</a>
    </li>
</ul>

<c:forEach var="product" items="${products}">
    <var>
        <p>
            <a href="/products/${product.id}">${product.name}</a><br>
            <b>${product.price}</b><br><br>

        </p>
    </var>
</c:forEach>
<security:authorize access="hasRole('ADMIN')">
    <input type="submit" value="Add" onclick="window.location.href='/adding'"/>
</security:authorize>

</body>
</html>
