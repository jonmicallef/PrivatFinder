package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;

import com.example.slideshow.Teachers.AnnaCarbonaro;
import com.example.slideshow.Teachers.GabriellaBonnici;
import com.example.slideshow.Teachers.GeorgeMicallef;
import com.example.slideshow.Teachers.JackGrech;
import com.example.slideshow.Teachers.JasonBartolo;
import com.example.slideshow.Teachers.JeromeMicallef;
import com.example.slideshow.Teachers.JonathanGalea;
import com.example.slideshow.Teachers.KayAzzopardi;
import com.example.slideshow.Teachers.MichealGonzalez;
import com.example.slideshow.Teachers.NatashaMifsud;
import com.example.slideshow.Teachers.RichardBonnici;
import com.example.slideshow.Teachers.TarahGalea;
import com.example.slideshow.Teachers.VictorValdes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TeacherList extends AppCompatActivity {


    //sorting teacher list alphabetically
    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

   //setting dropdown menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown,menu);
        return true;
    }
    //dropdown menu options
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem ) {
        switch (menuItem.getItemId()) {
            //case user chooses sort by Alphabet
            case R.id.sortbyAlphabet:
                //outputting at the bottom of the screen via toast
                Toast.makeText(this, "List is already sorted", Toast.LENGTH_SHORT).show();
                break;
             //case user chooses sort by Subject
            case R.id.sortbyPrice:
                Toast.makeText(this, "Cannot Sort by Subject at the moment", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.LogOut:
                //User chooses to log out and is logged back into the slides activity
                Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TeacherList.this, slideOne.class));
                return true;

        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        //setting toolbar
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        //getting app logo and setting it in the center of the toolbar
        getSupportActionBar().setIcon(getDrawable(R.drawable.logo));
        ListView resultsListView = (ListView) findViewById(R.id.results_listview);



        //inputting list of teachers into TreeMap data structure
        TreeMap<String, String> nameSubject = new TreeMap<>();
        nameSubject.put("Richard Bonnici", "Maths");     //1
        nameSubject.put("Natasha Mifsud", "English");   //2
        nameSubject.put("Victor Valdes", "Computing");   //3
        nameSubject.put("Jonathan Galea", "Computing");  //4
        nameSubject.put("Jerome Micallef", "History");   //5
        nameSubject.put("Tarah Galea", "Marketing");     //6
        nameSubject.put("Micheal Gonzalez", "Maths");    //7
        nameSubject.put("Jason Bartolo", "Chemistry");   //8
        nameSubject.put("Jack Grech", "Chemistry");      //9
        nameSubject.put("Anna Carbonaro", "Maltese");    //10
        nameSubject.put("Kay Azzopardi", "Biology");     //11
        nameSubject.put("George Micallef", "Physics");   //12
        nameSubject.put("Gabriella Bonnici", "Maths");   //13

        //Sorting List Alphabetically
        Map sortedMap = valueSort(nameSubject);

        // Get a set of the entries on the sorted map
        Set set = sortedMap.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        //making adapter for listView
        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        //while loop to displat TreeMap items into ViewList
        Iterator it = nameSubject.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry) it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        resultsListView.setAdapter(adapter);

        //switch case for ViewList
        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long l) {
            //According to item position the item clicked on is taken to its respective class and makes use of viewteacher.xml
                switch (i) {
                    case 0:
                        startActivity(new Intent(TeacherList.this, AnnaCarbonaro.class));
                        break;
                    case 1:
                        startActivity(new Intent(TeacherList.this, GabriellaBonnici.class));
                        break;
                    case 2:
                        startActivity(new Intent(TeacherList.this, GeorgeMicallef.class));
                        break;
                    case 3:
                        startActivity(new Intent(TeacherList.this, JackGrech.class));
                        break;
                    case 4:
                        startActivity(new Intent(TeacherList.this, JasonBartolo.class));
                        break;
                    case 5:
                        startActivity(new Intent(TeacherList.this, JeromeMicallef.class));
                        break;
                    case 6:
                        startActivity(new Intent(TeacherList.this, JonathanGalea.class));
                        break;
                    case 7:
                        startActivity(new Intent(TeacherList.this, KayAzzopardi.class));
                        break;
                    case 8:
                        startActivity(new Intent(TeacherList.this, MichealGonzalez.class));
                        break;
                    case 9:
                        startActivity(new Intent(TeacherList.this, NatashaMifsud.class));
                        break;
                    case 10:
                        startActivity(new Intent(TeacherList.this, RichardBonnici.class));
                        break;
                    case 11:
                        startActivity(new Intent(TeacherList.this, TarahGalea.class));
                        break;
                    case 12:
                        startActivity(new Intent(TeacherList.this, VictorValdes.class));
                        break;


                }
            }
        });


    }
}


