package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt0.setOnClickListener { setTextFields("0") }
        bt1.setOnClickListener { setTextFields("1") }
        bt2.setOnClickListener { setTextFields("2") }
        bt3.setOnClickListener { setTextFields("3") }
        bt4.setOnClickListener { setTextFields("4") }
        bt5.setOnClickListener { setTextFields("5") }
        bt6.setOnClickListener { setTextFields("6") }
        bt7.setOnClickListener { setTextFields("7") }
        bt8.setOnClickListener { setTextFields("8") }
        bt9.setOnClickListener { setTextFields("9") }
        btMinus.setOnClickListener { setTextFields("-") }
        btPercent.setOnClickListener { setTextFields("%") }
        btPlus.setOnClickListener { setTextFields("+") }
        btMultiplie.setOnClickListener { setTextFields("*") }
        btDivision.setOnClickListener { setTextFields("/") }
        btComma.setOnClickListener { setTextFields(",") }




        btEquals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    txEight.text = longRes.toString()
                else
                     txEight.text = result.toString()

            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

        btNegate.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate().toInt()
                val longRes = result.toLong()
                val mark = result * (-1)

                txEight.text = mark.toString()



            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }

        }
        btPercent.setOnClickListener {
            try {
                val ex = ExpressionBuilder(txEight.text.toString()).build()
                val result = ex.evaluate().toInt()
                val longRes = result.toLong()
                val marker = result / 100

                txEight.text = marker.toString()



            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }


        btAc.setOnClickListener {
            txEight.text = ""

        }


    }



    fun setTextFields(resultator: String){

        txEight.append(resultator)
    }
}