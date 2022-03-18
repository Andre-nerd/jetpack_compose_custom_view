package com.zoom_machine.jetpack_compose_custom_view.di

import com.zoom_machine.jetpack_compose_custom_view.view_models.RickMortyViewModel
import dagger.Module
import dagger.Provides

@Module
class ScreenCartoonModule {

    @Provides
    @ScreenCartoonScope
    fun provideViewModel():RickMortyViewModel = RickMortyViewModel()
}