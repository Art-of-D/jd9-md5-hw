package org.selection_classes;

import java.util.Objects;

public class ProjectPrices {
    String name;
    Integer price;

    public ProjectPrices(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectPrices)) return false;
        ProjectPrices that = (ProjectPrices) o;
        return name.equals(that.name) && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
