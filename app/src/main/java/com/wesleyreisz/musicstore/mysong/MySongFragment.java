package com.wesleyreisz.musicstore.mysong;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wesleyreisz.musicstore.R;
import com.wesleyreisz.musicstore.mysong.model.Song;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MySongFragment extends Fragment {


    public MySongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_song, container, false);
        List<Song> songs = new MockSongService().findAll();
        ListView listViewSongs = (ListView)view.findViewById(R.id.listViewMusicList);
        SongAdapter songAdapter = new SongAdapter(getActivity(),R.layout.fragment_my_song,songs);
        listViewSongs.setAdapter(songAdapter);

        return view;
    }

}
