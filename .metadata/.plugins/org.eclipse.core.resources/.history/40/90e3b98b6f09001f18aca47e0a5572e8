<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utilities.Utilities" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="icon" href="${pageContext.request.contextPath}/Images/pixelprinter-high-resolution-logo.png" type="image/png">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css">
  <title>Login</title>
</head>

<body style="background-image: url('${pageContext.request.contextPath}/Images/LoginImage.png');">
  <header class="showcase">
    <div class="showcase-content">
      <div class="showcase-top">
        <h1>LOGIN</h1>
      </div>
      <div class="formm">
      	<% if (request.getAttribute(Utilities.ERROR_MESSAGE) != null) { %>
    	<p class="errorMessage"><%= request.getAttribute(Utilities.ERROR_MESSAGE) %></p>
		<% } %>
        <form method="post" action="${pageContext.request.contextPath}/UserLogin">
          <h2>Welcome user!
          </h2>
          <div class="info">
            <input class="username" type="text" placeholder="Username" id="username" name="user_name"> <br>
            <input class="email" type="password" placeholder="Password" id="password" name="password">
          </div>
          <div class="btn">
            <button class="btn-primary" type="submit" onclick="signIn()">Sign In</button>
          </div>
          <div class="help">
            <div>
              <input value="true" type="checkbox"><label>Remember me</label>
            </div>
          </div>
          <div class="signup">
            <p>New to User ?</p>
            <a href="../pages/Register.jsp">Sign up now</a>
          </div>
        </form>
      </div>
    </div>
  </header>
  <script src="${pageContext.request.contextPath}/js/Login.js"></script>
</body>
</html>