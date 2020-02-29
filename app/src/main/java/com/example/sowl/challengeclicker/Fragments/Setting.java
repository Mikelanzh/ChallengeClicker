package com.example.sowl.challengeclicker.Fragments;


import android.app.AlertDialog;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.example.sowl.challengeclicker.R;
import com.example.sowl.challengeclicker.Repository.Utility.Utils;
import com.example.sowl.challengeclicker.Repository.Utility.Validator;
import com.example.sowl.challengeclicker.Repository.ViewModel.SettingViewModel;
import com.example.sowl.challengeclicker.Utilities.MyPreferences;
import com.example.sowl.challengeclicker.Utilities.TApplication;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static java.lang.String.format;


/**
 * A simple {@link Fragment} subclass.
 */
public class Setting extends Fragment implements
        BSImagePicker.ImageLoaderDelegate,
        BSImagePicker.OnSingleImageSelectedListener {

    private NavController navController;
    private CircleImageView mAvatar;
    //    private EditText mNameEntering;
    private TextInputEditText mNameEntering;
    private TextInputLayout mLayout;
    private Button mBtn;
    private Uri selectedIMG;
    private SettingViewModel mViewModel;


    public Setting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        init(view);
        initListener();
    }

    private void init(View view) {

        mAvatar = view.findViewById(R.id.profile_image);
        mNameEntering = view.findViewById(R.id.EnteringNameED);
        mBtn = view.findViewById(R.id.BtnSubmit);
        navController = NavHostFragment.findNavController(this);
        mLayout = view.findViewById(R.id.EnteringNameEditText);
        mViewModel = ViewModelProviders.of(this).get(SettingViewModel.class);
        mLayout.setCounterMaxLength(10);
        mLayout.setCounterEnabled(true);


    }

    private void initListener() {

        mBtn.setOnClickListener(view -> {

            if (selectedIMG != null && !mNameEntering.getText().toString().equals("")) {
                if (Validator.validator(mNameEntering.getText().toString())) {
                    MultipartBody.Part[] uploadImageList = new MultipartBody.Part[1];
                    RequestBody surveyBody = null;
                    File f = new File(getRealPathFromURI(selectedIMG));
                    try {
                        File comFile = new Compressor(TApplication.applicationContext)
                                .setMaxHeight(640)
                                .setMaxWidth(480)
                                .setQuality(75)
                                .compressToFile(f);
                        surveyBody = RequestBody.create(MediaType.parse("multipart/form-data"), comFile);
                        String ss = comFile.getName();
                        String[] postx = ss.split("\\.");
                        String tempName = format(Locale.US, "image" + "%d.", 0) + postx[1];
                        uploadImageList[0] = MultipartBody.Part.createFormData("myFile", tempName, surveyBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mViewModel.AddPlayer(uploadImageList, mNameEntering.getText().toString()).observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(apiResponse -> {
                                if (apiResponse.State) {
                                    if (apiResponse.Message != null && apiResponse.Message != "") {
                                        MyPreferences.writeString(TApplication.applicationContext, "playerId", apiResponse.Message);
                                        navController.navigate(R.id.gameFragment);
                                    } else {
                                        Utils.ShowToast("User Data Not Saved").show();
                                    }
                                } else {
                                    Utils.ShowToast(apiResponse.Message).show();
                                }
                            }, throwable -> {

                                Utils.ShowToast(throwable.getMessage()).show();

                            });

                } else {

                    mLayout.setError("3-10 character Aa-Zz 0-9");
//                    mLayout.setHelperTextEnabled(true);
//                    mLayout.setErrorEnabled(false);

                }
            } else {
                Utils.ShowToast("Please Check Your Inputs").show();
            }
        });


        mAvatar.setOnClickListener(v -> selectImage());

        mNameEntering.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0)
                    mLayout.setHelperTextEnabled(true);
                mLayout.setErrorEnabled(false);
                mLayout.setHelperText("3-10 character Aa-Zz 0-9");
            }
        });

    }

    private void selectImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TApplication.applicationContext);
        BSImagePicker pickerDialog = new BSImagePicker.Builder("com.example.sowl.challengeclicker.provider")
                .setSpanCount(3)
                .build();
        pickerDialog.show(getChildFragmentManager(), "picker");
        builder.setOnCancelListener(dialog -> {

        });
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getActivity().getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }


    public void onSingleImageSelected(Uri uri, String tag) {
        Glide.with(getActivity()).load(uri).into(mAvatar);
        selectedIMG = uri;
    }

    @Override
    public void loadImage(File imageFile, ImageView ivImage) {
        try {
            Glide.with(getActivity()).load(imageFile).into(ivImage);
        } catch (Exception ignored) {

        }

    }

}