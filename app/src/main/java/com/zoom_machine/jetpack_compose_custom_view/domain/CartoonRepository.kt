package com.zoom_machine.jetpack_compose_custom_view.domain

import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter

interface CartoonRepository {
    suspend fun loadCharacters(page: Int): List<RickMortyCharacter>
}