package me.toru.collapse;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;

    private LinkedList<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        final TextView text = (TextView)findViewById(R.id.changeable_text);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing_toolbar);

        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.main_appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(collapsingToolbarLayout.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)) {
                    // collapsed
                    text.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.theme_cyan_color_dark));
                } else {
                    // extended
                    text.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                }
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.main_recyclerview);

        stringList = new LinkedList<>();
        stringList.add("알폰스테크");
        stringList.add("트루모바일");
        stringList.add("메리츠금융정보서비스");
        stringList.add("우아한형제들");
        stringList.add("블루페그");
        stringList.add("버즈피아");
        stringList.add("인코어드테크놀로지스");
        stringList.add("직토");
        stringList.add("카우치그램");
        stringList.add("헤이뷰티");

        adapter = new MainAdapter(stringList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
