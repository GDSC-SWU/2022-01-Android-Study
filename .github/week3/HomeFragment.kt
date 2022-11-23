package com.example.gdsc_myapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_myapp2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater)

        val todos = listOf(
            Todo("today's todo list #1", false),
            Todo("today's todo list #2", false),
            Todo("today's todo list #3", false),
            Todo("today's todo list #4", false),
            Todo("today's todo list #5", false),
        )

        // 아이템들을 어떻게 배열할지 정해줌 -> Linear: 세로로 나열
        binding.rv1.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rv1.adapter = TodoAdapter(todos)

        binding.rv2.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rv2.adapter = TodoAdapter(todos)

        binding.rv3.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rv3.adapter = TodoAdapter(todos)

        // return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }
}