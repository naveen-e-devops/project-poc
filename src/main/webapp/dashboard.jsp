<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Dashboard</title></head>
<body>
  <h2>Welcome, <%= request.getAttribute("user") %>!</h2>
  <p>You have successfully logged in.</p>
</body>
</html>

