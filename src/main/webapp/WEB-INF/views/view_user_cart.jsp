<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Cart</title>
</head>
<body>
Cart:
<c:forEach var="cart" items="${cartItems.items}">
    <var>
        <p>
            ${cart.product.name} | ${cart.product.price} BYN | x${cart.number} <input type="button" value="Delete" onclick="window.location.href= '/cart/delete/${cart.id}'"/>
        </p>
    </var>
</c:forEach>
<form action="/discount" method="post">
<input name="promo" type="text"/>
<input type="submit" value="Activate" onclick="window.location.href='/discount'">
</form>
<var>
    <p>
        Total price: ${cartItems.price}
    </p>
</var>
<input type="button" value="Buy" onclick="window.location.href= '/check'"/>
</body>
</html>