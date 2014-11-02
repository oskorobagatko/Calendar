package com.calendar.datastore;

import com.calendar.common.Event;
import com.calendar.common.Person;

import java.util.*;

/**
 * Created by Aleksey on 01.11.2014.
 */
public class CalendarDataStoreImpl implements CalendarDataStore {

    private final Map<UUID, Event> storeEvent = new HashMap();
    private final Map<UUID, String> storeName = new HashMap();
    private final Map<UUID, String> storeDesc = new HashMap();
    private final Map<UUID, GregorianCalendar> storeStartTime = new HashMap();
    private final Map<UUID, GregorianCalendar> storeEndTime = new HashMap();
    private final Map<UUID, List<Person>> storeAttender = new HashMap();

    @Override
    public void addStoreEvent(Event event){
        storeEvent.put(event.getUuid(), event);
        storeName.put(event.getUuid(), event.getName());
        storeDesc.put(event.getUuid(), event.getDescription());
        storeStartTime.put(event.getUuid(), event.getStartTime());
        storeEndTime.put(event.getUuid(), event.getEndTime());
        storeAttender.put(event.getUuid(), event.getAttenders());
    }

    @Override
    public void modifyStoreEvent(UUID uuid, Event event){
        removeStoreEvent(uuid);
        addStoreEvent(event);
    }

    @Override
    public Event removeStoreEvent(UUID eventUUID){
        Event remEvent = storeEvent.get(eventUUID);
        storeEvent.remove(eventUUID);
        storeName.remove(eventUUID);
        storeDesc.remove(eventUUID);
        storeStartTime.remove(eventUUID);
        storeEndTime.remove(eventUUID);
        storeAttender.remove(eventUUID);
        return remEvent;
    }

    @Override
    public Event getStoreEvent(UUID eventUUID){
        return storeEvent.get(eventUUID);
    }

    @Override
    public Event findStoreEventByDate(GregorianCalendar dateEvent){
        Event findEvent = new Event.Builder().build();

        for (Map.Entry<UUID, GregorianCalendar> startDate  : storeStartTime.entrySet()) {
            if (startDate.getValue().before(dateEvent) || startDate.getValue().equals(dateEvent)){
                UUID currentUUID = startDate.getKey();
                GregorianCalendar endDate = storeEndTime.get(currentUUID);
                if (endDate.after(dateEvent) || endDate.equals(dateEvent)){
                    findEvent = storeEvent.get(currentUUID);
                    break;
                }
            }
        }

        return findEvent;
    }
}
