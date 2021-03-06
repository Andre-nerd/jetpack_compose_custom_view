package com.zoom_machine.jetpack_compose_custom_view.data

import android.util.Log
import com.zoom_machine.jetpack_compose_custom_view.domain.CartoonRepository
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import com.zoom_machine.jetpack_compose_custom_view.data.networking.RetrofitApi
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(): CartoonRepository {

    override suspend fun loadCharacters(page: Int): List<RickMortyCharacter> {
        return try {
            RetrofitApi.api.loadList(page).results
        } catch (t: Throwable) {
            Log.d("TAG", "Throwable: $t")
            emptyList()
        }
    }
}
