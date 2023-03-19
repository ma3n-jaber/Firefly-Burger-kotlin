package com.example.firefly_burger

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.Float.sum

class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast", "MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button =  findViewById(R.id.button4)
        val edtxt1: TextView = findViewById(R.id.textView2)
        val edtxt2: TextView = findViewById(R.id.textView4)
        val resultTV: TextView = findViewById(R.id.textResult)

        var delivery_cost:Double=0.0
        var meal_price:Double=0.0

        val meal1 = arrayOf("Select your meal", "Angus Burger","Kamikaze Burger","Firefly Burger","Wall-street Burger")
        val meals_prices:Array<Double> = arrayOf(0.0, 5.0, 6.0, 4.0, 4.0)

        val location1 = arrayOf("Select your location", "Amman","Zarqa","Irbid","ar-Rusaifa")
        val delivery_costs:Array<Double> = arrayOf(0.0, 2.5, 0.1, 3.5, 2.5)


        val spinner:Spinner = findViewById(R.id.Splocation)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,meal1)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    delivery_cost = delivery_costs.get(p2).toString().toDouble()
                    edtxt2.text = "The cost of delivering to ${location1.get(p2)} is: ${delivery_costs.get(p2).toString()}"
                }
                //Toast.makeText(applicationContext, "select Burger =${meal1.get(p2)}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        val spinner1:Spinner = findViewById(R.id.SpMeal)
        val arrayAdapter1 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,location1)
        spinner1.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    meal_price = meals_prices.get(p2).toString().toDouble()
                    edtxt1.text = "The price of ${meal1.get(p2)} is: ${meal_price.toString()}"
                }

                //Toast.makeText(applicationContext, "location =${location1.get(p2)}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,meal1 )
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,location1 )

        button.setOnClickListener { view ->
            //code here
            var total:Double = meal_price + delivery_cost
            resultTV.text = total.toString()

        }



    }


}