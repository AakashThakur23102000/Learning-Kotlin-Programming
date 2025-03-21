package com.dexterverse.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dexterverse.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    UnitConverterComp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UnitConverterComp(modifier: Modifier = Modifier) {
    val focusManager = LocalFocusManager.current  // Manage keyboard focus
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Centimeters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() },  // Dismiss keyboard on background tap
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text(text = "Enter value") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            UnitDropdownMenu("From: $inputUnit", iExpanded, { iExpanded = it }) { unit ->
                inputUnit = unit
            }
            Spacer(modifier = Modifier.width(16.dp))
            UnitDropdownMenu("To: $outputUnit", oExpanded, { oExpanded = it }) { unit ->
                outputUnit = unit
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            focusManager.clearFocus()  // Hide keyboard when Convert is clicked
            outputValue = convertUnits(inputValue, inputUnit, outputUnit)
        }) {
            Text(text = "Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result -> $outputValue", fontSize = 18.sp)
    }
}
@Composable
fun UnitDropdownMenu(
    label: String,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onUnitSelected: (String) -> Unit
) {
    Box {
        Button(onClick = { onExpandedChange(!expanded) }) {
            Text(text = label)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown Arrow")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            modifier = Modifier.background(Color.Yellow)
        ) {
            listOf("Centimeters", "Meters", "Feet", "Millimeters").forEach { unit ->
                DropdownMenuItem(text = { Text(unit) }, onClick = {
                    onExpandedChange(false)
                    onUnitSelected(unit)
                })
            }
        }
    }
}

fun convertUnits(value: String, fromUnit: String, toUnit: String): String {
    val conversionFactors = mapOf(
        "Centimeters" to 0.01,
        "Meters" to 1.0,
        "Feet" to 0.3048,
        "Millimeters" to 0.001
    )

    val inputValue = value.toDoubleOrNull() ?: return "Invalid Input"

    val fromFactor = conversionFactors[fromUnit] ?: return "Error"
    val toFactor = conversionFactors[toUnit] ?: return "Error"

    val result = inputValue * (fromFactor / toFactor)
    return "%.4f $toUnit".format(result)
}

@Preview(showBackground = true)
@Composable
fun UnitConverterCompPreview() {
    UnitConverterComp()
}

