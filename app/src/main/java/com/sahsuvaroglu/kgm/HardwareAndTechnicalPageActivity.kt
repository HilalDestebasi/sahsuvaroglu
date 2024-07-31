package com.sahsuvaroglu.kgm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahsuvaroglu.kgm.databinding.ActivityHardwareAndTechnicalPageBinding

class HardwareAndTechnicalPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHardwareAndTechnicalPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHardwareAndTechnicalPageBinding.inflate(layoutInflater)

        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)

        binding.hardwareAndTechnicalPageLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.techLogo.setOnClickListener {
            showPopup(it, this)
        }
        binding.hardLogo.setOnClickListener {
            showPopup(it, this)
        }

        val carName = intent.getStringExtra("CAR_NAME")
        if (carName == "Torres EVX") {
            val car = CarManager.getTorresEvx().car.get(0)
            binding.hardNTechPageTitle.setImageResource(R.drawable.torres_evx_logo_color)
            binding.apply {
                hardNTechPageSubtitle.text = car.carGeneralInfo.title
                hardNTechPageInformation.text =
                    "• " + car.carGeneralInfo.subInfo1 + "\n• " + car.carGeneralInfo.subInfo2 + "\n• " + car.carGeneralInfo.subInfo3
                hardNTechPagePriceInformation.text = car.carGeneralInfo.price
                hardNTechPageCarImg.setImageResource(R.drawable.torres_evx7)
                genelBakisList.layoutManager = LinearLayoutManager(root.context)
                genelBakisList.adapter = TechAdapter(
                    listOf(
                        TechItem("Kapı Sayısı", "5"),
                        TechItem("Azami Sürat", "175 km/saat")
                    )
                )
                motorPerformansList.layoutManager = LinearLayoutManager(root.context)
                motorPerformansList.adapter = TechAdapter(
                    listOf(
                        TechItem("Motor Gücü", "152,2 kw (206,9) hp"),
                        TechItem("Maksimum Tork", "339 Nm")
                    )
                )
                yakitTuketimiList.layoutManager = LinearLayoutManager(root.context)
                yakitTuketimiList.adapter = TechAdapter(
                    listOf(
                        TechItem("Ortalama Enerji Tüketimi", "13,5 Wh/Km"),
                        TechItem("Batarya Kapasitesi", "73,4 kWh")
                    )
                )
                boyutlarList.layoutManager = LinearLayoutManager(root.context)
                boyutlarList.adapter = TechAdapter(
                    listOf(
                        TechItem("Koltuk Sayısı", "5 Koltuk"),
                        TechItem("Uzunluk", "4715 mm"),
                        TechItem("Genişlik", "1890 mm"),
                        TechItem("Yükseklik", "1715 mm"),
                        TechItem("Net Ağırlık", "1915 kg"),
                        TechItem("Bagaj Hacmi", "839 lt"),
                        TechItem("Lastik Ölçüleri", "225 R60 - 245 R45"),
                    )
                )
                guvenlikList.layoutManager = LinearLayoutManager(root.context)
                guvenlikList.adapter = HardAdapter(
                    car.equipmentFeatures.safety
                )
                multimediaList.layoutManager = LinearLayoutManager(root.context)
                multimediaList.adapter = HardAdapter(
                    car.equipmentFeatures.multimedia
                )
                konforList.layoutManager = LinearLayoutManager(root.context)
                konforList.adapter = HardAdapter(
                    car.equipmentFeatures.comfort
                )
                icDonanimList.layoutManager = LinearLayoutManager(root.context)
                icDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.interior
                )
                disDonanimList.layoutManager = LinearLayoutManager(root.context)
                disDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.exterior
                )
                bilgiSistemList.layoutManager = LinearLayoutManager(root.context)
                bilgiSistemList.adapter = HardAdapter(
                    car.equipmentFeatures.informationSystem
                )
            }

        } else if (carName!!.contains("D2.2")) {
            binding.hardNTechPageTitle.setImageResource(R.drawable.mussogrand_logo_color)
            val car: CarI
            if (carName == "Platinum D2.2 4x2") {
                car = CarManager.getMussoGrand().car.get(0)
            } else if (carName == "Platinum D2.2 4x4") {
                car = CarManager.getMussoGrand().car.get(1)
            } else if (carName == "Platinum Plus D2.2 4x2") {
                car = CarManager.getMussoGrand().car.get(2)
            } else {
                car = CarManager.getMussoGrand().car.get(3)
            }
            binding.apply {
                hardNTechPageSubtitle.text = car.carGeneralInfo.title
                hardNTechPageInformation.text =
                    "• " + car.carGeneralInfo.subInfo1 + "\n• " + car.carGeneralInfo.subInfo2 + "\n• " + car.carGeneralInfo.subInfo3
                hardNTechPagePriceInformation.text = car.carGeneralInfo.price
                hardNTechPageCarImg.setImageResource(R.drawable.musso_grand8)
                genelBakisList.layoutManager = LinearLayoutManager(root.context)
                genelBakisList.adapter = TechAdapter(
                    listOf(
                        TechItem("Kapı Sayısı", car.technicalSpecifications.overview.doorCount),
                        TechItem("Azami Sürat", car.technicalSpecifications.overview.maxSpeed),
                        TechItem(
                            "Silindir Sayısı",
                            car.technicalSpecifications.overview.cylinderCount
                        ),
                        TechItem("Vites Sayısı", car.technicalSpecifications.overview.gearCount)
                    )
                )
                motorPerformansList.layoutManager = LinearLayoutManager(root.context)
                motorPerformansList.adapter = TechAdapter(
                    listOf(
                        TechItem(
                            "Motor Gücü",
                            car.technicalSpecifications.engineAndPerformance.enginePower
                        ),
                        TechItem(
                            "Motor Hacmi",
                            car.technicalSpecifications.engineAndPerformance.engineVolume
                        ),
                        TechItem(
                            "Maksimum Tork",
                            car.technicalSpecifications.engineAndPerformance.maxTorque
                        ),
                        TechItem(
                            "Maksimum Devir",
                            car.technicalSpecifications.engineAndPerformance.maxRev
                        ),
                    )
                )
                yakitTuketimiList.layoutManager = LinearLayoutManager(root.context)
                yakitTuketimiList.adapter = TechAdapter(
                    listOf(
                        TechItem(
                            "Ortalama Yakıt Tüketimi",
                            car.technicalSpecifications.fuelConsumption.averageConsumption
                        ),
                        TechItem(
                            "Yakıt Deposu",
                            car.technicalSpecifications.fuelConsumption.fuelTank
                        )
                    )
                )
                boyutlarList.layoutManager = LinearLayoutManager(root.context)
                boyutlarList.adapter = TechAdapter(
                    listOf(
                        TechItem("Koltuk Sayısı", car.technicalSpecifications.dimensions.seatCount),
                        TechItem("Uzunluk", car.technicalSpecifications.dimensions.length),
                        TechItem("Genişlik", car.technicalSpecifications.dimensions.width),
                        TechItem("Yükseklik", car.technicalSpecifications.dimensions.height),
                        TechItem("Net Ağırlık", car.technicalSpecifications.dimensions.netWeight),
                        TechItem("Bagaj Hacmi", car.technicalSpecifications.dimensions.trunkVolume),
                        TechItem(
                            "Lastik Ölçüleri",
                            car.technicalSpecifications.dimensions.tireDimensions
                        ),
                    )
                )
                guvenlikList.layoutManager = LinearLayoutManager(root.context)
                guvenlikList.adapter = HardAdapter(
                    car.equipmentFeatures.safety
                )
                multimediaList.layoutManager = LinearLayoutManager(root.context)
                multimediaList.adapter = HardAdapter(
                    car.equipmentFeatures.multimedia
                )
                konforList.layoutManager = LinearLayoutManager(root.context)
                konforList.adapter = HardAdapter(
                    car.equipmentFeatures.comfort
                )
                icDonanimList.layoutManager = LinearLayoutManager(root.context)
                icDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.interior
                )
                disDonanimList.layoutManager = LinearLayoutManager(root.context)
                disDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.exterior
                )
                bilgiSistemList.layoutManager = LinearLayoutManager(root.context)
                bilgiSistemList.adapter = HardAdapter(
                    car.equipmentFeatures.informationSystem
                )
                if (car.equipmentFeatures.informationSystem.get(0) == "") {
                    bilgiSistemContainer.visibility = View.GONE
                }
            }
        } else {
            binding.hardNTechPageTitle.setImageResource(R.drawable.torres_logo_color)
            val car: CarI
            if (carName == "Torres 4x2") {
                car = CarManager.getTorres().car.get(0)
            } else {
                car = CarManager.getTorres().car.last()
            }
            binding.apply {
                hardNTechPageSubtitle.text = car.carGeneralInfo.title
                hardNTechPageInformation.text =
                    "• " + car.carGeneralInfo.subInfo1 + "\n• " + car.carGeneralInfo.subInfo2 + "\n• " + car.carGeneralInfo.subInfo3
                hardNTechPagePriceInformation.text = car.carGeneralInfo.price
                hardNTechPageCarImg.setImageResource(R.drawable.torres3)
                genelBakisList.layoutManager = LinearLayoutManager(root.context)
                genelBakisList.adapter = TechAdapter(
                    listOf(
                        TechItem("Kapı Sayısı", car.technicalSpecifications.overview.doorCount),
                        TechItem("Azami Sürat", car.technicalSpecifications.overview.maxSpeed),
                        TechItem(
                            "Silindir Sayısı",
                            car.technicalSpecifications.overview.cylinderCount
                        ),
                        TechItem("Vites Sayısı", car.technicalSpecifications.overview.gearCount)
                    )
                )
                motorPerformansList.layoutManager = LinearLayoutManager(root.context)
                motorPerformansList.adapter = TechAdapter(
                    listOf(
                        TechItem(
                            "Motor Gücü",
                            car.technicalSpecifications.engineAndPerformance.enginePower
                        ),
                        TechItem(
                            "Motor Hacmi",
                            car.technicalSpecifications.engineAndPerformance.engineVolume
                        ),
                        TechItem(
                            "Maksimum Tork",
                            car.technicalSpecifications.engineAndPerformance.maxTorque
                        ),
                        TechItem(
                            "Maksimum Devir",
                            car.technicalSpecifications.engineAndPerformance.maxRev
                        ),
                    )
                )
                yakitTuketimiList.layoutManager = LinearLayoutManager(root.context)
                yakitTuketimiList.adapter = TechAdapter(
                    listOf(
                        TechItem(
                            "Ortalama Yakıt Tüketimi",
                            car.technicalSpecifications.fuelConsumption.averageConsumption
                        ),
                        TechItem(
                            "Yakıt Deposu",
                            car.technicalSpecifications.fuelConsumption.fuelTank
                        )
                    )
                )
                boyutlarList.layoutManager = LinearLayoutManager(root.context)
                boyutlarList.adapter = TechAdapter(
                    listOf(
                        TechItem("Koltuk Sayısı", car.technicalSpecifications.dimensions.seatCount),
                        TechItem("Uzunluk", car.technicalSpecifications.dimensions.length),
                        TechItem("Genişlik", car.technicalSpecifications.dimensions.width),
                        TechItem("Yükseklik", car.technicalSpecifications.dimensions.height),
                        TechItem("Net Ağırlık", car.technicalSpecifications.dimensions.netWeight),
                        TechItem("Bagaj Hacmi", car.technicalSpecifications.dimensions.trunkVolume),
                        TechItem(
                            "Lastik Ölçüleri",
                            car.technicalSpecifications.dimensions.tireDimensions
                        ),
                    )
                )
                guvenlikList.layoutManager = LinearLayoutManager(root.context)
                guvenlikList.adapter = HardAdapter(
                    car.equipmentFeatures.safety
                )
                multimediaList.layoutManager = LinearLayoutManager(root.context)
                multimediaList.adapter = HardAdapter(
                    car.equipmentFeatures.multimedia
                )
                konforList.layoutManager = LinearLayoutManager(root.context)
                konforList.adapter = HardAdapter(
                    car.equipmentFeatures.comfort
                )
                icDonanimList.layoutManager = LinearLayoutManager(root.context)
                icDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.interior
                )
                disDonanimList.layoutManager = LinearLayoutManager(root.context)
                disDonanimList.adapter = HardAdapter(
                    car.equipmentFeatures.exterior
                )
                bilgiSistemList.layoutManager = LinearLayoutManager(root.context)
                bilgiSistemList.adapter = HardAdapter(
                    car.equipmentFeatures.informationSystem
                )
                if (car.equipmentFeatures.informationSystem.get(0) == "") {
                    bilgiSistemContainer.visibility = View.GONE
                }
            }
        }
        binding.hardwareNTechnicalBackIcon.setOnClickListener {
            finish()
        }
        binding.apply {
            genelBakisContainer.setOnClickListener {
                if (genelBakisList.visibility == View.VISIBLE) {
                    genelBakisList.visibility = View.GONE
                } else {
                    genelBakisList.visibility = View.VISIBLE
                }
            }
            motorVePerformansContainer.setOnClickListener {
                if (motorPerformansList.visibility == View.VISIBLE) {
                    motorPerformansList.visibility = View.GONE
                } else {
                    motorPerformansList.visibility = View.VISIBLE
                }
            }
            yakitTuketimiContainer.setOnClickListener {
                if (yakitTuketimiList.visibility == View.VISIBLE) {
                    yakitTuketimiList.visibility = View.GONE
                } else {
                    yakitTuketimiList.visibility = View.VISIBLE
                }
            }
            boyutlarContainer.setOnClickListener {
                if (boyutlarList.visibility == View.VISIBLE) {
                    boyutlarList.visibility = View.GONE
                } else {
                    boyutlarList.visibility = View.VISIBLE
                }
            }
            hardNTechPageHardButton.setOnClickListener {
                hardContainer.visibility = View.VISIBLE
                techContainer.visibility = View.GONE
                hardLogo.visibility = View.VISIBLE
                techLogo.visibility = View.GONE
                hardNTechPageTechButton.setBackgroundResource(R.drawable.hard_n_tech_background)
                hardNTechPageHardButton.setBackgroundResource(R.drawable.hard_n_tech_selected_background)
            }
            hardNTechPageTechButton.setOnClickListener {
                hardContainer.visibility = View.GONE
                techContainer.visibility = View.VISIBLE
                hardLogo.visibility = View.GONE
                techLogo.visibility = View.VISIBLE
                hardNTechPageTechButton.setBackgroundResource(R.drawable.hard_n_tech_selected_background)
                hardNTechPageHardButton.setBackgroundResource(R.drawable.hard_n_tech_background)
            }
            guvenlikContainer.setOnClickListener {
                if (guvenlikList.visibility == View.VISIBLE)
                    guvenlikList.visibility = View.GONE
                else
                    guvenlikList.visibility = View.VISIBLE
            }
            multimediaContainer.setOnClickListener {
                if (multimediaList.visibility == View.VISIBLE)
                    multimediaList.visibility = View.GONE
                else
                    multimediaList.visibility = View.VISIBLE
            }
            konforContainer.setOnClickListener {
                if (konforList.visibility == View.VISIBLE)
                    konforList.visibility = View.GONE
                else
                    konforList.visibility = View.VISIBLE
            }
            icDonanimContainer.setOnClickListener {
                if (icDonanimList.visibility == View.VISIBLE)
                    icDonanimList.visibility = View.GONE
                else
                    icDonanimList.visibility = View.VISIBLE
            }
            disDonanimContainer.setOnClickListener {
                if (disDonanimList.visibility == View.VISIBLE)
                    disDonanimList.visibility = View.GONE
                else
                    disDonanimList.visibility = View.VISIBLE
            }
            bilgiSistemContainer.setOnClickListener {
                if (bilgiSistemList.visibility == View.VISIBLE)
                    bilgiSistemList.visibility = View.GONE
                else
                    bilgiSistemList.visibility = View.VISIBLE
            }
        }

    }
}