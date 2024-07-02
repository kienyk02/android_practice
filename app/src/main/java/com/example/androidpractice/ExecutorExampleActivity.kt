package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityExecutorExampleBinding
import java.util.concurrent.Executors

class ExecutorExampleActivity : AppCompatActivity() {
    private val binding: ActivityExecutorExampleBinding by lazy {
        ActivityExecutorExampleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val task = Runnable {
            Thread.sleep(2000)
            val value = (1..10).random()
            Log.d("myTag", "value: $value, ${Thread.currentThread()}")
            runOnUiThread {
                binding.txtValue.text = value.toString()
            }
        }
        //ThreadPoolExecutor
//        val threadPoolExecutor = ThreadPoolExecutor(
//            2, 4, 10000, TimeUnit.MILLISECONDS ,LinkedBlockingQueue())
        //Executors
//        val threadPoolExecutor = Executors.newCachedThreadPool() // sử dụng số lượng thread mặc định
//        val threadPoolExecutor = Executors.newFixedThreadPool(3) // sử dụng số lượng thread cố định
        val threadPoolExecutor = Executors.newSingleThreadExecutor() // sử dụng 1 thread
        for(i in 0 until 10 step 1){
            threadPoolExecutor.execute(task)
        }
        threadPoolExecutor.shutdown()
    }
}