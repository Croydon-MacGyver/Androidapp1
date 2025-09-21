package com.example.timemanger.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.timemanger.R
import com.example.timemanger.ui.calendar.CalendarActivity

class HomeFragment : Fragment() {

    private lateinit var tvCountdown: TextView
    private lateinit var btnCalendar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        tvCountdown = v.findViewById(R.id.tvCountdown)
        btnCalendar = v.findViewById(R.id.btnCalendar)

        btnCalendar.setOnClickListener {
            startActivity(Intent(requireContext(), CalendarActivity::class.java))
        }

        startCountdown(2 * 60 * 60 * 1000) // 模拟下一日程 2 小时后
        return v
    }

    private fun startCountdown(millis: Long) {
        object : CountDownTimer(millis, 1000) {
            override fun onTick(msUntilFinished: Long) {
                val h = msUntilFinished / 3600000
                val m = (msUntilFinished % 3600000) / 60000
                val s = (msUntilFinished % 60000) / 1000
                tvCountdown.text = String.format("%02d:%02d:%02d", h, m, s)
            }
            override fun onFinish() {
                tvCountdown.text = "到点啦！"
            }
        }.start()
    }
}
