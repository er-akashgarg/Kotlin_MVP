package com.akashgarg.app.presentor.presentor.impl

import com.akashgarg.app.presentor.inteceptor.AuthenticateInterceptor
import com.akashgarg.app.presentor.inteceptor.impl.AuthenticateInterceptorImpl
import com.akashgarg.app.presentor.presentor.AuthenticatePresentor
import com.akashgarg.app.view.AuthenticateView

/**
 * Created by AkashGarg on 9/11/2018.
 */
class AuthenticatePresentorImpl : AuthenticatePresentor, AuthenticateInterceptor.AuthenticateServiceCompleteListener {

    var authInterceptor: AuthenticateInterceptorImpl? = null
    var authView: AuthenticateView? = null

    constructor(authView: AuthenticateView) {
        this.authView = authView
        authInterceptor = AuthenticateInterceptorImpl()
    }

    override fun validate(userName: String, userPass: String) {
        authView?.showProgress()
        authInterceptor?.validateUser(userName, userPass, this)
    }

    override fun onFailure() {
        authView?.hideProgress()
    }

    override fun onSuccess() {
        authView?.hideProgress()
        authView?.navigate()
    }

    override fun onUserNameFailure() {
        authView?.hideProgress()
        authView?.onUserNameError()
    }

    override fun onUserPassFailure() {
        authView?.hideProgress()
        authView?.onUserPassError()
    }
}