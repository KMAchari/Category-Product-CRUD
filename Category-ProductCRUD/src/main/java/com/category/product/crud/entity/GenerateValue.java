package com.category.product.crud.entity;

import jakarta.persistence.GenerationType;

public @interface GenerateValue {

	GenerationType strategy();

}
