package ru.yandex.shtukarr.axontest.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.shtukarr.axontest.JSONHelper;
import ru.yandex.shtukarr.axontest.R;
import ru.yandex.shtukarr.axontest.model.ProfileModel;
import ru.yandex.shtukarr.axontest.model.EmployeesListModel;

public class MainActivity extends AppCompatActivity implements MainScreen {
    private RecyclerView mRecyclerView;
    private EmployeeListAdapter employeeListAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<ProfileModel> profileModelList;
    private JSONHelper jsonHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.main_recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        employeeListAdapter = new EmployeeListAdapter(this);
        mRecyclerView.setAdapter(employeeListAdapter);

        setListFromJSON();
    }

    private void setListFromJSON() {
        jsonHelper = new JSONHelper();
        EmployeesListModel employeesListModel = jsonHelper.parseJSON(this);
        profileModelList = new ArrayList<ProfileModel>(employeesListModel.getEmployees().values());
        employeeListAdapter.setList(profileModelList);
    }

    @Override
    public void onItemSelected(ProfileModel profileModel) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        intent.putExtra("ProfileModel", profileModel);
        startActivity(intent);
    }
}
