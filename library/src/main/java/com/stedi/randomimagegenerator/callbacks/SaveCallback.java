package com.stedi.randomimagegenerator.callbacks;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

import java.io.File;

/**
 * Interface definition for a callback to be invoked when an image is saved.
 */
public interface SaveCallback {
    /**
     * Called when an image is saved.
     *
     * @param bitmap The image that was saved.
     * @param file   The file of saved image.
     */
    void onSaved(@NonNull Bitmap bitmap, @NonNull File file);

    /**
     * Called when an image is not saved.
     *
     * @param bitmap The image that was not saved.
     * @param e      The detailed exception.
     */
    void onFailedToSave(@NonNull Bitmap bitmap, @NonNull Exception e);
}
