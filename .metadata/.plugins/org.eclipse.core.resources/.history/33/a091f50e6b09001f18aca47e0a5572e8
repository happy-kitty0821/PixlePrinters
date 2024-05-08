package utilities;
/**
	 * @author aayush wanem limbu
	 */
	
	public class Utilities {
		
		//loginquery for normal user
		public static final String Get_Login_User_Information = "SELECT * FROM User WHERE USERNAME = ?;";
		
		//query for user registration
		public static final String Customer_Registration = "INSERT INTO User (fullName, email, userName, phoneNumber, password, profilePicture) "
		        + "VALUES (?,?,?,?,?,?)";
		//query for admin registration 
		public static final String Add_Admin = "INSERT INTO User (fullName, email, userName, accountType, phoneNumber, password, profilePicture)"
		           + " VALUES (?,?,?,?,?,?,?)";
		//query for storing the contact us message to the database
		public static final String Store_Contact_Us_Page_Message = "INSERT INTO ContactUsFormMessage (Name, ContactNumber, Email, Message)"
				+ "VALUES (?, ?, ?, ?)";
		//query to read the stored message from the database
		public static final String READ_CONTACT_US_MESSAGE = "SELECT * FROM ContactUsFormMessage";
		//query to add brand to the database
		public static final String Add_Brands = "INSERT INTO Brand (CompanyName) VALUES(?) ";
		//query to get all the brands from the database;
		public static final String Show_Brands = "select * from Brand";
		//query to insert products into the product table
		public static final String Add_Products = "INSERT INTO Product(productName, productDesc, price, quantity, companyName, productImage, "
				+ "printTechnology, printSpeed, printResulotion, weight, dimensions, operatingSystem, supportedPageSize, color, printColor)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//quert to see all of the products
		public static final String  GET_ALL_PRODUCTS = "SELECT * FROM Product";
		//query to get the number of messages
		public static final String GET_MESSAGE_COUNT = "SELECT COUNT(*) FROM ContactUsFormMessage";
		//qery to get the Customer count
		public static final String GET_CUSTOMER_COUNT = "select count(*) from User where accountType = 'User'";
		//query to get the number of product in the database
		public static final String GET_PRODUCT_COUNT = "select count(*) from Product;";
		//query to get the brand count
		public static final String GET_BRAND_COUNT = "select count(*) from Brand";
		//query to get the info of users
		public static final String GET_CUSTOMER_DETATILS = "select * from User where accountType = 'User'";
		//query to get the purchase history of a customer
		public static final String GET_PURCHASE_HISTORY_OF_USER = "SELECT "
		        + "p.purchaseId, "
		        + "p.DateTime, "
		        + "p.quantity, "
		        + "p.totalAmount, "
		        + "pr.productName, "
		        + "pr.price, "
		        + "pr.productImage "
		        + "FROM Purchase p JOIN "
		        + "Product pr ON p.productId = pr.productId "
		        + "WHERE "
		        + "p.userId = ?;";

		
		
		//defining a set of constant values
		public static final String name = "name";
		public static final String user_name = "user_name";
		public static final String full_name = "full_name";
		public static final String email = "email";
		public static final String password = "password";
		public static final String phone_number = "phone_Num";
		public static final String message = "message";
		public static final String account_type = "account_type";
		public static final String company_name = "company_name";
		public static final String product_name = "productName";
		public static final String product_descrption = "productDescription";
		public static final String product_price = "productPrice";
		public static final String product_quantity = "productQuantity";
		public static final String brand_name = "brandName";
		public static final String product_image = "productImage";
		public static final String print_technology = "printTechnology";
		public static final String print_speed = "printSpeed";
		public static final String print_resolution = "printResolution";
		public static final String printer_weight = "printerWeight";
		public static final String printer_dimensions = "printerDimensions";
		public static final String operating_system = "operatingSystem";
		public static final String supported_page_size = "supportedPageSize";
		public static final String printer_color = "printerColor";
		public static final String print_color = "printColor";
		//end constants
		
		//start of the page names
		public static final String Home_Page_Title = "Pixle Print";
		public static final String Login_Page_Title = "Login Page";
		public static final String Registration_Page_Title = "Welcome User";
		//end of page names
		
		//profile picture store path
		public static final String Profile_Picture_Store_Dir = "/home/happy-kitty/eclipse-workspace/PixlePrinter/src/main/webapp/Uploads/ProfilePicture/";
		//product image store path
		public static final String Product_Picture_Store_Dir = "/home/happy-kitty/eclipse-workspace/PixlePrinter/src/main/webapp/Uploads/ProductImages/";
		
		
		//Start of constant string messages
		public static final String SUCCESSFULLY_REGISTERED_MESSAGE = "The User Was Successfully Registered!";
		public static final String INCORRECT_FORM_DATA_MESSAGE = "Please Check and Enter The Correct Form Data.";
		public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
		public static final String SUCCESS_MESSAGE = "successMessage";
		public static final String ERROR_MESSAGE = "errorMessage";
		public static final String INCORRECT_LOGIN_CREDENTIAL_ERROR = "Username or Password Incorrect";
		public static final String Successfully_Stored_Message = "Dear user your message has been successfully stored, please wait for an response";
		public static final String SUCCESSFULLY_ADD_BRAND_MESSAGE = "Brand Added Successfully";
		public static final String PRODUCT_SUCCESSFULLU_ADD_MESSAGE = "The product was added successfully";
		public static final String PRODUCT_ALREADY_EXISTS_MESSAGE = "This product already exists";
		public static final String USERANME_ALREADY_EXISTS_MESSAGE = "The user already exists";
		// End string messages 
		
		// Start JSP Route
		public static final String LOGIN_PAGE = "/pages/Login.jsp";
		public static final String REGISTER_PAGE = "/pages/Register.jsp";
		public static final String ADMIN_REGISTRATION_PAGE = "/pages/AddAdmin.jsp";
		public static final String HOME_PAGE = "/pages/Index.jsp";
		public static final String ADMIN_HOME_PAGE = "/pages/Admin.jsp";
		public static final String CONTACT_US_PAGE = "/pages/Contact.jsp";
		public static final String ADD_BRAND = "/pages/AddBrand.jsp";
		public static final String ADD_PRODUCT_PAGE = "/pages/AddProducts.jsp";
		// End JSP Route
		
		// Start Servlet Route
		public static final String REGISTER_SERVLET = "/RegisterServlet";
		public static final String LOGIN_SERVLET = "/UserLogin";
		public static final String ADMIN_HOME_SERVLET = "/AdminHomeServlet";
		// End Servlet Route
	}
