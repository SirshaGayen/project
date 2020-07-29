package infy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
@GenericGenerator(name="pkgen",strategy="increment")
public class Orders {

	@Id
	@GeneratedValue(generator="pkgen")
	private int id;
	private int itemId;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders(int itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
