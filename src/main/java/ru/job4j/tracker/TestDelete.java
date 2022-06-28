package ru.job4j.tracker;

public class TestDelete implements UserAction {
    private final Output out;

    public TestDelete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete some items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete some items ====");
        int id = input.askInt("Enter id: ");
        for (int i = 1; i < 10000; i++) {
            if (tracker.delete(id++)) {
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
