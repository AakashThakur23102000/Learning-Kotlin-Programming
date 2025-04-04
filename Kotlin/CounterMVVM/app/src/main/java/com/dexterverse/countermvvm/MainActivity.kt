package com.dexterverse.countermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dexterverse.countermvvm.ui.theme.CounterMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel by viewModels()
            CounterMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(innerPadding, viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(
    innerPadding: PaddingValues? = null,
    viewModel: CounterViewModel
) {

    Column(modifier = (innerPadding?.let { it ->
        Modifier.padding(it)
    } ?: Modifier).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = viewModel.count.value.toString(),
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace
        )
        Row() {
            Button(onClick = { viewModel.incrementCount() }) {
                Text(text = "Increase Count")
            }
            Button(onClick = { viewModel.decrementCount() }) {
                Text(text = "Decrease Count")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val previewViewModel = CounterViewModel()
    CounterMVVMTheme {
        CounterApp(viewModel = previewViewModel)
    }
}