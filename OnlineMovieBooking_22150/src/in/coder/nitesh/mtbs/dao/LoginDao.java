package in.coder.nitesh.mtbs.dao;

public interface LoginDao 
{
	boolean isAdmin(String adminEmailId,String adminPassword);
	boolean isCustomer(String custEmailId, String custPassword);
	boolean isCustPassword(String custEmailId, String custPassword);
	boolean changePassword(String custEmailId, String oldPassword, String newPassword);
	boolean forgetPassword(String custEmailId, String contactNo,String custPassword);
	
}
