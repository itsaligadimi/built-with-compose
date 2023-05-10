package com.agadimi.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.agadimi.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            Content()
        }
    }
}

@Composable
fun NumButton(text: String, onClick: () -> Unit)
{
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .background(Color.Transparent)
    ) {
        Text(text, color = Color.White, fontSize = 25.sp)
    }
}

@Composable
fun Content()
{
    CalculatorTheme {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color(0xFF2F3031), Color(0xFF16181A)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("123 / 4 * 456")
                Text("14 022")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Column (
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                        ) {
                    Row() {
                        NumButton("1") { }
                        NumButton("2") { }
                        NumButton("3") { }
                    }
                    Row() {
                        NumButton("4") { }
                        NumButton("5") { }
                        NumButton("6") { }
                    }
                    Row() {
                        NumButton("7") { }
                        NumButton("8") { }
                        NumButton("9") { }
                    }
                    Row() {
                        NumButton(".") { }
                        NumButton("0") { }
                    }
                }

                Column(
                    modifier = Modifier.absolutePadding(top= 32.dp, bottom = 32.dp)
                        .background(color = Color.Black)
                ) {
                    NumButton("C") { }
                    NumButton("/") { }
                    NumButton("*") { }
                    NumButton("-") { }
                    NumButton("+") { }
                    NumButton("=") { }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    Content()
}