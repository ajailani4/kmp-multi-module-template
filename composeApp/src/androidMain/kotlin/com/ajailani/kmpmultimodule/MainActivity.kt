package com.ajailani.kmpmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ajailani.presentation_android.feature_one.OneScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            App()
            OneScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}