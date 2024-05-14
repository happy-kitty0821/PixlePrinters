//this will be used to connect to the mysql database
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.mindrot.bcrypt.BCrypt;

import models.AdminModel;
import models.AllPurchasesModel;
import models.BrandModel;
import models.CartModel;
import models.ContactUsMessageModel;
import models.ProductModel;
import models.PurchaseHistroyModel;
import models.PurchaseModel;
import models.UserCartModel;
import models.UserModel;
import utils.Utilities;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/PixlePrint";// ailey lai temporary db name
		String user = "root";
		String pass = "12345"; // change it to the one u are using in ur xampp
		return DriverManager.getConnection(url, user, pass);
	}

	// login method start from here
	public int getUserLoginInformation(String username, String password) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(Utilities.Get_Login_User_Information);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				String hashedPasswordFromDb = result.getString("password");
				System.out.println("Hashed Password" + hashedPasswordFromDb);
				if (BCrypt.checkpw(password, hashedPasswordFromDb)) {
					String userAccountType = result.getString("accountType");
					if ("User".equals(userAccountType)) {
						return 1;
					} else if ("Admin".equals(userAccountType)) {
						return 5;
					}
				}
			}
			return 0; // Username or password is incorrect
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1; // Server error or exception
		}
	}// end of login method

	public int addNewCustomer(UserModel userModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(Utilities.Customer_Registration);
			
			 PreparedStatement checkUsernameSt = con.prepareStatement(Utilities.GET_USERNAME);
	            checkUsernameSt.setString(1, userModel.getUserName());
	            ResultSet checkUsernameRs = checkUsernameSt.executeQuery();
	            checkUsernameRs.next();
	            if (checkUsernameRs.getInt(1) > 0) {
	                return -2; //username already exists
	            }
	            PreparedStatement checkPhoneSt = con.prepareStatement(Utilities.GET_PHONE);
	            checkPhoneSt.setString(1, userModel.getPhoneNumber());
	            ResultSet checkPhoneRs = checkPhoneSt.executeQuery();

	            checkPhoneRs.next();

	            if (checkPhoneRs.getInt(1) > 0) {
	                return -4; //phonenumber already exists
	            }

	            PreparedStatement checkEmailSt = con.prepareStatement(Utilities.GET_EMAIL);
	            checkEmailSt.setString(1, userModel.getEmail());
	            ResultSet checkEmailRs = checkEmailSt.executeQuery();

	            checkEmailRs.next();

	            if (checkEmailRs.getInt(1) > 0) {
	                return -3; //email already exists
	            }
			//if the username, emnail and phone number are unique then continue the registration
			statement.setString(1, userModel.getFullName());
			statement.setString(2, userModel.getEmail());
			statement.setString(3, userModel.getUserName());
			statement.setString(4, userModel.getPhoneNumber());
			String hashedPassword = BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt());
			statement.setString(5, hashedPassword);
			statement.setString(6, userModel.getProfilePicture());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int storeContactUsMessages(ContactUsMessageModel contactUsMessageModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(Utilities.Store_Contact_Us_Page_Message);
			statement.setString(1, contactUsMessageModel.getName());
			statement.setString(2, contactUsMessageModel.getContactNumber());
			statement.setString(3, contactUsMessageModel.getEmail());
			statement.setString(4, contactUsMessageModel.getMessage());

			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int registerNewAdmin(AdminModel adminModel) {
		try (Connection conn = getConnection()) {
			PreparedStatement statement = conn.prepareStatement(Utilities.Add_Admin);
			statement.setString(1, adminModel.getFullName());
			statement.setString(2, adminModel.getEmail());
			statement.setString(3, adminModel.getUserName());
			statement.setString(4, adminModel.getAccountType());
			statement.setString(5, adminModel.getPhoneNumber());
			String hashedPassword = BCrypt.hashpw(adminModel.getPassword(), BCrypt.gensalt());
			statement.setString(6, hashedPassword);
			statement.setString(7, adminModel.getProfilePicture());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int addNewBrands(BrandModel brandModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(Utilities.Add_Brands);
			statement.setString(1, brandModel.getCompanyName());
			statement.setString(2,brandModel.getCountry() );
			statement.setString(3, brandModel.getContactInformation());
			statement.setString(4, brandModel.getWebsite());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public List<UserModel> getLoggedInUserDetails(String username) {
		List<UserModel> userDetails = new ArrayList<>();
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(Utilities.Get_Login_User_Information);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int userId = resultSet.getInt("userId");
				String fullName = resultSet.getString("fullName");
				String email = resultSet.getString("email");
				String userName = resultSet.getString("userName");
				String accountType = resultSet.getString("accountType");
				String password = resultSet.getString("password");
				String phoneNumber = resultSet.getString("phoneNumber");
				String profilePicture = resultSet.getString("profilePicture");
				UserModel userModel = new UserModel(userId, fullName, email, userName, accountType, password, phoneNumber, profilePicture);
				userDetails.add(userModel);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return userDetails;
	}

	public List<BrandModel> getBrandsFromDatabase() {
		List<BrandModel> brands = new ArrayList<>();
		try (Connection con = getConnection()) {
			PreparedStatement statements = con.prepareStatement(Utilities.Show_Brands);
			ResultSet resultSet = statements.executeQuery();
			while (resultSet.next()) {
				String companyName = resultSet.getString("CompanyName");
				String country = resultSet.getString("country");
				String contactInformation = resultSet.getString("contactInformation");
				String website = resultSet.getString("website");
				BrandModel brand = new BrandModel(companyName, country, contactInformation, website);
				brands.add(brand);
			}
			// Print each brand's name and id
			for (BrandModel brand : brands) {
				System.out.println("Brand Name: " + brand.getCompanyName());
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		}
		return brands;
	}

	public int addProducts(ProductModel productModel) {
		try (Connection conn = getConnection()) {
			PreparedStatement statement = conn.prepareStatement(Utilities.Add_Products);
			statement.setString(1, productModel.getProductName());
			statement.setString(2, productModel.getProductDescription());
			statement.setDouble(3, productModel.getPrice());
			statement.setInt(4, productModel.getQuantity());
			statement.setString(5, productModel.getCompanyName());
			statement.setString(6, productModel.getProductImage());
			statement.setString(7, productModel.getPrintTechnology());
			statement.setString(8, productModel.getPrintSpeed());
			statement.setString(9, productModel.getPrintResolution());
			statement.setString(10, productModel.getWeight());
			statement.setString(11, productModel.getDimensions());
			statement.setString(12, productModel.getOperatingSystem());
			statement.setString(13, productModel.getSupportedPageSize());
			statement.setString(14, productModel.getPrintColor());
			statement.setString(15, productModel.getColor());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public List<ProductModel> getProductsFromDatabase() {
		List<ProductModel> products = new ArrayList<>();
		try (Connection conn = getConnection()) {
			PreparedStatement statement = conn.prepareStatement(Utilities.GET_ALL_PRODUCTS);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("productId");
				String productName = resultSet.getString("productName");
				String productDesc = resultSet.getString("productDesc");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				String companyName = resultSet.getString("companyName");
				String productImage = resultSet.getString("productImage");
				String printTechnology = resultSet.getString("printTechnology");
				String printSpeed = resultSet.getString("printSpeed");
				String printResolution = resultSet.getString("printResulotion");
				String weight = resultSet.getString("weight");
				String dimensions = resultSet.getString("dimensions");
				String operatingSystem = resultSet.getString("operatingSystem");
				String supportedPageSize = resultSet.getString("supportedPageSize");
				String color = resultSet.getNString("color");
				String printColor = resultSet.getString("printColor");
				ProductModel product = new ProductModel(productId, productName, productDesc, price, quantity, companyName,
						productImage, printTechnology, printSpeed, printResolution, weight, dimensions, operatingSystem,
						supportedPageSize, color, printColor);
				products.add(product);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return products;
	}

	public int getCustomerCount() {
	    int result = 0;
	    try (Connection con = getConnection()) {
	        PreparedStatement statement = con.prepareStatement(Utilities.GET_CUSTOMER_COUNT);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	            result = rs.getInt(1);//yo line ley query execute vayepaxi ako result ko first row ko  integer data return garxa
	            System.out.println("Customer count is : " + result);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        // TODO: Handle the exception appropriately
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public int getProducCount() {
		int result = 0;
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.GET_PRODUCT_COUNT);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				 System.out.println("Product count is : " + result);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getMessageCount() {
		int result = 0;
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.GET_MESSAGE_COUNT);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				 System.out.println("Message count is : " + result);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getBrandCount() {
		int result = 0;
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.GET_BRAND_COUNT);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				 System.out.println("Brand count is : " + result);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<UserModel> getCustomerDetails(){
		List<UserModel> userDetails = new ArrayList<>();
		try(Connection conn = getConnection()){
			PreparedStatement statement = conn.prepareStatement(Utilities.GET_CUSTOMER_DETATILS);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String userName  = resultSet.getString("userName");
				String fullName = resultSet.getString("fullName");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phoneNumber");
				String profilePicture = resultSet.getString("profilePicture");
				UserModel userModel = new UserModel(fullName, email, userName, phoneNumber, profilePicture);
				userDetails.add(userModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails;
	}
	public int getUserId(String userName) {
	    int user_id = -1; //default value if no user is found
	    try (Connection con = getConnection()) {
	        PreparedStatement statement = con.prepareStatement(Utilities.GET_USER_ID);
	        statement.setString(1, userName); // Set the user_name parameter
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            user_id = resultSet.getInt(1);
	            System.out.println("user_id = " + user_id);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return user_id;
	}
	
	public String getAccountType(int userId) {
	    String accountType = null;
	        try (Connection con = getConnection()) {
	            PreparedStatement statement = con.prepareStatement(Utilities.GET_USER_ACCOUNT_TYPE);
	            statement.setInt(1, userId);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                accountType = resultSet.getString("accountType");
	                System.out.println("User account type is : " + accountType);
	            }
	        }
	        catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		    return accountType;
		}
 
	
	public List<ContactUsMessageModel> getContactUsMessage(){
		List<ContactUsMessageModel> contactUsMessages = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.READ_CONTACT_US_MESSAGE);
			ResultSet messages = statement.executeQuery();
			while (messages.next()){
				String name = messages.getString("Name");
				String contactNumber = messages.getString("ContactNumber");
				String email = messages.getString("Email");
				String message = messages.getString("Message");
				Date datetime = messages.getDate("DateTime");
				ContactUsMessageModel contactUsMessageModel = new ContactUsMessageModel(name, contactNumber, email, message, datetime);
				contactUsMessages.add(contactUsMessageModel);
			}
		}
		catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return contactUsMessages;
	}
	
	public int addProductToCart(CartModel cartModel) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.ADD_PRODUCT_TO_CART);
			statement.setInt(1, cartModel.getUserId());
			statement.setInt(2, cartModel.getProductId());
			statement.setString(3, cartModel.getProductName());
			statement.setInt(4, cartModel.getQuantity());
			statement.setDouble(5, cartModel.getPrice());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public List<UserCartModel> getUserCartInfo(int userIdNum){
		List<UserCartModel> userCartDetails = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.GET_USER_CART_INFO);
			statement.setInt(1, userIdNum);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int userId = resultSet.getInt("userId");
				int productId = resultSet.getInt("productId");
				String productName = resultSet.getString("productName");
				String productImage = resultSet.getString("productImage");
				int quantity = resultSet.getInt("quantity");
				Double price = resultSet.getDouble("price");
				Double totalAmount= price * quantity;
				UserCartModel userCartDetailsModel = new UserCartModel(productId, userId, productName, 
				productImage, price, quantity, totalAmount);
				userCartDetails.add(userCartDetailsModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCartDetails;
	}
	
	public void updateUserDetails() {
		
	}
	
	public List<ProductModel> getSearchResult(String userInput){
		List<ProductModel> SearchResult = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.SEARCH_RESULT_QUERY);
			statement.setString(1,"%"+ userInput +"%");
			ResultSet searchResult = statement.executeQuery();
			while(searchResult.next()){
				int productId = searchResult.getInt("productId");
                String productName = searchResult.getString("productName");
                String productDescription = searchResult.getString("productDesc");
                Double price = searchResult.getDouble("price");
                int quantity = searchResult.getInt("quantity");
                String productImage = searchResult.getString("productImage");
                String companyName = searchResult.getString("companyName");
                ProductModel productModel = new ProductModel(productId, productName, productDescription, price, quantity, companyName, productImage); 
                SearchResult.add(productModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SearchResult;
	}
	public int updateStockAfterPurchase(int numberStock, int productId) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.UPDATE_STOCK_QUANTITY_AFTER_PURCHASE);
			statement.setInt(1, numberStock);
			statement.setInt(2, productId);
			int semiResult = statement.executeUpdate();
			return semiResult > 0 ? 1 : 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
	}
	public int purchaseProducts(PurchaseModel purchaseModel, Double totalAmount) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.STORE_PURCHASE_HISTROY);
			statement.setInt(1, purchaseModel.getQuantity());
			statement.setDouble(2, totalAmount);
			statement.setInt(3, purchaseModel.getUserId());
			statement.setInt(4, purchaseModel.getProductid());
			int semiResult = statement.executeUpdate();
			int result = updateStockAfterPurchase(purchaseModel.getQuantity(), purchaseModel.getProductid());
			if(result==1 && semiResult > 0) {
				return 1;//purchase successfull
			}
			else {
				return -1;//purchase failed
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public int editProduct(ProductModel product) {
	    try (Connection con = getConnection();
	         PreparedStatement statement = con.prepareStatement(Utilities.Edit_Product)) {
	        statement.setString(1, product.getProductName());
	        statement.setString(2, product.getProductDescription());
	        statement.setDouble(3, product.getPrice());
	        statement.setString(4, product.getPrintSpeed());
	        statement.setString(5, product.getColor());
	        statement.setString(6, product.getDimensions());
	        statement.setInt(7, product.getProductId());
	        System.out.println(product.getProductDescription());
	        int rowsUpdated = statement.executeUpdate();
	        System.out.println("Rows updated: " + rowsUpdated);
	        
	        return rowsUpdated; // Return the number of rows updated
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        return -1; // Return an error code if an exception occurs
	    }
	}

	public List<PurchaseHistroyModel> getUserPruchaseHistroy(int userId){
		List<PurchaseHistroyModel> purchaseHistroy = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(Utilities.GET_PURCHASE_HISTORY_OF_USER);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int purchaseId = resultSet.getInt("purchaseId");
				Timestamp dateTime = resultSet.getTimestamp("dateTime");
				int quantity = resultSet.getInt("quantity");
				Double totalAmount = resultSet.getDouble("totalAmount");
				String productName = resultSet.getString("productName");
				Double price = resultSet.getDouble("price");
				String purchaseStatus = resultSet.getString("purchaseStatus");
				String productImage = resultSet.getString("productImage");
				
				PurchaseHistroyModel purchaseHistroyModel = new PurchaseHistroyModel(purchaseId, dateTime, quantity, totalAmount,productName, price, 
						purchaseStatus, productImage);
				purchaseHistroy.add(purchaseHistroyModel);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return purchaseHistroy;
	}
//	public int editProduct(ProductModel product) {
//		// TODO Auto-generated method stub
//		try(Connection con = getConnection()){
//			PreparedStatement statement = con.prepareStatement(Utilities.Edit_Product);
//			statement.setString(1, product.getProductName());
//			statement.setInt(2, product.getProductId());
//			System.out.println(product.getProductName());
//			System.out.println(product.getProductId());
//		
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return -1;
//		}
//		return 0;
//	}
	
	public List<ProductModel> getProductDetails(int product_Id){
		System.out.println("product detail method call");
	    List<ProductModel> productDetails = new ArrayList<>();
	    try(Connection con = getConnection()){
	        PreparedStatement statement = con.prepareStatement(Utilities.GET_PRODUCT_DETAILS);
	        statement.setInt(1, product_Id);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	            int productId = resultSet.getInt("productId");
	            String productName = resultSet.getString("productName");
	            String productDesc = resultSet.getString("productDesc");
	            Double price = resultSet.getDouble("price");
	            int quantity = resultSet.getInt("quantity");
	            String companyName = resultSet.getString("companyName");
	            String productImage = resultSet.getString("productImage");
	            String printTechnology = resultSet.getString("printTechnology");
	            String printSpeed = resultSet.getString("printSpeed");
	            String printResolution = resultSet.getString("printResulotion");
	            String weight = resultSet.getString("weight");
	            String dimensions = resultSet.getString("dimensions");
	            String operatingSystem = resultSet.getString("operatingSystem");
	            String supportedPageSize = resultSet.getString("supportedPageSize");
	            String color = resultSet.getString("color");
	            String printColor = resultSet.getString("printColor");

	            ProductModel productModel = new ProductModel(productId, productName, productDesc, price, 
	            quantity, companyName, productImage, printTechnology, printSpeed, printResolution, weight, dimensions, 
	            operatingSystem, supportedPageSize, color, printColor);
	            productDetails.add(productModel);
	        }
	    }
	    catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return productDetails;
	}
	
	public List<AllPurchasesModel> getAllPurchases(){
		List<AllPurchasesModel> allUserPurchases = new ArrayList<>();
	    try(Connection con = getConnection()){
	        PreparedStatement statement = con.prepareStatement(Utilities.GET_ALL_PURCHASES);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	        	int purchaseId = resultSet.getInt("purchaseId");
	            String DateTime = resultSet.getString("DateTime");
	            int quantity = resultSet.getInt("quantity");
	            double totalAmount = resultSet.getDouble("totalAmount");
	            String userName = resultSet.getString("userName");
	            String email = resultSet.getString("email");
	            String phoneNumber = resultSet.getString("phoneNumber");
	            String productName = resultSet.getString("productName");
	            String productImage = resultSet.getString("productImage");
	            double price = resultSet.getDouble("price");
	            int productQuantity = resultSet.getInt("productQuantity");
	            String companyName = resultSet.getString("companyName");
	            String printTechnology = resultSet.getString("printTechnology");
	            String color = resultSet.getString("color");
	            String printColor = resultSet.getString("printColor");
	            String purchaseStatus = resultSet.getString("purchaseStatus");
	            AllPurchasesModel allPurchasesModel = new AllPurchasesModel(purchaseId, DateTime, quantity, totalAmount, userName, email, phoneNumber, productName, productImage, price, productQuantity, companyName, printTechnology, color, printColor, purchaseStatus); 
	            allUserPurchases.add(allPurchasesModel);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return allUserPurchases;
	}
	
    public int deleteProduct(int prodId) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(Utilities.DELETE_PRODUCT_BY_ID);
            st.setInt(1, prodId);

            int result = st.executeUpdate();
            return result > 0 ? 1 : 0; // Return 1 if deletion is successful, otherwise return 0
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1; // Return -1 for any exceptions
        }
    }
    
    public int removeCartItems(int userId, int productId) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("delete from Cart where userId = ? and productId = ?");
            st.setInt(1, userId);
            st.setInt(2, productId);
            int result = st.executeUpdate();
            System.out.print(result);
            return result > 0 ? 1 : 0; // Return the actual result
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
    }

}