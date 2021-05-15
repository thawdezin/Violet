package com.thawdezin.violet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thawdezin.violet.ui.VioletTheme

class May15 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = ComposeView(context = applicationContext).apply {
            setContent {
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Thaw De Zin")
//                }
                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "TopAppBar")
                        }
                    )
                }, content = {
                    Greeting(name = "Thaw De Zin")
                }, bottomBar = {
                    BottomAppBar() {
                        Text(
                            text = "Jetpack Compose",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                )
            }
        }
        setContentView(contentView)
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        VioletTheme() {
            Greeting("Android")
        }
    }
}