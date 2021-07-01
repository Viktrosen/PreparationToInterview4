package com.example.preparationtointerview4.view

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.preparationtointerview4.databinding.MainFragmentBinding
import com.example.preparationtointerview4.model.Classes
import com.example.preparationtointerview4.model.Homework
import com.example.preparationtointerview4.viewmodels.MainViewModel
import java.util.*
import java.util.concurrent.TimeUnit


class MainFragment : BaseFragment<MainFragmentBinding>() {

    private lateinit var calendarFuture: Calendar
    private lateinit var viewModel: MainViewModel

    // Method to get days hours minutes seconds from milliseconds
    private fun timeString(millisUntilFinished:Long):String{
        var millisUntilFinished:Long = millisUntilFinished

        val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
        millisUntilFinished -= TimeUnit.DAYS.toMillis(days)

        val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
        millisUntilFinished -= TimeUnit.HOURS.toMillis(hours)

        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)

        // Format the string
        return String.format(
            Locale.getDefault(),
            "%02d day: %02d hour: %02d min: %02d sec",
            days,hours, minutes,seconds
        )
    }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner,{ renderData(it.classes,it.homework,it.exam) })

    }

    fun renderData(listOfClasses:List<Classes>,listOfHomework:List<Homework>,examTime:Long){
        val timer = object: CountDownTimer(examTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text =timeString(millisUntilFinished)}
            override fun onFinish() {}
        }
        binding.classesList.adapter = ClassesAdapter(listOfClasses)
        binding.homeworkList.adapter = HomeworkAdapter(listOfHomework)
        timer.start()
    }



    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= MainFragmentBinding.inflate(inflater, container, false)

}