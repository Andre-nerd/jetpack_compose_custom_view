package com.zoom_machine.jetpack_compose_custom_view.presentation.view_models

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zoom_machine.jetpack_compose_custom_view.domain.CartoonRepository
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import retrofit2.HttpException
import java.io.IOException

class RickMortySource(
    private val repository: CartoonRepository
) : PagingSource<Int, RickMortyCharacter>() {
    override fun getRefreshKey(state: PagingState<Int, RickMortyCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMortyCharacter> {
        val page = params.key ?: 1
        return try {
            val response = repository.loadCharacters(page)
            LoadResult.Page(
                response, prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
