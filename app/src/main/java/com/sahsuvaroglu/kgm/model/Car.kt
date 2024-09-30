package com.sahsuvaroglu.kgm.model

data class Car(
    val id: Int,
    val name: String,
    val mainPicture: Int,
    val priceList: List<CarPrice>,
    val gallery: List<String>,
    val youtubeVideoLink: String,
    val colorOptions: List<ColorOptions>,
    val carModelList: List<CarModel>?,
    val car: List<CarI>,
)

data class CarI(
    val name: String,
    val carGeneralInfo: CarGeneralInfo,
    val technicalSpecifications: TechnicalSpecifications,
    val equipmentFeatures: EquipmentFeatures
)

data class CarGeneralInfo(
    val title: String,
    val transmission: String,
    val fuelType: String,
    val driveType: String,
    val startingPrice: String
)

data class CarPrice(
    val modelName: String,
    val price: String
)

data class ColorOptions(
    val picture: String,
    val colorName: String,
)


data class TechnicalSpecifications(
    val overview: Overview,
    val engineAndPerformance: EngineAndPerformance,
    val fuelConsumption: FuelConsumption,
    val dimensions: Dimensions
)
data class Overview(
    val doorCount: String,
    val cylinderCount: String,
    val gearCount: String,
    val maxSpeed: String
)

data class EngineAndPerformance(
    val enginePower: String,
    val engineVolume: String,
    val maxRev: String,
    val maxTorque: String
)

data class FuelConsumption(
    val averageConsumption: String,
    val fuelTank: String
)

data class Dimensions(
    val seatCount: String,
    val length: String,
    val width: String,
    val height: String,
    val netWeight: String,
    val trunkVolume: String,
    val tireDimensions: String
)

data class EquipmentFeatures(
    val safety: List<String>,
    val multimedia: List<String>,
    val exterior: List<String>,
    val comfort: List<String>,
    val interior: List<String>,
    val informationSystem: List<String>
)