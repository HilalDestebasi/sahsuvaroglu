package com.sahsuvaroglu.kgm

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sahsuvaroglu.kgm.databinding.ActivityLocationBinding


class LocationActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityLocationBinding
    private val locationPermission = Manifest.permission.ACCESS_FINE_LOCATION

    private val LOCATION_PERMISSION_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        // Bildirim çubuğunu gizleme
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController?.run {
                hide(WindowInsetsCompat.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_DEFAULT
            }
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.locationPageLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.locationSgLogo.setOnClickListener {
            showPopup(it, this)
        }
        // Konum izinlerini kontrol et ve izinleri talep et
        if (hasLocationPermission()) {
            // İzinler zaten varsa, konum işlemlerine devam et
            performLocationOperations()
        } else {
            // İzinler yoksa, izinleri talep et
            requestLocationPermission()
        }
        binding.locationBackIcon.setOnClickListener {
            finish()
        }

    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Konum izni verildiyse, konum işlemlerine devam et
                performLocationOperations()
            } else {
                Toast.makeText(this, "izin olmadı", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun performLocationOperations() {
        // Konum izni kontrolü yapın
        if (hasLocationPermission()) {
            val mapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
            mapFragment?.getMapAsync(this)
        } else {
            // Eğer hala izin yoksa, tekrar izin talep edin
            requestLocationPermission()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Google Haritalar nesnesine erişim sağlandı
        val map = googleMap as GoogleMap  // GoogleMap türünde tanımlayın veya dönüştürün

        addMarkers()

        // Özel bilgi penceresi adaptörünü ayarlayın
        map.setInfoWindowAdapter(CustomInfoWindowAdapter())

        // Haritayı Türkiye'ye odaklayın
        val initialLocation = LatLng(39.925533, 32.866287)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 5f))
    }

    private fun addMarkers() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            val map = googleMap
            val locations = listOf(
                LocationInfo(
                    "YMY MALTEPE / ŞAHSUVAROĞLU",
                    "Satış - Servis",
                    LatLng(40.937976, 29.166809),
                    "Zümrütevler Mahallesi Acarlar Sokak No:3 Maltepe/İstanbul",
                    "+902164277373"
                ),
                LocationInfo(
                    "YMY ANKARA",
                    "Satış - Servis",
                    LatLng(39.921620, 32.834370),
                    "İşçi Blokları Mah. Mevlana Bulvarı No:162 Çankaya/Ankara",
                    "+903122292500"
                ),
                LocationInfo(
                    "YMY ANTALYA",
                    "Satış - Servis",
                    LatLng(36.917888, 30.695556),
                    "Göksu Mah. Gazi Bulvarı No:621 Antalya",
                    "+902423395454"
                ),
                LocationInfo(
                    "YMY BURSA",
                    "Satış - Servis",
                    LatLng(40.216751, 29.009471),
                    "İzmir Yolu Üzeri 8.Km No:279 Bursa",
                    "+902244431225"
                ),
                LocationInfo(
                    "YMY ÇORLU",
                    "Satış - Servis",
                    LatLng(41.178840, 27.805678),
                    "Zafer Mah. Önerler Mevkii E-5 İstanbul Yolu Üzeri Çorlu/Tekirdağ",
                    "+902826854960"
                ),
                LocationInfo(
                    "YMY ERZURUM",
                    "Satış - Servis",
                    LatLng(39.911056, 41.276870),
                    "Çağlayan Mah. Tortum Yolu Cad. No:134 Yakutiye/Erzurum",
                    "+904422424525"
                ),
                LocationInfo(
                    "YMY İZMİR",
                    "Satış - Servis",
                    LatLng(38.424172, 27.141704),
                    "Akçay Caddesi No: 64/1 İzmir",
                    "+902322543425"
                ),
                LocationInfo(
                    "YMY ADANA",
                    "Satış - Servis",
                    LatLng(37.002541, 35.297832),
                    "Kavaklı Mah.Turhan Cemal Beriker Bulvarı No:696/A Adana",
                    "+903224410070"
                ),
                LocationInfo(
                    "YMY MERSİN",
                    "Satış - Servis",
                    LatLng(36.798708, 34.617752),
                    "Menderes Mah. Gazi Mustafa Kemal Bulvarı No: 789/A Mersin",
                    "+903243588200"
                ),
                LocationInfo(
                    "YMY TRABZON",
                    "Satış - Servis",
                    LatLng(40.964532, 39.603367),
                    "Adnan Kahveci Bulvarı No:67 Söğütlü/Trabzon",
                    "+904622486565"
                ),
                LocationInfo(
                    "YMY TUZLA",
                    "Satış - Servis",
                    LatLng(40.858220, 29.287724),
                    "Aydıntepe Mah. E-5 Karayolu No:4 Tuzla/İstanbul",
                    "+902163927979"
                ),
                LocationInfo(
                    "YMY YENİBOSNA",
                    "Satış - Servis",
                    LatLng(41.011032, 28.823065),
                    "Çınar Caddesi No:34 Yenibosna/İstanbul",
                    "+902124528000"
                ),
                LocationInfo(
                    "TUNCERHAN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(37.767506, 29.080201),
                    "Gümüşcay Mah Adnan Menderes Blv No 33/c Merkezefendi/Denizli",
                    "+902582643994"
                ),
                LocationInfo(
                    "NEZİROĞLU OTOMOTİV",
                    "Satış",
                    LatLng(39.903556, 32.774974),
                    "Eskişehir Yolu No:108/B Söğütözü / Ankara",
                    "+903122845252"
                ),
                LocationInfo(
                    "ALKANLAR OTOMOTİV",
                    "Servis",
                    LatLng(37.033649, 27.421665),
                    "Konacık Mahallesi, Konacık Sanayi Sitesi D Blok No:8 Bodrum/Muğla",
                    "+902523638279"
                ),
                LocationInfo(
                    "ÇELİK OTOMOTİV",
                    "Satış - Servis",
                    LatLng(39.596671, 27.022367),
                    "Cennetayağı mahallesi Alpaslan Türkeş bulvarı. No11/1 Edremit Balıkesir",
                    "+902663722424"
                ),
                LocationInfo(
                    "OTOSTORE OTOMOTİV",
                    "Satış - Servis",
                    LatLng(37.924962, 40.210993),
                    "Seyrantepe San. Mah. Seyrantepe Kavşağı Twin Towers A Blok Altı No: 77, 21120 Yenişehir/Diyarbakır",
                    "+904125026097"
                ),
                LocationInfo(
                    "SUR OTOMOTİV",
                    "Satış",
                    LatLng(39.147104, 34.162527),
                    "Kervansaray Mah. 1973. Sk. No:2/4 Merkez/KIRŞEHİR",
                    "+903862527966"
                ),
                LocationInfo(
                    "GRUP İLBEY OTOMOTİV",
                    "Servis",
                    LatLng(37.313581, 40.747516),
                    "Yenişehir Mh. Ravza Cd. 1931 Sk. İlhan Apt. 47200 Artuklu/Mardin",
                    "+904822124900"
                ),
                LocationInfo(
                    "ANIL OTOMOTİV",
                    "Satış - Servis",
                    LatLng(36.570984, 36.155203),
                    "Mustafa Kemal Mah. İbrahim Karaoğlanoğlu Cad. No.80/A İskenderun / Hatay",
                    "+903266187700"
                ),
                LocationInfo(
                    "B MOTORS OTOMOTİV",
                    "Satış",
                    LatLng(39.751018, 37.004507),
                    "Uzuntepe Mah. Sultanşehir Blv. 1.OSGB Karşısı No: 176 Merkez / Sivas",
                    "+903462263058"
                ),
                LocationInfo(
                    "AHİ GROUP OTOMOTİV",
                    "Servis",
                    LatLng(39.753952, 39.492230),
                    "Gülalibey Mah. 967 Sk. No: 28 Merkez / Erzincan",
                    "+904462147588"
                ),
                LocationInfo(
                    "KONYA PRATİK OTOMOTİV",
                    "Servis",
                    LatLng(37.878744, 32.491287),
                    "Kottim İş Merkezi Fevzi Çakmak Mahallesi Çelik Caddesi No:8 Karatay/ KONYA",
                    "+903322386326"
                ),
                LocationInfo(
                    "KONYA TAMİR BAKIM SERVİSİ (AHTAP OTO)",
                    "Servis",
                    LatLng(37.886513, 32.506374),
                    "Musalla Bağları Mahallesi Gürsesler Sk. Sefer A.Ş. Sitesi N:2 Selçuklu/Konya",
                    "+903322441010"
                ),
                LocationInfo(
                    "ADAŞEN OTOMOTİV",
                    "Servis",
                    LatLng(40.764245, 30.391875),
                    "Adnan Menderes Cad. No: 143 Adapazarı / SAKARYA",
                    "+902643595454"
                ),
                LocationInfo(
                    "AYHAN OTOMOTİV",
                    "Servis",
                    LatLng(41.456523, 31.797572),
                    "1.Sanayi Sitesi B Blok No: 9-10 Zonguldak",
                    "+903723161896"
                ),
                LocationInfo(
                    "AYIK OTOMOTİV",
                    "Servis",
                    LatLng(39.747912, 37.011337),
                    "Mehmet Akif Ersoy Mh. Yeni Sanayi Girişi Halifelik Cad. No:1-2 Sivas",
                    "+903462151208"
                ),
                LocationInfo(
                    "ÇETİN OTOMOTİV",
                    "Servis",
                    LatLng(36.657314, 29.105894),
                    "Taşyaka Mah. Yeni San. Sitesi 254. Sok. No:27 Muğla",
                    "+902526145488"
                ),
                LocationInfo(
                    "GANİ KARDEŞLER",
                    "Servis",
                    LatLng(40.736171, 31.594735),
                    "Gülabi Bey Mah. 967.Sok. No:28-32 Bolu",
                    "+903742158455"
                ),
                LocationInfo(
                    "GÜÇLÜ OTOMOTİV",
                    "Servis",
                    LatLng(38.669943, 39.223783),
                    "Ataşehir Mah. Malatya Cad. Cezaevi Sok. No: 289 Elazığ",
                    "+904242471801"
                ),
                LocationInfo(
                    "GÜRCAN OTOMOTİV",
                    "Servis",
                    LatLng(41.108056, 29.007932),
                    "Atatürk Oto Sanayi Sitesi 1. Kısım A Blok No:78 Maslak/İstanbul",
                    "+902123462608"
                ),
                LocationInfo(
                    "KESKİN KARDEŞLER",
                    "Servis",
                    LatLng(41.324824, 36.268564),
                    "Toybelen Mah. Anadolu Bulvarı No:175 İç Kapı No: Z1 İlkadım/Samsun",
                    "+903622665583"
                ),
                LocationInfo(
                    "OTOFORS OTOMOTİV",
                    "Servis",
                    LatLng(37.769423, 29.088364),
                    "Sümer Mah. 53. Sok. No:29 Merkezefendi/Denizli",
                    "+902582666159"
                ),
                LocationInfo(
                    "ŞAHİN OTOMOTİV",
                    "Servis",
                    LatLng(38.750727, 30.553551),
                    "2.Küçük Sanayi Sitesi 6.Ada 4.Blok No: 5 Afyon",
                    "+902722234545"
                ),
                LocationInfo(
                    "TÜREL OTOMOTİV",
                    "Servis",
                    LatLng(38.731964, 35.491013),
                    "Yeni Sanayi Sitesi 3.Cad 84.Sokak Kayseri",
                    "+903523325848"
                ),
                LocationInfo(
                    "UZMANN OTOMOTİV",
                    "Servis",
                    LatLng(36.555387, 31.995304),
                    "Kestel Mah. Semt Sahil Cad. 23 Z01 Alanya/Antalya",
                    "+902425151618"
                ),
                LocationInfo(
                    "VAN GÖLÜ OTOMOTİV",
                    "Servis",
                    LatLng(38.501349, 43.383951),
                    "Seyrantepe Mah. Sanayi Sitesi 1. Sok. B1 Blok No:3/7 -VAN",
                    "+905321138314"
                ),
                LocationInfo(
                    "ALN OTOMOTİV",
                    "SAtış - Servis",
                    LatLng(38.680254, 39.207638),
                    "Sarayatik, Cahit Dalokay Blv. No:2, 23100 Elâzığ Merkez/Elazığ",
                    "+905435607484"
                ),
                LocationInfo(
                    "ZEKİ KAYA OTOMOTİV",
                    "Satış",
                    LatLng(37.876340, 32.504069),
                    "Musalla Bağları, Elmalı Cd. No: 51, 42060 Selçuklu/Konya",
                    "+903322359900"
                ),
                LocationInfo(
                    "ULAK OTOMOTIV",
                    "Satış - Servis",
                    LatLng(38.495014, 43.372922),
                    "Süphan Mah. İpekyolu Blv. No: 351 Edremit/Van",
                    "+904322170303"
                )

            )


            locations.forEach { location ->
                val marker =
                    map.addMarker(MarkerOptions().position(location.latLng).title("Marker"))
                marker!!.tag = location // Marker'a LocationInfo nesnesini etiket olarak ekleyin
            }
        }
    }

    inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {
        private val window: View = layoutInflater.inflate(R.layout.custom_info_window, null)

        override fun getInfoWindow(marker: Marker): View? {
            render(marker, window)
            return window
        }

        override fun getInfoContents(marker: Marker): View? {
            return null
        }

        private fun render(marker: Marker, view: View) {
            val locationInfo = marker.tag as? LocationInfo ?: return
            val title = view.findViewById<TextView>(R.id.address_title)
            val satSer = view.findViewById<TextView>(R.id.satis_servis)
            val addressView = view.findViewById<TextView>(R.id.address)
            val phoneView = view.findViewById<TextView>(R.id.phone)
            addressView.text = locationInfo.address
            phoneView.text = locationInfo.phone
            title.text = locationInfo.title
            satSer.text = locationInfo.satSer
        }
    }
}

data class LocationInfo(
    val title: String,
    val satSer: String,
    val latLng: LatLng,
    val address: String,
    val phone: String
)

