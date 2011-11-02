package POJO;
// Generated May 31, 2011 10:22:52 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role  implements java.io.Serializable {


     private Integer roleId;
     private String roleName;
     private Set users = new HashSet(0);

    public Role() {
    }

	
    public Role(String roleName) {
        this.roleName = roleName;
    }
    public Role(String roleName, Set users) {
       this.roleName = roleName;
       this.users = users;
    }
   
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }




}

