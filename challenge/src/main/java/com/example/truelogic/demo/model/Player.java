package com.example.truelogic.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jgarzon
 */
@Entity
@Table
public class Player {
    
@Id
@Column
private String name;

@Column  
private String type;  

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getType() {
    return type;
}

public void setType(String type) {
    this.type = type;
}

    @Override
    public String toString() {
        return "player: {name: " + this.getName() + ", type: " + this.getType() +"}";
    }
}
