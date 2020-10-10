package com.owino.mcarretal.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.owino.mcarretal.R
import com.owino.mcarretal.adapter.VehiclesAdapter
import com.owino.mcarretal.database.Vehicle
import com.owino.mcarretal.views.viewmodel.VehiclesViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    val requestCode: Int = 1211

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VehiclesAdapter
    lateinit var vehicles: ArrayList<Vehicle>

    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: VehiclesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeResources();
        loadData();
    }

    private fun loadData() {
        val model = VehiclesViewModel(application)
        model.getAll().observe(this, Observer<List<Vehicle>> { vehicles ->
            Log.e(TAG, "loadData: vehicle " + vehicles)
            this.vehicles.addAll(vehicles);
        })
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
}