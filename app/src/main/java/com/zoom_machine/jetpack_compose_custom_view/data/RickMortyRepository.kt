package com.zoom_machine.jetpack_compose_custom_view.data

import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter

interface RickMortyRepository {
    suspend fun loadCharacters(page: Int): List<RickMortyCharacter>
}