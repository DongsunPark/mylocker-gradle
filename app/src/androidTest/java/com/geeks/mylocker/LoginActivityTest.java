package com.geeks.mylocker;

import android.app.Activity;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import com.geeks.mylocker.helper.DeviceUuidFactory;
import com.geeks.mylocker.helper.MasterKeyManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by dspark on 1/29/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class LoginActivityTest {

    protected final String TAG = getClass().getSimpleName();

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    Context context;

    Activity self;

    @Before
    public void setUp() throws Exception {
        context = mActivityRule.getActivity().getBaseContext();
        self = mActivityRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOnCreate() throws Exception {
        DeviceUuidFactory uuidFactory = new DeviceUuidFactory(context);
        UUID uuid = uuidFactory.getDeviceUuid();
        Assert.assertNotNull(uuid);
    }

    @Test
    public void testMasterKeyManager() {
        //DeviceUuidFactory uuidFactory = new DeviceUuidFactory(context);
        //UUID systemKey = uuidFactory.getDeviceUuid();

        String key = "test";
        MasterKeyManager keyManager = new MasterKeyManager(self.getApplicationContext());
        keyManager.put(key);
        String key2 = keyManager.get();
        Assert.assertEquals(key,key2);

    }

    @Test
    public void testOnPause() throws Exception {

    }
}