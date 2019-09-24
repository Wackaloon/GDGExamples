package com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp

interface View

interface Presenter {
    fun onStart(view: View)

    fun onButtonClicked()
}
