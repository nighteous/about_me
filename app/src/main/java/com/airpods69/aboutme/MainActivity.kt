package com.airpods69.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.airpods69.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val name: Idk = Idk( name = "Varenyam Bhardwaj")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.idkYouTellMe = name
        //findViewById<Button>(R.id.done).setOnClickListener {
        //    addNickname(it)
        binding.done.setOnClickListener {
            addNickname(it)
        }
        }

    private fun addNickname(view: View) {

        binding.apply  {
            //binding.nameText.text = binding.editableText.text
            idkYouTellMe?.nickname = editableText.text.toString()
            invalidateAll()
            editableText.visibility = View.GONE
            view.visibility = View.GONE
            effect.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}