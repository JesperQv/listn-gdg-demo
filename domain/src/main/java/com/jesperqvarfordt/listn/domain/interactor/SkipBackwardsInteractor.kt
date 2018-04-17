package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Completable
import io.reactivex.Scheduler

class SkipBackwardsInteractor(private val player: MusicPlayer,
                           executionScheduler: Scheduler,
                           uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    fun execute(): Completable = player.skipBackwards()
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}