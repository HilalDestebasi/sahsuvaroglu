package com.sahsuvaroglu.kgm.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.sahsuvaroglu.kgm.adapter.SatisServisAdapter
import com.sahsuvaroglu.kgm.databinding.ActivitySatisServisBinding
import com.sahsuvaroglu.kgm.model.SatisServisInfoModel
import com.sahsuvaroglu.kgm.util.showPopup


class SatisServisActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySatisServisBinding

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
        binding = ActivitySatisServisBinding.inflate(layoutInflater)
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
                SatisServisInfoModel(
                    "YMY MALTEPE",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Zümrütevler Mahallesi Acarlar Sokak No:3 Maltepe/İstanbul",
                    "+902164277373"
                ),
                SatisServisInfoModel(
                    "YMY ANKARA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "İşçi Blokları Mah. Mevlana Bulvarı No:162 Çankaya/Ankara",
                    "+903122292500"
                ),
                SatisServisInfoModel(
                    "YMY ANTALYA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Göksu Mah. Gazi Bulvarı No:621 Antalya",
                    "+902423395454"
                ),
                SatisServisInfoModel(
                    "YMY BURSA",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "İzmir Yolu Üzeri 8.Km No:279 Bursa",
                    "+902244431225"
                ),
                SatisServisInfoModel(
                    "YMY ÇORLU",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Zafer Mah. Önerler Mevkii E-5 İstanbul Yolu Üzeri Çorlu/Tekirdağ",
                    "+902826854960"
                ),
                SatisServisInfoModel(
                    "YMY ERZURUM",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Çağlayan Mah. Tortum Yolu Cad. No:134 Yakutiye/Erzurum",
                    "+904422424525"
                ),
                SatisServisInfoModel(
                    "YMY İZMİR",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Akçay Caddesi No: 64/1 İzmir",
                    "+902322543425"
                ),
                SatisServisInfoModel(
                    "YMY ADANA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Kavaklı Mah.Turhan Cemal Beriker Bulvarı No:696/A Adana",
                    "+903224410070"
                ),
                SatisServisInfoModel(
                    "YMY MERSİN",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Menderes Mah. Gazi Mustafa Kemal Bulvarı No: 789/A Mersin",
                    "+903243588200"
                ),
                SatisServisInfoModel(
                    "YMY TRABZON",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Adnan Kahveci Bulvarı No:67 Söğütlü/Trabzon",
                    "+904622486565"
                ),
                SatisServisInfoModel(
                    "YMY TUZLA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Aydıntepe Mah. E-5 Karayolu No:4 Tuzla/İstanbul",
                    "+902163927979"
                ),
                SatisServisInfoModel(
                    "YMY YENİBOSNA",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Çınar Caddesi No:34 Yenibosna/İstanbul",
                    "+902124528000"
                ),
                SatisServisInfoModel(
                    "TUNCERHAN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Gümüşcay Mah Adnan Menderes Blv No 33/c Merkez/Denizli",
                    "+902582643994"
                ),
                SatisServisInfoModel(
                    "NEZİROĞLU OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Eskişehir Yolu No:108/B Söğütözü / Ankara",
                    "+903122845252"
                ),
                SatisServisInfoModel(
                    "ALKANLAR OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Konacık Mahallesi, Konacık Sanayi Sitesi D Blok No:5 Bodrum/Muğla",
                    "+902523638279"
                ),
                SatisServisInfoModel(
                    "ÇELİK OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Cennetayağı mahallesi Alpaslan Türkeş bulvarı. No:9/A BANDIRMA/BALIKESİR",
                    "+902663722424"
                ),
                SatisServisInfoModel(
                    "OTOSTORE OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Seyrantepe San. Mah. Seyrantepe Kavşağı Twin Towers No:1/35 Kağıthane/İstanbul",
                    "+904125026097"
                ),
                SatisServisInfoModel(
                    "SUR OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Kervansaray Mah. 1973. Sk. No:2/4 Merkez/KIRŞEHİR",
                    "+903862527966"
                ),
                SatisServisInfoModel(
                    "GRUP İLBEY OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Yenişehir Mh. Ravza Cd. 1931 Sk. İlhan Apt. 47/A BATMAN",
                    "+904822124900"
                ),
                SatisServisInfoModel(
                    "ANIL OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Mustafa Kemal Mah. İbrahim Karaoğlanoğlu Cad. No:36/A İSKENDERUN/HATAY",
                    "+903266187700"
                ),
                SatisServisInfoModel(
                    "B MOTORS OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Uzuntepe Mah. Sultanşehir Blv. 1.OSGB Karşısı No:18 Sivas",
                    "+903462263058"
                ),
                SatisServisInfoModel(
                    "AHİ GROUP OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Gülalibey Mah. 967 Sk. No: 28 Merkez / Erzincan",
                    "+904462147588"
                ),
                SatisServisInfoModel(
                    "KONYA PRATİK OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Kottim İş Merkezi Fevzi Çakmak Mahallesi Çelik Cad. No:85/5 Konya",
                    "+903322386326"
                ),
                SatisServisInfoModel(
                    "KONYA TAMİR BAKIM SERVİSİ (AHTAP OTO)",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Musalla Bağları Mahallesi Gürsesler Sk. Sefer Apt. No:3/A Konya",
                    "+903322441010"
                ),
                SatisServisInfoModel(
                    "ADAŞEN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Adnan Menderes Cad. No: 143 Adapazarı / SAKARYA",
                    "+902643595454"
                ),
                SatisServisInfoModel(
                    "AYHAN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "1.Sanayi Sitesi B Blok No: 9-10 Zonguldak",
                    "+903723161896"
                ),
                SatisServisInfoModel(
                    "AYIK OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Mehmet Akif Ersoy Mh. Yeni Sanayi Girişi Halife Sitesi No:27 Sivas",
                    "+903462151208"
                ),
                SatisServisInfoModel(
                    "ÇETİN OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Taşyaka Mah. Yeni San. Sitesi 254. Sok. No:27 Fethiye/MUĞLA",
                    "+902526145488"
                ),
                SatisServisInfoModel(
                    "GANİ KARDEŞLER",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Gülabi Bey Mah. 967.Sok. No:28-32 Bolu",
                    "+903742158455"
                ),
                SatisServisInfoModel(
                    "GÜÇLÜ OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Ataşehir Mah. Malatya Cad. Cezaevi Şok. No:289 Elazığ",
                    "+904242471801"
                ),
                SatisServisInfoModel(
                    "GÜRCAN OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Atatürk Oto Sanayi Sitesi 1. Kısım A Blok No:78 Maslak/İstanbul",
                    "+902123462608"
                ),
                SatisServisInfoModel(
                    "KESKİN KARDEŞLER",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Toybelen Mah. Anadolu Bulvarı No:175 İç Kapı No:Z1 İlkadım/Samsun",
                    "+903622665583"
                ),
                SatisServisInfoModel(
                    "OTOFORS OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Sümer Mah. 53. Sok. No:29 Merkezefendi/Denizli",
                    "+902582661599"
                ),
                SatisServisInfoModel(
                    "ŞAHİN OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "2. Küçük Sanayi Sitesi 6. Ada 4. Blok No:5 Afyon",
                    "+902722234545"
                ),
                SatisServisInfoModel(
                    "TUREL OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Yeni Sanayi Sitesi 3. Cad. 84. Sokak Kayseri",
                    "+903523325848"
                ),
                SatisServisInfoModel(
                    "UZMAN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Kestel Mah. Semt Sahil Cad. 23 Z01 Alanya/Antalya",
                    "+902425151618"
                ),
                SatisServisInfoModel(
                    "ALN OTOMOTİV",
                    "Satış - Servis",
                    LatLng(0.000000, 0.000000),
                    "Sarayatik, Cahit Dalokay Blv. No:2, 23100 Elâzığ Merkez/Elâzığ",
                    "+905435607484"
                ),
                SatisServisInfoModel(
                    "ZEKİ KAYA OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "Musalla Bağları, Elmalı Cd. No:51, 42060 Selçuklu/Konya",
                    "+903322359900"
                ),
                SatisServisInfoModel(
                    "ULAK OTOMOTİV",
                    "Satış",
                    LatLng(0.000000, 0.000000),
                    "SÜPHAN MAH. IPEKYOLU BLV. NO:351 EDREMIT/VAN",
                    "+904322170303"
                ),
            SatisServisInfoModel(
                "ERKAYA OTOMOTİV",
                    "Satış - Servis",
                LatLng(0.000000, 0.000000),
                "ATAKENT MAH. 6052 SK. NO:1 IC KAPI NO:1 KARAKÖPRÜ/SANLIURFA",
                "+908502816311"
            ),
            SatisServisInfoModel(
                "ERKAYA OTOMOTİV",
                "Satış",
                LatLng(0.000000, 0.000000),
                "KADIKENDİ MAH. 8728 CAD. NO:20E EYYÜBIYE/ŞANLIURFA",
                "+908502816311"
                )
            )
        val recyclerView = binding.ssRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SatisServisAdapter(locations)

    }


}


