package com.akashgarg.app.ui.activity

import android.content.Intent
import android.os.Handler
import com.akashgarg.app.R

/**
 * Created by AkashGarg on 9/11/2018.
 */
class LauncherActivity : android.support.v7.app.AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        Handler().postDelayed({
            val intent = Intent(this, AuthenticateActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}
