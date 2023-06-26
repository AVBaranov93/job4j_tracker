package ru.job4j;

public class Checkstyle {

    public static final String NEWVALUE = "";
    private String surName;
    private String name;
    private int sizeOfEmpty = 10;

    public Checkstyle() {
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeOfEmpty() {
        return sizeOfEmpty;
    }

    public void setSizeOfEmpty(int sizeOfEmpty) {
        this.sizeOfEmpty = sizeOfEmpty;
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }

}