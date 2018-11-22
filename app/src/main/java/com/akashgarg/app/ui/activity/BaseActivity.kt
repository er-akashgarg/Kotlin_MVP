package com.akashgarg.app.ui.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.akashgarg.app.util.Consts
import com.akashgarg.app.util.NetworkUtils
import com.akashgarg.app.util.callback.NetworkCallback

/**
 * Created by AkashGarg on 9/11/2018.
 */


abstract class BaseActivity : AppCompatActivity(), NetworkCallback {
    var networkBroadcast: BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        layoutAdded(savedInstanceState)
    }

    abstract fun layoutAdded(savedInstanceState: Bundle?)

    abstract fun setLayout(): Int

    abstract fun onNetworkChange(isConnected: Boolean)

    override fun networkChange(isConnected: Boolean) {
        onNetworkChange(isConnected)
    }

    override fun onStart() {
        super.onStart()
        registerNetworkBroadcast()
    }

    fun registerNetworkBroadcast() {
        networkBroadcast = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                networkChange(NetworkUtils.isNetworkConnected(context))
            }
        }
        try {
            LocalBroadcastManager.getInstance(this).registerReceiver(networkBroadcast as BroadcastReceiver, IntentFilter(Consts.NETWORK_BR))
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    fun getText(editText: EditText?): String {
        return editText?.text.toString().trim()
    }

}
