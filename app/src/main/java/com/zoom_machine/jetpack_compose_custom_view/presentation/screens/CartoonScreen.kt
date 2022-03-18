package com.zoom_machine.jetpack_compose_custom_view.presentation.screens

import android.util.Log
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.zoom_machine.jetpack_compose_custom_view.domain.RickMortyCharacter
import com.zoom_machine.jetpack_compose_custom_view.presentation.screens.custom_component.LoadingAnimation
import com.zoom_machine.jetpack_compose_custom_view.presentation.view_models.CartoonViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun CartoonScreen(viewModel: CartoonViewModel) {
    CharacterList(characters = viewModel.characters)
}

@Composable
fun ShowLoadingIndication(isShow: Boolean) {
    if (isShow) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 300.dp),
            contentAlignment = Alignment.Center
        ) {
            val circleColor = listOf(
                MaterialTheme.colors.primary,
                Color.Magenta,
                Color.Cyan
            )
            LoadingAnimation(circleColor = circleColor)
        }
    }
}

@Composable
fun CharacterList(characters: Flow<PagingData<RickMortyCharacter>>) {
    val lazyCharacterItem: LazyPagingItems<RickMortyCharacter> =
        characters.collectAsLazyPagingItems()

    val showLoadingIndication = remember { mutableStateOf(true) }

    ShowLoadingIndication(isShow = showLoadingIndication.value)
    LazyColumn {
        items(lazyCharacterItem) { character ->
            if (character != null) {
                Log.d("CMP", " List complete")
                showLoadingIndication.value = false
                CharacterItem(character)
            }
        }
    }
}


@Composable
fun CharacterItem(character: RickMortyCharacter) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row {
            CharacterImage(imageUrl = character.image)
            CharacterInfo(character = character)
        }
    }
}


@Composable
fun CharacterImage(
    imageUrl: String,
) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null,
        modifier = Modifier.size(128.dp)
    )
}

@Composable
fun CharacterInfo(
    character: RickMortyCharacter
) {
    var currentState = remember { MutableTransitionState(false) }
    currentState.targetState = true
    val transition = updateTransition(currentState, label = "tap_me_text")

    val x1Offset by transition.animateFloat(
        transitionSpec = { tween(1000) },
        label = ""
    ) { if (it) 0f else 30f }
    val x2Offset by transition.animateFloat(
        transitionSpec = { tween(1500) },
        label = ""
    ) { if (it) 0f else 30f }

    val alpha by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 1f else 0f }
    Column {
        Text(
            text = character.name,
            modifier = Modifier
                .padding(start = 16.dp)
                .offset(x = x1Offset.dp)
                .alpha(alpha),
            style = MaterialTheme.typography.h6
        )
        Text(
            text = character.species,
            modifier = Modifier
                .padding(start = 16.dp)
                .offset(x = x2Offset.dp),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = character.status,
            modifier = Modifier
                .padding(start = 16.dp)
                .offset(x = x2Offset.dp),
            style = MaterialTheme.typography.body1
        )
    }
}
