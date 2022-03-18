package com.zoom_machine.jetpack_compose_custom_view.data

import android.util.Log
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import com.zoom_machine.jetpack_compose_custom_view.networking.RetrofitApi

class RickMortyRepositoryImpl: RickMortyRepository {

    override suspend fun loadCharacters(page: Int): List<RickMortyCharacter> {
        return try {
            RetrofitApi.api.loadList(page).results
        } catch (t: Throwable) {
            Log.d("TAG", "Throwable: $t")
            emptyList()
        }
    }
}
