package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigateSecondScreen:(String, Int) -> Unit) {

    val userName = remember { mutableStateOf("") }
    val userAge = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "This is the First Screen", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = userName.value, placeholder = { Text(text = "User Name")}, onValueChange = {
            userName.value = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = userAge.value.toString(), placeholder = { Text(text = "User Age")}, onValueChange = {
            userAge.value = it.toInt()
        })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigateSecondScreen(userName.value, userAge.value)
        } ){
            Text(text = "Go to Second Screen")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun FirsScreenPreview() {
//    FirstScreen()
//}