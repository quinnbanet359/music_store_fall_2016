package com.wesleyreisz.musicstore.navigation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wesleyreisz.musicstore.R;
import com.wesleyreisz.musicstore.account.AccountFragment;
import com.wesleyreisz.musicstore.friend.FriendFragment;
import com.wesleyreisz.musicstore.home.HomeFragment;
import com.wesleyreisz.musicstore.itune.ItuneFragment;
import com.wesleyreisz.musicstore.mysong.MySongFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class NavigationFragment extends Fragment {

    public NavigationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        wireEvents(view);

        return view;
    }

    private void wireEvents(View view) {
        Button btnHome = (Button)view.findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new HomeFragment());
            }
        });
        Button btnAccount = (Button)view.findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AccountFragment());
            }
        });
        Button btnFriend = (Button)view.findViewById(R.id.btnFriend);
        btnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FriendFragment());
            }
        });
        Button btnITunes = (Button)view.findViewById(R.id.btnITunes);
        btnITunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ItuneFragment());
            }
        });
        Button btnMySong = (Button)view.findViewById(R.id.btnMySong);
        btnMySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new MySongFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment2load) {
        if(getActivity().findViewById(R.id.fragmentContent)!=null){
            //show this when in in landscape
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentMain, new NavigationFragment())
                    .replace(R.id.fragmentContent, fragment2load)
                    .commit();

        }else {
            //show this when in in portrait
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentMain, fragment2load)
                    .commit();
        }
    }
}
