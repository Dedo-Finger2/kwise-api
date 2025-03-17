package com.github.dedoFinger2.Kwise.Model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "shopping_list_products",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "shopping_list_id"})
)
public class ShoppingListProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingList shoppingList;

    @Column(name = "quantity_at_home", nullable = false)
    private double quantityAtHome;

    @Column(name = "last_price_paid")
    private double lastPricePaid;

    public ShoppingListProduct() {
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
        ShoppingListProduct other = (ShoppingListProduct) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Inventory Product [id=" + id + ", shopping_list_id=" + shoppingList.getId() + ", product_id=" + product.getId() + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public double getLastPricePaid() {
        return lastPricePaid;
    }

    public void setLastPricePaid(double lastPricePaid) {
        this.lastPricePaid = lastPricePaid;
    }

    public double getQuantityAtHome() {
        return quantityAtHome;
    }

    public void setQuantityAtHome(double quantityAtHome) {
        this.quantityAtHome = quantityAtHome;
    }
}
