package in.abacritt.android.library;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.commonsware.cwac.merge.MergeAdapter;

import java.util.HashMap;

public class SectionedMergeAdapter extends MergeAdapter {

    protected HashMap<Integer, Section> sections = new HashMap<>();

    public void addSection(Section section) {
        addAdapter(section);
    }

    public void addSection(int sectionId, Section section) {
        this.sections.put(sectionId, section);
        addSection(section);
    }

    public Section getSection(int sectionId) {
        return this.sections.get(sectionId);
    }

    public static class Section extends BaseAdapter {

        private View headerView;
        private ListAdapter adapter;

        public Section(View headerView, ListAdapter adapter) {
            this.headerView = headerView;
            this.adapter = adapter;
        }

        public ListAdapter getAdapter() {
            return adapter;
        }

        public View getHeaderView() {
            return headerView;
        }

        @Override
        public int getCount() {
            return (adapter.getCount() == 0) ? 0 : (adapter.getCount() + 1);
        }

        @Override
        public Object getItem(int i) {
            if (i == 0)
                return null;
            else
                return adapter.getItem(i - 1);
        }

        @Override
        public long getItemId(int i) {
            if (i == 0)
                return -1;
            else
                return adapter.getItemId(i - 1);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (i == 0)
                return headerView;
            else
                return adapter.getView(i - 1, view, viewGroup);
        }

        @Override
        public boolean isEnabled(int position) {
            if (position == 0)
                return false;
            else
                return adapter.isEnabled(position - 1);
        }
    }

}
