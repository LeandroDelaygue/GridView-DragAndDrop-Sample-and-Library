package com.example.leandro.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;

import com.ldelaygue.gridviewdinamic_draganddrop.classes.DinamicDragAndDropGridView;
import com.ldelaygue.gridviewdinamic_draganddrop.classes.SimpleScrollingStrategy;
import com.ldelaygue.gridviewdinamic_draganddrop.classes.SpanVariableGridView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DinamicDragAndDropGridView.DragAndDropListener, SpanVariableGridView.OnItemClickListener,
        SpanVariableGridView.OnItemLongClickListener {

    DinamicDragAndDropGridView mDinamicDragAndDropGridView;
    ItemAdapter mDragAndDropAdapter;
    List<Item> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new LinkedList<Item>();


        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        mDinamicDragAndDropGridView = (DinamicDragAndDropGridView) findViewById(R.id.dinamicDragAndDropGridView);

        mItems.add(new Item(-1, 2, "1/08/2016", "5","15","15"));
        mItems.add(new Item(-1, 2, "16/08/2016", "10","15","25"));
        mItems.add(new Item(-1, 1, "15/05/2015", "7","15","20"));
        mItems.add(new Item(-1, 1, "07/01/2015", "25","2","50"));

        mDragAndDropAdapter = new ItemAdapter(this, mItems);
        mDinamicDragAndDropGridView.setAdapter(mDragAndDropAdapter);
        mDinamicDragAndDropGridView.setScrollingStrategy(new SimpleScrollingStrategy(scrollView));
        mDinamicDragAndDropGridView.setDragAndDropListener(this);
        mDinamicDragAndDropGridView.setOnItemLongClickListener(this);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        mDragAndDropAdapter.notifyDataSetChanged();
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        mDinamicDragAndDropGridView.startDragAndDrop();

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

    }

    @Override
    public void onDragItem(int from) {

    }

    @Override
    public void onDraggingItem(int from, int to) {

    }

    @Override
    public void onDropItem(int from, int to) {
        if (from != to) {

            mItems.add(to, mItems.remove(from));
            mDragAndDropAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean isDragAndDropEnabled(int position) {
        return true;
    }
}
