

package com.example.nativeproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nativeproject.R

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MaterialTheme{
//                NavigationApp()
//            }
//        }
//    }
//}
//@Composable
//fun NavigationApp() {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = "first_screen"
//    ) {
//        composable("first_screen") { SetDailyGoalScreen(navController) }
//        composable("second_screen") { WelcomeScreen() }
//    }
//}

@Composable
fun SetDailyGoalScreen(navController: NavController) {
    var selectedGoal by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    change.consume()
                    if (dragAmount < -50) { // Left swipe
                        navController.navigate("welcome")
                    }
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Arrow Back Button (Placeholder)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                "<",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Title Text
        Text(
            text = "Set your daily goal",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 16.dp)
        )

        // Updated Image
        Image(
            painter = painterResource(id = R.drawable.first_image),
            contentDescription = "Daily Goal Image",
            modifier = Modifier
                .width(300.dp)
                .height(180.dp)
                .padding(top = 16.dp),
            contentScale = ContentScale.Fit
        )

        // Goal Options Container
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .width(327.dp)
                .padding(top = 16.dp)
        ) {
            GoalOptionRow(
                "5 min/day",
                "Casual",
                R.drawable.confidence_icon,
                isSelected = selectedGoal == "5 min/day",
                onClick = { selectedGoal = "5 min/day" }
            )
            Spacer(modifier = Modifier.height(8.dp))
            GoalOptionRow(
                "10 min/day",
                "Regular",
                R.drawable.third_icon,
                isSelected = selectedGoal == "10 min/day",
                onClick = { selectedGoal = "10 min/day" }
            )
            Spacer(modifier = Modifier.height(8.dp))
            GoalOptionRow(
                "15 min/day",
                "Serious",
                R.drawable.heart_icon,
                isSelected = selectedGoal == "15 min/day",
                onClick = { selectedGoal = "15 min/day" }
            )
            Spacer(modifier = Modifier.height(8.dp))
            GoalOptionRow(
                "20 min/day",
                "Intense",
                R.drawable.super_icon,
                isSelected = selectedGoal == "20 min/day",
                onClick = { selectedGoal = "20 min/day" }
            )

            Spacer(modifier = Modifier.height(56.dp))
            // Button
            Button(
                onClick = { navController.navigate("welcome") },
                modifier = Modifier
                    .padding( start = 16.dp, top = 16.dp)
                    .width(300.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF8A4DFF))
            ) {
                Text(text = "I’m committed", color = Color.White)
            }
        }
    }
}

@Composable
fun GoalOptionRow(
    time: String,
    level: String,
    iconResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                if (isSelected) Color(249, 247, 254) else Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                BorderStroke(
                    1.dp,
                    if (isSelected) Color(0xFF8A4DFF) else Color(0xFFECECEC)
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "Goal Icon",
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = time,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = level,
            style = TextStyle(fontSize = 14.sp, color = Color.Gray)
        )
    }
}

@Preview(showBackground = true, name = "Set Daily Goal Screen Preview")
@Composable
fun SetDailyGoalScreenPreview() {
//    NavigationApp()
}

