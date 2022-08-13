package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myname1: MyName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myname1 = MyName("Mahmoud Khalaf")
        binding.myname = myname1
        //val doneButton : Button = findViewById(R.id.done)
        binding.done.setOnClickListener(View.OnClickListener {
            addNickName(it)
        })
    }

    private fun addNickName(it: View) {
//           val editNickName : EditText = findViewById(R.id.nickname_editable)
//            val nickNameText : TextView = findViewById(R.id.nick_name_text)
        binding.apply {
            myname1.nickName = nicknameEditable.text.toString()
            invalidateAll()
            it.visibility = View.GONE
            nicknameEditable.visibility = View.GONE
            nickNameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)

    }
}