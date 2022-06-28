package ru.job4j.tracker;

public class TestCreate implements UserAction {
    private final Output out;

    public TestCreate(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create some items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create some Items ====");
        String name = input.askStr("Enter name: ");
        for (int i = 1; i < 10000000; i++) {
            Item item = new Item(name + i);
            tracker.add(item);
            out.println("Добавленная заявка: " + item);
        }
        return true;
    }
}
