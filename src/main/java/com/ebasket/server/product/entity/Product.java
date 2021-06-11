package com.ebasket.server.product.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4904208837832746699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	
	@NotNull(message = "Product name is required.")
	@NotEmpty(message = "Product name is required.")
	@Size(max = 255)
	private String productName;
	
	

	
	private String productSKU;
	
	
	private float productPrice;
	private float productWeight;

	private String productCartDescription;
	private String productShortDescription;
	private String productLongDescription;

	@Lob
	private byte[] productThumb;

	@Lob
	private byte[] productImage;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private ProductCategory productCategory;

	private Timestamp productCareatedDate;
	private Timestamp productUpdatedDate;

	private float productStock;
	private boolean productLive;
	private boolean productUnlimited;
	private String productLocation;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
}
