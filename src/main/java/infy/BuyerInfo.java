package infy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "buyers")
@GenericGenerator(name="pkgen",strategy="increment")
public class BuyerInfo {

	@Id
	@GeneratedValue(generator="pkgen")
	private int id;
	private String buyerName;
	private String address;
	private String gstin;
	private int stateCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public BuyerInfo(int id, String buyerName, String address, String gstin, int stateCode) {
		super();
		this.id = id;
		this.buyerName = buyerName;
		this.address = address;
		this.gstin = gstin;
		this.stateCode = stateCode;
	}
	public BuyerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BuyerInfo [id=" + id + ", buyerName=" + buyerName + ", address=" + address + ", gstin=" + gstin
				+ ", stateCode=" + stateCode + "]";
	}
	
	
	
}
