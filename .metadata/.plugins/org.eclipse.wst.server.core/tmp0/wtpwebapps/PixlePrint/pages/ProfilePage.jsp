<%@ page import="utils.Utilities"%>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name = "viewport" content="width=device-width, initial-scale= 1.0">
        <title>Drop-down profile</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ProfilePage.css">
    </head>
<body>  
    <div style="width:450px; height:570px; overflow: hidden; margin-top: 10px; margin-left: 1000px; margin-right: 20px;border: 2px solid #ccc; border-radius: 20px; padding: 50px;">
        <div style="width: 400px; height: 579px; position: relative; background: white; border-radius: 40px;">
            <div style="left: 39px; top: 30px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 400; word-wrap: break-word">Currently in</div>
            <div style="width: 320px; height: 100px; left: 35px; top: 61px; position: absolute; background: #D9D9D9; border-radius: 20px"></div>
            <div style="left: 42px; top: 189px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 400; word-wrap: break-word">Your accounts</div>
            <div style="left: 42px; top: 220px; position: absolute; color: black; font-size: 16px; font-family: Inter; font-weight: 700; word-wrap: break-word">Add account</div>
            <div style="left: 42px; top: 260px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 400; word-wrap: break-word">More options</div>
            <div style="left: 42px; top: 293px; position: absolute; color: black; font-size: 17px; font-family: Inter; font-weight: 700; word-wrap: break-word">Settings</div>
            <div style="left: 42px; top: 330px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 700; word-wrap: break-word">Account detail</div>
            <div style="left: 42px; top: 363px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 700; word-wrap: break-word">Get Help</div>
            <div style="left: 42px; top: 396px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 700; word-wrap: break-word">See privacy policy</div>
            <div style="left: 42px; top: 429px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 700; word-wrap: break-word">Feedback</div>
            <a style="left: 42px; top: 462px; position: absolute; color: black; font-size: 14px; font-family: Inter; font-weight: 700; word-wrap: break-word" href="${pageContext.request.contextPath}/LogoutServlet">
            Logout</a>
            </div>
            <div style="width: 71px; height: 71px; left: 50px; top: 79px; position: absolute; background: white; border-radius: 9999px"></div>
            <div style="left: 141px; top: 97px; position: absolute; color: #8B8888; font-size: 20px; font-family: Inter; font-weight: 400; line-height: 35px; word-wrap: break-word">User name email</div>
        </div>
    </div>
    <div class= "Profile">
    <%
    Cookie[] cookies = request.getCookies();
    String username = null;
    if(cookies != null) {
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("username")) {
                username = cookie.getValue();
                break;
            }
        }
    }
%>
        <h1><%=username %></h1>
        <h2>User name email</h2>
        <h3>Following<h3>
    </div>
    <div >
       
        <form action="${pageContext.request.contextPath}/PurchaseHistroyOfUserServlet" method="get">
    <button type="submit" style="left: 200px; top: 531px; position: absolute; font-size:20px; background-color: grey; color: white;border-radius:25px; width:200px; height: 40px;">Purchase History</button>
</form>

<form action="ServletName" method="post">
    <input type="hidden" name="action" value="delete">
    <button type="submit" style="left: 450px; top: 531px; position: absolute; font-size:20px; background-color: grey; color: white;border-radius:25px; width:150px; height: 40px;">Delete</button>
</form>

        <div style="left: 370px; top: 616px; position: absolute; color: black; font-size: 30px; font-family: Inter; font-weight: 600; line-height: 35px; word-wrap: break-word">Saved</div>
        <img style="width: 137px; height: 136px; left: 340px; top: 207px; position: absolute" src="Images\Girl.jpg" />
      </div> 
      
</body>
</html>