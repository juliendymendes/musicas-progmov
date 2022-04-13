package com.me.trab1_progmov;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.me.trab1_progmov.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MediaPlayer mp;
    private int spinnerItemPos; //variavel utilizada para controlar a visibilidade do botão 'play'


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(getContext(),
                R.array.musicas, android.R.layout.simple_spinner_item);
        binding.spinner.setAdapter(adapter);


        // listeners
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                onSpinnerItemSelected(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        binding.btnPlay.setOnClickListener(view2 -> {
            if(mp != null){
                mp.start();
            }
        });

        binding.btnPausar.setOnClickListener(view1 -> {
            if(mp != null){
                mp.pause();
            }

            if(spinnerItemPos != 0){
                binding.btnPlay.setVisibility(View.VISIBLE);
            }

        });

        binding.btnVoltar.setOnClickListener(view1 -> { NavHostFragment
                .findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment); });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        if(mp != null){
            mp.release();
        }
    }

    // listener do spinner
    private void onSpinnerItemSelected(int pos){
        spinnerItemPos = pos;

        if(mp != null){
            mp.release();
        }

        switch (pos){
            case 1:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_actionable);
                break;
            case 2:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_anewbeginning);
                break;
            case 3:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_badass);
                break;
            case 4:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_happyrock);
                break;
            case 5:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_punky);
                break;
            case 6:
                mp = MediaPlayer.create(getContext(), R.raw.bensound_rumble);
                break;
        }

        if (mp!=null){
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }


}