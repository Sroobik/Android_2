package com.example.android_2.ui.main.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_2.R
import com.example.android_2.data.networking.Retrofit
import com.example.android_2.databinding.FragmentDashboardBinding
import com.example.android_2.databinding.FragmentNotificationsBinding
import com.example.android_2.model.Post
import com.example.android_2.ui.adapter.RecyclerAdapter
import com.example.android_2.ui.adapter.RetrofitAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var adapter: RetrofitAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        binding = FragmentNotificationsBinding.inflate(layoutInflater, container, false)



        linearLayoutManager = LinearLayoutManager(context)
        binding.retrofitRecycler.layoutManager = linearLayoutManager


        Retrofit(context!!).myApiJson.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(context, "Erooooor", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let {
                    adapter = RetrofitAdapter(it)
                    binding.retrofitRecycler.adapter = adapter
                }


            }

        })
        return binding.root
    }
}
