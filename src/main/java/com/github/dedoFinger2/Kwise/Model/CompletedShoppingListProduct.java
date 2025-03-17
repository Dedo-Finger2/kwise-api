package com.github.dedoFinger2.Kwise.Model;

import jakarta.persistence.*;

@Entity
public class CompletedShoppingListProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_list_product_id", nullable = false)
    private ShoppingListProduct shoppingListProduct;

    @Column(name = "quantity_bought", nullable = false)
    private int quantityBought;

    @Column(name = "unit_price_paid")
    private double unitPricePaid;

    public CompletedShoppingListProduct() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CompletedShoppingListProduct other = (CompletedShoppingListProduct) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Completed Shopping List Product [id=" + id + ", shopping_list_product_id=" + shoppingListProduct.getId() + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingListProduct getShoppingListProduct() {
        return shoppingListProduct;
    }

    public void setShoppingListProduct(ShoppingListProduct shoppingListProduct) {
        this.shoppingListProduct = shoppingListProduct;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public double getUnitPricePaid() {
        return unitPricePaid;
    }

    public void setUnitPricePaid(double unitPricePaid) {
        this.unitPricePaid = unitPricePaid;
    }
}
