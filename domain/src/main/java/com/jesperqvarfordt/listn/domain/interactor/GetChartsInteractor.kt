package com.jesperqvarfordt.listn.domain.interactor

import com.jesperqvarfordt.listn.domain.interactor.base.Interactor
import com.jesperqvarfordt.listn.domain.model.Chart
import com.jesperqvarfordt.listn.domain.repository.ChartRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

open class GetChartsInteractor(private val chartRepository: ChartRepository,
                            executionScheduler: Scheduler,
                            uiScheduler: Scheduler) : Interactor(executionScheduler, uiScheduler) {

    open fun execute(): Observable<List<Chart>> = chartRepository.getCharts()
            .subscribeOn(executionScheduler)
            .observeOn(postExecutionSchedulers)
}