# OneLook
1)What is the purpose of the ViewHolder pattern in Android? 
The purpose of the ViewHolder pattern is to improve the performance and efficiency of RecyclerView by recycling views and minimizing the view inflation and initialization.

3)What are Decorative Patterns , and why are they useful ? Demonstrate how you can use Decorative Patterns in Kotlin to add functionality to existing classes
Decorator pattern allows us to wrap objects with new behaviors.
interface ICoffee {
    fun cost(): Int
    fun description(): String
}
abstract class CoffeeDecorator(private val iCoffee: ICoffee) : ICoffee {
    override fun cost(): Int {
        return iCoffee.cost()
    }
    override fun description(): String {
        return iCoffee.description()
    }
}
class BaseCoffee : ICoffee {
    override fun cost(): Int {
        return 5
    }
    override fun description(): String {
        return "Basic Coffee"
    }
}
class MilkDecorator(iCoffee: ICoffee) : CoffeeDecorator(iCoffee) {
    override fun cost(): Int {
        return super.cost() + 2
    }
    override fun description(): String {
        return super.description() + " + milk"
    }
}
class SugarDecorator(iCoffee: ICoffee) : CoffeeDecorator(iCoffee) {
    override fun cost(): Int {
        return super.cost() + 1
    }
    override fun description(): String {
        return super.description() + " + sugar"
    }
}


5)What is the purpose of the “let” keyword in Kotlin , give example.
let is scoped one of the scoped functions , it gives referance to the object. And allows us to not repeat same object name when we want to access it.
class Car() {
    var member1 = 1
    var member2 = "String"
    fun method1() {
        println("method1")
    }
    fun method2() {
        println("method2")
    }
}

fun main() {
    val car1 = Car()
    car1.let {
        it.member1 = 2
        it.member2 = "Hello"
        it.method1()
        it.method2()
    }
}

6)Which of the principle (SOLID) is violated in example ? : 
Interface segregation principle is violated.
Because fly method is only for birds that able to fly. We shouldnt apply same interface to the birds cannot fly.

7)How can we declare static variables in Kotlin ?
In Kotlin when we want to make variable static, we put the variable(s) inside companion object.

8)What is Constructors ? How many types of constructors do you know in Kotlin?
Constructor is used to create instance of class. Constructor accept parameters and make some computation inside class. Two types Constructors are there : primary and seondary Constructors
1. class name() 
2. class name(){ constructor(): this}
   
9)Explain Usage of Factory Patterns in Kotlin , why do we need it ?
Factory pattern allows us to avoid coupling. Its subclasses imlpements interface and we get the desired object from getfactory class.

10)Implement a HouseFactory class that provides methods for creating different types of houses (Cottage , Villa ,Mansion). Each house type should have its own specific features.
package com.zireddinismayilov.onelook.Algorithms
enum class House {
    Cottage, Villa, Mansion
}
interface IHouse {
    fun method()
}
class Cottage : IHouse {
    override fun method() {
        println("Cottage")
    }
}
class Villa : IHouse {
    override fun method() {
        println("Villa")
    }
}
class Mansion : IHouse {
    override fun method() {
        println("Mansion")
    }
}
class HouseFactory {
    fun getFactoryHouse(house: House): IHouse {
        return when (house) {
            House.Cottage -> Cottage()
            House.Villa -> Villa()
            House.Mansion -> Mansion()
        }
    }
}
fun main() {
    val house1 = HouseFactory().getFactoryHouse(House.Mansion)
    house1.method()
}

11)What is LiveData ?
Live data allows us to update our data in realtime. When data changes, we use observer and get the latest data.

12)Explain MVP structure
Model:
The Model represents the data and business logic of the application.
It is responsible for retrieving and managing data from various sources, such as databases, APIs, or local storage.
The Model notifies the Presenter when the data changes, ensuring that the Presenter always has up-to-date information.
The Model should be independent of the user interface and presentation logic.
View:
The View is responsible for rendering the user interface and displaying data to the user.
It receives input events from the user and forwards them to the Presenter for processing.
The View should ideally have minimal business logic and should only be concerned with UI-related tasks.
In Android, the View is often represented by activities, fragments, or custom UI components.
Presenter:
The Presenter acts as an intermediary between the Model and the View.
It handles user input from the View and processes it by interacting with the Model.
The Presenter updates the View with the latest data received from the Model.
It contains the application's presentation logic, which includes formatting data for display and handling user interactions.
The Presenter is generally responsible for coordinating the flow of data between the Model and the View.

14)What is Singleton pattern?
Singleton pattern is one of the creational patterns. If we want to only one instance of class we should use singleton pattern. For this pattern , object keyword is used.
object Car {
    var engine: String = ""
    var wheelcount: Int = 4
    fun start() {}
    fun stop() {}
}
fun main() {
    Car.engine
    Car.start()
}

15)Create a House class with attributes like the number of rooms,roof,type and color. Then , design a HouseBuilder class to construct House objects . Provide the necessary methods in the builder to set the attributes of the House class

package com.zireddinismayilov.onelook.Algorithms
class HouseBuilder private constructor(val rooms: Int, val roof: String, val type: String, val color: String) {
    class Builder() {
        private var rooms: Int? = null
        private var roof: String? = null
        private var type: String? = null
        private var color: String? = null
        fun setRooms(rooms: Int): Builder {
            this.rooms = rooms
            return this
        }
        fun setRoof(roof: String): Builder {
            this.roof = roof
            return this
        }
        fun setType(type: String): Builder {
            this.type = type
            return this
        }
        fun setColor(color: String): Builder {
            this.color = color
            return this
        }
    }
}
fun main() {
    var house1 = HouseBuilder.Builder().setRooms(4).setColor("Blue").setType("Mansion")
}

