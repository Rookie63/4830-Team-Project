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
@Table(name = "MyItems")
public class Item {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "name")
   private String name;
   
   @Column(name = "description")
   private String description;

   @Column(name = "price")
   private String price;
   
   
 
   @Column(name = "pickup")
   private boolean pickup;

 
   @Column(name = "delivery")
   private boolean delivery;
   
   @Column(name = "locations")
   private String locations;
   
   @Column(name = "rooms")
   private String rooms;
   
   
   public Item() {
   }

   public Item(Integer id, String name, String description, String price, boolean pickup, boolean delivery, String locations, String rooms) {
	   		this.id = id;
	      this.name = name;
	      this.description = description;
	      this.price = price;
	      this.pickup = pickup;
	      this.delivery = delivery;
	      this.locations = locations;
	      this.rooms = rooms;
	      
	   }
   
   
   public Item(String name, String description, String price, boolean pickup, boolean delivery, String locations, String rooms) {
	   this.name = name;
	      this.description = description;
	      this.price = price;
	      this.pickup = pickup;
	      this.delivery = delivery;
	      this.locations = locations;
	      this.rooms = rooms;
   }

   public Integer getId() {
	      return id;
   }

	public void setId(Integer id) {
	   this.id = id;
	}
   
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
   
   public String getPrice() {
	      return price;
	   }
   
   public void setPrice(String price) {
	      this.price = price;
	   }
   
   public boolean getPickup() {
	      return pickup;
	   }

   public void setPickup(boolean pickup) {
	      this.pickup = pickup;
	   }
   public boolean getDelivery() {
	      return delivery;
	   }

   public void setDelivery(boolean delivery) {
	      this.delivery = delivery;
	   }
   public String getLocations() {
	      return locations;
	   }

   public void setLocations(String locations) {
	      this.locations = locations;
	   }
   public String getRooms() {
	      return rooms;
	   }

   public void setRooms(String rooms) {
	      this.rooms = rooms;
	   }
   @Override
   public String toString() {
      return "Item: " + this.id + ", " + this.name;
   }
}