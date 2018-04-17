package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.model.Chart
import com.jesperqvarfordt.listn.domain.model.Track
import com.jesperqvarfordt.listn.domain.repository.TrackRepository
import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import io.reactivex.Observable
import io.reactivex.Scheduler

open class GetTracksOnChartInteractor(private val trackRepository: TrackRepository,
                                   executionScheduler: Scheduler,
                                   uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    open fun execute(chart: Chart): Observable<List<Track>> =
            trackRepository.getTracksOnChart(chart.topTracksUrl)
                    .subscribeOn(executionScheduler)
                    .observeOn(postExecutionSchedulers)
}