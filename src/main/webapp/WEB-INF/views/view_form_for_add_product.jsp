<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add Product</title>
</head>
<body>
<c:form action="/save" modelAttribute="productForAdding" method="post">
    <form:hidden path="id"/>
    Name:<form:input type="text" path="name"/><br>
    Category:<form:input type="text" path="category"/><br>
    Brand:<form:input type="text" path="brand"/><br>
    <form:errors path="brand"/>
    Description:<form:input type="text" path="description"/><br>
    Price:<form:input type="text" path="price"/><br>
    <form:errors path="price"/>
    <input type = "submit" value = "Ok" />

</c:form>
</body>
</html>