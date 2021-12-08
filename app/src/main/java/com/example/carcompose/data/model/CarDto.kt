package com.example.carcompose.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CarDto(
    val id: Long,
    val brand: CarBrand,
    val color: String,
    val horsePower: Int,
    val year: Int,
    val price: Int
) {
    val imageLink: String get() = when (brand) {
        CarBrand.BMW -> "https://www.pngall.com/wp-content/uploads/2016/04/BMW-PNG-Image.png"
        CarBrand.MERCEDES_BENZ -> "https://www.mercedes-benz.ro/passengercars/mercedes-benz-cars/models/cla/coupe-c118/explore/_jcr_content/image.MQ6.4.2x.20210519083158.png"
        CarBrand.AUDI -> "https://www.freeiconspng.com/uploads/audi-rs7-png-image-pictures-0.png"
        CarBrand.FORD -> "https://cdn.picpng.com/ford/ford-image-28858.png"
        CarBrand.OPEL -> "https://www.pngplay.com/wp-content/uploads/2/Opel-Car-Background-PNG.png"
        CarBrand.VOLKSWAGEN -> "https://www.pngall.com/wp-content/uploads/2016/05/Volkswagen-PNG-Picture.png"
    }
}