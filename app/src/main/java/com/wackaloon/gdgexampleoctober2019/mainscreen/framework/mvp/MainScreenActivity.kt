package com.wackaloon.gdgexampleoctober2019.mainscreen.framework.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wackaloon.gdgexampleoctober2019.R
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp.Presenter
import com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp.View
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainScreenActivity : AppCompatActivity(), View {

    private val presenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            presenter.onButtonClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart(this)
    }
}
