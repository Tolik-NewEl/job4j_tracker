package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new ShowAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        String id = String.valueOf(item.getId());
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new ReplaceAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new DeleteAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(Matchers.nullValue()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        String id = String.valueOf(item.getId());
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new FindIDAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new FindNameAction(out));
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0", "New item", "1"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction());
        Input in = new StubInput(
                new String[] {"0"}
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenSorting() {
        List<Item> items = Arrays.asList(
                new Item(5, "test1"),
                new Item(1, "test3"),
                new Item(3, "test5")
        );
        List<Item> upSorting = Arrays.asList(
                new Item(1, "test3"),
                new Item(3, "test5"),
                new Item(5, "test1")
        );
        List<Item> downSorting = Arrays.asList(
                new Item(5, "test1"),
                new Item(3, "test5"),
                new Item(1, "test3")
        );
        Collections.sort(items);
        assertThat(items, is(upSorting));
        Collections.reverse(items);
        assertThat(items, is(downSorting));
    }

    @Test
    public void whenSortWithComparator() {
        List<Item> items = Arrays.asList(
                new Item(1, "test3"),
                new Item(3, "test5"),
                new Item(5, "test1")
        );
        List<Item> expected = Arrays.asList(
                new Item(5, "test1"),
                new Item(1, "test3"),
                new Item(3, "test5")
        );
        Collections.sort(items, new ItemComparator());
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortWithComparatorDesc() {
        List<Item> items = Arrays.asList(
                new Item(5, "test1"),
                new Item(1, "test3"),
                new Item(3, "test5")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "test5"),
                new Item(1, "test3"),
                new Item(5, "test1")
        );
        Collections.sort(items, new ItemComparatorDesc());
        assertThat(items, is(expected));
    }
}