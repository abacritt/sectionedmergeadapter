package in.abacritt.android.sectionedmergeadapterdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.abacritt.android.library.SectionedMergeAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(android.R.id.list);

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            array.add(i);
        }

        ArrayAdapter<Integer> adapter1 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1, array.subList(0, 10));
        ArrayAdapter<Integer> adapter2 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1, array.subList(10, 20));
        ArrayAdapter<Integer> adapter3 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1, array.subList(20, 30));

        TextView tv1 = new TextView(this);
        tv1.setText("Header");
        TextView tv2 = new TextView(this);
        tv2.setText("Header");
        TextView tv3 = new TextView(this);
        tv3.setText("Header");

        SectionedMergeAdapter adapter = new SectionedMergeAdapter();
        adapter.addSection(new SectionedMergeAdapter.Section(tv1, adapter1));
        adapter.addSection(new SectionedMergeAdapter.Section(tv2, adapter2));
        adapter.addSection(new SectionedMergeAdapter.Section(tv3, adapter3));

        listView.setAdapter(adapter);
    }
}
