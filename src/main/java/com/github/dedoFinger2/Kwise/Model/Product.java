package com.github.dedoFinger2.Kwise.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "min_quantity")
    private double minQuantity;

    @Column(nullable = false)
    private int perishable;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product")
    private List<InventoryProduct> inventories;

    @OneToMany(mappedBy = "product")
    private List<ShoppingListProduct> shoppingLists;

    public Product() {
        this.createdAt = LocalDateTime.now();
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
        Product other = (Product) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getPerishable() {
        return perishable;
    }

    public void setPerishable(int perishable) {
        this.perishable = perishable;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<InventoryProduct> getInventories() {
        return inventories;
    }

    public void setInventories(List<InventoryProduct> inventories) {
        this.inventories = inventories;
    }

    public List<ShoppingListProduct> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(List<ShoppingListProduct> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}
