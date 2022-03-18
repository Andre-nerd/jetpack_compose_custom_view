package com.zoom_machine.jetpack_compose_custom_view.data

import com.zoom_machine.jetpack_compose_custom_view.domain.IndicatorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IndicatorsRepositoryImpl @Inject constructor(): IndicatorsRepository {

    override suspend fun progressIndicator(condition:Boolean): Flow<Int> {
        return flow{
            while(condition) {
                kotlinx.coroutines.delay(2000)
                emit((0..100).random())
            }
        }
    }

    override suspend fun progressOutput(condition:Boolean): Flow<Int> {
        return flow{
            while(condition) {
                kotlinx.coroutines.delay(1200)
                emit((0..105).random())
            }
        }
    }
}