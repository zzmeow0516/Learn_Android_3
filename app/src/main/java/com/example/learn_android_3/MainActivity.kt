package com.example.learn_android_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//MainActivity 类实现了 View.OnClickListener 接口，这意味着 MainActivity 类必须实现 onClick 方法，从而可以作为点击事件的监听器
//笑鼠，OnClickListener接口只有一个方法onClick(v: View?)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "mylog_MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        //将当前的 MainActivity 实例（即 this）设置为按钮（button1）的点击事件监听器
        //这样，当按钮被点击时，系统会调用 MainActivity 的 onClick 方法来处理点击事件
        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> Log.v(TAG, "we click button1")
        }
    }
}