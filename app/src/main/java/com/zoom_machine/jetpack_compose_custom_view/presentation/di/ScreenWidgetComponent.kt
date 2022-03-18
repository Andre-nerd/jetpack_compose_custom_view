package com.zoom_machine.jetpack_compose_custom_view.presentation.di

import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.IndicatorsViewModel
import dagger.Component

@Component(
    modules = [ScreenWidgetModule::class]
)
@ScreenWidgetScope
interface ScreenWidgetComponent{
    @Component.Builder
    interface  Builder {
        fun build(): ScreenWidgetComponent
    }

    fun getViewModel(): IndicatorsViewModel
}