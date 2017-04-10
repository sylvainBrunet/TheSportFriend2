package com.example.brunetsylvain.thesportfriend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    private TextView mTextMessage;

    private String[] quotes;
    private Quote newQuote;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> listQuotes;
    ArrayList<Quote> arrayListQuote = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    loadQuotes();
                    showQuotes(arrayListQuote);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //Affichage ListView Classement Ligue 1
    protected void addQuote(String quote) {
        newQuote = new Quote(quote);
        arrayListQuote.add(newQuote);
    }

    protected void loadQuotes() {
        quotes = getResources().getStringArray(R.array.ligue1);
        for (String item: quotes) {
            addQuote(item);
        }
    }

    protected ArrayList<String> getAllQuotes(ArrayList<Quote> quotes) {
        listQuotes = new ArrayList<>();
        for (Quote quote: quotes) {
            listQuotes.add(quote.getStrQuote());
        }
        return listQuotes;
    }

    protected void showQuotes(ArrayList<Quote> quote) {
        ListView lv = (ListView) findViewById(R.id.lv);
        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getAllQuotes(quote));
        lv.setAdapter(listAdapter);
    }

    protected void clear()
    {
        listAdapter.clear();
    }
}
