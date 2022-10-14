package br.com.fiap.StarIntersection.model;

public class Produto {

	private String _id; 
	
	private String title;
	
	private String description;
	
	private double price;
	
	private boolean active;

	public Produto() {
		
	}
	
	public Produto(String _id, String title, String description, double price, boolean active) {
		super();
		this._id = _id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.active = active;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title; 
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Produto [_id=" + _id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", active=" + active + "]";
	}
	
	
	
}
