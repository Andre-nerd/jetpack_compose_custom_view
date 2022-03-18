package com.zoom_machine.jetpack_compose_custom_view.presentation.di

import com.zoom_machine.jetpack_compose_custom_view.data.IndicatorsRepositoryImpl
import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.IndicatorsViewModel
import dagger.Module
import dagger.Provides

@Module
class ScreenWidgetModule {

    @Provides
    @ScreenWidgetScope
    fun provideViewModel(): IndicatorsViewModel = IndicatorsViewModel(IndicatorsRepositoryImpl())
}