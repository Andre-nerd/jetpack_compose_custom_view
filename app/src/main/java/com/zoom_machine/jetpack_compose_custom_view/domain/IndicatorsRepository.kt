package com.zoom_machine.jetpack_compose_custom_view.domain

import kotlinx.coroutines.flow.Flow

interface IndicatorsRepository {
    suspend fun progressIndicator(condition:Boolean): Flow<Int>

    suspend fun progressOutput(condition:Boolean): Flow<Int>
}