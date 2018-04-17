package com.jesperqvarfordt.listn.musicplayer.di

import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.di.component.AppComponent
import com.jesperqvarfordt.listn.explore.ExploreFragment
import com.jesperqvarfordt.listn.explore.di.TracksModule
import dagger.Component

@ViewScope
@Component(dependencies = [AppComponent::class], modules = [TracksModule::class])
interface TracksComponent {
    fun inject(fragment: ExploreFragment)
}