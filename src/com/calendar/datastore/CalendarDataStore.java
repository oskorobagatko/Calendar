package com.calendar.datastore;

import com.calendar.common.Event;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by Aleksey on 01.11.2014.
 */
public interface CalendarDataStore {

    void addStoreEvent(Event event);

    void modifyStoreEvent(UUID eventUUID, Event event);

    Event removeStoreEvent(UUID eventUUID);

    Event getStoreEvent(UUID eventUUID);

    Event findStoreEventByDate(GregorianCalendar dateEvent);

}
