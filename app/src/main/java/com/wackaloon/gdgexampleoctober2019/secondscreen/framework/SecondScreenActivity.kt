package com.wackaloon.gdgexampleoctober2019.secondscreen.framework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wackaloon.gdgexampleoctober2019.R
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp.View
import kotlinx.android.synthetic.main.activity_main.*

class SecondScreenActivity : AppCompatActivity(), View {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SecondScreenActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setText("General Kenobi...")
    }
}
