package com.test;

public class Student {
    private final int fId;
    private final String fName;

    public Student(int id, String name) {
        fId = id;
        fName = name;
    }

    public int getId() {
        return fId;
    }

    public String getName() {
        return fName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((Student) obj).getId();
    }
}
