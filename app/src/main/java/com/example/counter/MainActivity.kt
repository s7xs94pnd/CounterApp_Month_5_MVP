package com.example.counter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachView(this)
        setUpListeners()
    }

    private fun setUpListeners() = with(binding) {
        btnDecrement.setOnClickListener {
            presenter.onDecrement()
        }

        btnIncrement.setOnClickListener {
            presenter.onIncrement()
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun tvColorGreen() {
        binding.tvResult.setTextColor(this.getColor(R.color.green))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}