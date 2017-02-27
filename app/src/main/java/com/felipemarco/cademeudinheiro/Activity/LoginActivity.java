package com.felipemarco.cademeudinheiro.activity;

import android.os.Bundle;
import android.view.View;

import com.felipemarco.cademeudinheiro.R;
import com.felipemarco.cademeudinheiro.domain.FormProblemException;
import com.felipemarco.cademeudinheiro.web.WebLogin;

public class LoginActivity extends BaseActivity {

    private final int MIN_PASSWORD = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){

        hideKeyboard();

        try{
            checkEmail();
            checkPassword();
        } catch (FormProblemException e){
            showAlert(e.getMessage());
            return;
        }

        String password = getStringFromEdit(R.id.editTextSenha);
        String email = getStringFromEdit(R.id.editTextEmail);

        showDialogWithMessage(getString(R.string.load_login));

        tryLogin(password,email);
    }

    private void checkPassword() throws FormProblemException{
        String password = getStringFromEdit(R.id.editTextSenha);
        if("".equals(password)){
            throw new FormProblemException(getString(R.string.error_password_empty));
        }

        if (password.length() < MIN_PASSWORD){
            throw new FormProblemException(getString(R.string.error_password_small));
        }
    }

    private void checkEmail() throws FormProblemException{
        String email = getStringFromEdit(R.id.editTextEmail);
        if("".equals(email)){
            throw new FormProblemException(getString(R.string.error_password_empty));
        }
    }

    private void tryLogin(String password, String email) {
        WebLogin webLogin = new WebLogin(email,password);
        webLogin.call();
    }
}
