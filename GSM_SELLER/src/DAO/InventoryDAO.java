package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POJO.Bank;
import POJO.Invenstate;
import POJO.Inventory;
import POJO.Ordercancel;
import POJO.Payment;
import POJO.Products;
import POJO.Role;
import POJO.User;
import UTIL.MySqlDataAccessHelper;

public class InventoryDAO extends HibernateDAO {


	//Get list Inventory By Limit
	public static List<Inventory> lstInventoryByLimit(String lang) {
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		return HibernateDAO.getList("from Inventory where LimitDate < '"+currentDate+"' ", lang);
	}

	//Get list Inventory By Limit (pagging)
	public static List<Inventory> lstInventoryByLimit(int pageNumber, int pageSize,String lang) {
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		return HibernateDAO.getList("from Inventory where LimitDate < '"+currentDate+"' ",pageNumber,pageSize, lang);
	}

	// Get Inventory in ID
	public static Inventory getInventory(int id, String lang) {
		return (Inventory) HibernateDAO.getObject(Inventory.class, id, lang);
	}

	public static ArrayList<Inventory> lstInventory(String username, String lang) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sql = "select inventory.InventoryId,inventory.LimitDate,inventory.SateId," +
			"inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			"where inventory.ProductId=products.ProductID " +
			"and products.ManufacturerId=manufacturer.ManufacturerId" + 
			" and inventory.SateId = invenstate.StateId " + 
			" and inventory.LimitDate < '"+currentDate+"' " +
			" and products.Account= '"+username+"'";
			helper.open(lang);

			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				inventory.setSateId(rs.getInt("SateId"));
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}
	public static ArrayList<Inventory> lstSearchInventory(String username, String lang,String fromDate,String toDate,
			int manufactureId,String namekey) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sqlsearch = "select inventory.InventoryId,inventory.LimitDate,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			" where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +
			" and inventory.LimitDate between '"+fromDate+"' and '"+toDate+"' " +
			" and products.ProductName like'%"+namekey+"%'" +
			" and manufacturer.ManufacturerId="+manufactureId+" "+
			/*" and invenstate.StateId="+invenstateId+" " +*/
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";
			helper.open(lang);
			System.out.print("sql6:"+sqlsearch);
			ResultSet rs = helper.executeQuery(sqlsearch);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				/*inventory.setSateId(rs.getInt("SateId"));*/
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}


	public static ArrayList<Inventory> lstSearchInventoryDate(String username, String lang,String fromDate,String toDate) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sqlDate = "select inventory.InventoryId,inventory.LimitDate,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			" where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +
			" and inventory.LimitDate between '"+fromDate+"' and '"+toDate+"' " +
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";
			helper.open(lang);
			System.out.print("sql5:"+sqlDate);
			ResultSet rs = helper.executeQuery(sqlDate);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				/*inventory.setSateId(rs.getInt("SateId"));*/
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}


	public static ArrayList<Inventory> lstSearchInventoryDateKey(String username, String lang,String fromDate,String toDate,
			String namekey) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sqlnamekey = "select inventory.InventoryId,inventory.LimitDate,inventory.SateId,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			"where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +
			" and inventory.LimitDate between '"+fromDate+"' and '"+toDate+"' " +
			" and products.ProductName like'%"+namekey+"%'" +
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";
			helper.open(lang);
			System.out.print("sql4:"+sqlnamekey);
			ResultSet rs = helper.executeQuery(sqlnamekey);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				inventory.setSateId(rs.getInt("SateId"));
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}


	public static ArrayList<Inventory> lstSearchInventoryManuId(String username, String lang,String fromDate,String toDate,
			int manufactureId) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sql = "select inventory.InventoryId,inventory.LimitDate,inventory.SateId,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			"where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +
			" and inventory.LimitDate between '"+fromDate+"' and '"+toDate+"' " +
			" and manufacturer.ManufacturerId="+manufactureId+" "+
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";
			helper.open(lang);
			System.out.print("sql3:"+sql);
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				inventory.setSateId(rs.getInt("SateId"));
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}


	public static ArrayList<Inventory> lstSearchInventoryState(String username, String lang,String fromDate,String toDate) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sql = "select inventory.InventoryId,inventory.LimitDate,inventory.SateId,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			" where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +
			" and inventory.LimitDate between '"+fromDate+"' and '"+toDate+"' " +
			/*" and invenstate.StateId="+invenstateId+" " +*/
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";
			helper.open(lang);
			System.out.print("sql2:"+sql);
			ResultSet rs = helper.executeQuery(sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				/*inventory.setSateId(rs.getInt("SateId"));*/
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}


	public static ArrayList<Inventory> lstSearchInventoryKey(String username, String lang,String namekey) {
		ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			String sql = "select inventory.InventoryId,inventory.LimitDate,inventory.ProductId " +
			"from inventory,products,manufacturer,invenstate " +
			" where inventory.ProductId=products.ProductID  " +
			" and inventory.SateId=invenstate.StateId"+
			" and products.ManufacturerId=manufacturer.ManufacturerId"+
			" and products.Account= '"+username+"' " +		
			" and products.ProductName like'%"+namekey+"%'" +
			" and inventory.LimitDate < '"+currentDate+"' " +
			" Group by products.ProductID";

			helper.open(lang);
			ResultSet rs = helper.executeQuery(sql);
			System.out.print("sql:"+sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setInventoryId(rs.getInt("InventoryId"));
				inventory.setLimitDate(rs.getDate("LimitDate"));
				inventory.setProductId(rs.getInt("ProductId"));
				/*inventory.setSateId(rs.getInt("SateId"));*/
				lstInven.add(inventory);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return lstInven;
	}
	/*
	 * public static ArrayList<Inventory> lstInventory(String lang) {
	 * ArrayList<Inventory> lstInven = new ArrayList<Inventory>();
	 * MySqlDataAccessHelper helper = new MySqlDataAccessHelper(); try { String
	 * sql = "select inventory.InventoryId,inventory.LimitDate from inventory";
	 * if (null == lang || lang.length() <= 0 || lang.equals("MALL_EN")) {
	 * helper.open_en(); } else { if (lang.equals("MALL_VN")) {
	 * helper.open_vn(); } else { helper.open_kr(); } } ResultSet rs =
	 * helper.executeQuery(sql); while (rs.next()) { Inventory inventory = new
	 * Inventory(); inventory.setInventoryId(rs.getInt("InventoryId"));
	 * inventory.setLimitDate(rs.getDate("LimitDate")); lstInven.add(inventory);
	 * } } catch (Exception ex) { ex.getMessage(); } return lstInven; }
	 */
	public static List<Inventory> lstInvenProductId(Products product,
			String lang) {
		return HibernateDAO.getList("from Inventory where productId='"
				+ product.getProductId() + "'", lang);
	}


	//Insert Inventory
	public static boolean insertInventory(Inventory p,String lang) {
		return HibernateDAO.insert(p, lang);
	}

	//Update Inventory
	public static boolean updateInventory(Inventory p,String lang) {
		return HibernateDAO.update(p, lang);
	}

	//Delete Inventory
	public static boolean deleteInventory(Inventory p,String lang) {
		return HibernateDAO.delete(p, lang);
	}
	// update inventory by productId
	public static boolean updateInvetoryByProductId(String dateTime,String lang,String account,int productID){
		boolean result = false;
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		try {
			helper.open(lang);
			String sql = "UPDATE inventory,products SET inventory.LimitDate ='" + dateTime + "' WHERE inventory.ProductId = '" + productID + "'" +
			" and inventory.ProductId = products.ProductID " +
			" and products.Account ='" + account + "'";
			int rs = helper.executeUpdate(sql);
			if(rs > 0){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// update inventory by productId
	public static boolean updateStateInvetoryByProductId(String lang,String account,int productID){
		boolean result = false;
		MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=simp.format(new Date());
		try {
			helper.open(lang);
			String sql = "UPDATE inventory,products SET inventory.SateId ='1' , inventory.UpdateDate='"+currentDate+"'  WHERE inventory.ProductId = '" + productID + "'" +
			" and inventory.ProductId = products.ProductID " +
			" and products.Account ='" + account + "'";
			int rs = helper.executeUpdate(sql);
			if(rs > 0){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
