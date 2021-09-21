package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String area;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   int experience, String area) {
        super(name, surname, education, birthday, experience);
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
