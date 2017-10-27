package com.maple7sha.haowan.whereareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.maple7sha.haowan.whereareyou.adapter.FeedAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.toolbar)
  Toolbar toolbar;

  @BindView(R.id.rvFeed)
  RecyclerView rvFeed;

  private MenuItem inboxMenuItem;
  private FeedAdapter feedAdapter;

  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);

    setupToolbar();
    setupFeed();
  }

  protected void setupToolbar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      toolbar.setNavigationIcon(R.drawable.ic_menu_white);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    inboxMenuItem = menu.findItem(R.id.action_inbox);
    inboxMenuItem.setActionView(R.layout.menu_item_view);
    return true;
  }

  private void setupFeed() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    rvFeed.setLayoutManager(linearLayoutManager );
    feedAdapter = new FeedAdapter(this);
    rvFeed.setAdapter(feedAdapter);
  }
}
