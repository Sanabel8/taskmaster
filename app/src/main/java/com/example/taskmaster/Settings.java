package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        Button saveUsernameButton = findViewById(R.id.settingUsernameButton);
        saveUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_LONG).show();
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.this);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

                EditText usernameField = findViewById(R.id.usernameField);
                String username = usernameField.getText().toString();

                sharedPreferencesEditor.putString("username", username);
                sharedPreferencesEditor.apply();

                Intent toHome = new Intent(Settings.this,MainActivity.class);
                startActivity(toHome);
            }
        });
    }

}