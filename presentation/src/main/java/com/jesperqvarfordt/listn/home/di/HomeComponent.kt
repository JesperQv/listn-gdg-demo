package com.jesperqvarfordt.listn.home.di

import com.jesperqvarfordt.listn.di.component.AppComponent
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.home.HomeActivity
import dagger.Component

@ViewScope
@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
interface HomeComponent {
    fun inject(activity: HomeActivity)
}