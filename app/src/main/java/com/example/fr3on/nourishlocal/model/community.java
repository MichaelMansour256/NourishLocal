package com.example.fr3on.nourishlocal.model;

import java.io.Serializable;

public class community implements Serializable{
    private String name;
    private String description;
    private int  imageReference;
    public community (String name , String description ,int imageReference){
        this.name = name;
        this.description = description;
        this.imageReference = imageReference;

    }
    public void setName(String name){
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageReference() {
        return imageReference;
    }

    public void setImageReference(int imageReference) {
        this.imageReference = imageReference;
    }

    public String getName() {
        return name;
    }
}
