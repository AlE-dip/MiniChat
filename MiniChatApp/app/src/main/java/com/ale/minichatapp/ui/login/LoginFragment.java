package com.ale.minichatapp.ui.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.ale.minichatapp.databinding.FragmentLoginBinding;
import com.ale.minichatapp.handler.ApiUtils;
import com.ale.minichatapp.handler.LoginService;
import com.ale.minichatapp.mapper.AuthRequest;
import com.ale.minichatapp.mapper.UserView;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;
    private LoginService loginService;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        loginService = ApiUtils.getLoginService();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        observeData();
        initializationAction();
    }

    private void observeData() {
//        loginViewModel.username.observe(getViewLifecycleOwner(), username -> {
//            if(!username.equals(binding.username.getText().toString().trim())) {
//                binding.username.setText(username);
//            }
//        });
    }

    private void initializationAction() {
        binding.username.addTextChangedListener(getTextWatcher(loginViewModel.username));
        binding.password.addTextChangedListener(getTextWatcher(loginViewModel.password));
        binding.login.setOnClickListener(view -> {
            AuthRequest authRequest = new AuthRequest(
                    binding.username.getText().toString().trim(),
                    binding.password.getText().toString().trim()
            );
            loginService.login(authRequest)
                    .enqueue(new Callback<UserView>() {
                        @Override
                        public void onResponse(Call<UserView> call, Response<UserView> response) {
                            if (response.isSuccessful()) {
                                Gson gson = new Gson();
                                String json = gson.toJson(response.body());
                                Log.d("MainActivity", json);
                            } else {
                                int statusCode = response.code();
                                // handle request errors depending on status code
                            }
                        }

                        @Override
                        public void onFailure(Call<UserView> call, Throwable t) {
                            Log.d("MainActivity", "error loading from API");
                            t.printStackTrace();
                        }
                    });
        });
    }

    private TextWatcher getTextWatcher(MutableLiveData<String> mutableLiveData) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals(mutableLiveData.getValue())) {
                    mutableLiveData.setValue(editable.toString().trim());
                }
            }
        };
    }
}