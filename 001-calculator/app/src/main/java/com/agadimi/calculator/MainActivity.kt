package com.agadimi.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Dimension
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
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
fun Content()
{
    CalculatorTheme {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color(0xFF1B3753), Color(0xFF031220)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        ){
            Text("Built with compose",
                modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color(0xFFEBEBEB)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max=300.dp)
                    .weight(1f)
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text("123 / 4 * 456", modifier = Modifier.fillMaxWidth(),
                    fontSize = 28.sp, color = Color(0xFF50BEE9)
                )
                Text("14 022",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top= 8.dp),
                    fontSize = 45.sp, color = Color(0xFFFFFFFF))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 64.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                NumPad()
                OperatorPad()
            }
        }
    }
}

@Composable
fun NumButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit)
{
    TextButton(
        onClick = onClick,
        modifier = modifier
            .width(90.dp)
            .height(90.dp)
            .clip(RoundedCornerShape(45.dp))
            .background(Color.Transparent)
    ) {
        Text(text, color = Color(0xFFD6D4D4), fontSize = 28.sp)
    }
}

@Composable
fun NumPad(){
    Column (
        modifier = Modifier
            .width(286.dp)
            .wrapContentHeight()
            .padding(end = 16.dp),
    ) {
        Divider(modifier=Modifier.fillMaxWidth().padding(start=16.dp).clip(RoundedCornerShape(1.dp))
            ,color= Color(0xFFD6D4D4), thickness = 1.dp)
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
            NumButton("C") { }
        }
    }
}


@Composable
fun OperatorPad(){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .background(color = Color(0xFF3C94E6))
            .width(60.dp)
            .wrapContentHeight()
    ) {
        NumButton("÷", modifier = Modifier.height(82.dp)) { }
        NumButton("×", modifier = Modifier.height(82.dp)) { }
        NumButton("-", modifier = Modifier.height(82.dp)) { }
        NumButton("+", modifier = Modifier.height(82.dp)) { }
        NumButton("=", modifier = Modifier
            .height(70.dp)
            .clip(RoundedCornerShape(40.dp))
            .shadow(15.dp, ambientColor = Color(0xFFEB1A40), spotColor = Color(0xFFEB1A40))
            .background(Color(0xFF2474E4))) { }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    Content()
}