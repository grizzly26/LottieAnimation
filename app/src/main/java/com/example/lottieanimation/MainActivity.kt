package com.example.lottieanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimation.ui.theme.LottieAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val composition by rememberLottieComposition(spec =
            LottieCompositionSpec.Asset(assetName = "anim.json"))

            var isPlaying by remember {
                mutableStateOf(false)
            }

            var isComplete by remember {
                mutableStateOf(false)
            }

            val animSpec = LottieClipSpec.Progress(
                0f,
                if (isComplete) 1f
                else 0.5f)


            LottieAnimationTheme {
                Column(modifier = Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    LottieAnimation(
                        composition = composition,
                        isPlaying = isPlaying,
                        iterations = if (isComplete) 1 else LottieConstants.IterateForever,
                        clipSpec = animSpec

                    )
                    Button(onClick = {
                        isPlaying = true
                    }) {
                      Text("Download")
                    }

                    Button(onClick = {
                        isComplete = true
                    }) {
                        Text("Finish")
                    }

                    Button(onClick = {
                        isComplete = false
                    }) {
                        Text("Restart")
                    }

                }

            }
        }
    }
}

