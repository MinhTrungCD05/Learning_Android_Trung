package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)

        val numberIds = listOf(
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
            R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_dot
        )

        numberIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener { view ->
                val button = view as Button
                appendNumber(button.text.toString())
            }
        }

        findViewById<Button>(R.id.btn_minus).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.btn_multiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.btn_divide).setOnClickListener { setOperator("/") }
        findViewById<Button>(R.id.btn_percent).setOnClickListener { setOperator("%") }
        findViewById<Button>(R.id.btn_equal).setOnClickListener { calculate() }
        findViewById<Button>(R.id.btn_C).setOnClickListener { clear() }
        findViewById<Button>(R.id.btn_DEL).setOnClickListener { delete() }

    }

    private fun appendNumber(number: String) {
        if (tvResult.text == "0") {
            tvResult.text = number
        } else {
            tvResult.append(number)
        }
    }

    private fun clear() {
        tvResult.text = "0"
    }

    private fun delete() {
        val currentText = tvResult.text.toString()
        if (currentText.length > 1) {
            tvResult.text = currentText.substring(0, currentText.length - 1)
        } else {
            tvResult.text = "0"
        }
    }

    // Thêm hàm này để hết lỗi đỏ ở các nút phép tính
    private fun setOperator(operator: String) {
        tvResult.append(" $operator ")
    }

    // Thêm hàm này để hết lỗi đỏ ở nút Equal
    private fun calculate() {
        val input = tvResult.text.toString()

        // Kiểm tra nếu có dấu cách (vì mình đã thêm dấu cách ở hàm setOperator)
        val parts = input.split(" ")
        if (parts.size < 3) return // Nếu chưa đủ số và phép tính thì không làm gì

        val num1 = parts[0].toDoubleOrNull() ?: 0.0
        val operator = parts[1]
        val num2 = parts[2].toDoubleOrNull() ?: 0.0

        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "Lỗi"
            "%" -> num1 % num2
            else -> 0.0
        }

        // Hiển thị kết quả lên màn hình
        tvResult.text = result.toString()
    }
}

