package com.example.myapplication.main.login;

import com.example.myapplication.base.IPresenter;

public class LoginPresenter implements IPresenter<ILoginView>, ILoginPresenter {
    //sebagai context
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public ILoginView getiLoginView() {
        return iLoginView;
    }

    public void setiLoginView(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    //IPresenter
    @Override
    public void onAttach(ILoginView view) {
        iLoginView = view;
        //open db, dll
    }

    //IPresenter
    @Override
    public void onDetach() {
        iLoginView = null;
        //close db, dll
    }

    //ILogin Presenter
    @Override
    public void loginPresenter(String email, String passsword) {
        if (email.equals("admin") && passsword.equals("admin")) {
            iLoginView.loginBerhasil();
        }else{
            iLoginView.loginGagal();
        }
    }
}
