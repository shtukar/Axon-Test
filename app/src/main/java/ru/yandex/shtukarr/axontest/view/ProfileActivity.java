package ru.yandex.shtukarr.axontest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.yandex.shtukarr.axontest.JSONHelper;
import ru.yandex.shtukarr.axontest.R;
import ru.yandex.shtukarr.axontest.model.EmployeesListModel;
import ru.yandex.shtukarr.axontest.model.ProfileModel;

public class ProfileActivity extends AppCompatActivity{
    private CircleImageView imageViewPhoto;
    private TextView textViewFullName;
    private TextView textViewAge;
    private ProfileModel profileModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        imageViewPhoto = findViewById(R.id.photo_profile);
        textViewFullName = findViewById(R.id.full_name);
        textViewAge = findViewById(R.id.age);

        profileModel = Objects.requireNonNull(getIntent().getExtras()).getParcelable("ProfileModel");

        Picasso.get().load(profileModel.getAvatar())
                .error(R.drawable.ic_error_outline_black_24dp)
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(imageViewPhoto);
        textViewFullName.setText(profileModel.getFirstName() + " " + profileModel.getSecondName());
        textViewAge.setText(profileModel.getAge().toString() + " years old");
    }

}
