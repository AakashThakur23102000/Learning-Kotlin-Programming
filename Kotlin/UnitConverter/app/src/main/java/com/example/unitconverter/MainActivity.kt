package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.paddingFrom
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Here elements are stacked one below another
        Text(text = "Unit Converter")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = "", onValueChange = {
            // Here goes onChangeValue
        })

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Here elements are stacked next to each other

//            //code to show toast when button is pressed
//            val context = LocalContext.current
//            Button(
//                onClick = {
//                    Toast.makeText(
//                        context, "Toast is showing up.", Toast.LENGTH_LONG
//                    ).show()
//                }
//            ) {
//                Text(text = "Press Me")
//            }


            Box() {
                Button(onClick = {/*Fill later*/ }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow Down",

                        )
                }
                DropdownMenu(
                    expanded = true,
                    onDismissRequest = {/* */ }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Centimeters")
                        },
                        onClick = {/**/ }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Meters")
                        },
                        onClick = {/**/ }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Feet")
                        },
                        onClick = {/**/ }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Millimeters")
                        },
                        onClick = {/**/ }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box() {
                Button(onClick = {/*Fill later*/ }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow Down",
                    )
                }
            }

        }

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