package sher.app;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by aniket on 9/5/17.
 */

public class ThemeChanger {
    private static int sTheme;

    public final static int THEME_1 = 0;
    public final static int THEME_2 = 1;

    public static void changeThemeTo(Activity activity, int theme){
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public static void setTheme(Activity activity){
        switch (sTheme){
            default:
            case THEME_1:
                activity.setTheme(R.style.Theme_AppCompat);
                break;
            case THEME_2:
                activity.setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);
                break;
        }
    }


}
