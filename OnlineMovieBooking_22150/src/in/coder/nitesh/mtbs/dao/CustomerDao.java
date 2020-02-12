package in.coder.nitesh.mtbs.dao;
import java.util.List;

import in.coder.nitesh.mtbs.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer cust);
	boolean updateCustomer(Customer cust);
	boolean deleteCustomer(int custId);
	List<Customer> showAllCustomer();
	Customer searchCustomerById(int custId);
	Customer searchCustomerByEmailId(String custEmailId);
}
