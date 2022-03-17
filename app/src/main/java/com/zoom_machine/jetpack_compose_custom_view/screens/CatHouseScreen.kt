package com.zoom_machine.jetpack_compose_custom_view.screens

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.zoom_machine.jetpack_compose_custom_view.R
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun CatHouseScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val showTextTapMe = remember { mutableStateOf(true) }
        val showTextThanks = remember { mutableStateOf(false) }
        CoteHouseOne()
        CoteDragAndDrop(
            { showTextTapMe.value = false},
            { showTextThanks.value = true },
        )
        TextThanks(showTextThanks)
        TextClickMe(showText = showTextTapMe )
    }
}

@Composable
fun TextThanks(showText: MutableState<Boolean>){
    if(showText.value){
        TextTapMe(stringResource(id = R.string.thanks_a_lot))
    }
}

@Composable
fun TextClickMe(showText: MutableState<Boolean>){
    if(showText.value){
        TextTapMe(stringResource(id = R.string.click_me))
    }
}


@Composable
fun CoteHouseOne() {
    val currentState = remember { MutableTransitionState(false) }
    currentState.targetState = true
    val transition = updateTransition(currentState, label = "tap_me_text")

    val yOffset by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 30f else 0f }

    val alpha by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) {
        if (it) 1f else 0f
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.TopCenter)
                .offset(y = yOffset.dp)
                .alpha(alpha),
            painter = painterResource(R.drawable.cote_hous_rose),
            contentDescription = stringResource(R.string.im_cote)
        )
    }
}

@Composable
fun TextTapMe(messageText: String) {
    val currentState = remember { MutableTransitionState(false) }
    currentState.targetState = true
    val transition = updateTransition(currentState, label = "tap_me_text")

    val yOffset by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 280f else 0f }

    val alpha by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 1f else 0f }
    Box(modifier = Modifier.width(40.dp)) {
        Text(
            text = messageText,
            modifier = Modifier
                .offset(y = yOffset.dp)
                .alpha(alpha)
                .align(Alignment.TopCenter),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
fun CoteDragAndDrop(
    isShowTextTapMe: () -> Unit,
    onComplete: () -> Unit
) {
    val transformOriginTopCenter: TransformOrigin = TransformOrigin(0.5f, 0f)
    val showListOfHeroes = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val offset = remember { Animatable(Offset(104f, 100f), Offset.VectorConverter) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val x = offset.value.x.roundToInt()
        val y = offset.value.y.roundToInt()
        showListOfHeroes.value = (x in 15..200) && (y in -940..-520)
        if (showListOfHeroes.value) {
            onComplete()
        }

        CoteIcon(Modifier
            .offset { IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt()) }
            .align(Alignment.Center)
            .graphicsLayer(transformOrigin = transformOriginTopCenter)
            .pointerInput(Unit) {
                scope.launch {
                    detectTapGestures {

                    }
                }
                scope.launch {
                    detectDragGestures(
                        onDragStart = {
                            isShowTextTapMe()

                        },
                        onDragEnd = {
                            scope.launch {
                                // Если хотим вернуть в центр, то..
                                //offset.animateTo(Offset.Zero, tween())
                            }
                        },
                        onDrag = { _, dragAmount ->
                            val original = offset.value
                            val summed = original + dragAmount
                            scope.launch {
                                offset.snapTo(summed)
                            }
                        }
                    )
                }
            })
    }
}


@Composable
fun CoteIcon(modifier: Modifier = Modifier) {
    val dOffset = 28f
    var currentState = remember { MutableTransitionState(false) }
    currentState.targetState = true
    val transition = updateTransition(currentState, label = "tap_me_text")

    val yOffset by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 30f else 0f }
    val alpha by transition.animateFloat(
        transitionSpec = { tween(3000) },
        label = ""
    ) { if (it) 1f else 0f }
    Box(
        modifier = modifier.requiredSize(80.dp, 80.dp)
    )
    {
        Image(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.Center)
                .offset(x = -dOffset.dp, y = yOffset.roundToInt().dp - dOffset.dp)
                .alpha(alpha = alpha),
            painter = painterResource(R.drawable.cote_rose),
            contentDescription = stringResource(R.string.im_cote)
        )
    }
}