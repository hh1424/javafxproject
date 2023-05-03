package edu.guilford;

public class Animal {
    // Five attributes of an Animal object.
    private String name;
    private String species;
    private String color;
    private int age;
    private String sound;

    //Constructor with default values.
    public Animal() {
        name = "Polar Bear";
        species = "Bear";
        color = "White";
        age = 8;
        sound = "Roar";
    }

    //Constructor with parameters.
    public Animal(String name, String species, String color, int age, String sound) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.age = age;
        this.sound = sound;
    }

    //Getters and setters for each attribute.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species != null) {
            this.species = species;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive integer.");
        }
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        if (sound != null) {
            this.sound = sound;
        }
    }

    //toString method
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", sound='" + sound + '\'' +
                '}';
    }

}
