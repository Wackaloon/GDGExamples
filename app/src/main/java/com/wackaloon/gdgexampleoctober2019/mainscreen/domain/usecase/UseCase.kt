package com.wackaloon.gdgexampleoctober2019.mainscreen.domain.usecase

import com.wackaloon.gdgexampleoctober2019.mainscreen.domain.repository.Repository

class UseCase(private val repository: Repository) {

    fun doStuff() {
        repository.uploadSomething()
    }
}
