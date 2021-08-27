package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "brand")
    private final List<Drink> drinks = new ArrayList<>();

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
