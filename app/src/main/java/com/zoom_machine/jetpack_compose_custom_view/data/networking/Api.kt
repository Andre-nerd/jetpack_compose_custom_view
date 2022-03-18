package com.zoom_machine.jetpack_compose_custom_view.data.networking

import com.squareup.moshi.JsonClass
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/api/character")
    suspend fun loadList(@Query("page") page: Int): RickMortyResponse

    @JsonClass(generateAdapter = true)
    class RickMortyResponse(val results: List<RickMortyCharacter>)
}


