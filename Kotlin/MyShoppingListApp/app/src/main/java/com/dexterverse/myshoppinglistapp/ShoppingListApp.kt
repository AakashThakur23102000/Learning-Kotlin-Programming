package com.dexterverse.myshoppinglistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//type to accept in array
data class ShoppingItem(
    val id: Int,
    val name: String,
    val quantity: Int,
    var isEditable: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp(innerPadding: PaddingValues? = null) {

    val sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    val itemIsEditable by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(innerPadding ?: PaddingValues())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { showDialog = true },
        ) {
            Text(text = "Add Items")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) { item ->
                Text(text = "${item.name} - Qty: ${item.quantity}")
            }
        }

    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            modifier = Modifier,
            confirmButton = {/**/ },
            title = { Text(text = "Add Shopping Items.") },
            text = {
                Column {
                    OutlinedTextField(
                        label = { Text("Enter your Name") },
                        value = itemName,
                        onValueChange = { text ->
                            itemName = text
                        }
                    )

                    OutlinedTextField(
                        label = { Text("Enter your Quantity") },
                        value = itemQuantity,
                        onValueChange = { text ->
                            itemQuantity = text
                        }
                    )
                }
            }
        )
    }
}
