package org.mm.thoracalling;

public class PrayerNotFoundException extends RuntimeException {
    static final long serialVersionUID = 1;
 
    public PrayerNotFoundException(){
        super();
    }

    public PrayerNotFoundException(String message){
        super(message);
    }

    public PrayerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}