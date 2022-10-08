package br.com.profdigital.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

    }
}

//https://stackoverflow.com/questions/30684613/android-studio-xml-editor-autocomplete-not-working-with-support-libraries