package com.zoom_machine.jetpack_compose_custom_view.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zoom_machine.jetpack_compose_custom_view.domain.CartoonRepository
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartoonViewModel @Inject constructor (private val repository: CartoonRepository) : ViewModel() {

    val characters: Flow<PagingData<RickMortyCharacter>> = Pager(PagingConfig(pageSize = 20)) {
        RickMortySource(repository)
    }.flow
}