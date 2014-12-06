package com.siliconvalleyinsight.mwork.singletons;

/**
 * Created by johnys on 12/3/14.
 */
public class MWorkStateManager {
    private boolean mLogin;
    private double mBalance;
    private int mTasksCompleted;

    private Profile mProfile;

    private class Profile {
        public String language;
        public int age;
        public String City;
        public String State;
        public String Country;
    }

    // Fast initialization
    MWorkStateManager() {
        mLogin = false;
        mBalance = 0;
        mTasksCompleted = 0;

    }

    // Longer Initialization here (lazy init) if we needed it
    public boolean getLogin() {
        return mLogin;
    }
    public void setLogin(boolean state) {
        mLogin = state;
    }

    public double getBalance() {
        return mBalance;
    }
}
