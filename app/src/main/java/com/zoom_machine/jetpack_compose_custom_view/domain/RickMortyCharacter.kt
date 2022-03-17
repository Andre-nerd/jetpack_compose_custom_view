package com.zoom_machine.jetpack_compose_custom_view.domain

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RickMortyCharacter(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
)
