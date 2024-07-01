package ru.itis.summerpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var text : TextView? = null
    var button : Button? = null
    var editText : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRace()
    }

    fun generateCar(): Car{
        var random: Int
        val countries = listOf("Италия","США","Япония","Германия")
        random = (0..3).random()
        val nameCountry = countries.get(random)

        val americanCars = listOf("Tesla","Ford","Cadillac")
        val japanCars = listOf("Toyota","Nissan","Honda")
        val germanyCars = listOf("Mercedes","BMW","Audi")
        val italyCars = listOf("Maserati","Ferrari","Lamborghini")

        val nameCar = when(random){
            0 -> italyCars.get((0..2).random())
            1 -> americanCars.get((0..2).random())
            2 -> japanCars.get((0..2).random())
            else -> germanyCars.get((0..2).random())
        }

        val typeDrive = when((0..2).random()){
            0 -> TypeDrive.ALL
            1 -> TypeDrive.BACK
            else -> TypeDrive.FRONT
        }

        val typeMotor = when((0..2).random()){
            0 -> TypeMotor.DISEL
            1 -> TypeMotor.ELECTRIC
            else -> TypeMotor.GASOLINE
        }


        val car = when((0..4).random()){
            0 -> SportCar(name = nameCar,
                model = "SportCar",
                year = ((2000..2024).random()),
                country = nameCountry,
                power = ((100..600).random()),
                drive = typeDrive,
                motor = typeMotor)
            1 -> Crossover(name = nameCar,
                model = "Crossover",
                year = ((2000..2024).random()),
                country = nameCountry,
                power = ((100..600).random()),
                drive = typeDrive,
                motor = typeMotor)
            2 -> Pickup(name = nameCar,
                model = "Pickup",
                year = ((2000..2024).random()),
                country = nameCountry,
                power = ((100..600).random()),
                drive = typeDrive,
                motor = typeMotor)
            3 -> TruckWagon(name = nameCar,
                model = "TruckWagon",
                year = ((2000..2024).random()),
                country = nameCountry,
                power = ((100..600).random()),
                drive = typeDrive,
                motor = typeMotor)

            else -> Car(name = nameCar,
                model = "lalala",
                year = ((2000..2024).random()),
                country = nameCountry)
        }
        return car
    }

    fun carRace(car1: Car, car2: Car): Car{
        val compare1 = when(car1){
            is SportCar -> listOf(car1.power,car1.year)
            is Pickup -> listOf(car1.power,car1.year)
            is Crossover -> listOf(car1.power,car1.year)
            is TruckWagon -> listOf(car1.power, car1.year)
            else -> listOf(((100..600).random()),(2000..2024).random())
        }
        val compare2 = when(car2){
            is SportCar -> listOf(car2.power,car2.year)
            is Pickup -> listOf(car2.power,car2.year)
            is Crossover -> listOf(car2.power,car2.year)
            is TruckWagon -> listOf(car2.power,car2.year)
            else -> listOf((100..600).random(),(2000..2024).random())
        }

        if (compare1.get(0) == compare2.get(0)){
            if (compare1.get(1) > compare2.get(1)) {return car2}
            else {return car1}
        }
        else {
            if (compare1.get(0) > compare2.get(0)) {return car1}
            else {return car2}
        }
    }
    fun race(list: ArrayList<Car>) {
        if (list.size == 2) {
            println("Гонка между ${list[0].printInfo()} и ${list[1].printInfo()}, Победитель ${carRace(list[0], list[1]).printInfo()}")
        } else {
            val newList = ArrayList<Car>()
            while (list.size > 1) {
                val oneCar = list.removeAt((0..list.size - 1).random())
                val twoCar = list.removeAt((0..list.size - 1).random())
                val carWin = carRace(oneCar, twoCar)
                newList.add(carWin)
                println("Гонка между ${oneCar.printInfo()} и ${twoCar.printInfo()}, " + "Победитель ${carWin.printInfo()}")
                if (list.size == 1) {
                    println("${list[0].printInfo()} - Нет пары, следующий круг")
                    newList.add(list.removeAt(0))
                }
            }
            return race(newList)
        }
    }
    fun initRace() {
        this.text = findViewById<TextView>(R.id.text)
        this.button = findViewById<Button>(R.id.button)
        this.editText = findViewById<EditText>(R.id.editText) as EditText

        editText?.doOnTextChanged { t, start, before, count ->
            t?.let {
                button?.isEnabled = t.matches("[0-9]+".toRegex())
            }
        }
        var textOnEditText : Int
        var list = ArrayList<Car>()
        button?.setOnClickListener {
            textOnEditText = editText?.text.toString().toInt()
            for (x in 1..textOnEditText) {
                list.add(generateCar())
            }
            race(list)
        }


    }

}
