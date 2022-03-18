package com.zoom_machine.jetpack_compose_custom_view.di

import com.zoom_machine.jetpack_compose_custom_view.data.IndicatorsRepositoryImpl
import com.zoom_machine.jetpack_compose_custom_view.view_models.IndicatorsViewModel
import dagger.Module
import dagger.Provides

@Module
class ScreenWidgetModule {

    @Provides
    @ScreenWidgetScope
    fun provideViewModel(): IndicatorsViewModel = IndicatorsViewModel(IndicatorsRepositoryImpl())
}