package com.koalait.sierra.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.koalait.sierra.R;
import com.koalait.sierra.databinding.FragmentSettingsBinding;
import com.koalait.sierra.login.SaveSharedPreference;
import com.koalait.sierra.model.Model;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private static final String TAG = "SettingsFragment";
    @InjectView(R.id.btn_resetPw)
    Button btn_resetPw;
    @InjectView(R.id.btn_logout)
    Button btn_logout;
    private SwipeRefreshLayout swipeContainer;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);

        View view = binding.getRoot();
        ButterKnife.inject(this, view);

        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(() -> {
            // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.
            fetchTimelineAsync();
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        binding.setUser(Model.getInstance().getUser());

        // Inflate the layout for this fragment
        return view;
    }

    public void fetchTimelineAsync() {
        new android.os.Handler().postDelayed(
                () -> swipeContainer.setRefreshing(false), 3000);

    }

    @OnClick(R.id.btn_resetPw)
    public void onResetPw() {
        Log.println(Log.DEBUG, TAG, "reset PW");
    }

    @OnClick(R.id.btn_logout)
    public void onLogout() {
        Log.println(Log.DEBUG, TAG, "logout");
        SaveSharedPreference.clearUserName(this.getContext());
        getActivity().finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (swipeContainer != null) {
            swipeContainer.setRefreshing(false);
            swipeContainer.destroyDrawingCache();
            swipeContainer.clearAnimation();
        }
    }
}
