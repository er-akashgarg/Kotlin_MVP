package com.akashgarg.app.view

/**
 * Created by AkashGarg on 9/11/2018.
 */
interface AuthenticateView {
    fun onUserNameError()
    fun onUserPassError()
    fun showProgress()
    fun hideProgress()
    fun navigate()
}