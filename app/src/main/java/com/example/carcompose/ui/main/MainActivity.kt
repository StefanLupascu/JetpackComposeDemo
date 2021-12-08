package com.example.carcompose.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.carcompose.R
import com.example.carcompose.data.model.CarDto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }

    @Composable
    private fun MainActivityScreen() {
        val cars = viewModel.carsLiveData.observeAsState()
        Column(
            Modifier
                .background(colorResource(id = R.color.white))
                .fillMaxSize()
        ) {
            TopAppBar {
                Modifier
                    .fillMaxWidth()
                Text(
                    text = "Cars",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            CarsListContainer(cars.value)
        }
    }

    @Composable
    private fun CarsListContainer(cars: List<CarDto>?) {
        LazyColumn(
            modifier = Modifier.background(colorResource(id = R.color.white)),
            // Spacing between items
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_content_padding)),
            // Outside Margins
            contentPadding = PaddingValues(
                horizontal = dimensionResource(id = R.dimen.small_content_padding),
                vertical = dimensionResource(id = R.dimen.small_content_padding)
            )
        ) {
            cars?.let {
                // Data source
                items(it, itemContent = { car ->
                    CarItem(car)
                })
            }
        }
    }

    @Composable
    private fun CarItem(car: CarDto) {
        Card(
            backgroundColor = colorResource(id = R.color.purple_500),
            elevation = dimensionResource(id = R.dimen.xsmall_content_padding),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_content_padding)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row() {
                Image(
                    painter = rememberImagePainter(car.imageLink),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.small_content_padding))
                        .size(dimensionResource(id = R.dimen.image_size))
                )
                TextComponent(car.brand.displayText)
                TextComponent(car.year.toString())
            }
        }
    }

    @Composable
    private fun TextComponent(text: String) {
        Text(
            text = text,
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.small_content_padding))
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}