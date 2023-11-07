package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int time1 = calculateTime(o1.getTimeFrom(), o1.getTimeTo());
        int time2 = calculateTime(o2.getTimeFrom(), o2.getTimeTo());
        return time1 - time2;
    }

    private int calculateTime(int timeFrom, int timeTo) {
        return timeTo < timeFrom ? timeTo + (24 - timeFrom) : timeTo - timeFrom;
    }
}
