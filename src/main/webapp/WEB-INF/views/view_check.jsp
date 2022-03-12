<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Check</title>
</head>
<body>
<hr>
    <table>
        <tr>
            <td style="padding-left: 0px; padding-right: 20px;">NUMBER</td>
            <td style="padding-left: 20px">PRODUCT</td>
            <td style="padding-left: 20px">PRICE</td>
            <td style="padding-left: 20px">TOTAL</td>
        </tr>
        <c:forEach var="cart" items="${cartItems.items}">
            <tr>
                <td style="padding-right: 20px;">${cart.number}</td>
                <td style="padding-left: 20px">${cart.product.name}</td>
                <td style="padding-left: 20px">${cart.product.price} BYN</td>
                <td style="padding-left: 20px">${cart.cartItemFinalPrice} BYN</td>
            </tr>
        </c:forEach>
    </table>
TOTAL PRICE: ${cartItems.price}
<hr>
<br>
<input type="button" value="Finish Shopping" onclick="window.location.href= '/end_shopping'"/>
</body>
</html>