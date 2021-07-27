package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 200);
        Book second = new Book("Java для чайников", 400);
        Book third = new Book("Букварь", 100);
        Book fourth = new Book("Колобок", 10);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int index = 0; index < books.length; index++) {
            Book nr = books[index];
            System.out.println(nr.getName() + " - " + nr.getNumber() + " страниц.");
        }
        System.out.println("Меняем местами книги с индексами 0 и 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book nr = books[index];
            System.out.println(nr.getName() + " - " + nr.getNumber() + " страниц.");
        }
        System.out.println("Вывод книги с именем Clean code");
        for (int index = 0; index < books.length; index++) {
            Book nr = books[index];
            if (nr.getName().equals("Clean code")) {
                System.out.println(nr.getName() + " - " + nr.getNumber() + " страниц.");
            }
        }
    }
}
