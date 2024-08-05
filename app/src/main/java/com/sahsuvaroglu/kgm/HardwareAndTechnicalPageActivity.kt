package com.sahsuvaroglu.kgm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahsuvaroglu.kgm.databinding.ActivityHardwareAndTechnicalPageBinding

class HardwareAndTechnicalPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHardwareAndTechnicalPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHardwareAndTechnicalPageBinding.inflate(layoutInflater)

        setupWindow()
        setContentView(binding.root)

        setupLogoClickListeners()
        setupCarInfo()
        setupBackIconClickListener()
        setupSectionToggleListeners()
    }

    private fun setupWindow() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun setupLogoClickListeners() {
        binding.hardwareAndTechnicalPageLogo.setOnClickListener {
            navigateToMainActivity()
        }

        binding.techLogo.setOnClickListener {
            showPopup(it, this)
        }

        binding.hardLogo.setOnClickListener {
            showPopup(it, this)
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setupCarInfo() {
        val carName = intent.getStringExtra("CAR_NAME")
        when {
            carName == "Torres EVX" -> setupTorresEvxInfo()
            carName!!.contains("D2.2") -> setupD22Info(carName)
            else -> setupTorresInfo(carName)
        }
    }

    private fun setupTorresEvxInfo() {
        val car = CarManager.getTorresEvx().car[0]
        val imageResourceId = getResourceId(CarManager.getTorresEvx().logo)
        binding.hardNTechPageTitle.setImageResource(imageResourceId)
        binding.apply {
            hardNTechPageSubtitle.text = car.carGeneralInfo.title
            hardNTechPageInformation.text = formatCarGeneralInfo(car.carGeneralInfo)
            hardNTechPagePriceInformation.text = car.carGeneralInfo.price
            hardNTechPageCarImg.setImageResource(getResourceId(car.carGeneralInfo.image))
            setupTechSpecsAdapters(car)
            setupEquipmentFeaturesAdapters(car)
        }
    }

    private fun setupD22Info(carName: String) {
        val carIndex = when (carName) {
            "Platinum D2.2 4x2" -> 0
            "Platinum D2.2 4x4" -> 1
            "Platinum Plus D2.2 4x2" -> 2
            else -> 3
        }
        val car = CarManager.getMussoGrand().car[carIndex]
        binding.hardNTechPageTitle.setImageResource(getResourceId(CarManager.getMussoGrand().logo))
        binding.apply {
            hardNTechPageSubtitle.text = car.carGeneralInfo.title
            hardNTechPageInformation.text = formatCarGeneralInfo(car.carGeneralInfo)
            hardNTechPagePriceInformation.text = car.carGeneralInfo.price
            hardNTechPageCarImg.setImageResource(getResourceId(car.carGeneralInfo.image))
            setupTechSpecsAdapters(car)
            setupEquipmentFeaturesAdapters(car)
            toggleInformationSystemVisibility(car)
        }
    }

    private fun setupTorresInfo(carName: String) {
        val carIndex = if (carName == "Torres 4x2") 0 else CarManager.getTorres().car.lastIndex
        val car = CarManager.getTorres().car[carIndex]
        binding.hardNTechPageTitle.setImageResource(getResourceId(CarManager.getTorres().logo))
        binding.apply {
            hardNTechPageSubtitle.text = car.carGeneralInfo.title
            hardNTechPageInformation.text = formatCarGeneralInfo(car.carGeneralInfo)
            hardNTechPagePriceInformation.text = car.carGeneralInfo.price
            hardNTechPageCarImg.setImageResource(getResourceId(car.carGeneralInfo.image))
            setupTechSpecsAdapters(car)
            setupEquipmentFeaturesAdapters(car)
            toggleInformationSystemVisibility(car)
        }
    }

    private fun formatCarGeneralInfo(info: CarGeneralInfo) =
        "• ${info.subInfo1}\n• ${info.subInfo2}\n• ${info.subInfo3}"

    private fun setupTechSpecsAdapters(car: CarI) {
        binding.genelBakisList.setupAdapter(
            listOf(
                TechItem("Kapı Sayısı", car.technicalSpecifications.overview.doorCount),
                TechItem("Azami Sürat", car.technicalSpecifications.overview.maxSpeed),
                TechItem("Silindir Sayısı", car.technicalSpecifications.overview.cylinderCount),
                TechItem("Vites Sayısı", car.technicalSpecifications.overview.gearCount)
            ).filterNot { it.info.isEmpty() }
        )
        binding.motorPerformansList.setupAdapter(
            listOf(
                TechItem("Motor Gücü", car.technicalSpecifications.engineAndPerformance.enginePower),
                TechItem("Motor Hacmi", car.technicalSpecifications.engineAndPerformance.engineVolume),
                TechItem("Maksimum Tork", car.technicalSpecifications.engineAndPerformance.maxTorque),
                TechItem("Maksimum Devir", car.technicalSpecifications.engineAndPerformance.maxRev),
            ).filterNot { it.info.isEmpty() }
        )
        binding.yakitTuketimiList.setupAdapter(
            listOf(
                TechItem(
                    "Ortalama Yakıt Tüketimi",
                    car.technicalSpecifications.fuelConsumption.averageConsumption
                ),
                TechItem("Yakıt Deposu", car.technicalSpecifications.fuelConsumption.fuelTank)
            ).filterNot { it.info.isEmpty() }
        )
        binding.boyutlarList.setupAdapter(
            listOf(
                TechItem("Koltuk Sayısı", car.technicalSpecifications.dimensions.seatCount),
                TechItem("Uzunluk", car.technicalSpecifications.dimensions.length),
                TechItem("Genişlik", car.technicalSpecifications.dimensions.width),
                TechItem("Yükseklik", car.technicalSpecifications.dimensions.height),
                TechItem("Net Ağırlık", car.technicalSpecifications.dimensions.netWeight),
                TechItem("Bagaj Hacmi", car.technicalSpecifications.dimensions.trunkVolume),
                TechItem("Lastik Ölçüleri", car.technicalSpecifications.dimensions.tireDimensions),
            ).filterNot { it.info.isEmpty() }
        )
    }

    private fun setupEquipmentFeaturesAdapters(car: CarI) {
        binding.guvenlikList.setupAdapter(car.equipmentFeatures.safety.filterNot { it.isEmpty() }.map { TechItem(it, "") })
        binding.multimediaList.setupAdapter(car.equipmentFeatures.multimedia.filterNot { it.isEmpty() }.map { TechItem(it, "") })
        binding.konforList.setupAdapter(car.equipmentFeatures.comfort.filterNot { it.isEmpty() }.map { TechItem(it, "") })
        binding.icDonanimList.setupAdapter(car.equipmentFeatures.interior.filterNot { it.isEmpty() }.map { TechItem(it, "") })
        binding.disDonanimList.setupAdapter(car.equipmentFeatures.exterior.filterNot { it.isEmpty() }.map { TechItem(it, "") })
        binding.bilgiSistemList.setupAdapter(car.equipmentFeatures.informationSystem.filterNot { it.isEmpty() }.map { TechItem(it, "") })
    }

    private fun toggleInformationSystemVisibility(car: CarI) {
        binding.bilgiSistemContainer.visibility =
            if (car.equipmentFeatures.informationSystem.firstOrNull().isNullOrEmpty()) View.GONE else View.VISIBLE
    }

    private fun RecyclerView.setupAdapter(items: List<TechItem>) {
        layoutManager = LinearLayoutManager(context)
        adapter = TechAdapter(items)
    }

    private fun setupBackIconClickListener() {
        binding.hardwareNTechnicalBackIcon.setOnClickListener {
            finish()
        }
    }

    private fun setupSectionToggleListeners() {
        setupToggleListener(binding.genelBakisContainer, binding.genelBakisList)
        setupToggleListener(binding.motorVePerformansContainer, binding.motorPerformansList)
        setupToggleListener(binding.yakitTuketimiContainer, binding.yakitTuketimiList)
        setupToggleListener(binding.boyutlarContainer, binding.boyutlarList)
        setupToggleListener(binding.guvenlikContainer, binding.guvenlikList)
        setupToggleListener(binding.multimediaContainer, binding.multimediaList)
        setupToggleListener(binding.konforContainer, binding.konforList)
        setupToggleListener(binding.icDonanimContainer, binding.icDonanimList)
        setupToggleListener(binding.disDonanimContainer, binding.disDonanimList)
        setupToggleListener(binding.bilgiSistemContainer, binding.bilgiSistemList)

        binding.hardNTechPageHardButton.setOnClickListener {
            switchToHardMode()
        }
        binding.hardNTechPageTechButton.setOnClickListener {
            switchToTechMode()
        }
    }

    private fun setupToggleListener(container: View, list: View) {
        container.setOnClickListener {
            list.visibility = if (list.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }
    }

    private fun switchToHardMode() {
        binding.hardContainer.visibility = View.VISIBLE
        binding.techContainer.visibility = View.GONE
        binding.hardLogo.visibility = View.VISIBLE
        binding.techLogo.visibility = View.GONE
        binding.hardNTechPageTechButton.setBackgroundResource(R.drawable.hard_n_tech_background)
        binding.hardNTechPageHardButton.setBackgroundResource(R.drawable.hard_n_tech_selected_background)
    }

    private fun switchToTechMode() {
        binding.hardContainer.visibility = View.GONE
        binding.techContainer.visibility = View.VISIBLE
        binding.hardLogo.visibility = View.GONE
        binding.techLogo.visibility = View.VISIBLE
        binding.hardNTechPageTechButton.setBackgroundResource(R.drawable.hard_n_tech_selected_background)
        binding.hardNTechPageHardButton.setBackgroundResource(R.drawable.hard_n_tech_background)
    }

    private fun getResourceId(resourceName: String): Int {
        return resources.getIdentifier(resourceName, "drawable", packageName)
    }
}
