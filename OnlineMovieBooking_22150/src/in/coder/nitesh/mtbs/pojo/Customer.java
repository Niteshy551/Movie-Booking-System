package in.coder.nitesh.mtbs.pojo;

public class Customer {
	
	private int custId;
	private String custFName;
	private String custLName;
	private String custEmailId;
	private String custPassword;
	private String custContactNo;
	private String custAddress;
	
	
	public Customer() {
		super();
	}


	public Customer(int custId, String custFName, String custLName, String custEmailId, String custPassword,
			String custContactNo, String custAddress) {
		super();
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
		this.custContactNo = custContactNo;
		this.custAddress = custAddress;
	}


	public Customer(String custFName, String custLName, String custEmailId, String custPassword, String custContactNo,
			String custAddress) {
		super();
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
		this.custContactNo = custContactNo;
		this.custAddress = custAddress;
	}

	

	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustFName() {
		return custFName;
	}


	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}


	public String getCustLName() {
		return custLName;
	}


	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}


	public String getCustEmailId() {
		return custEmailId;
	}


	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}


	public String getCustPassword() {
		return custPassword;
	}


	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}


	public String getCustContactNo() {
		return custContactNo;
	}


	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	@Override
	public String toString() {
		return "Customer Id = " + custId + ", First Name= " + custFName + ", Last Name = " + custLName + ", Email Id = "
				+ custEmailId + ", Password = " + custPassword + ", Contact No. = " + custContactNo + ", Address. = "
				+ custAddress + "]";
	}
	
	
	
	
	
}
