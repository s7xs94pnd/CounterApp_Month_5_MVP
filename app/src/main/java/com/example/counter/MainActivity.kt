package com.example.counter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpObservers()
        setUpListeners()
    }

    private fun setUpObservers() {
        viewModel.count.observe(this, Observer { count ->
            binding.tvResult.text = count.toString()
        })

        viewModel.toastMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        viewModel.textColor.observe(this, Observer { colorRes ->
            binding.tvResult.setTextColor(getColor(colorRes))
        })
    }

    private fun setUpListeners() = with(binding) {
        btnDecrement.setOnClickListener {
            viewModel.decrement()
        }

        btnIncrement.setOnClickListener {
            viewModel.increment()
        }
    }
}