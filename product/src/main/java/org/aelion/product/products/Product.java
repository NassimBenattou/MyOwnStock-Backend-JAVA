package org.aelion.product.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /**
     * @var Product id
     */
    private String id;
    /**
     * @var Product name
     */
    private String label;
    /**
     * @var Product stock
     */
    private int stock;
}
