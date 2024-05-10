package com.target.targetcasestudy.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R
import com.target.targetcasestudy.presentation.viewmodel.DealsListViewModel

class DealListFragment : Fragment() {

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    val view =  inflater.inflate(R.layout.fragment_deal_list, container, false)

    view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager =
        LinearLayoutManager(requireContext())
    view.findViewById<RecyclerView>(R.id.recycler_view).adapter = DealItemAdapter()



    return view
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}