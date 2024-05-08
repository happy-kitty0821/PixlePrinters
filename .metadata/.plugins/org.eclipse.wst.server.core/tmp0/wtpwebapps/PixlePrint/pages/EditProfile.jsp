<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	<title>Edit Profile | <%= request.getSession().getAttribute("username") %></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ProfileEdit.css">
</head>
<body>
    <center>
        <div class = "box">
        <form action="" method="post">
            <img src="https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExdXJ5ZTI3ZDlqczZ6YW11MzdldmN5ZG56dDRmdjd0cmh5ejAxeG9lZCZlcD12MV9naWZzX3NlYXJjaCZjdD1n/AYy9YYXHmsGek/giphy.webp">
            <input type ="file" anme="" id="file" accept="image/*">
            <label for ="file" > Edit Profile</label>
            <input type="text" name ="" placeholder = "User Name">
            <input type="email" name ="" placeholder = "Email ID">
            <input type="text" name ="" placeholder = "Phone Number">
            <input type="text" name ="" placeholder = "Date of Birth">
            <input type="text" name ="" placeholder = "Gender">
            <button style="float: left;margin:10px 0 0 18.2%;">CANCEL</button>
            <button style="float: right;margin:10px 18.2% 0 0;">DONE</button>
		</form>
        </div>
    </center>
</body>
</html>
