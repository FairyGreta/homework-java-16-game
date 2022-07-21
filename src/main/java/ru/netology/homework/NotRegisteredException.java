package ru.netology.homework;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException (String s) {
        super(s);
    }
}
