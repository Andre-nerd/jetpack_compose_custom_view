package com.zoom_machine.jetpack_compose_custom_view.presentation.di

import com.zoom_machine.jetpack_compose_custom_view.data.RickMortyRepositoryImpl
import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.CartoonViewModel
import dagger.Module
import dagger.Provides

@Module
class ScreenCartoonModule {

    @Provides
    @ScreenCartoonScope
    fun provideViewModel():CartoonViewModel = CartoonViewModel(RickMortyRepositoryImpl())
}