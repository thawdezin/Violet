package com.thawdezin.violet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ComposeView(applicationContext).apply {
            setContent {
                //val img = imageResource(R.drawable.ic_menu_camera)
                //BottomAppBarNoFab(getMyActionImage = { img }, getMyNavigationImage = { img })
            }
        }
        setContentView(view)

    }

//    @Composable
//    fun BottomAppBarNoFab(getMyActionImage: () -> Image?, getMyNavigationImage: () -> Image?) {
//        val someActionImage: Image? = getMyActionImage()
//        val someNavigationImage: Image? = getMyNavigationImage()
//        val navigationIcon: @Composable() () -> Unit = {
//            someNavigationImage?.let { AppBarIcon(it) { /* doSomething()*/ } }
//        }
//        val actionData = listOf(someActionImage)
//        BottomAppBar(
//            navigationIcon = navigationIcon,
//            actionData = actionData
//        ) { actionImage ->
//            actionImage?.let { AppBarIcon(it) { /* doSomething()*/ } }
//        }
//    }
}

