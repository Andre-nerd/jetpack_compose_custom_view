package com.zoom_machine.jetpack_compose_custom_view.di

import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
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