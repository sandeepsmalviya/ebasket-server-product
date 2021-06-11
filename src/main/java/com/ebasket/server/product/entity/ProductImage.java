package com.ebasket.server.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;

	@NotNull(message = "Please provide imageName")
	@NotEmpty(message = "Please provide imageName")
	@Size(max = 255)
	private String imageName;

	@Size(max = 255)
	private String imageDescription;

	@OneToOne(mappedBy = "productImage", cascade = {  CascadeType.PERSIST, CascadeType.MERGE })
	@JsonIgnore
	private Product product;

}
