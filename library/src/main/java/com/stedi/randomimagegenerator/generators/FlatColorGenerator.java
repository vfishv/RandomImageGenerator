package com.stedi.randomimagegenerator.generators;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import com.stedi.randomimagegenerator.ImageParams;

/**
 * Simple random flat color image generator.
 */
public class FlatColorGenerator implements Generator {
    @Override
    @Nullable
    @WorkerThread
    public Bitmap generate(@NonNull ImageParams imageParams) throws Exception {
        Bitmap bitmap = Bitmap.createBitmap(imageParams.getWidth(), imageParams.getHeight(), Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(imageParams.getPalette().getRandom());
        return bitmap;
    }

    @Override
    public String toString() {
        return "FlatColorGenerator{}";
    }
}
