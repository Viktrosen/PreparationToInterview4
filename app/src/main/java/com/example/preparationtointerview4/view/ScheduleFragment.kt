package com.example.preparationtointerview4.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.preparationtointerview4.R
import com.example.preparationtointerview4.databinding.MainFragmentBinding
import com.example.preparationtointerview4.databinding.ScheduleFragmentBinding
import com.example.preparationtointerview4.model.Classes
import com.example.preparationtointerview4.model.Homework
import com.example.preparationtointerview4.viewmodels.MainViewModel
import com.example.preparationtointerview4.viewmodels.ScheduleViewModel

class ScheduleFragment : BaseFragment<ScheduleFragmentBinding>() {

    private lateinit var viewModel: ScheduleViewModel



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner,{ renderData(it.classes) })

    }

    fun renderData(listOfClasses:List<Classes>){
        binding.scheduleList.adapter = ClassesAdapter(listOfClasses)
        binding.scheduleList.addItemDecoration(VerticalSpaceItemDecoration(30))
    }



    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= ScheduleFragmentBinding.inflate(inflater, container, false)

}