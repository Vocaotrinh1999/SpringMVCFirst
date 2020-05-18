<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
Person<br>
Name : ${person.name }<br>
Address : ${person.address }<br>
Age : ${person.age }<br>
Email : ${person.email }<br>
Phone number : ${person.phoneNumber }
</body>
</html>