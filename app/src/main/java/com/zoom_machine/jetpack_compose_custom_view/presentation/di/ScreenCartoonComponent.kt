package com.zoom_machine.jetpack_compose_custom_view.presentation.di

import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.CartoonViewModel
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

    fun getViewModel():CartoonViewModel
}