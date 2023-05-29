package com.example.sixthmonth_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sixthmonth_2.databinding.FragmentSelectedBinding


class SelectedFragment : Fragment() {

    private lateinit var binding: FragmentSelectedBinding
    private var arrayList = arrayListOf<Sheep>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedPhotos = arguments?.getSerializable("Key") as ArrayList<Sheep>

            arrayList.addAll(selectedPhotos)
            val adapter = SelectedAdapter(arrayList)
            with(binding) {
                rvSelected.layoutManager = GridLayoutManager(context, 3)
                rvSelected.adapter = adapter
            }


    }
}
