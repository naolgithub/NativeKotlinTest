@file:JvmName("MainActivityKt")

package com.example.nativeproject

import android.media.SoundPool
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WelcomeScreen()
//            GiftExplosionAnimation()
            val navController = rememberNavController()
            NavigationSetup(navController)
        }
    }
}

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "first") { // Changed startDestination to "first"
        composable("welcome") { WelcomeScreen(navController) }
        composable("first") { SetDailyGoalScreen(navController) }
        composable("third") { FairTrialDisclaimerScreen() }
    }
}



@Composable
fun WelcomeScreen(navController: NavController) {
    GiftExplosionAnimation()
    var isRemarkableAndWelcomeVisible by remember { mutableStateOf(true) }
    var swingAnimation by remember { mutableStateOf(false) }
    // Orange shirt animation
    val xOffset = remember { Animatable(1000f) } // Starting x-coordinate (off-screen bottom-left)
    val yOffset = remember { Animatable(2500f) }  // Starting y-coordinate (off-screen bottom-left)
    val rotation = remember { Animatable(0f) }   // Initial rotation angle

    // Ocean hair animation
    val xOceanHairOffset = remember { Animatable(1000f) }
    val yOceanHairOffset = remember { Animatable(2500f) }
    val oceanHairRotation = remember { Animatable(0f) }

    //orange right arm animation
    val xOrangeRightArmOffset = remember { Animatable(1000f) }
    val yOrangeRightArmOffset = remember { Animatable(2500f) }
    val orangeRightArmRotation = remember { Animatable(0f) }

    // Hand shake animation
    val xHandShakeOffset = remember { Animatable(1000f) } // Starting x-coordinate (off-screen bottom-left)
    val yHandShakeOffset = remember { Animatable(2500f) }
    val handShakeRotation = remember { Animatable(0f) }

    // Green Shirt animation
    val xGreenShirtOffset = remember { Animatable(-1000f) } // Starting x-coordinate (off-screen bottom-left)
    val yGreenShirtOffset = remember { Animatable(2500f) }  // Starting y-coordinate (off-screen bottom-left)
    val greenShirtRotation = remember { Animatable(0f) }   // Initial rotation angle

    // Chef lady animation
    val xChefLadyOffset = remember { Animatable(1000f) } // Starting x-coordinate (off-screen bottom-left)
    val yChefLadyOffset = remember { Animatable(2500f) }  // Starting y-coordinate (off-screen bottom-left)
    val chefLadyRotation = remember { Animatable(0f) }   // Initial rotation angle

    // blonde face animation
    val xBlondeFaceOffset = remember { Animatable(1000f) } // Starting x-coordinate (off-screen bottom-left)
    val yBlondeFaceOffset = remember { Animatable(2500f) }  // Starting y-coordinate (off-screen bottom-left)
    val blondeFaceRotation = remember { Animatable(0f) }   // Initial rotation angle

    // Animatables for the second image (bottom-right corner)
    val xOffset2 = remember { Animatable(2000f) } // Starting x-coordinate (off-screen bottom-right)
    val yOffset2 = remember { Animatable(2000f) } // Starting y-coordinate (off-screen bottom-right)
    val rotation2 = remember { Animatable(0f) }   // Initial rotation angle

    // Animatables for black hair
    val xBlackHairOffset = remember { Animatable(-1000f) }
    val yBlackHairOffset = remember { Animatable(2500f) }
    val blackHairRotation = remember { Animatable(0f) }

    // Animatables for waving hand
    val xHandWaveOffset = remember { Animatable(-1000f) }
    val yHandWaveOffset = remember { Animatable(500f) }
    val handWaveRotation = remember { Animatable(0f) }

    //Middle Person animation
    val xMiddlePersonOffset = remember { Animatable(-1500f) }
    val yMiddlePersonOffset = remember { Animatable(2000f) }
    val middlePersonRotation = remember { Animatable(0f) }


    //blonde head animation
    val xBlondeHeadOffset = remember { Animatable(-1500f) }
    val yBlondeHeadOffset = remember { Animatable(2000f) }
    val blondeHeadRotation = remember { Animatable(0f) }

    //blonde hair animation
    val xBlondeHairOffset = remember { Animatable(-1500f) }
    val yBlondeHairOffset = remember { Animatable(2000f) }
    val blondeHairRotation = remember { Animatable(0f) }

    //blonde right arm animation
    val xBlondeRightArmOffset = remember { Animatable(-1500f) }
    val yBlondeRightArmOffset = remember { Animatable(2000f) }
    val blondeRightArmRotation = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // Blonde Hair animation
        launch {
            xBlondeHairOffset.animateTo(
                targetValue = 120f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yBlondeHairOffset.animateTo(
                targetValue = 1720f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            blondeHairRotation.animateTo(
                targetValue = 10f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // Blonde Head animation
        launch {
            xBlondeHeadOffset.animateTo(
                targetValue = 325f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yBlondeHeadOffset.animateTo(
                targetValue = 1725f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            blondeHeadRotation.animateTo(
                targetValue = 10f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // Middle person animation
        launch {
            xMiddlePersonOffset.animateTo(
                targetValue = -200f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yMiddlePersonOffset.animateTo(
                targetValue = 1700f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            middlePersonRotation.animateTo(
                targetValue = -0f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // blonde right arm animation
        launch {
            xBlondeRightArmOffset.animateTo(
                targetValue = -170f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yBlondeRightArmOffset.animateTo(
                targetValue = 1750f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            blondeRightArmRotation.animateTo(
                targetValue = 10.19f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // Green shirt animation
        launch {
            xGreenShirtOffset.animateTo(
                targetValue = -350f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yGreenShirtOffset.animateTo(
                targetValue = 1300f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            greenShirtRotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // Black Hair animation
        launch {
            xBlackHairOffset.animateTo(
                targetValue = 330f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yBlackHairOffset.animateTo(
                targetValue = 1460f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            blackHairRotation.animateTo(
                targetValue = 10f,
                animationSpec = tween(durationMillis = 2500)
            )
        }

        // Waving hand animation (lasting 2 seconds)
        launch {
            xHandWaveOffset.animateTo(
                targetValue = -150f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            handWaveRotation.animateTo(
                targetValue = 10f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            repeat(8) { // 5 half-cycles (2.5 full cycles) lasting 2 seconds
                yHandWaveOffset.animateTo(
                    targetValue = 1250f,
                    animationSpec = tween(durationMillis = 500)
                )
                yHandWaveOffset.animateTo(
                    targetValue = 1200f,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        }

        // First image animation
        launch {
            xOffset.animateTo(
                targetValue = 600f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            yOffset.animateTo(
                targetValue = 1600.47f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            rotation.animateTo(
                targetValue = 5.19f,
                animationSpec = tween(durationMillis = 2000)
            )
        }

        // orange right arm animation
        launch {
            xOrangeRightArmOffset.animateTo(
                targetValue = 515f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            yOrangeRightArmOffset.animateTo(
                targetValue = 1910.47f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            orangeRightArmRotation.animateTo(
                targetValue = -1.19f,
                animationSpec = tween(durationMillis = 2000)
            )
        }

        // ocean hair animation
        launch {
            xOceanHairOffset.animateTo(
                targetValue = 480f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            yOceanHairOffset.animateTo(
                targetValue = 1610.47f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            oceanHairRotation.animateTo(
                targetValue = 5.19f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        // Second image animation
        launch {
            xOffset2.animateTo(
                targetValue = 100f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            yOffset2.animateTo(
                targetValue = 1450f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        launch {
            rotation2.animateTo(
                targetValue = -10f,
                animationSpec = tween(durationMillis = 2500)
            )
        }
        delay(1000) // 1 second delay before starting animation
        swingAnimation = true
        delay(10000) // Wait for 10 seconds
        isRemarkableAndWelcomeVisible = false // Hide the text
    }
    // Animate top and left positions with a curve using tween
    val topPosition: Dp by animateDpAsState(
        targetValue = if (swingAnimation) (-100).dp else (-100).dp,
        animationSpec = tween(durationMillis = 5000)
    )
    val leftPosition: Dp by animateDpAsState(
        targetValue = if (swingAnimation) (-50).dp else (-10).dp,
        animationSpec = tween(durationMillis = 5000)
    )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "Curved Animated Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .alpha(1f)
                .offset(x = leftPosition, y = topPosition)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 234, green = 254, blue = 236)) // Background color
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    change.consume()
                    if (dragAmount < -50) { // Left swipe
                        navController.navigate("third")
                    } else if (dragAmount > 50) { // Right swipe
                        navController.navigate("first")
                    }
                }
            }
    ) {
        GiftExplosionAnimation()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Curved Animated Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .alpha(1f)
                    .offset(x = leftPosition, y = topPosition)
            )
        }

        // Image 3
        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = null,
            modifier = Modifier
                .size(24.36.dp, 18.5.dp)
                .offset(x = 286.dp, y = 228.dp)
        )

        // Image 4
        Image(
            painter = painterResource(id = R.drawable.img_4),
            contentDescription = null,
            modifier = Modifier
                .size(25.95.dp, 19.3.dp)
//                .rotate(-150f)
                .offset(x = 327.48.dp, y = 444.56.dp)
        )

        // Image 5
        Image(
            painter = painterResource(id = R.drawable.img_5),
            contentDescription = null,
            modifier = Modifier
                .size(22.56.dp, 12.69.dp)
//                .rotate(-17.49f)
                .offset(x = 21.81.dp, y = 434.dp)
        )

        // Image 6
        Image(
            painter = painterResource(id = R.drawable.img_6),
            contentDescription = null,
            modifier = Modifier
                .size(23.15.dp, 13.03.dp)
//                .rotate(43.96f)
                .offset(x = 49.dp, y = 287.56.dp)
        )

        // Image 17
        Image(
            painter = painterResource(id = R.drawable.img_17),
            contentDescription = null,
            modifier = Modifier
                .size(469.dp, 438.63.dp)
//                .rotate(-18.07f)
                .offset(x = 43.47.dp, y = 410.dp)
        )
        // Image 0
        Image(
            painter = painterResource(id = R.drawable.img_0),
            contentDescription = null,
            modifier = Modifier
                .size(146.22.dp, 110.39.dp)
                .offset(x = 319.dp, y = 489.dp)
        )
        // Image 12
        Image(
            painter = painterResource(id = R.drawable.img_12),
            contentDescription = null,
            modifier = Modifier
                .size(112.34.dp, 87.44.dp)
                .graphicsLayer(
                    translationX = xOceanHairOffset.value,
                    translationY = yOceanHairOffset.value,
                    rotationZ = oceanHairRotation.value
                )
        )

        // Image 13
        Image(
            painter = painterResource(id = R.drawable.img_13),
            contentDescription = null,
            modifier = Modifier
                .size(96.51.dp, 110.1.dp)
                .graphicsLayer(
                    translationX = xOrangeRightArmOffset.value,
                    translationY = yOrangeRightArmOffset.value,
                    rotationZ = orangeRightArmRotation.value
                )
        )
        // Image 11
        Image(
            painter = painterResource(id = R.drawable.img_11),
            contentDescription = null,
            modifier = Modifier.
            size(267.64.dp, 270.39.dp).
            graphicsLayer(
                translationX = xOffset.value,
                translationY = yOffset.value,
                rotationZ = rotation.value
            )
        )

        // Image 18
        Image(
            painter = painterResource(id = R.drawable.img_18),
            contentDescription = null,
            modifier = Modifier
                .size(37.75.dp, 28.31.dp)
//                .rotate(20.42f)
                .offset(x = 79.dp, y = 418.17.dp)
        )

        // Image 20
        Image(
            painter = painterResource(id = R.drawable.img_20),
            contentDescription = null,
            modifier = Modifier
                .size(23.dp, 17.25.dp)
//                .rotate(-16.73f)
                .offset(x = 200.96.dp, y = 497.dp)
        )

        // Green shirt image
        Image(
            painter = painterResource(id = R.drawable.img_16),
            contentDescription = "Green shirt",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xGreenShirtOffset.value,
                    translationY = yGreenShirtOffset.value,
                    rotationZ = greenShirtRotation.value
                )
        )

        // Black hair image
        Image(
            painter = painterResource(id = R.drawable.img_14),
            contentDescription = "Black Hair",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xBlackHairOffset.value,
                    translationY = yBlackHairOffset.value,
                    rotationZ = blackHairRotation.value
                )
        )

        // Waving hand image
        Image(
            painter = painterResource(id = R.drawable.img_15),
            contentDescription = "Hand Shake",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xHandWaveOffset.value,
                    translationY = yHandWaveOffset.value,
                    rotationZ = handWaveRotation.value
                )
        )

        // Middle person image
        Image(
            painter = painterResource(id = R.drawable.img_10),
            contentDescription = "Middle person image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xMiddlePersonOffset.value,
                    translationY = yMiddlePersonOffset.value,
                    rotationZ = middlePersonRotation.value
                )
        )
        // blonde right arm image
        Image(
            painter = painterResource(id = R.drawable.img_9),
            contentDescription = "Blonde right arm",
            modifier = Modifier
                .graphicsLayer(
                    translationX = xBlondeRightArmOffset.value,
                    translationY = yBlondeRightArmOffset.value,
                    rotationZ = blondeRightArmRotation.value
                )
        )

        // blonde head image
        Image(
            painter = painterResource(id = R.drawable.img_8),
            contentDescription = "Green shirt",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xBlondeHeadOffset.value,
                    translationY = yBlondeHeadOffset.value,
                    rotationZ = blondeHeadRotation.value
                )
        )

        // blonde hair image
        Image(
            painter = painterResource(id = R.drawable.img_7),
            contentDescription = "Green shirt",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer(
                    translationX = xBlondeHairOffset.value,
                    translationY = yBlondeHairOffset.value,
                    rotationZ = blondeHairRotation.value
                )
        )

        // Blonde right eye
        Image(
            painter = painterResource(id = R.drawable.blonde_right_eye),
            contentDescription = null,
            modifier = Modifier
                .size(4.44.dp, 6.81.dp)
//                .rotate(-5.91f)
                .offset(x = 157.01.dp, y = 676.71.dp)
        )

        // Blonde left eye
        Image(
            painter = painterResource(id = R.drawable.blonde_left_eye),
            contentDescription = null,
            modifier = Modifier
                .size(4.44.dp, 6.81.dp)
//                .rotate(-5.91f)
                .offset(x = 174.57.dp, y = 680.31.dp)
        )


        // Welcome Text
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 256.dp)
        ) {
            if(isRemarkableAndWelcomeVisible){
                Text(
                    text = "You're \n remarkable!",
                    color = Color(0xFF4CAF50),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }
            if(isRemarkableAndWelcomeVisible){
                Text(
                    text = "Welcome to Hapday",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun GiftExplosionAnimation() {
    var startAnimation by remember { mutableStateOf(false) }
    var animationEnded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val soundPool = remember { SoundPool.Builder().setMaxStreams(1).build() }
    val soundId = remember { soundPool.load(context, R.raw.animation_sound, 1) }

    // Start animation after a short delay when the app launches
    LaunchedEffect(Unit) {
        // Play sound
        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)

        delay(500) // Delay before starting animation
        startAnimation = true
        delay(5000) // Wait for animation duration (1 second)
        animationEnded = true

        // Release resources
        soundPool.release()
    }

    if (!animationEnded) { // Show animation only if it hasn't ended
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // Main gift images
            GiftImage(R.drawable.flower_three, -300, -300, startAnimation)
            GiftImage(R.drawable.flower_three, -400, -400, startAnimation)
            GiftImage(R.drawable.flower_three, -500, -500, startAnimation)
            GiftImage(R.drawable.flower_three, -500, 0, startAnimation)
            GiftImage(R.drawable.green_two_flower, 300, -300, startAnimation)
            GiftImage(R.drawable.second_flower, -300, 300, startAnimation)
            GiftImage(R.drawable.green_qenxe_flower, 300, 300, startAnimation)
            GiftImage(R.drawable.orange_flower, 300, 300, startAnimation)
            GiftImage(R.drawable.second_flower, 300, 300, startAnimation)
            GiftImage(R.drawable.green_two_flower, 0, 0, startAnimation)

            // Add 20 more gift images with randomized offsets
            repeat(20) {
                GiftImage(
                    resourceId = listOf(
                        R.drawable.flower_three,
                        R.drawable.green_two_flower,
                        R.drawable.green_qenxe_flower,
                        R.drawable.green_two_flower,
                        R.drawable.orange_flower,
                        R.drawable.second_flower,
                        R.drawable.green_two_flower
                    ).random(),
                    offsetX = Random.nextInt(-400, 400),
                    offsetY = Random.nextInt(-400, 400),
                    startAnimation = startAnimation
                )
            }
        }
    }
}

@Composable
fun GiftImage(resourceId: Int, offsetX: Int, offsetY: Int, startAnimation: Boolean) {
    val animationDuration = 5000 // 1 second

    // Animate position (offset) and opacity
    val animatedOffsetX by animateFloatAsState(
        targetValue = if (startAnimation) offsetX.toFloat() else 0f,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val animatedOffsetY by animateFloatAsState(
        targetValue = if (startAnimation) offsetY.toFloat() else 0f,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 1f, // Fade out effect
        animationSpec = tween(durationMillis = animationDuration)
    )

    if (alpha > 0f) { // Only show the image when alpha is greater than 0
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = "Gift",
            modifier = Modifier
                .size(50.dp)
                .offset { IntOffset(animatedOffsetX.toInt(), animatedOffsetY.toInt()) }
                .graphicsLayer {
                    scaleX = 1.2f
                    scaleY = 1.2f
                }
                .alpha(alpha)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
//    WelcomeScreen()
}
