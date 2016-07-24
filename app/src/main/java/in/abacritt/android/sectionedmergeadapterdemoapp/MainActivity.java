package in.abacritt.android.sectionedmergeadapterdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
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

        List<String> array = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            array.add("Row " + i);
        }

        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1,
                        array.subList(0, 8));
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1,
                        array.subList(8, 16));
        ArrayAdapter<String> adapter3 =
                new ArrayAdapter<>(this, R.layout.item_list, android.R.id.text1,
                        array.subList(16, 24));

        TextView tv1 = (TextView) getLayoutInflater().inflate(R.layout.item_header, null, false)
                .findViewById(R.id.headerText);
        tv1.setText("Header 1");
        TextView tv2 = (TextView) getLayoutInflater().inflate(R.layout.item_header, null, false)
                .findViewById(R.id.headerText);
        tv2.setText("Header 2");
        TextView tv3 = (TextView) getLayoutInflater().inflate(R.layout.item_header, null, false)
                .findViewById(R.id.headerText);
        tv3.setText("Header 3");

        SectionedMergeAdapter adapter = new SectionedMergeAdapter();
        adapter.addSection(new SectionedMergeAdapter.Section(tv1, adapter1));
        adapter.addSection(new SectionedMergeAdapter.Section(tv2, adapter2));
        adapter.addSection(new SectionedMergeAdapter.Section(tv3, adapter3));

        listView.setAdapter(adapter);
    }
}
