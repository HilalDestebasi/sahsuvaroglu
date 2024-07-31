package com.sahsuvaroglu.kgm

class CarManager {


    companion object {
        private var torresEvx: Car? = null
        private var torres: Car? = null
        private var musso_grand: Car? = null

        fun getTorresEvx(): Car {
            if (torresEvx == null) {
                torresEvx = createTorresEvx()
            }
            return torresEvx!!
        }

        fun getTorres(): Car {
            if (torres == null) {
                torres = createTorres()
            }
            return torres!!

        }

        fun getMussoGrand(): Car{
            if(musso_grand== null){
                musso_grand = createMussoGrand()
            }
            return musso_grand!!
        }

        private fun createMussoGrand(): Car{
            return Car(
                name = "Musso Grand",
                mainPicture = R.drawable.musso_grand,
                car = listOf(
                    CarI(
                        name = "Musso Grand Platinum D2.2 4x2 Otomatik",
                        carGeneralInfo = CarGeneralInfo("Musso Grand Platinum D2.2 4x2 Otomatik","Otomatik","Dizel","4x2","₺1.401.365'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x2 AT Platinum", "1.401.365 TL"),
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x2 AT Platinum Plus", "1.566.365 TL"),
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x4 AT Platinum", "1.539.412 TL"),
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x4 AT Edition", "2.064.412 TL"),
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x4 AT Platinum Plus", "1.674.412 TL"),
                            CarPrice("MUSSO GRAND 2.2 Dizel 4x4 AT Edition", "1.964.412 TL")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/watch?v=SQKOVtZzSls&t=1s",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "4 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "172 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "202 hp",
                                engineVolume = "2157 cc",
                                maxRev = "3800 rpm",
                                maxTorque = "441 Nm (1600-2600 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "9,0 L",
                                fuelTank = "75 L"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "5405 mm",
                                width = "1950 mm",
                                height = "1885 mm",
                                netWeight = "2095 kg",
                                trunkVolume = "1441 lt",
                                tireDimensions = "255/70 R17 - 255/60 R18 - 255/50 R20"
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Hıza Duyarlı Emniyet Kemeri Uyarısı", "HBA (Uzun Far Asistanı)",
                                "Alarm", "ESS (Acil Durum Arka Sinyal Sistemi)",
                                "ESP (Elektronik Stabilite Programı)", "ABS (Kilitlenme Karşıtı Fren Sistemi)",
                                "TCS (Çekiş Kontrol Sistemi)", "HBA (Hidrolik Fren Asistanı)",
                                "Immobilizer", "Sürücü ve Yolcu Ön Hava Yastıkları",
                                "Önde Hava Soğutmalı Disk Frenler", "Arkada Disk Frenler",
                                "Yükseklik Ayarlı Ön Emniyet Kemerleri", "Yüksek Mukavemetli Çelik Şasi",
                                "Ultra Sert 4 Katmanlı Şasi Yapısı", "Yan Çarpmalardan Optimum Koruma Sağlayan Kapı Çarpışma Kirişleri",
                                "EBD- Elektronik Fren Dağıtım Sistemi", "Hıza Duyarlı Kapı Kilidi",
                                "Isofıx Çocuk Koltuğu Bağlantısı", "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Akıllı Ses Sistemi 8\" (Geri Görüş Kamerası ve Akıllı Telefon bağlantılı)",
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)", "6 Adet Hoparlör",
                                "Müzik Sistemi- DAB", "Bluetooth Bağlantı", "USB Bağlantı"
                            ),
                            exterior = listOf(
                                "Arka Sis Farları", "Far Yükseklik Ayarı",
                                "Hafif ve Güçlendirilmiş Arka Bagaj Kapağı", "17\" Aluminyum Alaşım Jant",
                                "Aerodinamik Dış Dikiz Aynaları", "Aerodinamik Silecek Kolları",
                                "Gövde Rengi Kapı Kolları ve Gizli Anahtar Deliği", "Köpekbalığı Anten",
                                "Ön Sis Farları", "Siyah Hava Giriş Izgarası",
                                "Gövde Rengi Kapı Kolları", "Elektrikli Güvenlikli Sürücü Camı",
                                "Gümüş Şık Tavan Çıtaları", "Mercekli Projeksiyon Tipi Farlar",
                                "Isıtmalı Ön Cam", "Renkli Yan Camlar",
                                "Ses Yalıtımlı Renkli Ön Cam", "Sesi Azaltan Akustik Motor Kapağı",
                                "LED Arka Stop", "Görsel VIN (Şasi Numarası)",
                                "Temiz Tutan Kapı Eşikleri"
                            ),
                            comfort = listOf(
                                "Otomatik Far Kontrolü ve Otomatik Silecek Kontrolü",
                                "Helezon Yaylı 5 Nokta Bağlantılı Arka Süspansiyon",
                                "6 Yönlü Ayarlanabilir Sürücü ve Yolcu Ön Koltuğu",
                                "2.Sıra Koltukların Katlanması İçin Katlanır Dirseklik",
                                "Öne Kaymalı Ön Koltuk Başlıkları", "Otomatik Buğu Çözme",
                                "Cruise Control (Hız Sabitleme Sistemi)",
                                "Elektrikli Direksiyon Kolonu Kilidi", "Kumaş Koltuk Döşeme",
                                "Lastik Tamir Kiti", "Hıza Duyarlı Hidrolik Direksiyon",
                                "B Direğinde Tutma Kolu", "Tuş Kilitli Torpido Kutusu",
                                "Yükseklik Ayarlı Ön Koltuk Başlıkları",
                                "60/40 Katlanabilir ve Yatırılabilir Arka Koltuklar",
                                "Katlanır Kol Dayama", "Yükseklik Ayarlı Sürücü Koltuğu",
                                "Işıklı Makyaj Aynası", "Yükleme Alanında Alet Kutusu",
                                "Bagaj Kasa Kancaları", "Akıllı Anahtar",
                                "Helezon Yaylı Çift Salıncaklı Ön Süspansiyon"
                            ),
                            interior = listOf(
                                "Derinlik ve Yükseklik Ayarlı Teleskopik Direksiyon",
                                "Elektrikli Ön Camlar", "Elektrikli Arka Camlar",
                                "Tek Dokunmalı Üçlü Sinyal", "Gümüş İç Kapı Kolları",
                                "Otomatik Kararan Iç Dikiz Aynası", "12V Güç Soketi"
                            ),
                            informationSystem = listOf(
                                "Direksiyondan Kumanda Sistemi",
                                "Yol Bilgisayarı (3.5\" Mono TFT-LCD Ekran)"
                            )
                        )),
                    CarI(
                        name = "Musso Grand Platinum D2.2 4x4 Otomatik",
                        carGeneralInfo = CarGeneralInfo("Musso Grand Platinum D2.2 4x4 Otomatik","Otomatik","Dizel","4x4","₺1.539.412'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("Musso Grand Platinum D2.2 4x4 Otomatik", "₺1.539.412'den başlayan fiyatlarla")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/example",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "4 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "172 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "202 hp",
                                engineVolume = "2157 cc",
                                maxRev = "3800 rpm",
                                maxTorque = "441 Nm (1600-2600 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "9.2 L",
                                fuelTank = "75 L"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "5405 mm",
                                width = "1950 mm",
                                height = "1885 mm",
                                netWeight = "2195 kg",
                                trunkVolume = "1441 lt",
                                tireDimensions = "255/70 R17 - 255/60 R18 - 255/50 R20"
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Hıza Duyarlı Emniyet Kemeri Uyarısı", "HBA (Uzun Far Asistanı)",
                                "Alarm", "ESS (Acil Durum Arka Sinyal Sistemi)",
                                "ESP (Elektronik Stabilite Programı)", "ABS (Kilitlenme Karşıtı Fren Sistemi)",
                                "TCS (Çekiş Kontrol Sistemi)", "HBA (Hidrolik Fren Asistanı)",
                                "Immobilizer", "Sürücü ve Yolcu Ön Hava Yastıkları",
                                "Önde Hava Soğutmalı Disk Frenler", "Arkada Disk Frenler",
                                "Yükseklik Ayarlı Ön Emniyet Kemerleri", "Yüksek Mukavemetli Çelik Şasi",
                                "Ultra Sert 4 Katmanlı Şasi Yapısı", "Yan Çarpmalardan Optimum Koruma Sağlayan Kapı Çarpışma Kirişleri",
                                "EBD- Elektronik Fren Dağıtım Sistemi", "Hıza Duyarlı Kapı Kilidi",
                                "Isofıx Çocuk Koltuğu Bağlantısı", "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Akıllı Ses Sistemi 8\" (Geri Görüş Kamerası ve Akıllı Telefon bağlantılı)",
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Müzik Sistemi- DAB", "Bluetooth Bağlantı",
                                "USB Bağlantısı"
                            ),
                            exterior = listOf(
                                "Far Yükseklik Ayarı", "17\" Aluminyum Alaşım Jant",
                                "Aerodinamik Dış Dikiz Aynaları", "Aerodinamik Silecek Kolları",
                                "Gövde Rengi Kapı Kolları ve Gizli Anahtar Deliği", "Köpekbalığı Anten",
                                "Ön Sis Farları", "Arka Sis Farları", "Hafif ve Güçlendirilmiş Arka Bagaj Kapağı",
                                "Siyah Hava Giriş Izgarası", "Gövde Rengi Kapı Kolları",
                                "Elektrikli Güvenlikli Sürücü Camı", "Gümüş Şık Tavan Çıtaları",
                                "Mercekli Projeksiyon Tipi Farlar", "Isıtmalı Ön Cam",
                                "Renkli Yan Camlar", "Ses Yalıtımlı Renkli Ön Cam",
                                "Sesi Azaltan Akustik Motor Kapağı", "LED Arka Stop",
                                "Görsel VIN (Şasi Numarası)", "Temiz Tutan Kapı Eşikleri"
                            ),
                            comfort = listOf(
                                "B Direğinde Tutma Kolu", "Helezon Yaylı 5 Nokta Bağlantılı Arka Süspansiyon",
                                "6 Yönlü Ayarlanabilir Sürücü ve Yolcu Ön Koltuğu",
                                "2.Sıra Koltukların Katlanması İçin Katlanır Dirseklik",
                                "Öne Kaymalı Ön Koltuk Başlıkları", "Otomatik Far Kontrolü ve Otomatik Silecek Kontrolü",
                                "Otomatik Buğu Çözme", "Cruise Control (Hız Sabitleme Sistemi)",
                                "Lastik Tamir Kiti", "Tuş Kilitli Torpido Kutusu",
                                "Elektrikli Direksiyon Kolonu Kilidi", "Hıza Duyarlı Hidrolik Direksiyon",
                                "Yükseklik Ayarlı Ön Koltuk Başlıkları", "60/40 Katlanabilir ve Yatırılabilir Arka Koltuklar",
                                "Katlanır Kol Dayama", "Yükseklik Ayarlı Sürücü Koltuğu",
                                "Işıklı Makyaj Aynası", "4x4 Geçiş Düğmesi ( 2H,4H,4L)",
                                "Yükleme Alanında Alet Kutusu", "Bagaj Kasa Kancaları",
                                "Akıllı Anahtar", "Helezon Yaylı Çift Salıncaklı Ön Süspansiyon"
                            ),
                            interior = listOf(
                                "Elektrikli Ön Camlar", "Derinlik ve Yükseklik Ayarlı Teleskopik Direksiyon",
                                "Elektrikli Arka Camlar", "Tek Dokunmalı Üçlü Sinyal",
                                "Gümüş İç Kapı Kolları", "Otomatik Kararan Iç Dikiz Aynası",
                                "12V Güç Soketi"
                            ),
                            informationSystem = listOf(
                                "Yol Bilgisayarı (3.5\" Mono TFT-LCD Ekran)",
                                "Direksiyondan Kumanda Sistemi"
                            )
                        )
                    ),
                    CarI(
                        name = "Musso Grand Platinum Plus D2.2 4x2 Otomatik",
                        carGeneralInfo = CarGeneralInfo("Musso Grand Platinum Plus D2.2 4x2 Otomatik","Otomatik","Dizel","4x2","₺1.566.365'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("Musso Grand Platinum Plus D2.2 4x2 Otomatik", "₺1.566.365'den başlayan fiyatlarla")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/example",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "4 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "172 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "202 hp",
                                engineVolume = "2157 cc",
                                maxRev = "3800 rpm",
                                maxTorque = "441 Nm (1600-2600 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "Belirtilmedi",
                                fuelTank = "Belirtilmedi"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "Belirtilmedi",
                                width = "Belirtilmedi",
                                height = "Belirtilmedi",
                                netWeight = "Belirtilmedi",
                                trunkVolume = "Belirtilmedi",
                                tireDimensions = "Belirtilmedi"
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Hızı Algılayan Otomatik Kapı Kilitleri", "Hıza Duyarlı Emniyet Kemeri Uyarısı",
                                "AEBS (Bağımsız Acil Fren Sistemi)", "HBA (Uzun Far Asistanı)",
                                "Alarm", "ESS (Acil Durum Arka Sinyal Sistemi)",
                                "ESP (Elektronik Stabilite Programı)", "ABS (Kilitlenme Karşıtı Fren Sistemi)",
                                "TCS (Çekiş Kontrol Sistemi)", "HBA (Hidrolik Fren Asistanı)",
                                "Immobilizer", "Sürücü ve Yolcu Ön Hava Yastıkları",
                                "Önde Hava Soğutmalı Disk Frenler", "Arkada Disk Frenler",
                                "Yükseklik Ayarlı Ön Emniyet Kemerleri", "Ultra Sert 4 Katmanlı Şasi Yapısı",
                                "Yan Çarpmalardan Optimum Koruma Sağlayan Kapı Çarpışma Kirişleri",
                                "EBD- Elektronik Fren Dağıtım Sistemi", "Hıza Duyarlı Kapı Kilidi",
                                "Isofıx Çocuk Koltuğu Bağlantısı", "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Akıllı Ses Sistemi 8\" (Geri Görüş Kamerası ve Akıllı Telefon bağlantılı)",
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Müzik Sistemi- DAB", "Bluetooth Bağlantı",
                                "USB Bağlantısı"
                            ),
                            exterior = listOf(
                                "Aralıklı Arka Cam Sileceği", "Ön Kapı Aydınlatma Lambası",
                                "Arka Sis Farları", "18\" Alüminyum Alaşım Jant",
                                "Ön Sis Farları", "Temiz Tutan Kapı Eşikleri",
                                "Köpekbalığı Anten", "Renkli Yan Camlar",
                                "Görsel VIN (Şasi Numarası)", "LED Arka Stop",
                                "Sesi Azaltan Akustik Motor Kapağı", "Siyah Hava Giriş Izgarası",
                                "Ses Yalıtımlı Renkli Ön Cam", "Isıtmalı Ön Cam",
                                "Mercekli Projeksiyon Tipi Farlar", "Gümüş Şık Tavan Çıtaları",
                                "Elektrikli Güvenlikli Sürücü Camı", "Gövde Rengi Kapı Kolları",
                                "Far Yükseklik Ayarı", "Aerodinamik Dış Dikiz Aynaları",
                                "Aerodinamik Silecek Kolları", "Gövde Rengi Kapı Kolları ve Gizli Anahtar Deliği",
                                "Hafif ve Güçlendirilmiş Arka Bagaj Kapağı", "Sunroof"
                            ),
                            comfort = listOf(
                                "Lastik Tamir Kiti", "Yükseklik Ayarlı Sürücü Koltuğu",
                                "Öne Kaymalı Ön Koltuk Başlıkları", "Yükseklik Ayarlı Ön Koltuk Başlıkları",
                                "Otomatik Buğu Çözme", "Cruise Control (Hız Sabitleme Sistemi)",
                                "Isıtmalı Arka Koltuklar", "Işıklı Makyaj Aynası",
                                "Katlanır Kol Dayama", "60/40 Katlanabilir ve Yatırılabilir Arka Koltuklar",
                                "Isıtmalı Ön Koltuklar", "Helezon Yaylı 5 Nokta Bağlantılı Arka Süspansiyon",
                                "Yükleme Alanında Alet Kutusu", "Akıllı Anahtar",
                                "Helezon Yaylı Çift Salıncaklı Ön Süspansiyon", "B Direğinde Tutma Kolu",
                                "Elektrikli Ön Koltuklar", "Tuş Kilitli Torpido Kutusu",
                                "Elektrikli Direksiyon Kolonu Kilidi", "Otomatik Far Kontrolü ve Otomatik Silecek Kontrolü",
                                "Bagaj Kasa Kancaları", "Hıza Duyarlı Hidrolik Direksiyon"
                            ),
                            interior = listOf(
                                "Tek Dokunmalı Üçlü Sinyal", "12V Güç Soketi",
                                "Elektrikli Arka Camlar", "Deri Kaplama Direksiyon",
                                "Elektrikli Ön Camlar", "Derinlik ve Yükseklik Ayarlı Teleskopik Direksiyon",
                                "Otomatik Kararan Iç Dikiz Aynası", "Gümüş İç Kapı Kolları",
                                "Deri Kaplama Koltuklar"
                            ),
                            informationSystem = listOf("")
                        )
                    ),
                    CarI(
                        name = "Musso Grand Platinum Plus D2.2 4x4 Otomatik",
                        carGeneralInfo = CarGeneralInfo("Musso Grand Platinum Plus D2.2 4x4 Otomatik","Otomatik","Dizel","4x4","₺1.674.412'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("Musso Grand Platinum Plus D2.2 4x4 Otomatik", "₺1.674.412'den başlayan fiyatlarla")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/example",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "4 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "172 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "202 hp",
                                engineVolume = "2157 cc",
                                maxRev = "3800 rpm",
                                maxTorque = "441 Nm (1600-2600 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "9.2 L",
                                fuelTank = "75 L"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "5405 mm",
                                width = "1950 mm",
                                height = "1885 mm",
                                netWeight = "2195 kg",
                                trunkVolume = "1441 lt",
                                tireDimensions = "255/70 R17 - 255/60 R18 - 255/50 R20"
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Ön Emniyet Kemeri Yük Sınırlama Düzeneği ve Kilitleme Dilli Ön Gergiler",
                                "Hızı Algılayan Otomatik Kapı Kilitleri", "Hıza Duyarlı Emniyet Kemeri Uyarısı",
                                "AEBS (Bağımsız Acil Fren Sistemi)", "HBA (Uzun Far Asistanı)",
                                "Acil Arama Sistemi", "Takviyeli Monoblok Gövde Yapısı",
                                "Yan Darbelere Karşı Kapı Darbe Kirişleri", "Alarm",
                                "ESS (Acil Durum Arka Sinyal Sistemi)", "ESP (Elektronik Stabilite Programı)",
                                "ABS (Kilitlenme Karşıtı Fren Sistemi)", "TCS (Çekiş Kontrol Sistemi)",
                                "HBA (Hidrolik Fren Asistanı)", "Immobilizer",
                                "Sürücü ve Yolcu Ön Hava Yastıkları", "Ön Yolcu Hava Yastığı Kapama Düğmesi",
                                "Önde Hava Soğutmalı Disk Frenler", "Arkada Disk Frenler",
                                "Yükseklik Ayarlı Ön Emniyet Kemerleri", "Ultra Sert 4 Katmanlı Şasi Yapısı",
                                "Yan Çarpmalardan Optimum Koruma Sağlayan Kapı Çarpışma Kirişleri",
                                "EBD- Elektronik Fren Dağıtım Sistemi", "Hıza Duyarlı Kapı Kilidi",
                                "Isofıx Çocuk Koltuğu Bağlantısı", "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Akıllı Ses Sistemi 8\" (Geri Görüş Kamerası ve Akıllı Telefon bağlantılı)",
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Müzik Sistemi- DAB", "AUX Girişi",
                                "Bluetooth Bağlantı", "USB Bağlantısı"
                            ),
                            exterior = listOf(
                                "18\" Alüminyum Alaşım Jant", "Sesi Azaltan Akustik Motor Kapağı",
                                "Ön Sis Farları", "Gümüş Şık Tavan Çıtaları",
                                "Siyah Hava Giriş Izgarası", "Arkada Sportif Koruyucu Plakası",
                                "LED Arka Stop", "Arka Sis Farları",
                                "Ön Kapı Aydınlatma Lambası", "Temiz Tutan Kapı Eşikleri",
                                "Renkli Yan Camlar", "Mercekli Projeksiyon Tipi Farlar",
                                "Isıtmalı Ön Cam", "Elektrikli, Katlanır ve Isıtmalı Dikiz Aynaları",
                                "Ses Yalıtımlı Renkli Ön Cam", "Gövde Rengi Kapı Kolları",
                                "Hibrit Ön Silecekler", "Hafif ve Güçlendirilmiş Arka Bagaj Kapağı",
                                "Aerodinamik Dış Dikiz Aynaları", "Solar Ön Cam",
                                "Far Yükseklik Ayarı", "Aralıklı Arka Cam Sileceği",
                                "PVC Ön ve Arka Kapı Eşikleri", "Görsel VIN (Şasi Numarası)",
                                "Elektrikli Güvenlikli Sürücü Camı", "Sunroof"
                            ),
                            comfort = listOf(
                                "Lastik Tamir Kiti", "Elektronik Park Freni (Otomatik Tutmalı)",
                                "Kablosuz Şarj", "Isıtmalı Ön Koltuklar",
                                "Smart Key (Akıllı Anahtar-Anahtarsız Giriş/Çalıştırma/Kilitleme)",
                                "EPS (Elektrik Destekli Direksiyon)", "Sürüş Modları Sistemi (Normal/Kış/Spor)",
                                "Stop and Go Sistemi (ISG)", "Elektrikli Ön Koltuklar",
                                "Isıtmalı Arka Koltuklar", "4x4 Geçiş Düğmesi ( 2H,4H,4L)",
                                "Elektrikli Direksiyon Kolonu Kilidi", "B Direğinde Tutma Kolu",
                                "Tuş Kilitli Torpido Kutusu", "Öne Kaymalı Ön Koltuk Başlıkları",
                                "Helezon Yaylı 5 Nokta Bağlantılı Arka Süspansiyon",
                                "Helezon Yaylı Çift Salıncaklı Ön Süspansiyon",
                                "Yükseklik Ayarlı Sürücü Koltuğu", "60/40 Katlanabilir ve Yatırılabilir Arka Koltuklar",
                                "Katlanır Kol Dayama", "Yükseklik Ayarlı Ön Koltuk Başlıkları",
                                "Otomatik Buğu Çözme", "Cruise Control (Hız Sabitleme Sistemi)",
                                "Işıklı Makyaj Aynası", "Yükleme Alanında Alet Kutusu"
                            ),
                            interior = listOf(
                                "LED Kapı İçi Aydınlatma", "Otomatik Kararan Iç Dikiz Aynası",
                                "Gümüş İç Kapı Kolları", "Deri Kaplama Direksiyon",
                                "Tek Dokunmalı Üçlü Sinyal", "Elektrikli Arka Camlar",
                                "Elektrikli Ön Camlar", "Deri Kaplama Koltuklar",
                                "12V Güç Soketi", "Derinlik ve Yükseklik Ayarlı Teleskopik Direksiyon"
                            ),
                            informationSystem = listOf("")
                        )
                    )

                )
            )

        }

        private fun createTorres(): Car{
            return  Car(
                mainPicture = R.drawable.torres,
                name = "Torres",
                car = listOf(
                    CarI(
                        name = "Torres 4x2 1.5 GDI Turbo",
                        carGeneralInfo = CarGeneralInfo("Torres 4x2 1.5 GDI Turbo","Otomatik","Benzinli","4x2","₺2.471.450'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("TORRES 1.5 GDI Turbo Benzinli 4x2", "2.471.450 TL"),
                            CarPrice("TORRES 1.5 GDI Turbo Benzinli 4x4", "2.671.450 TL")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/watch?time_continue=1&v=JUATjV-W2J4&embeds_referring_euri=https%3A%2F%2Fssangyong.com.tr%2F&source_ve_path=Mjg2NjY&feature=emb_logo",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "5 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "191 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "163 hp",
                                engineVolume = "1497 cc",
                                maxRev = "5000-5500 rpm",
                                maxTorque = "280 Nm (1500-4000 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "8.5 L",
                                fuelTank = "50 L"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "4700 mm",
                                width = "1890 mm",
                                height = "1710/1720 (Port Bagajlı) mm",
                                netWeight = "1603 kg",
                                trunkVolume = "839 lt",
                                tireDimensions = "235/55R 18\""
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Ön Emniyet Kemeri Yük Sınırlama Düzeneği ve Kilitleme Dilli Ön Gergiler",
                                "Hızı Algılayan Otomatik Kapı Kilitleri", "Hıza Duyarlı Emniyet Kemeri Uyarısı",
                                "AEBS (Bağımsız Acil Fren Sistemi)", "LDW (Şeritten Çıkış Uyarısı)",
                                "LKA (Şerit Koruma Asistanı)", "HBA (Uzun Far Asistanı)",
                                "SDA (Emniyetli Mesafe Uyarısı)", "DAA (Sürücü Yorgunluk Uyarısı)",
                                "FVSA (Öndeki Araç İçin Hareket Uyarısı)", "Takviyeli Monoblok Gövde Yapısı",
                                "Yan Darbelere Karşı Kapı Darbe Kirişleri", "Alarm",
                                "ESS (Acil Durum Arka Sinyal Sistemi)", "ESP (Elektronik Stabilite Programı)",
                                "ABS (Kilitlenme Karşıtı Fren Sistemi)", "TCS (Çekiş Kontrol Sistemi)",
                                "HBA (Hidrolik Fren Asistanı)", "Immobilizer",
                                "Sürücü ve Yolcu Ön Hava Yastıkları", "Sürücü ve Yolcu Yan Hava Yastıkları",
                                "Sürücü Perde Hava Yastığı", "Ön Yolcu Perde Hava Yastığı",
                                "Ön Yolcu Hava Yastığı Kapama Düğmesi", "Önde Hava Soğutmalı Disk Frenler",
                                "Arkada Disk Frenler", "Yükseklik Ayarlı Ön Emniyet Kemerleri",
                                "Arka Koltuklarda Üç Noktadan Bağlantılı Emniyet Kemer Sistemi",
                                "Çocuk Güvenlik Kilidi", "Hıza Duyarlı Kapı Kilidi",
                                "Sürücü Diz Hava Yastığı", "Isofıx Çocuk Koltuğu Bağlantısı",
                                "FTCS-Çekiş Kontrol Sistemi", "FCW-Ön Çarpışma Uyarısı",
                                "RCTA-Arka Çapraz Trafik Uyarısı", "Arka Yolcu Perde Hava Yastıkları",
                                "Park Asistanı Sistemi", "Yüksek Gergili Çelik Yapı",
                                "Darbe Emici Özellikli Kapı Kirişleri", "BSD-Kör Nokta Uyarı Sistemi",
                                "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Bluetooth Bağlantı", "USB Bağlantısı"
                            ),
                            exterior = listOf(
                                "LED Arka Stop", "Dış Aynalarda Led Sinyal Lambaları",
                                "Ön Sis Farları", "Arka Sis Farları", "Köpekbalığı Anten",
                                "5 Noktadan Bağlantılı Bağımsız Arka Süspansiyon",
                                "Karartılmış Arka Camlar", "Geri Görüş Kamerası ve Park Kılavuz Çizgileri",
                                "Ön ve Arka Park Sensörü", "Elektrikli, Katlanır ve Isıtmalı Dikiz Aynaları",
                                "18\" Alüminyum Alaşım Jant", "Gövde Rengi Kapı Kolları",
                                "Elektrikli Güvenlikli Sürücü Camı", "Ön Kapı Aydınlatma Lambası",
                                "Arkada Sportif Koruyucu Plakası", "Tavan Çıtaları", "Renkli Yan Camlar",
                                "Ses Yalıtımlı Renkli Ön Cam", "Siyah Hava Giriş Izgarası",
                                "Sesi Azaltan Akustik Motor Kapağı", "Aralıklı Arka Cam Sileceği",
                                "Görsel VIN (Şasi Numarası)", "LED Işıklı Gündüz Farları", "Sunroof"
                            ),
                            comfort = listOf(
                                "Lastik Tamir Kiti", "Cruise Control (Hız Sabitleme Sistemi)",
                                "Yeni Tip Çok Fonksiyonlu Anahtar (Smart-Key)",
                                "8 Yönlü Elektrikli ve Hafızalı Sürücü Koltuğu",
                                "Anahtarsız Giriş ve Çalıştırma (Start & Stop)",
                                "60/40 Katlanabilir ve Yatırılabilir 2.Sıra Koltuklar",
                                "Bardak Tutuculu Arka Kol Dayama", "Isıtmalı Arka Koltuklar",
                                "Çift Bölgeli İyonizerli Otomatik Klima",
                                "Arka Koltuk Klima Ünitesi-Manuel",
                                "Kabin İçi Hava Kalite Kontrol Sistemi", "Yağmur Sensörü",
                                "Elektronik Far Yükseklik Ayarı", "Kablosuz Şarj",
                                "Işıklı Makyaj Aynası", "Sürüş Modları Sistemi (Normal/Kış/Spor)",
                                "Elektronik Park Freni (Otomatik Tutmalı)", "EPS (Elektrik Destekli Direksiyon)",
                                "Çok Bağlantılı Spiral Arka Süspansiyon", "Yükseklik Ayarlı Sürücü Koltuğu",
                                "Isıtmalı Ön Koltuklar", "Bardak Tutucu (Ön ve Arka)",
                                "McPherson Spiral Ön Süspansiyon Sistemi",
                                "Smart Key (Akıllı Anahtar-Anahtarsız Giriş/Çalıştırma/Kilitleme)"
                            ),
                            interior = listOf(
                                "Işığa Duyarlı Elektrokrom İç Dikiz Aynası",
                                "Manuel Eğim Kontrollü Teleskopik Direksiyon",
                                "Ön Konsol Arkasında 12V Güç Çıkışı ve USB Şarj", "12V Güç Soketi",
                                "LED Kabin İçi Aydınlatma", "Deri Kaplama Direksiyon", "Gümüş İç Kapı Kolları"
                            ),
                            informationSystem = listOf(
                                "Direksiyondan Kumanda Sistemi",
                                "Yol Bilgisayarı (3.5\" Mono TFT-LCD Ekran)"
                            )
                        )
                    ),
                    CarI(
                        name = "Torres 4x4 1.5 GDI Turbo Otomatik Benzinli",
                        carGeneralInfo = CarGeneralInfo("Torres 4x4 1.5 GDI Turbo","Otomatik","Benzinli","4x4","₺2.671.450'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("TORRES 1.5 GDI Turbo Otomatik Benzinli 4x4", "₺2.671.450'den başlayan fiyatlarla")
                        ),
                        gallery = listOf("drawable/torres_gallery.jpg", "drawable/torres_gallery.jpg"),
                        youtubeVideoLink = "https://www.youtube.com/example",
                        colorOptions = listOf(ColorOptions("drawable/musso_grand.png","Black"), ColorOptions("drawable/musso_grand.png","Black")),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "5 Kapı",
                                cylinderCount = "4 Silindir",
                                gearCount = "6 Vites",
                                maxSpeed = "191 km/saat"
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "163 hp",
                                engineVolume = "1497 cc",
                                maxRev = "5000-5500 rpm",
                                maxTorque = "280 Nm (1500-4000 d/dk)"
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "9.08 L",
                                fuelTank = "50 L"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "4700 mm",
                                width = "1890 mm",
                                height = "1710/1720 (Port Bagajlı) mm",
                                netWeight = "1693 kg",
                                trunkVolume = "839 lt",
                                tireDimensions = "235/55R 20\""
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)", "HSA (Yokuş Kalkış Sistemi)",
                                "HDC (Yokuş İniş Kontrolü)", "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Ön Emniyet Kemeri Yük Sınırlama Düzeneği ve Kilitleme Dilli Ön Gergiler",
                                "Hızı Algılayan Otomatik Kapı Kilitleri", "Hıza Duyarlı Emniyet Kemeri Uyarısı",
                                "AEBS (Bağımsız Acil Fren Sistemi)", "LDW (Şeritten Çıkış Uyarısı)",
                                "LKA (Şerit Koruma Asistanı)", "HBA (Uzun Far Asistanı)",
                                "SDA (Emniyetli Mesafe Uyarısı)", "DAA (Sürücü Yorgunluk Uyarısı)",
                                "FVSA (Öndeki Araç İçin Hareket Uyarısı)", "Takviyeli Monoblok Gövde Yapısı",
                                "Yan Darbelere Karşı Kapı Darbe Kirişleri", "Alarm",
                                "ESS (Acil Durum Arka Sinyal Sistemi)", "ESP (Elektronik Stabilite Programı)",
                                "ABS (Kilitlenme Karşıtı Fren Sistemi)", "TCS (Çekiş Kontrol Sistemi)",
                                "HBA (Hidrolik Fren Asistanı)", "Immobilizer",
                                "Sürücü ve Yolcu Ön Hava Yastıkları", "Sürücü ve Yolcu Yan Hava Yastıkları",
                                "Sürücü Perde Hava Yastığı", "Ön Yolcu Perde Hava Yastığı",
                                "Ön Yolcu Hava Yastığı Kapama Düğmesi", "Önde Hava Soğutmalı Disk Frenler",
                                "Arkada Disk Frenler", "Yükseklik Ayarlı Ön Emniyet Kemerleri",
                                "Arka Koltuklarda Üç Noktadan Bağlantılı Emniyet Kemer Sistemi",
                                "Çocuk Güvenlik Kilidi", "Hıza Duyarlı Kapı Kilidi",
                                "Sürücü Diz Hava Yastığı", "Isofıx Çocuk Koltuğu Bağlantısı",
                                "FTCS-Çekiş Kontrol Sistemi", "FCW-Ön Çarpışma Uyarısı",
                                "RCTA-Arka Çapraz Trafik Uyarısı", "Arka Yolcu Perde Hava Yastıkları",
                                "Park Asistanı Sistemi", "Yüksek Gergili Çelik Yapı",
                                "Darbe Emici Özellikli Kapı Kirişleri", "BSD-Kör Nokta Uyarı Sistemi",
                                "İlk Yardım Kiti"
                            ),
                            multimedia = listOf(
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Bluetooth Bağlantı", "USB Bağlantısı"
                            ),
                            exterior = listOf(
                                "LED Arka Stop", "Dış Aynalarda Led Sinyal Lambaları",
                                "Ön Sis Farları", "Arka Sis Farları", "Köpekbalığı Anten",
                                "5 Noktadan Bağlantılı Bağımsız Arka Süspansiyon",
                                "Karartılmış Arka Camlar", "Geri Görüş Kamerası ve Park Kılavuz Çizgileri",
                                "Ön ve Arka Park Sensörü", "Elektrikli, Katlanır ve Isıtmalı Dikiz Aynaları",
                                "20\" Alüminyum Alaşım Jant", "Gövde Rengi Kapı Kolları",
                                "Elektrikli Güvenlikli Sürücü Camı", "Ön Kapı Aydınlatma Lambası",
                                "Arkada Sportif Koruyucu Plakası", "Tavan Çıtaları", "Renkli Yan Camlar",
                                "Ses Yalıtımlı Renkli Ön Cam", "Siyah Hava Giriş Izgarası",
                                "Sesi Azaltan Akustik Motor Kapağı", "Aralıklı Arka Cam Sileceği",
                                "Görsel VIN (Şasi Numarası)", "LED Işıklı Gündüz Farları", "Sunroof"
                            ),
                            comfort = listOf(
                                "Lastik Tamir Kiti", "Cruise Control (Hız Sabitleme Sistemi)",
                                "Yeni Tip Çok Fonksiyonlu Anahtar (Smart-Key)",
                                "Anahtarsız Giriş ve Çalıştırma (Start & Stop)",
                                "8 Yönlü Elektrikli ve Hafızalı Sürücü Koltuğu",
                                "60/40 Katlanabilir ve Yatırılabilir 2.Sıra Koltuklar",
                                "Bardak Tutuculu Arka Kol Dayama", "Isıtmalı ve Soğutmalı Ön Koltuklar",
                                "Isıtmalı Arka Koltuklar", "Çift Bölgeli İyonizerli Otomatik Klima",
                                "Arka Koltuk Klima Ünitesi-Manuel", "Kabin İçi Hava Kalite Kontrol Sistemi",
                                "Yağmur Sensörü", "Elektronik Far Yükseklik Ayarı", "Kablosuz Şarj",
                                "Işıklı Makyaj Aynası", "Sürüş Modları Sistemi (Normal/Kış/Spor)",
                                "Elektronik Park Freni (Otomatik Tutmalı)", "EPS (Elektrik Destekli Direksiyon)",
                                "Çok Bağlantılı Spiral Arka Süspansiyon", "Yükseklik Ayarlı Sürücü Koltuğu",
                                "Isıtmalı Ön Koltuklar", "Bardak Tutucu (Ön ve Arka)"
                            ),
                            interior = listOf(
                                "Işığa Duyarlı Elektrokrom İç Dikiz Aynası",
                                "Manuel Eğim Kontrollü Teleskopik Direksiyon",
                                "Ön Konsol Arkasında 12V Güç Çıkışı ve USB Şarj", "12V Güç Soketi",
                                "LED Kabin İçi Aydınlatma", "Deri Kaplama Direksiyon", "Gümüş İç Kapı Kolları"
                            ),
                            informationSystem = listOf("")
                        )
                    )

                )
            )
        }

        private fun createTorresEvx(): Car {
            return Car(
                name = "Torres EVX",
                mainPicture = R.drawable.torres_evx,
                car = listOf(
                    CarI(
                        name = "Torres EVX 2024",
                        carGeneralInfo = CarGeneralInfo("Torres EVX Torres EVX 4x2","Otomatik","Elektrik","4x2","₺1.780.000'den başlayan fiyatlarla"),
                        priceList = listOf(
                            CarPrice("Torres EVX 4x2 Elektrik", "1.780.000 TL")
                        ),
                        gallery = listOf(
                            "drawable/torres_gallery.jpg",
                            "drawable/torres_gallery.jpg"
                        ),
                        youtubeVideoLink = "https://www.youtube.com/example",
                        colorOptions = listOf(
                            ColorOptions("drawable/musso_grand.png", "Black"),
                            ColorOptions("drawable/musso_grand.png", "Black")
                        ),
                        technicalSpecifications = TechnicalSpecifications(
                            overview = Overview(
                                doorCount = "5 Kapı",
                                maxSpeed = "175 km/saat",
                                cylinderCount = "",
                                gearCount = ""
                            ),
                            engineAndPerformance = EngineAndPerformance(
                                enginePower = "152,2 kw (206,9 hp)",
                                maxTorque = "339 Nm",
                                engineVolume = "",
                                maxRev = ""
                            ),
                            fuelConsumption = FuelConsumption(
                                averageConsumption = "13,5 Wh/Km",
                                fuelTank = "73,4 kWh"
                            ),
                            dimensions = Dimensions(
                                seatCount = "5 Koltuk",
                                length = "4715 mm",
                                width = "1890 mm",
                                height = "1715 mm",
                                netWeight = "1915 kg",
                                trunkVolume = "839 lt",
                                tireDimensions = "225 R60 - 245 R45"
                            )
                        ),
                        equipmentFeatures = EquipmentFeatures(
                            safety = listOf(
                                "ARP (Aktif Devrilme Önleyici)",
                                "HDC (Yokuş İniş Kontrolü)",
                                "TPMS (Lastik Basıncı İzleme Sistemi)",
                                "Ön Emniyet Kemeri Yük Sınırlama Düzeneği ve Kilitleme Dilli Ön Gergiler",
                                "Hızı Algılayan Otomatik Kapı Kilitleri",
                                "Hıza Duyarlı Emniyet Kemeri Uyarısı",
                                "AEBS (Bağımsız Acil Fren Sistemi)",
                                "LDW (Şeritten Çıkış Uyarısı)",
                                "LKA (Şerit Koruma Asistanı)",
                                "DAA (Sürücü Yorgunluk Uyarısı)",
                                "FVSA (Öndeki Araç İçin Hareket Uyarısı)",
                                "Yan Darbelere Karşı Kapı Darbe Kirişleri",
                                "ESS (Acil Durum Arka Sinyal Sistemi)",
                                "TSR-Trafik İşareti Algılama Sistemi",
                                "ESP (Elektronik Stabilite Programı)",
                                "ABS (Kilitlenme Karşıtı Fren Sistemi)",
                                "TCS (Çekiş Kontrol Sistemi)",
                                "HBA (Hidrolik Fren Asistanı)",
                                "Immobilizer",
                                "Sürücü ve Yolcu Ön Hava Yastıkları",
                                "Sürücü ve Yolcu Yan Hava Yastıkları",
                                "Sürücü Perde Hava Yastığı",
                                "Ön Yolcu Perde Hava Yastığı",
                                "Ön Yolcu Hava Yastığı Kapama Düğmesi",
                                "Önde Hava Soğutmalı Disk Frenler",
                                "Yükseklik Ayarlı Ön Emniyet Kemerleri",
                                "Arka Koltuklarda Üç Noktadan Bağlantılı Emniyet Kemer Sistemi",
                                "Çocuk Güvenlik Kilidi",
                                "Hıza Duyarlı Kapı Kilidi",
                                "Sürücü Diz Hava Yastığı",
                                "Isofıx Çocuk Koltuğu Bağlantısı",
                                "FCW-Ön Çarpışma Uyarısı",
                                "RCTA-Arka Çapraz Trafik Uyarısı",
                                "Arka Yolcu Perde Hava Yastıkları",
                                "Park Asistanı Sistemi",
                                "Yüksek Gergili Çelik Yapı",
                                "Darbe Emici Özellikli Kapı Kirişleri",
                                "BSD-Kör Nokta Uyarı Sistemi",
                                "RCW (Arkadaki araca çarpma ikazı)",
                                "İlk Yardım Kiti",
                                "RCTW (Arka çapraz trafikte araç var ikazı)",
                                "BSA (Kör noktadaki araca çarpma ikazı)",
                                "MCB (Çoklu çarpışma önleyici sistem)",
                                "SEW (Emniyetli araçtan iniş ikazı)",
                                "LCW (Şerit değişme esnasında araca çarpma ikazı)",
                                "CLKA (Akıllı şeritte tutma yardımcısı)",
                                "ALC (Navigasyon ayara göre otomatik şerit değiştirme)",
                                "ELK (Acil şeritte tutma yardımcısı)",
                                "Soğutma kanallı ön ve arka fren diskleri",
                                "AUTO HOLD sistemli EPB",
                                "ESA (Acil direksiyon yardımcısı) ve sollama yardımcısı",
                                "AEB-HO (Karşıdan gelen araca göre otomatik fren sistemi)",
                                "AEB-JT (ön çapraz dönen araca göre otomatik fren sistemi)",
                                "AEB-JC (ön çapraz araca göre otomatik fren sistemi)",
                                "FVWS (öndeki araç hareket uyarısı)",
                                "Güçlendirilmiş monokok şase gövde",
                                "SHB (Akıllı far)",
                                "DAW (Sürücü yorgunluk ikaz)",
                                "BSW (Yan kör nokta ikaz sistemi)",
                                "SDW (Emniyetli takip mesafe ayarlayıcısı)",
                                "IACC (Akıllı adaptif hız sabitleme)"
                            ),
                            multimedia = listOf(
                                "Araç Bağlantısı (Apple Carplay/Google Android Auto)",
                                "6 Adet Hoparlör", "Bluetooth Bağlantı",
                                "12.3” HD kamera destekli navigasyon",
                                "Ön ve arkada şarj edebilen ve ses sistem bağlantılı USB portu",
                                "E call (Acil arama) sistemi"
                            ),
                            exterior = listOf(
                                "Elektrikli, Katlanır ve Isıtmalı Dikiz Aynaları",
                                "Görsel VIN (Şasi Numarası)",
                                "Gövde Rengi Kapı Kolları",
                                "Köpekbalığı Anten",
                                "Ses Yalıtımlı Renkli Ön Cam",
                                "Aralıklı Arka Cam Sileceği",
                                "20\" Aluminyum Alaşım Jant",
                                "Ön Sis Farları",
                                "LED Işıklı Gündüz Farları",
                                "Ön Kapı Aydınlatma Lambası",
                                "Karartılmış Arka Camlar",
                                "Dış Aynalarda Led Sinyal Lambaları",
                                "LED Arka Stop",
                                "Arka Sis Farları",
                                "Aktif aerodinamik ön alt panjur",
                                "Siyah renkli arka üst C direği (Gümüş renkli opsiyon)",
                                "Bağımsız Arka Süspansiyon",
                                "Sportif yapılı rüzgarlık üzerinde fren lambası",
                                "Sunroof",
                                "Siyah port bagaj",
                                "Koyu renk ses kontrollü ön cam",
                                "Koyu renk kapılar camı ve bagaj kapı camı"
                            ),
                            comfort = listOf(
                                "McPherson Spiral Ön Süspansiyon Sistemi",
                                "Elektrikli Direksiyon Kolonu Kilidi",
                                "Arka Koltuk Klima Ünitesi-Manuel",
                                "Bagaj Tepsisi",
                                "Lastik Tamir Kiti",
                                "Bardak Tutucu (Ön ve Arka)",
                                "Kabin İçi Hava Kalite Kontrol Sistemi",
                                "EPS (Elektrik Destekli Direksiyon)",
                                "Isıtmalı Arka Koltuklar",
                                "Isıtmalı ve Soğutmalı Ön Koltuklar",
                                "Işıklı Makyaj Aynası",
                                "Çok Bağlantılı Spiral Arka Süspansiyon",
                                "Elektronik Park Freni (Otomatik Tutmalı)",
                                "Kablosuz Şarj",
                                "Cruise Control (Hız Sabitleme Sistemi)",
                                "Yağmur Sensörü",
                                "Çift Bölgeli İyonizerli Otomatik Klima",
                                "60/40 Katlanabilir ve Yatırılabilir 2.Sıra Koltuklar",
                                "Bardak Tutuculu Arka Kol Dayama",
                                "Sürüş Modları (ECO-SPOR-KIŞ-RAHAT)",
                                "12.3” yol bilgisayarlı tam ekran gösterge"
                            ),
                            interior = listOf(
                                "Deri Kaplama Direksiyon",
                                "Gümüş İç Kapı Kolları",
                                "Işığa Duyarlı Elektrokrom İç Dikiz Aynası",
                                "Manuel Eğim Kontrollü Teleskopik Direksiyon",
                                "Isıtmalı deri direksiyon simidi",
                                "Zemine montaj gaz pedalı",
                                "Isıtmalı koltuklar (Ön ve arka)",
                                "Soğutmalı ön koltuklar",
                                "8 yönlü elektrikli ayarlanabilir koltuklar",
                                "2 yönlü ayarlanabilir koltuk sırt yan destek",
                                "Elle kumandalı kapı perdesi",
                                "Ön kapı döşeme orta kısmı TPU kaplama",
                                "Ön kapı döşeme üst kısmı TPU kaplama",
                                "Paslanmaz metal kaplı ön ve arka basamak bakaliti",
                                "Aydınlatmalı ve aynalı güneşlik"
                            ),
                            informationSystem = listOf("Direksiyondan Kumanda Sistemi")
                        )
                    )
                )
            )
        }

    }
}