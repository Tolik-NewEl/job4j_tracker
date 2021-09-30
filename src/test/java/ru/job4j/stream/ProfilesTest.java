package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenFindByCityAndApartment() {
        Profiles prof = new Profiles();
        Address adr1 = new Address("Ekaterinburg", "Lenina", 1, 1);
        Address adr2 = new Address("Moscow", "Turgeneva", 10, 10);
        Profile prof1 = new Profile(adr1);
        Profile prof2 = new Profile(adr2);
        List<Profile> pr = List.of(
            prof1,
            prof2
        );
        List<Address> rsl = prof.collect(pr);
        assertThat(rsl.get(0).getCity(), is("Ekaterinburg"));
        assertThat(rsl.get(0).getApartment(), is(1));
    }
}