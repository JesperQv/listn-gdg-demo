package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.model.player.PlayerInfo
import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Observable
import io.reactivex.Scheduler

open class ObserveToPlayerInfoInteractor(private val player: MusicPlayer,
                                         executionScheduler: Scheduler,
                                         uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    open fun execute(): Observable<PlayerInfo> = player.playerInfoObservable
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}