package com.lockit.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Wall {
    private String name;
    private List<Locker> lockers = new ArrayList<Locker>();
    private List<TenantLockerHistory> tenantLockersHistory = new ArrayList<TenantLockerHistory>();

    //Constructor
    public Wall(String name) {
        this.name = name;
    }

    //Untils
    private String generateUniqueId(Locker locker){
        return locker.getXAxis() + "" + locker.getYAxis();
    }
    public int getWallHeight(){
        return this.lockers.stream().max(Comparator.comparingInt(Locker::getYAxis)).get().getYAxis();
    }
    public int getWallWidth(){
        return this.lockers.stream().max(Comparator.comparingInt(Locker::getXAxis)).get().getXAxis();
    }


    public String printWall(){
        StringBuilder result = new StringBuilder();
        for(int i = 1; i <= this.getWallWidth(); i++){

            for(int j = 1; j <= this.getWallHeight(); j++){

                result.append(i + "" + j + " ");

                if(j == this.getWallHeight()) {
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
    public String printWall(boolean withStatus){
        StringBuilder result = new StringBuilder();
        if(withStatus){
            for(int i = 1; i <= this.getWallWidth(); i++){

                for(int j = 1; j <= this.getWallHeight(); j++){
                    result.append(i + "" + j );

                    for (Locker locker : this.lockers){
                        if(locker.getYAxis() == j && locker.getXAxis() == i){
                            if(locker.getLocked()){
                                result.append(" <- status: Locked ");
                                for(TenantLockerHistory history : tenantLockersHistory){
                                    if(history.getLocker().getXAxis() == j && locker.getYAxis() == i){
                                        result.append("till approximately: " + history.getExpectedLockedUntil().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " | ");
                                    }
                                }
                            }else{
                                result.append(" <- status: unlocked | ");
                            }
                        }
                    }



                    if(j == this.getWallHeight()) {
                        result.append("\n");
                    }
                }
            }
            return result.toString();
        }else{
            return this.printWall();
        }
        // 11 - 21 - 31
        // 12 - 22 - 32
        // 13 - 23 - 33
    }

    //Setters
    //Validate x and y axis
    public void addLocker(Locker locker){
        //Generate id
        locker.setId(this.generateUniqueId(locker));

        this.lockers.add(locker);
    }
    public void removeLocker(Locker locker){
        this.lockers.remove(locker);
    }

    public String addLockerReservation(
            LocalDateTime lockedAt,
            LocalDateTime ExpectedLockedUntil,
            Tenant tenant,
            String lockerId
    )
    {
        TenantLockerHistory lockerOccupied = new TenantLockerHistory();
        lockerOccupied.setLockedAt(lockedAt);
        lockerOccupied.setExpectedLockedUntil(ExpectedLockedUntil);
        lockerOccupied.setTenant(tenant);

        for (Locker locker : this.lockers){
            if(locker.getId().equals(lockerId)){
                lockerOccupied.setLocker(locker);
                locker.setLocked(true);
            }
        }
        String password = lockerOccupied.setPassword();
        //Locker selectedLocker = this.lockers.stream().filter(locker -> locker.getId() == lockerId).findAny().orElse(null);

        this.tenantLockersHistory.add(lockerOccupied);
        return password;
    }

    public void openLocker(String lockerId, String password){
        //get locker with the latest time stampt that is locked
        List<TenantLockerHistory> listOfLockerWithGivenId = new ArrayList<TenantLockerHistory>();
        for(TenantLockerHistory lockerHistory : this.tenantLockersHistory){
            if(lockerHistory.getLocker().getId().equals(lockerId)){
                listOfLockerWithGivenId.add(lockerHistory);
            }
        }
        TenantLockerHistory latestLocker = listOfLockerWithGivenId.stream().max(Comparator.comparing(TenantLockerHistory::getLockedAt)).get();

        if(latestLocker.getPassword().equals(password)){
            System.out.println("Password: [" + password + "] is correct");
            latestLocker.getLocker().setLocked(false);
        }else{
            System.out.println("Wrong password: [" + password + "]");
        }
    }

    //Getters
    private List<Locker> getAllOccupiedLockers(){
        return null;
    }
}
