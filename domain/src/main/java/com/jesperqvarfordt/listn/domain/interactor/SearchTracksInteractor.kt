package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.model.Track
import com.jesperqvarfordt.listn.domain.repository.TrackRepository
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Observable
import io.reactivex.Scheduler

class SearchTracksInteractor(private val repository: TrackRepository,
                          executionScheduler: Scheduler,
                          uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    fun execute(query: String): Observable<List<Track>> = repository.search(query)
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}