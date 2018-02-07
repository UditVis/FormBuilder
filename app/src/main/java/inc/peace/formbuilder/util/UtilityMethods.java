package inc.peace.formbuilder.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.UUID;

/**
 * Created by axxuser on 2/6/2018.
 */

public class UtilityMethods {
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    public static String getRandomRefId(int count,String fieldName) {
        StringBuilder builder = new StringBuilder();
        String alphanumericString = fieldName + "0123456789";
        while (count-- != 0) {
            int character = (int)(Math.random()*alphanumericString.length());
            builder.append(alphanumericString.charAt(character));
        }
        return builder.toString();
    }
}
