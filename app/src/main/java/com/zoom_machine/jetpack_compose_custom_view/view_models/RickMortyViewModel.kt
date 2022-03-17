package com.zoom_machine.jetpack_compose_custom_view.view_models

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zoom_machine.jetpack_compose_custom_view.data.RickMortyRepository
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import kotlinx.coroutines.flow.Flow

class RickMortyViewModel : ViewModel() {
    private val repository = RickMortyRepository()

    val characters: Flow<PagingData<RickMortyCharacter>> = Pager(PagingConfig(pageSize = 20)) {
        RickMortySource(repository)
    }.flow
}