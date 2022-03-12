<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
Page with sorted products!
<c:forEach var="product" items="${prodByCategory}">
    <var>
        <p>
            <a href="/products/${product.id}">${product.name}</a><br>
            <b>${product.price}</b><br><br>

        </p>
    </var>
</c:forEach>
</body>
</html>