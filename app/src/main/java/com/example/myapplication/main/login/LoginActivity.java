package com.example.myapplication.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.main.home.Welcome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {
    private LoginPresenter loginPresenter;

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents(Bundle savedInstanceState) {
        loginPresenter = new LoginPresenter(this);
        onAttachView();
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        loginPresenter.loginPresenter(name.getText().toString(), pass.getText().toString());
    }

    @Override
    public void loginGagal() {
        Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginBerhasil() {
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Welcome.class));
    }

    @Override
    public void onAttachView() {
        loginPresenter.onAttach(this);
    }

    @Override
    public void onDetachhView() {
        loginPresenter.onDetach();
    }
}
