package com.zoom_machine.jetpack_compose_custom_view.di

import com.zoom_machine.jetpack_compose_custom_view.view_models.RickMortyViewModel
import dagger.Component

@Component(
    modules = [ScreenCartoonModule::class]
)
@ScreenCartoonScope
interface ScreenCartoonComponent {

    @Component.Builder
    interface Builder {
        fun build():ScreenCartoonComponent
    }

    fun getViewModel():RickMortyViewModel
}