package com.example.sowl.challengeclicker.Utilities;

import com.example.sowl.challengeclicker.Repository.Model.ScoreModel;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static List<ScoreModel> createFakeData() {
        List<ScoreModel> mdata = new ArrayList<>();

        ScoreModel TaskDec1 = new ScoreModel(
                1,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "m=Mohammad Hesam Ebrahimpour", 100
        );
        ScoreModel TaskDec2 = new ScoreModel(
                2,
                "https://images.fastcompany.net/image/upload/w_596,c_limit,q_auto:best,f_auto/fc/3026791-inline-s-2-why-you-should-write-a-personal-mission-statement-and-5-ceos-who-did.jpg",
                "علی داودی", 90
        );
        ScoreModel TaskDec3 = new ScoreModel(
                3,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "Ahmad Kheyri", 80
        );

        ScoreModel TaskDec4 = new ScoreModel(
                4,
                "https://images.fastcompany.net/image/upload/w_596,c_limit,q_auto:best,f_auto/fc/3026791-inline-s-4-why-you-should-write-a-personal-mission-statement-and-5-ceos-who-did.jpg",
                "Alireza Mohammadi", 70
        );
        ScoreModel TaskDec5 = new ScoreModel(
                5,
                "https://cdn.geekwire.com/wp-content/uploads/2016/11/Jordan-Ritter-photo-2-829x1240.jpg",
                "نیما مسلمی", 60
        );
        ScoreModel TaskDec6 = new ScoreModel(
                6,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "Nima Moslemi", 50
        );
        ScoreModel TaskDec7 = new ScoreModel(
                7,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "احمد خیری", 40
        );
        ScoreModel TaskDec8 = new ScoreModel(
                8,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "احمد خیری", 30
        );
        ScoreModel TaskDec9 = new ScoreModel(
                9,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "احمد خیری", 20
        );
        ScoreModel TaskDec10 = new ScoreModel(
                10,
                "https://people.math.ethz.ch/~afigalli/avatar.jpg",
                "احمد خیری", 10
        );


        mdata.add(TaskDec1);
        mdata.add(TaskDec2);
        mdata.add(TaskDec3);
        mdata.add(TaskDec4);
        mdata.add(TaskDec5);
        mdata.add(TaskDec6);
        mdata.add(TaskDec7);
        mdata.add(TaskDec8);
        mdata.add(TaskDec9);
        mdata.add(TaskDec10);

        return mdata;
    }


}
