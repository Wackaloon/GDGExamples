package com.wackaloon.gdgexampleoctober2019.mainscreen.data.mvp

import com.wackaloon.gdgexampleoctober2019.mainscreen.data.navigation.Navigator
import com.wackaloon.gdgexampleoctober2019.mainscreen.domain.usecase.UseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PresenterImpl(
    private val useCase: UseCase,
    private val navigator: Navigator
) : Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main

    private lateinit var view: View

    override fun onStart(view: View) {
        this.view = view
    }

    override fun onButtonClicked() {
        launch {
            useCase.doStuff()
            delay(5000)
            navigator.openSecondScreenAtAnyCost()
        }
    }
}
