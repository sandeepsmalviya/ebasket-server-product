package com.ecommerce.catalog.server.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	private String productSku;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, optional = true)
	@JoinColumn(name = "product_image_id")
	private ProductImage productImage;

	// @ManyToOne(cascade = { CascadeType.PERSIST })
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, }, optional = false)
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

//	private float productPrice;
//	private float productWeight;
//
//	private String productCartDescription;
//	private String productShortDescription;
//	private String productLongDescription;
//
//	@Lob
//	private byte[] productThumb;
//
//	@Lob
//	private byte[] productImage;
//
//	private Timestamp productCareatedDate;
//	private Timestamp productUpdatedDate;
//
//	private float productStock;
//	private boolean productLive;
//	private boolean productUnlimited;
//	private String productLocation;

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			//return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

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
