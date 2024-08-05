package com.sahsuvaroglu.kgm

class CarManager {


    companion object {
        private var torresEvx: Car? = null
        private var torres: Car? = null
        private var musso_grand: Car? = null

        fun setTorresEvx(newCar: Car) {
            torresEvx = newCar
        }
        fun setTorres(newCar: Car) {
            torres = newCar
        }
        fun setMussoGrand(newCar: Car) {
            musso_grand = newCar
        }

        fun getTorresEvx(): Car {
            return torresEvx!!
        }

        fun getTorres(): Car {
            return torres!!

        }

        fun getMussoGrand(): Car{
            return musso_grand!!
        }

    }
}