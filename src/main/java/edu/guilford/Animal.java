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
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("Name must be at least one character long.");
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species.length() > 0) {
            this.species = species;
        } else {
            System.out.println("Species must be at least one character long.");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.length() > 0) {
            this.color = color;
        } else {
            System.out.println("Color must be at least one character long.");
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
        if (sound.length() > 0) {
            this.sound = sound;
        } else {
            System.out.println("Sound must be at least one character long.");
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
