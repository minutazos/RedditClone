package com.epitech.redditech.Views.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.epitech.redditech.App;
import com.epitech.redditech.Controllers.Login.ILoginController;
import com.epitech.redditech.Controllers.Login.LoginController;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Home.HomeActivity;


public class LoginActivity extends AppCompatActivity implements ILoginView {

    private static final String TAG = LoginActivity.class.getName();
    ILoginController controller = new LoginController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(view -> initLoginBtn());
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent() != null && getIntent().getAction().equals(Intent.ACTION_VIEW)) {
            Uri uri = getIntent().getData();

            if (uri.getQueryParameter("error") != null) {
                String error = uri.getQueryParameter("error");
                Log.e(TAG, "An error has ocurred: " + error);
            } else {
                String state = uri.getQueryParameter("state");
                // We check that the sign in belongs to us
                if (state.equals(NetworkClientInstance.STATE)) {
                    String code = uri.getQueryParameter("code");
                    Log.d(TAG, "OAuth2 code retrieved: " + code);
                    controller.onLogin(code);
                }
            }
        }
    }


    private void initLoginBtn() {
        startActivity(controller.openRedditLogin());
    }

    public void onLoginFailure(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.getContext(), "PROBLEMS DURING LOGIN!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onLoginSuccess() {
        startActivity(new Intent(getBaseContext(), HomeActivity.class));
        finish();
    }

    @Override
    public void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }
}
