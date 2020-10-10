package com.owino.mcarretal.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.owino.mcarretal.R
import com.owino.mcarretal.adapter.VehiclesAdapter
import com.owino.mcarretal.database.Vehicle
import com.owino.mcarretal.views.viewmodel.VehiclesViewModel

class MainActivity : AppCompatActivity() {

    val requestCode: Int = 1211

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VehiclesAdapter
    lateinit var vehicles: List<Vehicle>

    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: VehiclesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeResources();
        loadData();
    }

    private fun loadData() {
        adapter.notifyDataSetChanged()
    }

    fun initializeResources() {
        recyclerView = findViewById(R.id.recycler_view);
        vehicles = ArrayList();
        layoutManager = LinearLayoutManager(applicationContext)
        adapter = VehiclesAdapter(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter;

        viewModel = ViewModelProvider(this).get(VehiclesViewModel::class.java)
        viewModel.getAll().observe(this, Observer { vehicles ->
            vehicles?.let { adapter.setVehicles(it) }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == requestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(MainActivity.EXTRA_REPLY)?.let {
                val vehicle = Vehicle(it)
                viewModel.insert(vehicle)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
}