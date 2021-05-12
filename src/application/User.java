package application;

public class User {
private String firstname;
private String surname;
private String login;
private String password;
private String eblan;

public User(String firstname,String surname, String login, String password, String eblan) {
	this.firstname = firstname;
	this.surname = surname;
	this.login = login;
	this.password = password;
	this.eblan = eblan;
}

public User() {}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEblan() {
	return eblan;
}
public void setEblan(String eblan) {
	this.eblan = eblan;
}

}
