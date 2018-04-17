package com.jesperqvarfordt.listn.common.view.miniplayer.di

import com.jesperqvarfordt.listn.common.view.miniplayer.MiniPlayer
import com.jesperqvarfordt.listn.di.component.AppComponent
import com.jesperqvarfordt.listn.di.ViewScope
import dagger.Component

@ViewScope
@Component(dependencies = [(AppComponent::class)], modules = [(MiniPlayerModule::class)])
interface MiniPlayerComponent {
    fun inject(view: MiniPlayer)
}