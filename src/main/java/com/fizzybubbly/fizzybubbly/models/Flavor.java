package com.fizzybubbly.fizzybubbly.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flavor extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "flavor")
    private final List<Drink> drinks = new ArrayList<>();

    public Flavor(String name) {
        this.name = name;
    }

    public Flavor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
