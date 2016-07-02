package rb.popviewsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rb.popview.PopField;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

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
        final View addView = inflater.inflate(R.layout.sampleimageview, null);
        ImageView newImageView = (ImageView) addView.findViewById(R.id.sampleimageview);
        newImageView.setImageDrawable(getResources().getDrawable(R.drawable.p5));
        mPopField.popView(view, addView);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.imageview3)
    void onClick3(View view) {
        Log.d(TAG, "image 3 on click");
        final View addView = inflater.inflate(R.layout.sampleimageview, null);
        ImageView newImageView = (ImageView) addView.findViewById(R.id.sampleimageview);
        newImageView.setImageDrawable(getResources().getDrawable(R.drawable.p3));
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
}
