package com.lockit;

import com.lockit.models.Locker;
import com.lockit.models.Tenant;
import com.lockit.models.TenantLockerHistory;
import com.lockit.models.Wall;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;


//als een gebruiker wil ik de locker kunnen sluiten
//als een gebruiker wil ik de locker kunnen openen met een wachtwoord
//als een gebruiker wil ik overzichtelijk kunnen zien welke lockers bezet zijn
//als een gebruiker wil ik een wachtwoord ontvangen wanneer ik mijn locker sluit deze moet random zijn
//als een gebruiker wil ik
public class Main {


    public static void main(String[] args) {
        //Generate wall
        Wall wall = new Wall("Fontys");

        //Generate lockers
        // First row
        Locker lockerA1 = new Locker();
        lockerA1.setXAxis(1);
        lockerA1.setYAxis(1);

        Locker lockerA2 = new Locker();
        lockerA2.setXAxis(1);
        lockerA2.setYAxis(2);

        Locker lockerA3 = new Locker();
        lockerA3.setXAxis(1);
        lockerA3.setYAxis(3);

        wall.addLocker(lockerA1);
        wall.addLocker(lockerA2);
        wall.addLocker(lockerA3);

        // Second row
        Locker lockerB1 = new Locker();
        lockerB1.setXAxis(2);
        lockerB1.setYAxis(1);

        Locker lockerB2 = new Locker();
        lockerB2.setXAxis(2);
        lockerB2.setYAxis(2);

        Locker lockerB3 = new Locker();
        lockerB3.setXAxis(2);
        lockerB3.setYAxis(3);

        wall.addLocker(lockerB1);
        wall.addLocker(lockerB2);
        wall.addLocker(lockerB3);

        // Second row
        Locker lockerC1 = new Locker();
        lockerC1.setXAxis(3);
        lockerC1.setYAxis(1);

        Locker lockerC2 = new Locker();
        lockerC2.setXAxis(3);
        lockerC2.setYAxis(2);

        Locker lockerC3 = new Locker();
        lockerC3.setXAxis(3);
        lockerC3.setYAxis(3);

        wall.addLocker(lockerC1);
        wall.addLocker(lockerC2);
        wall.addLocker(lockerC3);

        //Printing the wall
        System.out.println(wall.printWall(true));

        //Create a tenant
        Tenant tenant = new Tenant();
        tenant.setName("Rik Peeters");

        //Occupies a locker
        String password = wall.addLockerReservation(
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                tenant,
                "11"
                );

        System.out.println(wall.printWall(true));

        wall.openLocker("11", "1202");
        wall.openLocker("11", password);

        System.out.println(wall.printWall(true));
    }
}
