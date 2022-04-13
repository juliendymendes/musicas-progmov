package com.me.trab1_progmov;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.me.trab1_progmov.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // lista de imagens do grid
        int[] lista = new int[]{
                R.drawable.abap, R.drawable.blurryface, R.drawable.calm,
                R.drawable.death_of_a_bachelor, R.drawable.i_like_it_when_you_sleep, R.drawable.plastic_hearts,
                R.drawable.sgfg, R.drawable.wiped_out, R.drawable.word_of_mouth, R.drawable.youngblood
        };
        binding.grid.setAdapter(new Adaptador(getContext(), lista));

        //listeners
        binding.grid.setOnItemClickListener((adapterView, view1, i, l) -> onGridItemClick(i));

        binding.btnVoltar.setOnClickListener((view1) -> NavHostFragment.findNavController(ThirdFragment.this)
                .navigate(R.id.action_thirdFragment_to_FirstFragment));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //listener dos itens grid
    private void onGridItemClick(int pos){
        AlertDialog.Builder dlg=new AlertDialog.Builder(getContext());

        switch (pos){
            case 0:
                dlg.setMessage("Álbum: American Beauty/American Psycho\nArtista: Fall Out Boy\nAno: 2015");
                break;
            case 1:
                dlg.setMessage("Álbum: Blurryface\nArtista: Twenty One Pilots\nAno: 2015");
                break;
            case 2:
                dlg.setMessage("Álbum: CALM\nArtista: 5 seconds of summer\nAno: 2020");
                break;
            case 3:
                dlg.setMessage("Álbum: Death of a bachelor\nArtista: Panic! at the disco\nAno: 2016");
                break;
            case 4:
                dlg.setMessage("Álbum: I Like It When You Sleep, for You Are So Beautiful yet So Unaware of It\nArtista: The 1975\nAno: 2016");
                break;
            case 5:
                dlg.setMessage("Álbum: Plastic Hearts\nArtista: Miley Cyrus\nAno: 2020");
                break;
            case 6:
                dlg.setMessage("Álbum: Sounds good feels good\nArtista: 5 seconds of summer\nAno: 2015");
                break;
            case 7:
                dlg.setMessage("Álbum: Wiped out!\nArtista: The neighbourhood\nAno: 2015");
                break;
            case 8:
                dlg.setMessage("Álbum: Word of Mouth\nArtista: The Wanted\nAno: 2013");
                break;
            case 9:
                dlg.setMessage("Álbum: Youngblood\nArtista: 5 seconds of summer\nAno: 2018");
                break;
        }
        dlg.setNeutralButton("OK",null);
        dlg.show();
    }

}