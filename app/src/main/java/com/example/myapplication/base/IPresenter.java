package com.example.myapplication.base;

//digunakan untuk memproses dibackground
public interface IPresenter<T extends IView> {
    void onAttach(T view);
    void onDetach();
}
