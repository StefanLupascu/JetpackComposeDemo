package com.example.carcompose.ui.landing

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.carcompose.R
import com.example.carcompose.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private val viewModel by viewModels<LandingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LandingScreen() }
    }

    @Composable
    private fun LandingScreen() {
        Column(
            Modifier
                .background(colorResource(R.color.white))
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = dimensionResource(id = R.dimen.small_content_padding)),
                verticalArrangement = Arrangement.Top
            ) {
                LandingScreenTitle()
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(vertical = dimensionResource(id = R.dimen.small_content_padding)),
                verticalArrangement = Arrangement.Bottom
            ) {
                LandingScreenButton(R.string.landing_button_local) {
                    Toast.makeText(this@LandingActivity, "Local", Toast.LENGTH_LONG).show()
                    navigateToMainActivity(true)
                }
                LandingScreenButton(R.string.landing_button_remote) {
                    Toast.makeText(this@LandingActivity, "Remote", Toast.LENGTH_LONG).show()
                    navigateToMainActivity(false)
                }
            }
        }
    }

    @Composable
    private fun LandingScreenTitle() {
        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    private fun LandingScreenButton(resource: Int, onClick: () -> Unit) {
        Row(
            Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.small_content_padding))
                .padding(vertical = dimensionResource(id = R.dimen.xsmall_content_padding))
        ) {
            Button(
                onClick = onClick,
                Modifier.height(dimensionResource(id = R.dimen.button_height))
            ) {
                Text(
                    text = stringResource(resource),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.purple_500))
                )
            }
        }
    }

    private fun navigateToMainActivity(isDemoMode: Boolean) {
        viewModel.setDemoMode(isDemoMode)
        val intent = Intent(this@LandingActivity, MainActivity::class.java)
        startActivity(intent)
    }
}