package com.sahsuvaroglu.kgm

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.sahsuvaroglu.kgm.databinding.ActivityLocationBinding


class LocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // System UI visibility configurations
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
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

        // Inflate the layout using ViewBinding
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Add location list to RecyclerView
        addList()

        // Set click listeners
        binding.locationPageLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.locationSgLogo.setOnClickListener {
            showPopup(it, this)
        }
        binding.locationBackIcon.setOnClickListener {
            finish()
        }
    }





    private fun addList() {

        val locations = listOf(
                LocationInfo(
                    "YMY MALTEPE",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Zümrütevler Mahallesi Acarlar Sokak No:3 Maltepe/İstanbul",
                    "+902164277373"
                ),
                LocationInfo(
                    "YMY ANKARA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "İşçi Blokları Mah. Mevlana Bulvarı No:162 Çankaya/Ankara",
                    "+903122292500"
                ),
                LocationInfo(
                    "YMY ANTALYA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Göksu Mah. Gazi Bulvarı No:621 Antalya",
                    "+902423395454"
                ),
                LocationInfo(
                    "YMY BURSA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "İzmir Yolu Üzeri 8.Km No:279 Bursa",
                    "+902244431225"
                ),
                LocationInfo(
                    "YMY ÇORLU",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Zafer Mah. Önerler Mevkii E-5 İstanbul Yolu Üzeri Çorlu/Tekirdağ",
                    "+902826854960"
                ),
                LocationInfo(
                    "YMY ERZURUM",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Çağlayan Mah. Tortum Yolu Cad. No:134 Yakutiye/Erzurum",
                    "+904422424525"
                ),
                LocationInfo(
                    "YMY İZMİR",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Akçay Caddesi No: 64/1 İzmir",
                    "+902322543425"
                ),
                LocationInfo(
                    "YMY ADANA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Kavaklı Mah.Turhan Cemal Beriker Bulvarı No:696/A Adana",
                    "+903224410070"
                ),
                LocationInfo(
                    "YMY MERSİN",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Menderes Mah. Gazi Mustafa Kemal Bulvarı No: 789/A Mersin",
                    "+903243588200"
                ),
                LocationInfo(
                    "YMY TRABZON",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Adnan Kahveci Bulvarı No:67 Söğütlü/Trabzon",
                    "+904622486565"
                ),
                LocationInfo(
                    "YMY TUZLA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Aydıntepe Mah. E-5 Karayolu No:4 Tuzla/İstanbul",
                    "+902163927979"
                ),
                LocationInfo(
                    "YMY YENİBOSNA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Çınar Caddesi No:34 Yenibosna/İstanbul",
                    "+902124528000"
                ),
                LocationInfo(
                    "TUNCERHAN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Gümüşcay Mah Adnan Menderes Blv No 33/c Merkez/Denizli",
                    "+902582643994"
                ),
                LocationInfo(
                    "NEZİROĞLU OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Eskişehir Yolu No:108/B Söğütözü / Ankara",
                    "+903122845252"
                ),
                LocationInfo(
                    "ALKANLAR OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Konacık Mahallesi, Konacık Sanayi Sitesi D Blok No:8 Bodrum/Muğla ",
                    "+902523638279"
                ),
                LocationInfo(
                    "ÇELİK OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Cennetayağı mahallesi Alpaslan Türkeş bulvarı. No11/1 Edremit Balıkesir",
                    "+902663722424"
                ),
                LocationInfo(
                    "OTOSTORE OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Seyrantepe San. Mah. Seyrantepe Kavşağı Twin Towers A Blok Altı No: 77, 21120 Yenişehir/Diyarbakır",
                    "+904125026097"
                ),
                LocationInfo(
                    "SUR OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Kervansaray Mah. 1973. Sk. No:2/4 Merkez/KIRŞEHİR ",
                    "+903862527966"
                ),
                LocationInfo(
                    "GRUP İLBEY OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Yenişehir Mh. Ravza Cd. 1931 Sk. İlhan Apt. 47200 Artuklu/Mardin ",
                    "+904822124900"
                ),
                LocationInfo(
                    "ANIL OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Mustafa Kemal Mah. İbrahim Karaoğlanoğlu Cad. No.80/A İskenderun / Hatay",
                    "+903266187700"
                ),
                LocationInfo(
                    "B MOTORS OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Uzuntepe Mah. Sultanşehir Blv. 1.OSGB Karşısı No: 176 Merkez / Sivas ",
                    "+903462263058"
                ),
                LocationInfo(
                    "AHİ GROUP OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Gülalibey Mah. 967 Sk. No: 28 Merkez / Erzincan",
                    "+904462147588"
                ),
                LocationInfo(
                    "KONYA PRATİK OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Kottim İş Merkezi Fevzi Çakmak Mahallesi Çelik Caddesi No:8 Karatay/ KONYA",
                    "+903322386326"
                ),
                LocationInfo(
                    "KONYA TAMİR BAKIM SERVİSİ (AHTAP OTO)",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Musalla Bağları Mahallesi Gürsesler Sk. Sefer A.Ş. Sitesi N:2 Selçuklu/Konya",
                    "+903322441010"
                ),
                LocationInfo(
                    "ADAŞEN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Adnan Menderes Cad. No: 143 Adapazarı / SAKARYA",
                    "+902643595454"
                ),
                LocationInfo(
                    "AYHAN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "1.Sanayi Sitesi B Blok No: 9-10 Zonguldak",
                    "+903723161896"
                ),
                LocationInfo(
                    "AYIK OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Mehmet Akif Ersoy Mh. Yeni Sanayi Girişi Halifelik Cad No:1-2 Sivas",
                    "+903462151208"
                ),
                LocationInfo(
                    "ÇETİN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Taşyaka Mah. Yeni San. Sitesi 254. Sok. No:27 Fethiye/MUĞLA",
                    "+902526145488"
                ),
                LocationInfo(
                    "GANİ KARDEŞLER",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Gülabi Bey Mah. 967.Sok. No:28-32 Bolu",
                    "+903742158455"
                ),
                LocationInfo(
                    "GÜÇLÜ OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Ataşehir Mah. Malatya Cad. Cezaevi Şok. No:289 Elazığ",
                    "+904242471801"
                ),
                LocationInfo(
                    "GÜRCAN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Atatürk Oto Sanayi Sitesi 1. Kısım A Blok No:78 Maslak/İstanbul",
                    "+902123462608"
                ),
                LocationInfo(
                    "KESKİN KARDEŞLER",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Toybelen Mah. Anadolu Bulvarı No:175 İç Kapı No:Z1 İlkadım/Samsun",
                    "+903622665583"
                ),
                LocationInfo(
                    "OTOFORS OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Sümer Mah. 53. Sok. No:29 Merkezefendi/Denizli",
                    "+902582661599"
                ),
                LocationInfo(
                    "ŞAHİN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "2. Küçük Sanayi Sitesi 6. Ada 4. Blok No:5 Afyon",
                    "+902722234545"
                ),
                LocationInfo(
                    "TUREL OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Yeni Sanayi Sitesi 3. Cad. 84. Sokak Kayseri",
                    "+903523325848"
                ),
                LocationInfo(
                    "UZMAN OTOMOTİV",
                    "Servis",
                    LatLng(0.000000, 0.000000),
                    "Kestel Mah. Semt Sahil Cad. 23 Z01 Alanya/Antalya",
                    "+902425151618"
                ),
                LocationInfo(
                    "ALN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Sarayatik, Cahit Dalokay Blv. No:2, 23100 Elâzığ Merkez/Elâzığ",
                    "+905435607484"
                ),
                LocationInfo(
                    "ZEKİ KAYA OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Musalla Bağları, Elmalı Cd. No:51, 42060 Selçuklu/Konya",
                    "+903322359900"
                ),
                LocationInfo(
                    "ULAK OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "SÜPHAN MAH. IPEKYOLU BLV. NO:351 EDREMIT/VAN",
                    "+904322170303"
                ),
            LocationInfo(
                "ERKAYA OTOMOTİV",
                    "Satış",
                LatLng(0.000000, 0.000000),
                "ATAKENT MAH. 6052 SK. NO:1 IC KAPI NO:1 KARAKÖPRÜ/SANLIURFA",
                "+908502816311"
            ),
            LocationInfo(
                "ERKAYA OTOMOTİV",
                "Servis",
                LatLng(0.000000, 0.000000),
                "KADIKENDİ MAH. 8728 CAD. NO:20E EYYÜBIYE/ŞANLIURFA",
                "+908502816311"
                )
            )
        val recyclerView = binding.ssRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LocationAdapter(locations)

    }


}


