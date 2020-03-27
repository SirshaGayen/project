package infy2;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Paper12 {
	
	public Paper12()
	{
		
	}
	public Paper12(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
