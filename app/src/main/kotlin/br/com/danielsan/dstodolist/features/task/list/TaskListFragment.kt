package br.com.danielsan.dstodolist.features.task.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.danielsan.dstodolist.databinding.FragmentTaskListBinding

/**
 * Created by daniel on 04/09/16.
 */
class TaskListFragment : Fragment() {

    companion object {
        fun newInstance(): TaskListFragment {
            return TaskListFragment()
        }
    }

    private var binding: FragmentTaskListBinding? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentTaskListBinding.inflate(inflater, container, false);
        return binding!!.root
    }

}