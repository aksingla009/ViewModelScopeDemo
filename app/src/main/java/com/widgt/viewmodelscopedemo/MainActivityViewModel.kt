package com.widgt.viewmodelscopedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    private var userRepo = UserRepository()
    private var users : MutableLiveData<List<User>> = MutableLiveData()

    val usersData : LiveData<List<User>>
    get() = users

    fun getUsers() {
        viewModelScope.launch {
            var result : List<User> ? = null
            withContext(Dispatchers.IO){
                result = userRepo.getUserResponse()
            }
            users.postValue(result)
        }
    }

}