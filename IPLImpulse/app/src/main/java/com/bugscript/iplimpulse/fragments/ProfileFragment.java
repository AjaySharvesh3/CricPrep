package com.bugscript.iplimpulse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bugscript.iplimpulse.MainActivity;
import com.bugscript.iplimpulse.R;

import org.w3c.dom.Text;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment{

    @BindView(R.id.textView8) TextView name;
    @BindView(R.id.textView11) TextView number;
    @BindView(R.id.textView13) TextView team_sup;
    @BindView(R.id.textView15) TextView points;

    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.profile,container,false);
        ButterKnife.bind(this,mView);
        name.setText(MainActivity.current_user_name);
        number.setText(MainActivity.currentUser.getPhoneNumber());
        team_sup.setText(MainActivity.current_support_team);
        points.setText(MainActivity.points_str);
        return mView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
