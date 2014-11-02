package com.calendar.common;

/**
 * Created by Aleksey on 01.11.2014.
 */
public class Person {

    // Initial variables
    private final String firstName;
    private final String secondName;
    private final String phone;
    private final String email;

    // Constructor
    private Person(Builder builder){
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    // GET classes
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
        if (secondName != null ? !secondName.equals(person.secondName) : person.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{

        private String firstName;
        private String secondName;
        private String phone;
        private String email;

        public Builder(){

        }

        public Builder(Person original) {
            this.firstName = original.firstName;
            this.secondName = original.secondName;
            this.phone = original.phone;
            this.email = original.email;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
