package com.example.nikhil.restaurants

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_food_details.*

class Food_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        var bundle:Bundle=intent.extras
        tv_food_name.text=bundle.getString("name")
        tv_food_des.text=bundle.getString("des")
        iv_food.setImageResource(bundle.getInt("image"))
        order_button.setOnClickListener {
            Toast.makeText(this,"You Face are Not Eligible To order This Item. Wash Your Face And Try Again",Toast.LENGTH_SHORT).show()
        }
    }
}
