package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand extends AbstractEntity{

    @NotNull(message = "Brand name is required")
    private String name;
    private String locator;

    @OneToMany(mappedBy = "brand")
    private final List<Drink> drinks = new ArrayList<>();

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {}

    public Brand(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public List<Drink> getDrinks() { return drinks; }

    @Override
    public String toString() {
        return name;
    }
}
