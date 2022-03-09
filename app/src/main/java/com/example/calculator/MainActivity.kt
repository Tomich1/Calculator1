package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    
    private val listener = View.OnClickListener { view ->
        val b = view as Button
        txEight.append(b.text)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_main)
        
        
        groupButton.referencedIds.forEach { view ->
            val myView = findViewById<View>(view)
            
            
            myView.setOnClickListener(listener)
        }
        
        btEquals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    txEight.text = longRes.toString()
                else {
                    txEight.text = result.toString()
                }
                
            } catch (e: Exception) {
                val text = "Wrong!"
                val duration = Toast.LENGTH_SHORT
                
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        btNegate.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate().toInt()
                val mark = result * (-1)
                txEight.text = mark.toString()
                
            } catch (e: Exception) {
                val text = "Wrong!"
                val duration = Toast.LENGTH_SHORT
                
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        btPercent.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate().toInt()
                val marker = result / 100
                
                txEight.text = marker.toString()
            } catch (e: Exception) {
                val text = "Wrong!"
                val duration = Toast.LENGTH_SHORT
                
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        
        btAc.setOnClickListener {
            txEight.text = ""
        }
    }
    
}





