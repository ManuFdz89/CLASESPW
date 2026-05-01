package org.example.tiedafx.model;

import java.util.List;

@lombok.Data
public class ProductResponse {
    private List<Product> products;
    private long total;
    private long skip;
    private long limit;
}