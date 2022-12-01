package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.view.MenuInflater as MenuInflater1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.textView)
        var flag:String="Argentina"
        val spinnerVal:Spinner = findViewById(R.id.spinner2)
        var options = arrayOf("Argentina","Brazil","Portugal","France")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.DFragment) {
            var dialog_var = CustomDialogclass()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
             if (item.itemId == R.id.SpinnerList) {
                var dialog_va = CustomDialogclass2()
                dialog_va.show(supportFragmentManager, "Custom Dialog2")

        }
        return true;
    }
    fun receiveFeedback(feedback: String){
        val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.text = feedback;
    }
}
