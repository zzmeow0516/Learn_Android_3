package com.example.learn_android_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        val button1: Button = findViewById(R.id.button1_pic)
        //将当前的 MainActivity 实例（即 this）设置为按钮（button1）的点击事件监听器
        //这样，当按钮被点击时，系统会调用 MainActivity 的 onClick 方法来处理点击事件
        button1.setOnClickListener(this)

        val button2: Button = findViewById(R.id.button2_visibility)
        button2.setOnClickListener(this)

        val button3: Button = findViewById(R.id.button3_progress)
        button3.setOnClickListener(this)

        val button4: Button = findViewById(R.id.button4_alertdialog)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1_pic ->
            {
                Log.v(TAG, "we click button1")
                val editText1: EditText = findViewById(R.id.editText1)
                //实际上调用的却是EditText的getText()方法,不过在kotlin中可以这样写（语法糖）
                val inputText = editText1.text.toString()
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()

                //在代码中动态更改pic source
                val imageView1: ImageView = findViewById(R.id.imageView1)
                imageView1.setImageResource(R.drawable.p3)
            }

            R.id.button2_visibility ->
            {
                val progressBar: ProgressBar = findViewById(R.id.progressBar1)
                if (progressBar.visibility == View.VISIBLE) progressBar.visibility = View.GONE
                else progressBar.visibility = View.VISIBLE
            }

            R.id.button3_progress ->
            {
                val progressBar: ProgressBar = findViewById(R.id.progressBar1)
                progressBar.progress += 10
            }

            R.id.button4_alertdialog ->
            {
                //AlertDialog.Builder: dialog构建
                //apply可以包含一个代码块，用于对 dialog进行一系列初始化
                AlertDialog.Builder(this).apply {
                    setTitle("AlertDialog")
                    setMessage("warning !")
                    setCancelable(false)
                    //dialog代表对话框本身，which代表点击了哪一个按钮， 但好像是废话，因为我点击的按钮肯定是确定好的
                    setPositiveButton("OK") {dialog, which ->
                        //这边添加点击后的逻辑
                        Log.v(TAG, "we clicked OK")
                    }
                    setNegativeButton("Cancel") {dialog, which ->
                        Log.v(TAG, "we clicked Cancel")
                    }.show()                //AlertDialog.Builder(this){...}.show()展示对话框
                }
            }

        }
    }
}