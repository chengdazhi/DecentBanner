package it.chengdazhi.decentbanner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengdazhi on 7/13/16.
 */
public class DecentBannerAdapter extends PagerAdapter {

    List<View> viewList;
    private int tabNum;
    private int itemNum;

    DecentBannerAdapter(int itemNum, List<View> views) {
        viewList = new ArrayList<>(tabNum);
        viewList = views;
        this.itemNum = itemNum;
        this.tabNum = views.size();
    }

    @Override
    public int getCount() {
        return itemNum;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position % tabNum);
        if(container.equals(view.getParent())) {
            container.removeView(view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
