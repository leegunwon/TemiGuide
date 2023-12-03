package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CallFromProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_from_professor);
    }

    public void selectDestination(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, WhereToGoActivity.class);
        startActivity(intent);
    }

    public void toMain_call(View view) {
        // 종료하기 버튼이 클릭되었을 때 실행되는 메소드
        DatabaseReference mReference_lec; //데이터 쓰기
        FirebaseDatabase mDatabase_lec;

        mDatabase_lec = FirebaseDatabase.getInstance();
        mReference_lec = mDatabase_lec.getReference("running");
        mReference_lec.setValue(false);
        mReference_lec = mDatabase_lec.getReference("chung_pl");
        mReference_lec.setValue(false);
        mReference_lec = mDatabase_lec.getReference("stair_pl");
        mReference_lec.setValue(false);
        mReference_lec = mDatabase_lec.getReference("mecha_pl");
        mReference_lec.setValue(false);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}