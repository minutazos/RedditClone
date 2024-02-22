package com.epitech.redditech.Controllers.Login;

import android.content.Intent;

public interface ILoginController {

    Intent openRedditLogin();
    void onLogin(String code);
    void onDestroy();
}
