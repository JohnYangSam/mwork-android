package com.siliconvalleyinsight.mwork.singletons;

/**
 * Created by johnys on 12/3/14.
 */
public class MWorkStateManager {
    private boolean mLogin;

    // Fast initialization
    MWorkStateManager() {
        mLogin = false;
    }

    // Longer Initialization here (lazy init) if we needed it
    public boolean getLogin() {
        return mLogin;
    }

    public void setLogin(boolean state) {
        mLogin = state;
    }
}
