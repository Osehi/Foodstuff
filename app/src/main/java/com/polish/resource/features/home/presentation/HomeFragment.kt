package com.polish.resource.features.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.polish.common.utils.resourcewrapper.Resource
import com.polish.resource.databinding.FragmentHomeBinding
import com.polish.resource.features.home.data.network.model.getevents.Event
import com.polish.resource.features.home.data.network.model.getevents.GetEventsRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.GetTeacherListRequestBody
import com.polish.resource.features.home.data.network.model.getteacherlist.Teacher
import com.polish.resource.features.home.data.network.model.molingaslist.GetMilongasListRequestBody
import com.polish.resource.features.home.data.network.model.molingaslist.Milongas
import com.polish.resource.features.home.presentation.adapter.EventsAdapter
import com.polish.resource.features.home.presentation.adapter.MilongasAdapter
import com.polish.resource.features.home.presentation.adapter.TeacherAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
    private lateinit var teacherList: MutableList<Teacher>
    private lateinit var eventList: MutableList<Event>
    private lateinit var milongasList: MutableList<Milongas>
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
        /**
         * initialize views
         */
        teacherList = mutableListOf<Teacher>()
        eventList = mutableListOf<Event>()
        milongasList = mutableListOf<Milongas>()
        setMilongasRecyclerview()
        setTeachersRecyclerview()
        setEventsRecyclerview()

        homeFragmentViewModel.allTangoHomeInfo(GetTeacherListRequestBody(), GetEventsRequestBody(), GetMilongasListRequestBody())
        getTeacherListObserver()
        getEventListObserver()
        getMilongasListObserver()
    }

    private fun setTeachersRecyclerview() {
        teachersRecyclerView = binding.teachersRv
        teachersAdapter = TeacherAdapter(teacherList)
        teachersRecyclerView.adapter = teachersAdapter
    }

    private fun setEventsRecyclerview() {
        eventsRecyclerView = binding.eventsRv
        eventsAdapter = EventsAdapter(eventList)
        eventsRecyclerView.adapter = eventsAdapter
    }

    private fun setMilongasRecyclerview() {
        milongasRecyclerView = binding.milongasRv
        milongasAdapter = MilongasAdapter(milongasList)
        milongasRecyclerView.adapter = milongasAdapter
    }

    private fun getTeacherListObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeFragmentViewModel.getTeacherListResponse.collect {
                    when (it) {
                        is Resource.Success -> {
                            binding.homeFragmentProgressBar.isVisible = false
                            binding.homeFragmentListTitleTeachersTv.isVisible = true
                            val allTeachers = it.data.teacher_list
                            teacherList.addAll(allTeachers)
                            teachersAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                        }
                        is Resource.Loading -> {
                        }
                    }
                }
            }
        }
    }

    private fun getEventListObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeFragmentViewModel.getEventResponse.collect {
                    when (it) {
                        is Resource.Success -> {
                            binding.homeFragmentProgressBar.isVisible = false
                            binding.homeFragmentListTitleEventsTv.isVisible = true
                            val allEvents = it.data.Event_List
                            eventList.addAll(allEvents)
                            eventsAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                        }
                        is Resource.Loading -> {
                        }
                    }
                }
            }
        }
    }

    private fun getMilongasListObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeFragmentViewModel.getMilongasListResponse.collect {
                    when (it) {
                        is Resource.Success -> {
                            binding.homeFragmentProgressBar.isVisible = false
                            binding.homeFragmentListTitleMilongasTv.isVisible = true
                            val allMilongas = it.data.milongas_list
                            milongasList.addAll(allMilongas)
                            teachersAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                        }
                        is Resource.Loading -> {
                        }
                    }
                }
            }
        }
    }
    /*
    private fun setMilongasRecyclerview() {
        milongasRecyclerView = binding.milongasRv
        milongasAdapter = MilongasAdapter(Milongas().generateMilongasInfo())
        milongasRecyclerView.adapter = milongasAdapter
        milongasAdapter.notifyDataSetChanged()
    }

     */
    /*
    private fun setTeachersRecyclerview() {
        teachersRecyclerView = binding.teachersRv
        teachersAdapter = TeacherAdapter(Teachers().getTeachersList())
        teachersRecyclerView.adapter = teachersAdapter
        teachersAdapter.notifyDataSetChanged()
    }

     */
    /*
    private fun setEventsRecyclerview() {
        eventsRecyclerView = binding.eventsRv
        eventsAdapter = EventsAdapter(Events().geneerateEvents())
        eventsRecyclerView.adapter = eventsAdapter
        eventsAdapter.notifyDataSetChanged()
    }

     */

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
