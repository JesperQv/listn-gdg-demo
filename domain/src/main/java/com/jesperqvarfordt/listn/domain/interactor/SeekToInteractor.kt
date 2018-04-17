package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Completable
import io.reactivex.Scheduler

open class SeekToInteractor(private val player: MusicPlayer,
                    executionScheduler: Scheduler,
                    uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    open fun execute(pos: Long): Completable = player.seekTo(pos)
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}