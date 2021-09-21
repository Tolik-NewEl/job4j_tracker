package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private char anesthetist;

    public Dentist(String name, String surname,
                   String education, String birthday,
                   int experience, char anesthetist) {
        super(name, surname, education, birthday, experience);
        this.anesthetist = anesthetist;
    }

    public char getAnesthetist() {
        return anesthetist;
    }
}
