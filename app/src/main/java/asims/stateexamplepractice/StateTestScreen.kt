package asims.stateexamplepractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//WHILE >>REMEMBER<< MAKES SURE THE STATE PERSISTS THROUGHOUT THE APP..
//>>REMEMBERSAVEABLE<< MAKES URE THE CHANGES PERSISTS THROUGHOUT UI CHANGES EX/ SCREEN ROTATION
@Composable
fun stateTestScreen(){
    var name  by rememberSaveable{
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        stateText(name)
        stateTextField(name, onNameChange = {
            name = it
        })

    }
}

@Composable
fun stateText(name:String){
    Text( text = "Hello $name!", color = Color.White, style = TextStyle(fontSize = 30.sp))

}

@Composable
fun stateTextField(name: String, onNameChange:(String) -> Unit){
    OutlinedTextField(value = name,
        onValueChange = {
        onNameChange(it)
        },
        label = { Text(text = "Enter text") })
}
















// PREVIEW PURPOSES ONLY
@Composable
@Preview
fun stateTextScreenPreview(){
    stateTestScreen()
}