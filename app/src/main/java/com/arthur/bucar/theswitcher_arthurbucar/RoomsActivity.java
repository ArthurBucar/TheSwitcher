package com.arthur.bucar.theswitcher_arthurbucar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.arthur.bucar.theswitcher_arthurbucar.Adapter.SwitchRecyclerAdapter;
import com.arthur.bucar.theswitcher_arthurbucar.Model.SwitchItemVO;

import java.util.ArrayList;
import java.util.List;

public class RoomsActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private LinearLayoutManager layoutMgr = null;
    Context context;
    private List<SwitchItemVO> mDataList = null;
    private SwitchRecyclerAdapter mAdapter = null;

    SwitchCompat switchCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        context = this;
        init();
        initLayout();
    }

    private void init() {
        mDataList = new ArrayList<>();
        mDataList.add(new SwitchItemVO("Kitchen", true));
        mDataList.add(new SwitchItemVO("Living room", true));
        mDataList.add(new SwitchItemVO("Master bedroom", true));
        mDataList.add(new SwitchItemVO("Guest's bedroom", true));
        switchCompat = (SwitchCompat) findViewById(R.id.switchOnOff);
    }

    private void initLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        layoutMgr = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutMgr);
        mAdapter = new SwitchRecyclerAdapter(this, mDataList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mAdapter.setOnClickListener(mOnClickedListener);
    }

    private SwitchRecyclerAdapter.OnCheckedChangeListener mOnCheckedChangeListener = new SwitchRecyclerAdapter.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(int position, boolean isChecked) {

            switch(position){
                case 0:
                    if (isChecked){
                        sendRoomName("Kitchen");
                    } else {
                        isChecked = false;
                    }
                    break;
                case 1:
                    if (isChecked){
                        sendRoomName("Living room");
                    } else {
                        isChecked = false;
                    }
                    break;
                case 2:
                    if (isChecked){
                        sendRoomName("Master bedroom");
                    } else {
                        isChecked = false;
                    }
                    break;
                case 3:
                    if (isChecked){
                        sendRoomName("Guest's bedroom");
                    } else {
                        isChecked = false;
                    }
                    break;
                default:
                    switchCompat.setChecked(false);
                    break;
            }
        }
    };

    private SwitchRecyclerAdapter.OnItemClickedListener mOnClickedListener = new SwitchRecyclerAdapter.OnItemClickedListener() {
        @Override
        public void onItemClicked(SwitchItemVO vo, int position) {
            Log.e("itemClicado", ">>>  vo : " + vo.getTitle() + ", position : " + position);
        }
    };


    public void sendRoomName(String msg) {
        Intent myIntent = new Intent(this, InsideRoomActivity.class);
        myIntent.putExtra("ROOMNAME", msg);
        SwitchItemVO switchItemVO = new SwitchItemVO();
        switchItemVO.setIsSwitch(false);
        this.startActivity(myIntent);
    }

}
