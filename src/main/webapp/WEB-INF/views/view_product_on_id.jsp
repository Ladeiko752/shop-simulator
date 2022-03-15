<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <title>${prodFoundById.name}</title>
</head>
<body>
<c:form action="/buy/${prodFoundById.id}" method="post">
<h4>${prodFoundById.name}</h4>
<hr>
Category: ${prodFoundById.category}<br>
Brand: ${prodFoundById.brand}<br>
Description: ${prodFoundById.description}<br>
Price: ${prodFoundById.price}<br>
Number: <input name="number" type="number" min=1 max=20 />
    <input type="submit" value="Add to cart">
</c:form>

<security:authorize access="hasRole('ADMIN')">
<c:form action="/delete/${prodFoundById.id}" method="post">
    <input type="submit" value="Delete">
</c:form>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<c:form action="/update/${prodFoundById.id}" method="post">
    <input type="submit" value="Update">
</c:form>
</security:authorize>
</body>
</html>