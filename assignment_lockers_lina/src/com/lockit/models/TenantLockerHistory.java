package com.lockit.models;

import java.time.LocalDateTime;
import java.util.Random;

public class TenantLockerHistory {
    private LocalDateTime lockedAt;
    private LocalDateTime expectedLockedUntil;
    private Tenant tenant;
    private Locker locker;
    private String password;

    //Setters
    public void setLockedAt(LocalDateTime lockedAt) {
        this.lockedAt = lockedAt;
    }
    public void setExpectedLockedUntil(LocalDateTime expectedLockedUntil) {
        this.expectedLockedUntil = expectedLockedUntil;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public String setPassword(){
        int combinationLength = 4;
        Random rn = new Random();
        String combination = "";
        for(int i =0; i < combinationLength; i++){
            int answer = rn.nextInt(10) + 1;
            combination += answer;

        }
        this.password = combination;
        System.out.println("Password to lock " + this.getLocker().getId() + " : " + combination);
        return combination;
    }

    //Getters
    public LocalDateTime getLockedAt() {
        return lockedAt;
    }
    public LocalDateTime getExpectedLockedUntil() {
        return expectedLockedUntil;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public Locker getLocker() {
        return locker;
    }
    public String getPassword(){
        return password;
    }
}
