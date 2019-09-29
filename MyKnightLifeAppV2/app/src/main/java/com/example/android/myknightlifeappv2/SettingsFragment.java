package com.example.android.myknightlifeappv2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsFragment extends Fragment {
    String aBlock, bBlock, cBlock, dBlock, eBlock, fBlock, gBlock;
    EditText aBlockInput,bBlockInput,cBlockInput,dBlockInput,eBlockInput,fBlockInput,gBlockInput;
    Button saveButton;
    private FragmentSettingListener listener;

    public interface FragmentSettingListener{
        void onInputSettingSent(CharSequence aInput,CharSequence bInput,CharSequence cInput,CharSequence dInput,CharSequence eInput,CharSequence fInput,CharSequence gInput);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        aBlock = getArguments().getString("ABlockInfo");
        bBlock = getArguments().getString("BBlockInfo");
        cBlock = getArguments().getString("CBlockInfo");
        dBlock = getArguments().getString("DBlockInfo");
        eBlock = getArguments().getString("EBlockInfo");
        fBlock = getArguments().getString("FBlockInfo");
        gBlock = getArguments().getString("GBlockInfo");
        aBlockInput = (EditText)v.findViewById(R.id.ABlock);
        bBlockInput = (EditText)v.findViewById(R.id.BBlock);
        cBlockInput = (EditText)v.findViewById(R.id.CBlock);
        dBlockInput = (EditText)v.findViewById(R.id.DBlock);
        eBlockInput = (EditText)v.findViewById(R.id.EBlock);
        fBlockInput = (EditText)v.findViewById(R.id.FBlock);
        gBlockInput = (EditText)v.findViewById(R.id.GBlock);
        saveButton = (Button)v.findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aBlock = aBlockInput.getText().toString();
                bBlock = bBlockInput.getText().toString();
                cBlock = cBlockInput.getText().toString();
                dBlock = dBlockInput.getText().toString();
                eBlock = eBlockInput.getText().toString();
                fBlock = fBlockInput.getText().toString();
                gBlock = gBlockInput.getText().toString();
                aBlockInput.setHint(aBlock);
                bBlockInput.setHint(bBlock);
                cBlockInput.setHint(cBlock);
                dBlockInput.setHint(dBlock);
                eBlockInput.setHint(eBlock);
                fBlockInput.setHint(fBlock);
                gBlockInput.setHint(gBlock);
                CharSequence aInput = aBlockInput.getText();
                CharSequence bInput = bBlockInput.getText();
                CharSequence cInput = cBlockInput.getText();
                CharSequence dInput = dBlockInput.getText();
                CharSequence eInput = eBlockInput.getText();
                CharSequence fInput = fBlockInput.getText();
                CharSequence gInput = gBlockInput.getText();
                listener.onInputSettingSent(aInput,bInput,cInput,dInput,eInput,fInput,gInput);

//                showToast(aBlock);
//                showToast(bBlock);
//                showToast(cBlock);
//                showToast(dBlock);
//                showToast(eBlock);
//                showToast(fBlock);
//                showToast(gBlock);
            }
        });

        return v;
    }
    public void updateEditText(CharSequence aBlockText,CharSequence bBlockText,CharSequence cBlockText,CharSequence dBlockText,CharSequence eBlockText,CharSequence fBlockText,CharSequence gBlockText) {
        aBlockInput.setText(aBlockText);
        bBlockInput.setText(bBlockText);
        cBlockInput.setText(cBlockText);
        dBlockInput.setText(dBlockText);
        eBlockInput.setText(eBlockText);
        fBlockInput.setText(fBlockText);
        gBlockInput.setText(gBlockText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentSettingListener) {
            listener = (FragmentSettingListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    private void showToast(String text) {
        Activity activity = getActivity();
        Toast.makeText(activity,text,Toast.LENGTH_SHORT).show();
    }
}
