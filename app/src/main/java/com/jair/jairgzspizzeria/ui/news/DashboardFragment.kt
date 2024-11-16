package com.jair.jairgzspizzeria.ui.news

import DashboardViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jair.jairgzspizzeria.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa el LiveData `time` y actualiza el TextView con el tiempo formateado
        dashboardViewModel.time.observe(viewLifecycleOwner) { time ->
            binding.timerTextView.text = formatTime(time)
        }

        // Configura los botones para interactuar con el ViewModel
        binding.startButton.setOnClickListener { dashboardViewModel.startTimer() }
        binding.stopButton.setOnClickListener { dashboardViewModel.stopTimer() }
        binding.resetButton.setOnClickListener { dashboardViewModel.resetTimer() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Método para formatear el tiempo en hh:mm:ss:cc
    private fun formatTime(milliseconds: Long): String {
        val millis = (milliseconds % 1000) / 10 // Centisegundos
        val seconds = (milliseconds / 1000) % 60
        val minutes = (milliseconds / (1000 * 60)) % 60
        val hours = (milliseconds / (1000 * 60 * 60)) % 24
        return String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, millis)
    }
}
