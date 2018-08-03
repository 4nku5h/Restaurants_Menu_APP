package com.example.nikhil.restaurants

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFoods=ArrayList<Food>()
    var adapter:FoodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfFoods.add(Food("Coffee","Coffee is a brewed drink prepared from roasted coffee beans, which are the seeds of berries from the Coffea plant. The genus Coffea is native to tropical Africa ...",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Espresso is coffee brewed by expressing or forcing out a small amount of nearly boiling water under pressure through finely ground coffee beans.",R.drawable.espresso))
        listOfFoods.add(Food("French Fries","French Fries Fries 2 A serving of French fries Alternative names Chips, finger chips, fries, frites, hot chips, steak fries, potato wedges, wedges Course Side dish or snack, rarely as a main dish Place of origin\tBelgium, France, or Spain Created by Disputed Serving temperature Hot, generally salted Main ingredients Potatoes Oil Variations fries, shoestring fries, steak fries, sweet potato fries, Chili cheese fries, poutine Other informatio Often served with a side of ketchup, mayonnaise, vinegar, barbecue sauce.",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Patanjli Honey  is a sweet, thick liquid made by honeybees. The bees swarm their environment and collect the sugar-rich nectar of flowers",R.drawable.honey))
        listOfFoods.add(Food(" Ice Cream","Ice cream (derived from earlier iced cream or cream ice) is a sweetened frozen food typically eaten as a snack or dessert. It is usually made from dairy products, such as milk and cream, and often combined with fruits or other ingredients and flavors. It is typically sweetened with sugar or sugar substitutes.",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","The cubes are made by pressing granulated sugar, mixed with a bit of sugar liquid to help glue them all together, into cube shapes. Machines form them into cubes, air-dry them, then package them. Most sugar cubes are made from refined white sugar, but you can also get them made from Brown Sugar, Demerara Sugar, etc.",R.drawable.sugar_cubes))
          adapter= FoodAdapter(this,listOfFoods)
          grid_view_ticket.adapter=adapter

    }
    class FoodAdapter:BaseAdapter{

        var listOfFood=ArrayList<Food>()
        var context:Context?=null
        constructor(context: Context,listOfFood:ArrayList<Food>):super(){
            this.context=context
            this.listOfFood=listOfFood


        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var inflator:LayoutInflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var food=listOfFood[p0]
            var current_food_view=inflator.inflate(R.layout.food_ticket,null)
            current_food_view.iv_food.setImageResource(food.image!!)
            current_food_view.tv_food.text=food.name!!
            current_food_view.linear_layout_ticket.setOnClickListener{

                var intent=Intent(context,Food_details::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            return  current_food_view
        }

        override fun getItem(p0: Int): Any {
        return  listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
    return listOfFood.size
        }




    }
}
// #@cker's Studio APP
//By Ankush Shrivastava

