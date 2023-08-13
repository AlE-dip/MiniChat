package com.ale.minichatapp.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    MutableLiveData<String> username = new MutableLiveData<>("");
    MutableLiveData<String> password = new MutableLiveData<>("");
}