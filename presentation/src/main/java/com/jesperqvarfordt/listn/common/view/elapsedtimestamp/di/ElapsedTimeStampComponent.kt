package com.jesperqvarfordt.listn.common.view.elapsedtimestamp.di

import com.jesperqvarfordt.listn.common.view.elapsedtimestamp.ElapsedTimeStamp
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.di.component.AppComponent
import dagger.Component

@ViewScope
@Component(dependencies = [AppComponent::class], modules = [ElapsedTimeStampModule::class])
interface ElapsedTimeStampComponent {
    fun inject(view: ElapsedTimeStamp)
}