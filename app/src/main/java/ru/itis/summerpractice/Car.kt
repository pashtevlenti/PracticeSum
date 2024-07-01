package ru.itis.summerpractice

open class Car (
    val name: String,
    val model: String,
    val year: Int,
    val country: String
){
    open fun printInfo() : String{
        return "Марка: $name, модель: $model, год выпуска: $year, страна производитель: $country "
    }

}