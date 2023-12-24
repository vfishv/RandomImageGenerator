package com.stedi.randomimagegenerator.callbacks;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

import com.stedi.randomimagegenerator.ImageParams;

/**
 * Interface definition for a callback to be invoked when an image is generated or not.
 */
public interface GenerateCallback {
    /**
     * Called when an image is generated.
     *
     * @param imageParams The parameters that were used to generate image.
     * @param bitmap      The image that was generated.
     */
    void onGenerated(@NonNull ImageParams imageParams, @NonNull Bitmap bitmap);

    /**
     * Called when an image is not generated.
     *
     * @param imageParams The parameters that were used to generate image.
     * @param e           The detailed exception.
     */
    void onFailedToGenerate(@NonNull ImageParams imageParams, @NonNull Exception e);
}
