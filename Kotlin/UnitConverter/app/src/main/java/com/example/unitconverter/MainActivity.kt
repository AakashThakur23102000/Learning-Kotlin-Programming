package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background)
                ) { innerPadding ->  // Capture padding values
                    UnitConverterComp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun UnitConverterComp(modifier: Modifier = Modifier) {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Centimeters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(0.01) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Here elements are stacked one below another
        Text(text = "Unit Converter")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = { text ->
                inputValue = text
            },
            label = { Text(text = "Enter value") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Box() {
                Button(onClick = { iExpanded = !iExpanded }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow Down",
                    )
                }
                DropdownMenu(
                    modifier = Modifier
                        .background(color = Color.Yellow),

                    expanded = iExpanded,
                    onDismissRequest = {/* */ }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Centimeters")
                        },
                        onClick = {
                            iExpanded = !iExpanded
                            inputUnit = "Centimeters"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Meters")
                        },
                        onClick = {
                            iExpanded = !iExpanded
                            inputUnit = "Meters"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Feet")
                        },
                        onClick = {
                            iExpanded = !iExpanded
                            inputUnit = "Feet"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Millimeters")
                        },
                        onClick = {
                            iExpanded = !iExpanded
                            inputUnit = "Millimeters"
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box() {
                Button(onClick = { oExpanded = !oExpanded }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow Down",
                    )
                }

                DropdownMenu(
                    expanded = oExpanded,
                    onDismissRequest = {/* */ }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Centimeters")
                        },
                        onClick = {
                            oExpanded = !oExpanded
                            outputUnit = "Centimeters"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Meters")
                        },
                        onClick = {
                            oExpanded = !oExpanded
                            outputUnit = "Meters"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Feet")
                        },
                        onClick = {
                            oExpanded = !oExpanded
                            outputUnit = "Feet"
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Millimeters")
                        },
                        onClick = {
                            oExpanded = !oExpanded
                            outputUnit = "Millimeters"
                        }
                    )
                }

            }

        }
        Text(
            text = "Input Unit: -  $inputUnit"
        )
        Text(
            text = "Output Unit: - $outputUnit"
        )
        Text(
            modifier = Modifier.padding(18.dp),
            text = "Result: "
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterCompPreview() {
    UnitConverterComp()
}