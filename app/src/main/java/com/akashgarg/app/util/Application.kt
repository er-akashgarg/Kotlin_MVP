package com.akashgarg.app.util

import android.app.Application
import android.content.Context

/**
 * Created by AkashGarg on 9/11/2018.
 */

open class Application : Application() {
    var context: Context? = null

    private object Holder {
        val INSTANCE = Application()
    }

    companion object {
        val instance = Application by lazy { Holder.INSTANCE }

        private infix fun by(lazy: Lazy<Application>): Any {
            return lazy
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}
