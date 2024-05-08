<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Printer Design </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css" />
    
</head>
<body>
     <div class="About_us">
        <div class ="Printer" style="margin-top: 30px;">
            <img src="https://nypost.com/wp-content/uploads/sites/2/2023/03/printerfeat.jpg?quality=75&strip=all&w=1200"style="width: 650px; height: 350px;">
       </div>
     </div> 

    <div class="Para_blog">
        <p>
            PixelPrinter is a leading provider of high-quality printing solutions, catering to the needs of individuals and businesses alike. 
            With years of experience in the industry, we have established ourselves as a reliable and trusted name in the printing market. 
            Our dedicated team of professionals is committed to delivering exceptional products and services to our valued customers.
            At PixelPrinter, we specialize in offering a wide range of printing solutions that meet the diverse requirements of our clients.
            Whether you need professional-grade printers for your office or personal printers for home use, we have got you covered. 
            We also provide a comprehensive selection of printing accessories, ink cartridges, and paper supplies to support your printing needs.
            We understand the importance of quality and reliability when it comes to printing. That's why we partner with renowned printer brands and ensure that our product 
            lineup consists of top-notch printers known for their performance and durability. We believe in delivering printing solutions that consistently produce outstanding results, 
            allowing you to unleash your creativity and achieve professional-grade prints.
        </p>
    </div>
    <br>
    <br>
    <div class="message-from-backend">
		<% if (session.getAttribute(Utilities.Successfully_Stored_Message) != null) { %>
		<div class="alert alert-success" role="alert">
			<%= session.getAttribute(Utilities.Successfully_Stored_Message) %>
		</div>
		<% } else if (request.getAttribute(Utilities.ERROR_MESSAGE) != null) {
                  if (request.getAttribute(Utilities.ERROR_MESSAGE).equals(Utilities.INCORRECT_FORM_DATA_MESSAGE)) { %>
		<div class="alert alert-danger" role="alert">
			<%= request.getAttribute(Utilities.ERROR_MESSAGE) %>
		</div>
		<%   } else if (request.getAttribute(Utilities.ERROR_MESSAGE).equals(Utilities.SERVER_ERROR_MESSAGE)) { %>
		<div class="alert alert-danger" role="alert">
			<%= request.getAttribute(Utilities.ERROR_MESSAGE) %>
		</div>
		<%   }
                  } %>
	</div>
    <div class="containerclass">
        <div class="content" >
            <div class="left">
                <!-- Address Details -->
                <div class="address details" >
                    <i class="fas fa-map-marker-alt"></i>
                    <div class="topic">Address</div>
                    <div class="text-one">Damak </div>
                    <div class="text-two">Jhapa</div>
                </div>
                <!-- Phone Details -->
                <div class="phone details">
                    <i class="fas fa-phone-alt"></i>
                    <div class="topic">Phone</div>
                    <div class="text-one">(977) 9842630796</div>
                </div>
                <!-- Email Details -->
                <div class="email details">
                    <i class="fas fa-envelope"></i>
                    <div class="topic">Email</div>
                    <div class="text-one">pixelPrinter686@gmail.com</div>
                </div>
            </div>
            <!-- Contact Form -->
            <div class="right" style="margin-top:80px;">
                <div class="topic-text">Send us a message</div>
                <p>If you have any queries regarding our products or overall system, you can contact us here.</p>
                <form action="${pageContext.request.contextPath}/StoreContactUsMessage" method="post" onsubmit="validateform()">
                    <div class="input-box">
                        <input name="name" type="text" id="name" placeholder="Enter your name" required>
                    </div>
                    <div class="input-box">
                        <input name="email" type="text" id="email" placeholder="Enter your email" required>
                    </div>
                    <div class="input-box">
						<input type="tel" id="phoneNumber" placeholder="Phone Number"
							name="phone_Num">
					</div>
                    <div class="input-box message-box">
                        <textarea name="message" id="message" placeholder="write us a message" rows="4" cols="50" required></textarea>
                    </div>
                    <div class="button">
                        <button type="submit">Send Now</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<!-- 
    <script>
        function validateform() {
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            alert("Your message has been sent");
            console.log("Name: " + name);
            console.log("Email: " + email);
        }
    </script>
     -->     
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
