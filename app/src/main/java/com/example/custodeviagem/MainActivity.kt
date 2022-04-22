package com.example.custodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.custodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener { calculate() }
    }
/*
    fun onClick(view: View) {
        if (view.id == R.id.calculate_btn) {
            calculate()
        }
    }
*/
    private fun isValid(): Boolean{
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if(isValid()){
            var distance = binding.editDistance.text.toString().toFloat()
            var price = binding.editPrice.text.toString().toFloat()
            var autonomy = binding.editAutonomy.text.toString().toFloat()

            var totalValue = (distance * price) / autonomy
            "%.2f".format(totalValue)
            binding.totalSpand.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_LONG).show()
        }
    }
}