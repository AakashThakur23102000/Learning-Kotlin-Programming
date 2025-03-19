package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CaptainGame(innerPadding: PaddingValues = PaddingValues(0.dp)) {
    var treasureFound by remember { mutableIntStateOf(0) }
    var direction by remember { mutableStateOf("North") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Text(text = "Treasure Found - $treasureFound")
        Text(text = "Direction - $direction")

        Button(
            onClick = {
                direction = "East"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                }
            }
        ) {
            Text(text = "Sale East")
        }

        Button(
            onClick = {
                direction = "West"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                }
            }
        ) {
            Text(text = "Sale West")
        }

        Button(
            onClick = {
                direction = "North"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                }
            }
        ) {
            Text(text = "Sale North")
        }

        Button(
            onClick = {
                direction = "South"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                }
            }
        ) {
            Text(text = "Sale South")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview() {
    CaptainGame()
}