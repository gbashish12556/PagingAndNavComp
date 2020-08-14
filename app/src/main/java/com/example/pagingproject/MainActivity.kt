package com.example.pagingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var args = Bundle()
        args.putInt("userId",2)
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.nav_graph, args)

    }
}
