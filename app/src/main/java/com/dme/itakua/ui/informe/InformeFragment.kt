package com.dme.itakua.ui.informe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dme.itakua.databinding.FragmentInformeBinding

class InformeFragment : Fragment() {

    private var _binding: FragmentInformeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val informeViewModel =
            ViewModelProvider(this).get(InformeViewModel::class.java)

        _binding = FragmentInformeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textSlideshow
        informeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}