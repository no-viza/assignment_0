package com.example.decisionmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.decisionmaker.ui.theme.DecisionMakerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DecisionMakerTheme {
                DecisionMakerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DecisionMakerApp() {
    DecisionButtons(modifier = Modifier
        .fillMaxSize()
    )
}

@Composable
fun DecisionButtons(modifier: Modifier = Modifier) {
    // The following implementation of 'mutableStateOf<int?>(null)' is from openAI, ChatGPT, "How do I ensure that there's nothing on the screen before a button is pressed?", 2026-09-17
    var result by remember { mutableStateOf<Int?>(null) }
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = modifier.padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Name: Laviza Nofal"
        )
        Text(
            "CCID: laviza"
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            "Decision Maker!"
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Should we go?"
        )
        Text(
            text = if (result == 1){
                "YES!"
            } else if (result == 0) {
                "NO!"
            } else {
                ""
            }
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Button(
                onClick = {
                    if (Random.nextInt(100) < 50){
                        result = 1
                    } else {
                        result = 0
                    }
                    count++
                }
            ) {
                Text(stringResource(R.string.ButtonA))

            }

            Button(
                onClick = {
                    if (Random.nextInt(100) < 25){
                        result = 1
                    } else {
                        result = 0
                    }
                    count++
                }
            ) {
                Text(stringResource(R.string.ButtonB))
            }
            Button(
                onClick = {
                    if (Random.nextInt(100) < 10){
                        result = 1
                    } else {
                        result = 0
                    }
                        count++
                }
            ) {
                Text(stringResource(R.string.ButtonC))
            }
        }
        Spacer(modifier= Modifier.height(16.dp))
        Text("Clicks: " +count )

    }
}