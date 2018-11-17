package com.akashgarg.app.presentor.inteceptor.impl

import android.os.Handler
import com.akashgarg.app.presentor.inteceptor.AuthenticateInterceptor

/**
 * Created by AkashGarg on 9/11/2018.
 */
class AuthenticateInterceptorImpl : AuthenticateInterceptor {
    override fun validateUser(userName: String, userPass: String, listner: AuthenticateInterceptor.AuthenticateServiceCompleteListener) {
        Handler().postDelayed({
            when {
                userName.isEmpty() -> listner.onUserNameFailure()
                userPass.isEmpty() -> listner.onUserPassFailure()
                else -> listner.onSuccess()
            }
        }, 500)
    }
}