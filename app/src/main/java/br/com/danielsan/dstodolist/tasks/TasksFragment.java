package br.com.danielsan.dstodolist.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.danielsan.dstodolist.databinding.FragmentTasksBinding;

/**
 * Created by daniel on 25/03/16.
 */
public class TasksFragment extends Fragment {

    private FragmentTasksBinding binding;

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTasksBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

}
