package com.example.mybio

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.mybio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Alex")
    lateinit var editText: EditText
    lateinit var nicknameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.btnDone.setOnClickListener { addNickname(it) }
        

        editText = findViewById(R.id.inputText)
        nicknameTextView = findViewById(R.id.nickname)
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = inputText.text.toString()
            invalidateAll()
            inputText.visibility = View.GONE
            nickname.visibility = View.VISIBLE
        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
