package com.geeks.mylocker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.geeks.mylocker.encrypto.Encryptor;
import com.geeks.mylocker.helper.DeviceUuidFactory;
import com.geeks.mylocker.helper.MasterKeyManager;

import java.util.UUID;

public class RegistrationActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void onRegisterClicked(View view) {
        Log.i(TAG, view.toString());
        validateAndSaveMasterKey();
    }

    private void validateAndSaveMasterKey() {

        EditText  masterKey = (EditText) findViewById(R.id.master_key);
        EditText  comfirmKey = (EditText) findViewById(R.id.comfirm_key);

        String key = masterKey.getText().toString();
        String repeatedKey = comfirmKey.getText().toString();
        if(key.equals(repeatedKey)) {
            DeviceUuidFactory uuidFactory = new DeviceUuidFactory(self.getApplicationContext());
            UUID systemKey = uuidFactory.getDeviceUuid();

            MasterKeyManager keyManager = new MasterKeyManager(self.getApplicationContext());
            if(keyManager.put(key)) {
                Toast.makeText(self, "successful registration", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, LoginActivity.class);
                this.startActivity(intent);
            }
        } else{
            Toast.makeText(self, "keys does not match with each others.", Toast.LENGTH_LONG).show();
        }
    }
}
