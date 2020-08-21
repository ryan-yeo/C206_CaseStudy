public class Account {
	private String username;
	private String password;
	private String userRole;

	public Account(String username, String password, String userRole) {

		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	public Account(String userAccount, String accountPassword) {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String toString() {
		String acc = "";
		acc = String.format("%-10s %-10s %-10s\n", username, password, userRole);
		return acc;
	}

}