package com.geeks.mylocker.test;

import com.geeks.mylocker.helper.DeviceUuidFactory;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by dspark on 1/26/16.
 */
public class DeviceUuidFactoryTest {

    @Test
    public void testGetDeviceId() {
        DeviceUuidFactory uuidFactory = new DeviceUuidFactory(null);
        UUID uuid = uuidFactory.getDeviceUuid();
    }
}
