package br.com.fiap.StarIntersection.Dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.fiap.StarIntersection.model.Produto;

public class EmailDto {
	@NotBlank
	@NotNull
	private String title;

	private String description;

	@NotNull
	@DecimalMin(value = "0.0")
	private double price;

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

	public void setPrice(double price) {
		this.price = price;
	}

	public void fromProduto(Produto produto) {
		this.price = produto.getPrice();
		this.title = produto.getTitle();
		this.description = produto.getDescription();

	}

}
