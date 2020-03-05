package com.thawdezin.violet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainContent()
        }
    }

    @Preview
    @Composable
    fun mainContent() {
        MaterialTheme {
            Scaffold {
                VerticalScroller {
                    Column  {
                        showButton(LayoutPlayground::class.javaObjectType as Class<Any>)
                        showButton(StackLayoutActivity::class.javaObjectType as Class<Any>)
                        showButton(NestedScrollActivity::class.javaObjectType as Class<Any>)
                        showButton(BottomNavigation::class.javaObjectType as Class<Any>)
                        showButton(ImageActivity::class.javaObjectType as Class<Any>)
                        showButton(DateTimeActivity::class.javaObjectType as Class<Any>)
                        showButton(DateTimeActivity::class.javaObjectType as Class<Any>)
                        showButton(TwoEqualContainerActivity::class.javaObjectType as Class<Any>)
                        showButton(BottomNavigationActivity::class.javaObjectType as Class<Any>)
                        showButton(TextChangedOnButtonClickActivity::class.javaObjectType as Class<Any>)
                        showButton(MultiViewWithoutFragment::class.javaObjectType as Class<Any>)
                    }
                }
           }
        }
    }

    private fun showButton(goTo: Class<Any>?) {

        val readableClassName = goTo!!.simpleName.split(("(?=\\p{Upper})").toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray().joinToString(prefix = "", postfix = "", separator = " ")

        Container(expanded = true, alignment = Alignment.Center) {
            Button(
                text = readableClassName,
                onClick = { startActivity(Intent(applicationContext, goTo)) }
            )
        }
        Divider(color = Color.Green, height = 3.dp)
    }
}//MainActivity



@Composable
fun BottomAppBarNoFab(getMyActionImage: () -> Image, getMyNavigationImage: () -> Image) {
    val someActionImage: Image = getMyActionImage()
    val someNavigationImage: Image = getMyNavigationImage()
    val navigationIcon: @Composable() () -> Unit = {
        AppBarIcon(someNavigationImage) { /* doSomething()*/ }
    }
    val actionData = listOf(someActionImage)
    BottomAppBar(
        navigationIcon = navigationIcon,
        actionData = actionData
    ) { actionImage ->
        AppBarIcon(actionImage) { /* doSomething()*/ }
    }
}


