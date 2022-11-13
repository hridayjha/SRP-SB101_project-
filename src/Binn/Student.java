package Binn;

public class Student {

	private int id;
	private String name;
	private String email;
	private String password;
	private int batchid;
	public Student(int id, String name, String email, String password, int batchid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.batchid = batchid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", batchid="
				+ batchid + "]";
	}
	
	
	
}
