package br.com.danielsan.dstodolist.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.danielsan.dstodolist.databinding.FragmentTasksBinding

/**
 * Created by daniel on 25/03/16.
 */
class TasksFragment : Fragment() {

    private var binding: FragmentTasksBinding? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    companion object {
        fun newInstance(): TasksFragment {
            return TasksFragment()
        }
    }

}
