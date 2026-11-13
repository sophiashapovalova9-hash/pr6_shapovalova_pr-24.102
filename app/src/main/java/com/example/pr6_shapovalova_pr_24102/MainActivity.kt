package com.example.pr6_shapovalova_pr_24102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pr6_shapovalova_pr_24102.ui.theme.Pr6_shapovalova_pr24102Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pr6_shapovalova_pr24102Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CounterSection()

        Divider()

        InputSection()

        Divider()

        RecompositionSection()

        Divider()

        RememberSection()

        Divider()

        StateInsideSection()
    }
}

@Composable
fun CounterSection() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text(text = "Урок 6: State — Счётчик кликов", style = MaterialTheme.typography.titleMedium)
        Text(text = "Кликов: $count")

        Button(
            onClick = { count++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Увеличить счётчик")
        }
    }
}

@Composable
fun InputSection() {
    var isChecked by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    Column {
        Text(text = "Урок 7: CheckBox и TextField", style = MaterialTheme.typography.titleMedium)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Text(text = "Я согласен с условиями")
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )

        if (text.isNotEmpty()) {
            Text(text = "Вы ввели: $text")
        }
    }
}

@Composable
fun RecompositionSection() {
    var counter by remember { mutableStateOf(0) }

    Column {
        Text(text = "Урок 8: Recomposition", style = MaterialTheme.typography.titleMedium)
        CounterDisplay(counter = counter, onIncrement = { counter++ })
        InfoText(counter = counter)
    }
}

@Composable
fun CounterDisplay(counter: Int, onIncrement: () -> Unit) {
    Text(text = "Счётчик: $counter")
    Button(onClick = onIncrement) { Text("+") }
}

@Composable
fun InfoText(counter: Int) {
    Text(
        text = if (counter < 3) "Ещё немного..." else "Достаточно!",
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.primary
    )
}

class EvenOdd(private val uppercase: Boolean) {
    fun check(value: Int): String {
        var result = if (value % 2 == 0) "чётное" else "нечётное"
        if (uppercase) result = result.uppercase()
        return result
    }
}

@Composable
fun RememberSection() {
    var counter by remember { mutableStateOf(0) }
    var uppercase by remember { mutableStateOf(false) }

    Column {
        Text(text = "Урок 9: remember", style = MaterialTheme.typography.titleMedium)

        val evenOdd = remember(uppercase) { EvenOdd(uppercase) }

        Checkbox(
            checked = uppercase,
            onCheckedChange = { uppercase = it },
            modifier = Modifier.align(Alignment.Start)
        )
        Text(text = "Регистр текста: ${if (uppercase) "ВЕРХНИЙ" else "обычный"}")

        Text(
            text = "Число $counter — ${evenOdd.check(counter)}",
            fontSize = 18.sp
        )

        Button(onClick = { counter++ }) {
            Text(text = "Изменить число")
        }
    }
}

@Composable
fun StateInsideSection() {
    var isExpanded by remember { mutableStateOf(false) }

    Column {
        Text(text = "Урок 10: remember + mutableStateOf", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isExpanded,
                onCheckedChange = { isExpanded = it }
            )
            Text(text = "Показать подробности")
        }

        if (isExpanded) {
            Text(
                text = "Это дополнительная информация, которая появляется по клику на чекбокс. Состояние хранится внутри Composable-функции с помощью remember + mutableStateOf.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}