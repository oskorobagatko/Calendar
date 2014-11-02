package com.calendar.common;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Aleksey on 01.11.2014.
 */
public class Event {

    private final String name;
    private final String description;
    private final GregorianCalendar startTime;
    private final GregorianCalendar endTime;
    private final List<Person> attenders;
    private final UUID uuid;

    private Event (Builder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.attenders = builder.attenders;
        this.uuid = builder.uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (endTime != null ? !endTime.equals(event.endTime) : event.endTime != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (startTime != null ? !startTime.equals(event.startTime) : event.startTime != null) return false;
        if (uuid != null ? !uuid.equals(event.uuid) : event.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", attenders=").append(attenders);
        sb.append(", uuid=").append(uuid);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{

        private String name;
        private String description;
        private GregorianCalendar startTime;
        private GregorianCalendar endTime;
        private List<Person> attenders;
        private UUID uuid;

        public Builder(){

        }

        public Builder(Event original) {
            this.name = original.name;
            this.description = original.description;
            this.startTime = original.startTime;
            this.endTime = original.endTime;
            this.attenders = original.attenders;
            this.uuid = original.uuid;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder startTime(GregorianCalendar startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(GregorianCalendar endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder attenders(List<Person> attenders) {
            this.attenders = attenders;
            return this;
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }
}
