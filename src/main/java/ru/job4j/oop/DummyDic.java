package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String say = "kukaracha";
        return say;
    }

    public static void main(String[] args) {
        DummyDic unknown = new DummyDic();
        String eng = unknown.engToRus("");
        System.out.println("Неизвестное слово." + eng);
    }
}
