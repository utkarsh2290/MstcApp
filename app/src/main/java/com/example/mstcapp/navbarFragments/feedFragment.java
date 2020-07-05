package com.example.mstcapp.navbarFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.adapters.FeedAdapter;
import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class feedFragment extends Fragment {
        private List<feedFragment> feedList;

        private String Desc_sample1, Title_sample1, Link_sample1;
        private int feedPicture;
        View view;
        RecyclerView recyclerView_feed;
        Boolean isScrolling = false;

        public feedFragment() {
        }

        public feedFragment(int URLs_sample, String desc_sample1, String title_sample1, String link_sample1) {
            this.feedPicture = URLs_sample;
            Desc_sample1 = desc_sample1;
            Title_sample1 = title_sample1;
            Link_sample1 = link_sample1;
        }

        public int getFeedPicture() {
            return feedPicture;
        }

        public void setFeedPicture(int feedPicture) {
            this.feedPicture = feedPicture;
        }

        public String getDesc_sample1() {
            return Desc_sample1;
        }

        public void setDesc_sample1(String desc_sample1) {
            Desc_sample1 = desc_sample1;
        }

        public String getTitle_sample1() {
            return Title_sample1;
        }

        public void setTitle_sample1(String title_sample1) {
            Title_sample1 = title_sample1;
        }

        public String getLink_sample1() {
            return Link_sample1;
        }

        public void setLink_sample1(String link_sample1) {
            Link_sample1 = link_sample1;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_feed, container, false);
            recyclerView_feed = (RecyclerView) view.findViewById(R.id.recyclerview_feed);
            FeedAdapter feedAdapter = new FeedAdapter(feedList, getContext());
            recyclerView_feed.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView_feed.setNestedScrollingEnabled(false);
            recyclerView_feed.setAdapter(feedAdapter);
            return view;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            feedList = new ArrayList<>();
            feedList.add(new feedFragment(R.drawable.xbox, "This the sample description for post  This is clickable and the insta post opens in new browser", "Did You Know", "https://www.instagram.com/mstcvit/"));
            feedList.add(new feedFragment(R.drawable.feed_bg1, "This the sample description for post  This is clickable and the insta post opens in new browser", "Did You Know", "https://www.instagram.com/mstcvit/"));
            feedList.add(new feedFragment(R.drawable.xbox, "This the sample description for post  This is clickable and the insta post opens in new browser", "Did You Know", "https://www.instagram.com/mstcvit/"));
            feedList.add(new feedFragment(R.drawable.feed_bg1, "This the sample description for post  This is clickable and the insta post opens in new browser", "Did You Know", "https://www.instagram.com/mstcvit/"));
        }


}
