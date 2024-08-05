package com.sahsuvaroglu.kgm

data class Car(
    val name: String = "",
    val mainPicture: String = "",  // Assuming this is a resource name or URL
    val priceList: List<CarPrice> = emptyList(),
    val carModelList: List<CarModel> = emptyList(),
    val car: List<CarI> = emptyList(),
    val logo: String = ""
)

data class CarI(
    val name: String = "",
    val carGeneralInfo: CarGeneralInfo = CarGeneralInfo(),
    val technicalSpecifications: TechnicalSpecifications = TechnicalSpecifications(),
    val equipmentFeatures: EquipmentFeatures = EquipmentFeatures()
)

data class CarGeneralInfo(
    val title: String = "",
    val subInfo1: String = "",
    val subInfo2: String = "",
    val subInfo3: String = "",
    val price: String = "",
    val image: String= "",
)

data class CarPrice(
    val modelName: String = "",
    val price: String = ""
)

data class CarModel(
    val title: String,
    val subInfo1: String,
    val subInfo2: String,
    val subInfo3: String,
    val price: String,
    val img: String
)

data class TechnicalSpecifications(
    val overview: Overview = Overview(),
    val engineAndPerformance: EngineAndPerformance = EngineAndPerformance(),
    val fuelConsumption: FuelConsumption = FuelConsumption(),
    val dimensions: Dimensions = Dimensions()
)

data class Overview(
    val doorCount: String = "",
    val cylinderCount: String = "",
    val gearCount: String = "",
    val maxSpeed: String = ""
)

data class EngineAndPerformance(
    val enginePower: String = "",
    val engineVolume: String = "",
    val maxRev: String = "",
    val maxTorque: String = ""
)

data class FuelConsumption(
    val averageConsumption: String = "",
    val fuelTank: String = ""
)

data class Dimensions(
    val seatCount: String = "",
    val length: String = "",
    val width: String = "",
    val height: String = "",
    val netWeight: String = "",
    val trunkVolume: String = "",
    val tireDimensions: String = ""
)

data class EquipmentFeatures(
    val safety: List<String> = emptyList(),
    val multimedia: List<String> = emptyList(),
    val exterior: List<String> = emptyList(),
    val comfort: List<String> = emptyList(),
    val interior: List<String> = emptyList(),
    val informationSystem: List<String> = emptyList()
)
