package com.siliconvalleyinsight.mwork.singletons;

import android.app.Application;

/**
 * Created by johnys on 12/3/14.
 * This is a subclass of the standard application that adds state management
 * for the mWork application.
 *
 * Note: This is only for the lifescycle of the app - it is NOT persistent
 * across life cycles (our login is therefore a "wizard of oz" technique).
 */
public class MWorkApp extends Application {
    private MWorkStateManager mWorkStateManager = new MWorkStateManager();

    public MWorkStateManager getStateManager() {
        return mWorkStateManager;
    }
}
