package POJO;

import java.util.HashSet;
import java.util.Set;
// Generated May 31, 2011 10:22:52 AM by Hibernate Tools 3.2.1.GA



/**
 * CategorySub generated by hbm2java
 */
public class CategorySub  implements java.io.Serializable {


     private String categorySubId;
     private String categoryChildId;
     private String categorySubName;
     private Set products = new HashSet(0);

   
	public CategorySub() {
    }

    public CategorySub(String categorySubId, String categoryChildId, String categorySubName) {
       this.categorySubId = categorySubId;
       this.categoryChildId = categoryChildId;
       this.categorySubName = categorySubName;
    }
    
    public CategorySub(String categorySubId, String categoryChildId, String categorySubName, Set products) {
        this.categorySubId = categorySubId;
        this.categoryChildId = categoryChildId;
        this.categorySubName = categorySubName;
        this.products = products;
     }
    
    public CategorySub(String categorySubId,String categorySubName) {
        this.categorySubId = categorySubId;
        this.categorySubName = categorySubName;
     }
   
   
    public String getCategorySubId() {
        return this.categorySubId;
    }
    
    public void setCategorySubId(String categorySubId) {
        this.categorySubId = categorySubId;
    }
    public String getCategoryChildId() {
        return this.categoryChildId;
    }
    
    public void setCategoryChildId(String categoryChildId) {
        this.categoryChildId = categoryChildId;
    }
    public String getCategorySubName() {
        return this.categorySubName;
    }
    
    public void setCategorySubName(String categorySubName) {
        this.categorySubName = categorySubName;
    }

    public Set getProducts() {
		return products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}



}


