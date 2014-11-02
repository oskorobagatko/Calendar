package com.calendar.service;

import com.calendar.common.Event;
import com.calendar.common.Person;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Aleksey on 01.11.2014.
 */
public interface CalendarService {

    void addEvent(String name, String description, GregorianCalendar startTime, GregorianCalendar endTime, List<Person> attenders) throws RemoteException;

    Event remEvent(UUID uuid) throws RemoteException;

    Event getEvent(UUID uuid) throws RemoteException;

    Event addAttender(UUID uuid, Person newPerson) throws RemoteException;

    Event findEventByDate(GregorianCalendar dateEvent) throws RemoteException;

}
