package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.Robot;
import androidx.appcompat.app.AppCompatActivity;

public class DeliveryToActicity extends AppCompatActivity {
    FirebaseDatabase mDatabase_delivery;
    DatabaseReference mReference_delivery; //데이터 쓰기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_to_acticity);

        Button finishbutton = findViewById(R.id.button_del_finish);
        // Firebase에 값을 쓰기
        mDatabase_delivery = FirebaseDatabase.getInstance();
        mReference_delivery = mDatabase_delivery.getReference("chung_pl");

        finishbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 다음 페이지로 이동하는 코드
                    Intent intent = new Intent(DeliveryToActicity.this, MainActivity.class);
                    startActivity(intent);
                    // Firebase에 값을 쓰기
                    mReference_delivery.setValue(true);
                }
        });

    }
    public void toMain_del(View view) {
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