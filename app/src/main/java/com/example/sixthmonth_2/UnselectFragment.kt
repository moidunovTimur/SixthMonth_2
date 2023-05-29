package com.example.sixthmonth_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sixthmonth_2.databinding.FragmentUnselectBinding

class UnselectFragment : Fragment() {

    private lateinit var binding: FragmentUnselectBinding
    private val arrayList = arrayListOf<Sheep>()
    private lateinit var adapter:UnselectAdapter
    private val selectedPhotos = arrayListOf<Sheep>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnselectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

        adapter = UnselectAdapter(arrayList, this::addImage,this::removeImage)
        with(binding){
            rvSeep.layoutManager=GridLayoutManager(context,3)
            rvSeep.adapter = adapter
        }

        initlistener()
    }

    private fun initlistener() {
        binding.btnGo.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable("Key",ArrayList(selectedPhotos))
            arrayList.clear()
            selectedPhotos.clear()
            findNavController().navigate(R.id.selectedFragment,bundle)
        }
    }

    private fun loadData() {
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
        arrayList.add(Sheep(R.drawable.img_sheep, false))
    }

    private fun addImage(sheep: Sheep){
        selectedPhotos.add(sheep)
    }

    private fun removeImage(sheep: Sheep){
       selectedPhotos.remove(sheep)
    }
}