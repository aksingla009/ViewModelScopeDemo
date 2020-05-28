package com.widgt.viewmodelscopedemo

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUserResponse() : List<User>{
        delay(8000)

        val users : List<User> = listOf(
            User(1,"Aman"),
            User(2,"Raman"),
            User(3,"Gagan"),
            User(4,"Mani")
        )

        return users

    }
}