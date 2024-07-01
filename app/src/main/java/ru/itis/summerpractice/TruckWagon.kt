package ru.itis.summerpractice

class TruckWagon (
    name: String,
    model: String,
    year: Int,
    country: String,
    val power: Int,
    val drive: TypeDrive,
    val motor: TypeMotor
) : Car(name, model, year, country) {
    override fun printInfo(): String{
        return super.printInfo() + "мощность: $power привод: $drive двигатель: $motor"
    }
}