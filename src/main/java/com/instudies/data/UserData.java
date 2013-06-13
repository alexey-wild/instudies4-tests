package com.instudies.data;

public class UserData {
	
	public String email;
	public String password;
    public String fullname;
    public String typeUser;
    public String emailUrl;
	
	public UserData(String email, String password, String fullname, String typeUser, String emailUrl) {
		this.email    = email;
		this.password = password;
        this.fullname = fullname;
        this.typeUser = typeUser;
        this.emailUrl = emailUrl;
	}
}
