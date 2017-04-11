package com.example.brunetsylvain.thesportfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    private String[] quotesResult;
    private Quote newQuoteResult;
    private ArrayAdapter<String> listAdapterResult;
    private ArrayList<String> listQuotesResult;
    ArrayList<Quote> arrayListQuoteResult = new ArrayList<>();

    private String[] quotesCalendrier;
    private Quote newQuoteCalendrier;
    private ArrayAdapter<String> listAdapterCalendrier;
    private ArrayList<String> listQuotesCalendrier;
    ArrayList<Quote> arrayListQuoteCalendrier = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    if(arrayListQuote.isEmpty()){
                        loadQuotes();
                        showQuotes(arrayListQuote);
                    } else {
                        if(!arrayListQuoteResult.isEmpty()){
                            clearResult();
                        }
                        if(!arrayListQuoteCalendrier.isEmpty()){
                            clearCalendrier();
                        }
                        clear();
                        showQuotes(arrayListQuote);
                    }
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    if(arrayListQuoteResult.isEmpty() ){
                        loadQuotesResult();
                        showQuotesResult(arrayListQuoteResult);
                    } else {
                        if(!arrayListQuote.isEmpty()){
                            clear();
                        }
                        if(!arrayListQuoteCalendrier.isEmpty()){
                            clearCalendrier();
                        }
                        clearResult();
                        showQuotesResult(arrayListQuoteResult);
                    }
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    if(arrayListQuoteCalendrier.isEmpty() ){
                        loadQuotesCalendrier();
                        showQuotesCalendrier(arrayListQuoteCalendrier);
                    } else {
                        if(!arrayListQuote.isEmpty()){
                            clear();
                        }
                        if(!arrayListQuoteResult.isEmpty()){
                            clearResult();
                        }
                        clearCalendrier();
                        showQuotesCalendrier(arrayListQuoteCalendrier);
                    }
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
        quotes = getResources().getStringArray(R.array.classement);
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
        if(lv.getCount() > 0) {
            clear();
        }
        lv.setAdapter(listAdapter);
    }

    protected void clear()
    {
        listAdapter.clear();
    }


    //Affichage ListView Résultat Ligue 1
    protected void addQuoteResult(String quote) {
        newQuoteResult = new Quote(quote);
        arrayListQuoteResult.add(newQuoteResult);
    }

    protected void loadQuotesResult() {
        quotesResult = getResources().getStringArray(R.array.resultat);
        for (String item: quotesResult) {
            addQuoteResult(item);
        }
    }

    protected ArrayList<String> getAllQuotesResult(ArrayList<Quote> quotes) {
        listQuotesResult = new ArrayList<>();
        for (Quote quote: quotes) {
            listQuotesResult.add(quote.getStrQuote());
        }
        return listQuotesResult;
    }

    protected void showQuotesResult(ArrayList<Quote> quote) {
        ListView lv = (ListView) findViewById(R.id.lv);
        listAdapterResult = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getAllQuotesResult(quote));
        if(lv.getCount() > 0) {
            clearResult();
        }
        lv.setAdapter(listAdapterResult);
    }

    protected void clearResult()
    {
        listAdapterResult.clear();
    }


    //Affichage List View Calendrier Ligue 1
    protected void addQuoteCalendrier(String quote) {
        newQuoteCalendrier = new Quote(quote);
        arrayListQuoteCalendrier.add(newQuoteCalendrier);
    }

    protected void loadQuotesCalendrier() {
        quotesCalendrier = getResources().getStringArray(R.array.calendrier);
        for (String item: quotesCalendrier) {
            addQuoteCalendrier(item);
        }
    }

    protected ArrayList<String> getAllQuotesCalendrier(ArrayList<Quote> quotes) {
        listQuotesCalendrier = new ArrayList<>();
        for (Quote quote: quotes) {
            listQuotesCalendrier.add(quote.getStrQuote());
        }
        return listQuotesCalendrier;
    }

    protected void showQuotesCalendrier(ArrayList<Quote> quote) {
        ListView lv = (ListView) findViewById(R.id.lv);
        listAdapterCalendrier = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getAllQuotesCalendrier(quote));
        if(lv.getCount() > 0) {
            clearCalendrier();
        }
        lv.setAdapter(listAdapterCalendrier);
    }

    protected void clearCalendrier()
    {
        listAdapterCalendrier.clear();
    }
}
