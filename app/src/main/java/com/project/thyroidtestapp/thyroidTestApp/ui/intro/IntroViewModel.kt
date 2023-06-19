package com.project.thyroidtestapp.thyroidTestApp.ui.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class IntroViewModel:ViewModel() {
    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    private val _isSigninEnable = MutableLiveData<Boolean>()
    val isSigninEnable:LiveData<Boolean> = _isSigninEnable


}