package com.calendar.service;

import com.calendar.common.Event;
import com.calendar.common.Person;
import com.calendar.datastore.CalendarDataStore;

import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

/**
 * Created by Aleksey on 01.11.2014.
 */
public class CalendarServiceImpl implements CalendarService {

    private final CalendarDataStore dataStore;
    private static final Logger logger = Logger.getAnonymousLogger();

    public CalendarServiceImpl(CalendarDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void addEvent(String name, String description, GregorianCalendar startTime, GregorianCalendar endTime, List<Person> attenders){
        UUID currentUUID;
        currentUUID = UUID.randomUUID();

        dataStore.addStoreEvent(new Event.Builder()
                .uuid(currentUUID)
                .name(name)
                .description(description)
                .startTime(startTime)
                .endTime(endTime)
                .attenders(attenders)
                .build());

        logger.info("Add even on service side " + name + ". ID = " + currentUUID);
    }

    @Override
    public Event remEvent(UUID uuid){
        return dataStore.removeStoreEvent(uuid);
//        logger.info("Remove even on service side.");
    }

    @Override
    public Event getEvent(UUID uuid){
        return dataStore.getStoreEvent(uuid);
    };

    @Override
    public Event addAttender(UUID uuid, Person newPerson){
        Event currentEvent = dataStore.getStoreEvent(uuid);
        if (currentEvent == null){
            return null;
        }

        List<Person> newAttender = new ArrayList(currentEvent.getAttenders());
        if (!newAttender.contains(newPerson)) {
            newAttender.addAll(asList(newPerson));
        }
        Event newEvent = new Event.Builder(currentEvent)
                .attenders(newAttender)
                .build();

        dataStore.modifyStoreEvent(uuid, newEvent);

        return newEvent;
    }

    @Override
    public Event findEventByDate(GregorianCalendar dateEvent){
        return dataStore.findStoreEventByDate(dateEvent);
    };

}
