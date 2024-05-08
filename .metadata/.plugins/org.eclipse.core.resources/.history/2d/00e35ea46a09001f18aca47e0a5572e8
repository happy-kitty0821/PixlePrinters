//this will be used to connect to the mysql database
package controller.servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.mindrot.bcrypt.BCrypt;

import models.AdminModel;
import models.BrandModel;
import models.ContactUsMessageModel;
import models.ProductModel;
import models.UserModel;
import utilities.Utilities;

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
			ResultSet result = statement.executeQuery();
			System.out.print("result is :" + result);
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
				BrandModel brand = new BrandModel(companyName);
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
				ProductModel product = new ProductModel(productName, productDesc, price, quantity, companyName,
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
}