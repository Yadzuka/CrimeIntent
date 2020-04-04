package com.example.crime.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.crime.R;
import com.example.crime.models.PictureUtils;

import java.io.File;

public class ImageDisplayFragment extends DialogFragment {
    private static final String ARG_FILE = "fileName";
    private File mPhotoFile;
    private ImageView mPhotoView;

    public static ImageDisplayFragment newInstance(File fileName) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FILE, fileName);

        ImageDisplayFragment fragment = new ImageDisplayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mPhotoFile = (File) getArguments().getSerializable(ARG_FILE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);
        mPhotoView = (ImageView) layout.findViewById(R.id.image_view);
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }

        builder.setView(layout);
        builder.setTitle(R.string.dialog_image_title);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        return builder.create();
    }
}
