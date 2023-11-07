package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Ереван", 20000, 23, 4);
    Ticket ticket2 = new Ticket("Петрозаводск", "Москва", 8000, 20, 22);
    Ticket ticket3 = new Ticket("Санкт-Петербург", "Владивосток", 25000, 22, 4);
    Ticket ticket4 = new Ticket("Москва", "Ереван", 18000, 14, 18);
    Ticket ticket5 = new Ticket("Москва", "Ереван", 23000, 6, 9);
    Ticket ticket6 = new Ticket("Москва", "Ереван", 15000, 4, 17);

    @BeforeEach
    public void setUp() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
    }

    @Test
    public void shouldCompareTwoTicketsByPrice() {
        int expected = 12000;
        int actual = ticket1.compareTo(ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindThreeTicketAndSortResultByDefault() {
        Ticket[] expected = { ticket6, ticket4, ticket1, ticket5 };
        Ticket[] actual = aviaSouls.search("Москва", "Ереван");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindThreeTicketAndSortResultByComparator() {
        Ticket[] expected = { ticket5, ticket4, ticket1, ticket6 };
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Ереван", new TicketTimeComparator());
        assertArrayEquals(expected, actual);
    }
}