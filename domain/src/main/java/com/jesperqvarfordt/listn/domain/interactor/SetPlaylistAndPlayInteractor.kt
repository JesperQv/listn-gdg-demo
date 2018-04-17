package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.model.Track
import com.jesperqvarfordt.listn.domain.player.MusicPlayer
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Completable
import io.reactivex.Scheduler

class SetPlaylistAndPlayInteractor(private val player: MusicPlayer,
                                executionScheduler: Scheduler,
                                uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    fun execute(playlist: List<Track>): Completable = player.setPlaylistAndPlay(playlist)
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}