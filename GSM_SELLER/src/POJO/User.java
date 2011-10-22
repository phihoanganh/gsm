package POJO;
// Generated May 31, 2011 10:22:52 AM by Hibernate Tools 3.2.1.GA


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import BUS.RoleBUS;
import UTIL.MySqlDataAccessHelper;
import UTIL.VuHong_MD5;

/**
 * User generated by hbm2java
 */
@SuppressWarnings("serial")
@ManagedBean(name="user")
@SessionScoped
public class User  implements java.io.Serializable {

	private String account;
	private Role role;
	private String pass;
	private String fullName;
	private Date birthday;
	private String sex;
	private Date registerDate;
	private String address;
	private String phone;
	private String email;
	private String state;
	private Set productorders = new HashSet(0);
	private Set products = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set companys = new HashSet(0);
	private Set banks = new HashSet(0);
	private Set deliverCosts = new HashSet(0);
	private Set shippingcompanys=new HashSet(0);
	
	
	@SuppressWarnings("unused")
	private String redirectProfileSeller;
	@SuppressWarnings("unused")
	private String redirectTaskChangeProfileSeller;
	@SuppressWarnings("unused")
	private String redirectAnswerSeller;


	public User(String account,String pass){
		this.account = account;
		this.pass = pass;
	}

	public User(String account,String pass,Role roles){
		this.account = account;
		this.pass = pass;
		this.role = roles;
	}
	public User(String account,String pass,String address,String email){
		this.account = account;
		this.pass = pass;
		this.address = address;
		this.email = email;
	}
	public User(String account,String pass,String address,String email,String fullName){
		this.account = account;
		this.pass = pass;
		this.address = address;
		this.email = email;
		this.fullName = fullName;
	}
	public User() {
	}


	public User(String account, Role role, String pass, String fullName, Date birthday, String sex,Date registerDate, String address, String phone, String email,String state) {
		this.account = account;
		this.role = role;
		this.pass = pass;
		this.fullName = fullName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.registerDate = registerDate;
	}
	public User(String account, Role role, String pass, String fullName, Date birthday, String sex,Date registerDate, String address, String phone, String email,String state, Set productorders, Set products, Set notices, Set companys, Set banks,Set shippingcompanys) {
		this.account = account;
		this.role = role;
		this.companys = companys;
		this.pass = pass;
		this.fullName = fullName;
		this.birthday = birthday;
		this.sex = sex;
		this.registerDate = registerDate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.productorders = productorders;
		this.products = products;
		this.notices = notices;
		this.banks = banks;
		this.shippingcompanys=shippingcompanys;
	}
	

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
		public Role getRole() {
			return this.role;
		}
	
		public void setRole(Role role) {
			this.role = role;
		}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public Set getProductorders() {
		return this.productorders;
	}

	public void setProductorders(Set productorders) {
		this.productorders = productorders;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	public Set getNotices() {
		return notices;
	}


	public void setNotices(Set notices) {
		this.notices = notices;
	}


	public Set getCompanys() {
		return companys;
	}


	public void setCompanys(Set companys) {
		this.companys = companys;
	}


	public Set getBanks() {
		return banks;
	}


	public void setBanks(Set banks) {
		this.banks = banks;
	}


	public Set getDeliverCosts() {
		return deliverCosts;
	}


	public void setDeliverCosts(Set deliverCosts) {
		this.deliverCosts = deliverCosts;
	}


	public Set getShippingcompanys() {
		return shippingcompanys;
	}


	public void setShippingcompanys(Set shippingcompanys) {
		this.shippingcompanys = shippingcompanys;
	}

	public String getRedirectProfileSeller() {
		return profileSeller();
	}

	public void setRedirectProfileSeller(String redirectProfileSeller) {
		this.redirectProfileSeller = redirectProfileSeller;
	}

	public String getRedirectTaskChangeProfileSeller() {
		return taskChangeProfileSeller();
	}

	public void setRedirectTaskChangeProfileSeller(
			String redirectTaskChangeProfileSeller) {
		this.redirectTaskChangeProfileSeller = redirectTaskChangeProfileSeller;
	}
	public String getRedirectAnswerSeller() {
		return answerSeller();
	}
	public void setRedirectAnswerSeller(String redirectAnswerSeller) {
		this.redirectAnswerSeller = redirectAnswerSeller;
	}

	public String canLogin(){
		try {
			MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
			helper.open();
			FacesContext face = FacesContext.getCurrentInstance();
			String query = "select * from user";
			ResultSet rs = helper.executeQuery(query);
			ArrayList<User> list = new ArrayList<User>();
			System.out.println("Account: "+account);
			System.out.println("pass: "+pass);
			
			while(rs.next()){
				User user = new User(rs.getString("Account"),rs.getString("Pass"),rs.getString("Address"),rs.getString("Email"),rs.getString("FullName"));
				Role role =RoleBUS.getRole(Integer.parseInt(rs.getString("RoleId")), "MALL_EN");
				user.setRole(role);
				list.add(user);
				System.out.println("Rolessss :" + user.getRole().getRoleId()) ;
			}
			boolean match=false;
			for (int i = 0; i < list.size(); i++) {
				User us = list.get(i);
				System.out.println("Accounts: "+us.getAccount());
				System.out.println("passs: "+us.getPass());
				System.out.println("roles: "+us.getRole().getRoleId());
				
				if(account.equalsIgnoreCase(us.getAccount()) &&
					VuHong_MD5.encrypt(pass).equalsIgnoreCase(us.getPass()) && us.getRole().getRoleId()==4){
					role=us.getRole();
					match=true;
					HttpSession session= (HttpSession) face.getExternalContext().getSession(true);
					session.setAttribute("uselogin", us);
					System.out.println("thanh cong");
					break;
				}
			}
			if(match){
				
				face.getExternalContext().redirect("index.xhtml");
			}
			else{
				face.getExternalContext().redirect("index.xhtml");
				System.out.println("loi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String profileSeller(){
		return "seller-profile/profile_seller.xhtml";
	}
	
	public String taskChangeProfileSeller() {
		return "seller-profile/task_change_account.xhtml";
	}
	
	public String answerSeller(){
		return "seller-profile/answer_seller.xhtml";
	}
	
	
}


