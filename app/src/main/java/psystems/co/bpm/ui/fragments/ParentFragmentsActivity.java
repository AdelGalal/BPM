package psystems.co.bpm.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import psystems.co.bpm.R;


public class ParentFragmentsActivity extends FragmentActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public void swipeBetweenFragments(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
       fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
