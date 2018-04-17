package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import io.reactivex.Completable
import io.reactivex.Scheduler

open class PauseInteractor(private val player: MusicPlayer,
                        executionScheduler: Scheduler,
                        uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    open fun execute(): Completable = player.pause()
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}