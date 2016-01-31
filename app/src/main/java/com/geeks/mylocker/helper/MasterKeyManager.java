package com.geeks.mylocker.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.geeks.mylocker.Config;
import com.geeks.mylocker.encrypto.Encryptor;

import java.util.UUID;

/**
 * manage key with single Preference storage.
 * Created by dspark on 1/30/16.
 */

public class MasterKeyManager {

    protected final String TAG = getClass().getSimpleName();

    private final static String MASTER_KEY = "MASTER_KEY";

    private Context context;

    private final SharedPreferences prefs;

    private Encryptor encryptor;

    private UUID systemKey;

    public MasterKeyManager(Context context) {

        this.context = context;

        DeviceUuidFactory uuidFactory = new DeviceUuidFactory(context);
        this.systemKey = uuidFactory.getDeviceUuid();

        encryptor = Encryptor.select(Encryptor.PADDING_ENC_IDX);
        prefs = context.getSharedPreferences(Config.APP_PREF, 0);

    }

    public boolean put(String key) {

        String encryptedKey = encryptor.encrypt(key, systemKey.toString());
        return prefs.edit().putString(MASTER_KEY, encryptedKey).commit();

    }

    public boolean remove() {
        return prefs.edit().remove(MASTER_KEY).commit();
    }

    public String get() {
        String encryptedKey = prefs.getString(MASTER_KEY, null);
        return encryptor.decrypt(encryptedKey, systemKey.toString());

    }

    public boolean hasMasterKey() {
        String encryptedKey = prefs.getString(MASTER_KEY, null);
        return encryptedKey == null ? Boolean.FALSE : Boolean.TRUE;
    }
}
