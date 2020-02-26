package com.example.sowl.challengeclicker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sowl.challengeclicker.R;
import com.example.sowl.challengeclicker.Repository.Model.ScoreModel;

import java.util.Objects;

public class ScoresAdapter extends ListAdapter<ScoreModel, ScoresAdapter.LogHolder> {


    private static final DiffUtil.ItemCallback<ScoreModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<ScoreModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull ScoreModel oldItem, @NonNull ScoreModel newItem) {
            return oldItem.ID == newItem.ID;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ScoreModel oldItem, @NonNull ScoreModel newItem) {
            return oldItem.Name.equals(newItem.Name) &&
                    oldItem.Score == newItem.Score &&
                    Objects.equals(oldItem.Avatar, newItem.Avatar);
        }
    };
    private Context mContext;


    public ScoresAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public LogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champs_card, parent, false);
        return new LogHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LogHolder holder, int position) {

        holder.bindData(getItem(position));

    }


    class LogHolder extends RecyclerView.ViewHolder {

        private ImageView mAvatar;
        private TextView mName;
        private TextView mDate;
        private ImageView mCup;

        LogHolder(@NonNull View itemView) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.profile_image);
            mName = itemView.findViewById(R.id.name);
            mDate = itemView.findViewById(R.id.date);
            mCup = itemView.findViewById(R.id.Place_Cup);

        }

        void bindData(ScoreModel mScoreModel) {

            mName.setText(mScoreModel.Name);
            mDate.setText("" + mScoreModel.Score);
            RequestOptions options = new RequestOptions()
                    .centerCrop();
            Glide.with(itemView)
                    .load(mScoreModel.Avatar.trim())
                    .apply(options)
                    .into(mAvatar);


            switch (getAdapterPosition()) {
                case (0): {
                    mCup.setVisibility(View.VISIBLE);
                    break;
                }
                case (1): {
                    mCup.setVisibility(View.VISIBLE);
                    mCup.setImageResource(R.drawable.ic_silvercup);

                    break;
                }
                case (2): {
                    mCup.setVisibility(View.VISIBLE);
                    mCup.setImageResource(R.drawable.ic_bronzecup);
                    break;
                }
            }

        }

    }
}
