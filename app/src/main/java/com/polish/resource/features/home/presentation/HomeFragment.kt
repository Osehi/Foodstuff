package com.polish.resource.features.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.polish.resource.databinding.FragmentHomeBinding
import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.presentation.adapter.EventsAdapter
import com.polish.resource.features.home.presentation.adapter.MilongasAdapter
import com.polish.resource.features.home.presentation.adapter.TeacherAdapter
import com.polish.resource.features.mock.Events
import com.polish.resource.features.mock.Milongas
import com.polish.resource.features.mock.Teachers
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    /**
     * declare variables
     */
    private val TAG = "HOMEFRAGMENT"
    private lateinit var milongasRecyclerView: RecyclerView
    private lateinit var teachersRecyclerView: RecyclerView
    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var milongasAdapter: MilongasAdapter
    private lateinit var teachersAdapter: TeacherAdapter
    private lateinit var eventsAdapter: EventsAdapter
    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMilongasRecyclerview()
        setTeachersRecyclerview()
        setEventsRecyclerview()

        homeFragmentViewModel.allTangoHomeInfo(GetTeacherListRequestBody(), GetEventsRequestBody(), GetMilongasListRequestBody())
    }

    private fun setMilongasRecyclerview() {
        milongasRecyclerView = binding.milongasRv
        milongasAdapter = MilongasAdapter(Milongas().generateMilongasInfo())
        milongasRecyclerView.adapter = milongasAdapter
        milongasAdapter.notifyDataSetChanged()
    }

    private fun setTeachersRecyclerview() {
        teachersRecyclerView = binding.teachersRv
        teachersAdapter = TeacherAdapter(Teachers().getTeachersList())
        teachersRecyclerView.adapter = teachersAdapter
        teachersAdapter.notifyDataSetChanged()
    }

    private fun setEventsRecyclerview() {
        eventsRecyclerView = binding.eventsRv
        eventsAdapter = EventsAdapter(Events().geneerateEvents())
        eventsRecyclerView.adapter = eventsAdapter
        eventsAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
