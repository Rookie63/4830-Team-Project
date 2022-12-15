package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "MyUsers")
public class User {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "username")
   private String username;
   
   @Column(name = "password")
   private String password;

   @Column(name = "email")
   private String email;
   
   @Column(name = "admin")
   private Integer admin;

   
   
   public User() {
   }

   public User(Integer id, String username, String password) {
	   		this.id = id;
	      this.username = username;
	      this.password = password;
	      this.admin = 0;
	   }
   
   
   public User(String username, String password) {
      this.username = username;
      this.password = password;
      this.admin = 0;
   }

   public Integer getId() {
	      return id;
   }

	public void setId(Integer id) {
	   this.id = id;
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
   
   public Integer getAdmin() {
	      return admin;
	   }
   
   public void setAdmin(int admin) {
	      this.admin = admin;
	   }

   @Override
   public String toString() {
      return "User: " + this.id + ", " + this.username;
   }
}