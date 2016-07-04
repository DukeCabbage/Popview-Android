package rb.popviewsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rb.popview.PopField;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @BindView(R.id.rl_test)
    RelativeLayout rlTest;

    private PopField mPopField;
    private LayoutInflater inflater;

    @SuppressWarnings("unused")
    @OnClick(R.id.textview1)
    void onClickText(View view) {
        Log.d(TAG, "text view on click");
        final View addView = inflater.inflate(R.layout.sampletextview, null);
        TextView newTextView = (TextView) addView.findViewById(R.id.sampletextview);
        newTextView.setText("New Sample text");
        mPopField.popView(view, addView, true);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.imageview1)
    void onClick1(View view) {
        Log.d(TAG, "image 1 on click");
        mPopField.popView(view);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.imageview2)
    void onClick2(View view) {
        Log.d(TAG, "image 2 on click");
        final View addView = inflater.inflate(R.layout.sampleimageview, (ViewGroup)view.getParent(), false);
        ImageView newImageView = (ImageView) addView.findViewById(R.id.sampleimageview);
        newImageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        ViewGroup.LayoutParams lp = newImageView.getLayoutParams();
        mPopField.popView(view, addView, false);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.imageview3)
    void onClick3(View view) {
        Log.d(TAG, "image 3 on click");
        final View addView = inflater.inflate(R.layout.sampleimageview, (ViewGroup)view.getParent(), false);
        ImageView newImageView = (ImageView) addView.findViewById(R.id.sampleimageview);
        newImageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        mPopField.popView(view, addView, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        mPopField = PopField.attach2Window(this);
        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.test:
                playground();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void playground() {
        ImageView ivTest = new AppCompatImageView(this);
        rlTest.addView(ivTest);
        ViewGroup.LayoutParams lp = ivTest.getLayoutParams();
        ViewGroup vg = (ViewGroup) ivTest.getParent();
        Log.d(TAG, "");
    }
}
