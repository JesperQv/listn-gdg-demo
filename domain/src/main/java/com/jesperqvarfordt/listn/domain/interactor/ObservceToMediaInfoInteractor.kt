package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.model.player.MediaInfo
import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Observable
import io.reactivex.Scheduler

class ObservceToMediaInfoInteractor(private val player: MusicPlayer,
                                    executionScheduler: Scheduler,
                                    uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    fun execute(): Observable<MediaInfo> = player.mediaInfoObservable
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}