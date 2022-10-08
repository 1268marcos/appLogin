package br.com.profdigital.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextCredentials, mEditTextPassword;
    private Button mButtonSignIn;

    private boolean isRequired(){
        if(TextUtils.isEmpty(mEditTextCredentials.getText()) ||
                TextUtils.isEmpty(mEditTextPassword.getText())) {
            return true;
        } else {
            return false;
        }
    }

    private void performNextActivity(){
        if(isRequired()){
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            /* New version
            String mTextMessage = getString(R.string.text_error_fill_mandatory_information);
            Toast.makeText(this, mTextMessage, Toast.LENGTH_SHORT).show();
            */
            return;
        }

        Toast.makeText(this, "Be welcome", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, StartActivity.class));

    }

    public class ClickButtonSignIn implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            performNextActivity();
        }
    }

    public class EditTextAction implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
           if(actionId == EditorInfo.IME_ACTION_DONE){
               performNextActivity();
           }
           return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextCredentials = findViewById(R.id.editText_credentials);

        mEditTextPassword = findViewById(R.id.editText_password);
        mEditTextPassword.setOnEditorActionListener(new EditTextAction());

        mButtonSignIn = findViewById(R.id.button_sign_in);
        mButtonSignIn.setOnClickListener(new ClickButtonSignIn());

    }

}