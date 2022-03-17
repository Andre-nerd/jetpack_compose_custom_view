package com.zoom_machine.jetpack_compose_custom_view.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IndicatorsRepositoryImpl(): IndicatorsRepository {

    override suspend fun progressIndicator(condition:Boolean): Flow<Int> {
        return flow{
            while(condition) {
                kotlinx.coroutines.delay(2000)
                emit((0..100).random())
            }
        }
    }
}