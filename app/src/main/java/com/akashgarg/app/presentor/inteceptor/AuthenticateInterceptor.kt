package com.akashgarg.app.presentor.inteceptor

/**
 * Created by AkashGarg on 9/11/2018.
 */

interface AuthenticateInterceptor {

    interface AuthenticateServiceCompleteListener {
        fun onSuccess()
        fun onFailure()
        fun onUserNameFailure()
        fun onUserPassFailure()
    }

    fun validateUser(userName: String, userPass: String, listner: AuthenticateServiceCompleteListener)
}
