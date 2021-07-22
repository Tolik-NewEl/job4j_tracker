package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error one = new Error();
        one.printInfo();
        Error two = new Error(true, 1, "Работает");
        two.printInfo();
        Error three = new Error(false, 0, "Не работает");
        three.printInfo();
    }
}
