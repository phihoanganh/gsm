package POJO;

import javax.faces.bean.ManagedBean;

// Generated Aug 2, 2011 4:30:55 PM by Hibernate Tools 3.2.1.GA



/**
 * Bank generated by hbm2java
 */
@ManagedBean
public class SellingMode  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172474281535638539L;
	private int sellingModeId;
    private String sellingMode;
    
	public int getSellingModeId() {
		return sellingModeId;
	}
	public void setSellingModeId(int sellingModeId) {
		this.sellingModeId = sellingModeId;
	}
	public String getSellingMode() {
		return sellingMode;
	}
	public void setSellingMode(String sellingMode) {
		this.sellingMode = sellingMode;
	}
    
     

}


