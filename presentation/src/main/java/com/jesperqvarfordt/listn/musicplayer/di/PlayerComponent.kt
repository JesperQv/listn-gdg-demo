package com.jesperqvarfordt.listn.musicplayer.di

import com.jesperqvarfordt.listn.di.component.AppComponent
import com.jesperqvarfordt.listn.di.ViewScope
import com.jesperqvarfordt.listn.musicplayer.PlayerActivity
import dagger.Component

@ViewScope
@Component(dependencies = [(AppComponent::class)], modules = [(PlayerModule::class)])
interface PlayerComponent {
    fun inject(activity: PlayerActivity)
}