package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programmCode;

    public Programmer(String name, String surname, String education, String birthday, String specialization, String programmCode) {
        super(name, surname, education, birthday, specialization);
        this.programmCode = programmCode;
    }

    public String getProgrammCode() {
        return programmCode;
    }
}
