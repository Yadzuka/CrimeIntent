package com.example.crime.activities;

import androidx.fragment.app.Fragment;

import com.example.crime.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
