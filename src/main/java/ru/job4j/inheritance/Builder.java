package ru.job4j.inheritance;

public class Builder extends Engineer {

    private char roadBuilder;
    private char otherBuilder;

    public Builder(String name, String surname, String education, String birthday, String specialization, char roadBuilder, char otherBuilder) {
        super(name, surname, education, birthday, specialization);
        this.roadBuilder = roadBuilder;
        this.otherBuilder = otherBuilder;
    }

    public char getRoadBuilder() {
        return roadBuilder;
    }

    public char getOtherBuilder() {
        return otherBuilder;
    }
}
