package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("X-102");
        student.setDataJoin("24.06.2021");

        System.out.println(student.getFio() + " зачислен в группу " + student.getGroup() + ". Дата приказа " + student.getDataJoin());
    }
}
