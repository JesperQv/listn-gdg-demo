package com.jesperqvarfordt.listn.domain.interactor.base

import io.reactivex.Scheduler

abstract class Interactor(protected val executionScheduler: Scheduler,
                       protected val postExecutionSchedulers: Scheduler)