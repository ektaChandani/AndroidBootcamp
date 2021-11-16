package com.example.androidbootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment() , RecyclerViewAdapter.ClickListener {

    private lateinit var adapter: RecyclerViewAdapter
    val listdata :ArrayList<DataModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)


        buildDisplayData()
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view:View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerViewAdapter(listdata , this)
        recyclerView.adapter=adapter



    }

    private fun buildDisplayData(){

        listdata.add(DataModel("Ekta"))
        listdata.add(DataModel("Shikha"))
        listdata.add(DataModel("Anshita"))
        listdata.add(DataModel("Atul"))
        listdata.add(DataModel("Akash"))
        listdata.add(DataModel("Anuj"))

    }
    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onItemClick(dataModel: DataModel) {
        val fragment:Fragment = DetailFragment.newInstance(dataModel.title!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("main_fragment")!!)
        transaction.add(R.id.fragment_container , fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}