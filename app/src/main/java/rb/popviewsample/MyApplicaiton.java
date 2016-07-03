package rb.popviewsample;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Leo on 2016-07-02.
 */
public class MyApplicaiton extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
