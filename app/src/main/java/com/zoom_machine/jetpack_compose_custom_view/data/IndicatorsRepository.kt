package com.zoom_machine.jetpack_compose_custom_view.data

import kotlinx.coroutines.flow.Flow

interface IndicatorsRepository {
    suspend fun progressIndicator(condition:Boolean): Flow<Int>
}