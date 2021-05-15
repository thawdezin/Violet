package com.thawdezin.violet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView

import androidx.compose.ui.tooling.preview.Preview

class ConstraintLayoutTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ComposeView(applicationContext).apply{
            setContent {
                MaterialTheme {
                Box(

                ) {

                }
                    TestConstraintLayout()
                }
            }
        }
        setContentView(view)
    }
}

@Preview("Constraint Layout")
@Composable
fun TestConstraintLayout(){
//    val amountTag = "N"
//    ConstraintLayoutTest(
//        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
//        constraintSet = ConstraintSet{
////        val decreaseTag = "Tag"
////        val decreaseConstraint = tag(decreaseTag).apply {
////            left constrainTo parent.left
////        }
//
//            tag(amountTag).apply {
//                //left constrainTo parent.left
//                bottom constrainTo parent.bottom
//                right constrainTo parent.right
//                //top constrainTo parent.top
////                centerHorizontally()
////                centerVertically()
//            }
//    }) {
//        Text(text = "OK Constraint Layout", modifier = Modifier.tag(amountTag))
//    }
}