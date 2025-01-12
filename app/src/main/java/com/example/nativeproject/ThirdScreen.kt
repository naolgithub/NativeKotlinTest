package com.example.nativeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FairTrialDisclaimerScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Close button at the top right corner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btn_close), // Replace with your close icon
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(65.dp)
                        .align(Alignment.TopEnd)
                )
            }

            Spacer(modifier = Modifier.height(36.dp)) // 50px = ~16dp

            // Center image
            Image(
                painter = painterResource(id = R.drawable.note_take), // Replace with your image
                contentDescription = "Center Image",
                modifier = Modifier
                    .width(152.dp)
                    .height(93.91.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))

            // Fair trial disclaimer text
            Text(
                text = "Fair trial \n" +
                        "disclaimer",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(46.dp))

            // Container with text
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .height(263.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE6D9FF),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "We only ask you to spend at least 5 minutes a day using Hapday.\n\n" +
                            "●  If you don’t, maybe this isn’t the best time for you to try Hapday so you should cancel the program before your trial ends.\n\n" +
                            "●  We’re not here to waste your time or your money, because let’s face it, it would be a waste of our time and money too.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            // "I'm in" button at the bottom
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier
//                    .align(Alignment.BottomCenter)
                    .padding(bottom = 36.dp)
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text(text = "I’m in")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FairTrialDisclaimerScreenPreview() {
    MaterialTheme {
        FairTrialDisclaimerScreen()
    }
}
