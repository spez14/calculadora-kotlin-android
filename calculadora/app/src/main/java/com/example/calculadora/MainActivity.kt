package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao_limpar.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        botao_parentese_esquerdo.setOnClickListener {
            input.text = addToInputText("(")
        }
        botao_parentese_direito.setOnClickListener {
            input.text = addToInputText(")")
        }
        botao_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        botao_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        botao_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        botao_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        botao_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        botao_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        botao_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        botao_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        botao_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        botao_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        botao_ponto.setOnClickListener {
            input.text = addToInputText(".")
        }
        botao_divisao.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        botao_multiplicar.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        botao_subtrair.setOnClickListener {
            input.text = addToInputText("-")
        }
        botao_somar.setOnClickListener {
            input.text = addToInputText("+")
        }
        botao_igual.setOnClickListener {
            showResult()
        }
    }
        private fun addToInputText(buttonValue: String): String {
            return "${input.text}$buttonValue"
        }

        private fun getInputExpression(): String {
            var expression = input.text.replace(Regex("÷"), "/")
            expression = expression.replace(Regex("×"), "*")
            return expression
        }

        private fun showResult() {
            try {
                val expression = getInputExpression()
                val result = Expression(expression).calculate()
                if (result.isNaN()) {
                    output.text = "Erro"
                    output.setTextColor(ContextCompat.getColor(this, R.color.red))
                } else {
                    output.text = DecimalFormat("0.######").format(result).toString()
                    output.setTextColor(ContextCompat.getColor(this, R.color.green))
                }
            } catch (e: Exception) {
                output.text = "Erro"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        }
    }
