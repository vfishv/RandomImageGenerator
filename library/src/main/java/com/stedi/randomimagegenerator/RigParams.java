package com.stedi.randomimagegenerator;

import androidx.annotation.NonNull;

import com.stedi.randomimagegenerator.callbacks.GenerateCallback;
import com.stedi.randomimagegenerator.callbacks.SaveCallback;
import com.stedi.randomimagegenerator.generators.Generator;

import java.io.File;
import java.util.Arrays;

/**
 * Generation parameters created by {@link Rig.Builder} and used by {@link Rig}.
 */
class RigParams {
    /**
     * Used for bitmaps generation.
     * <p>
     * Must not be null.
     * </p>
     */
    Generator generator;

    /**
     * Color palette for bitmaps.
     * <p>
     * Must not be null.
     * </p>
     */
    RigPalette palette;

    /**
     * Callbacks while generation.
     * <p>
     * Can be null.
     * </p>
     */
    GenerateCallback generateCallback;

    /**
     * Format and saving quality of bitmaps.
     * <p>
     * Must not be null.
     * </p>
     */
    Quality quality;

    /**
     * Width of generated images.
     * <p>
     * Must be bigger than 0 (if width range is not specified).
     * </p>
     */
    int width;

    /**
     * Height of generated images.
     * <p>
     * Must be bigger than 0 (if height range is not specified).
     * </p>
     */
    int height;

    /**
     * Width range start. Used along with widthTo and widthStep.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int widthFrom;

    /**
     * Width range end. Used along with widthFrom and widthStep.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int widthTo;

    /**
     * Width range step. Used along with widthFrom and widthTo.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int widthStep;

    /**
     * Height range start. Used along with heightTo and heightStep.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int heightFrom;

    /**
     * Height range end. Used along with heightFrom and heightStep.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int heightTo;

    /**
     * Height range step. Used along with heightFrom and heightTo.
     * <p>
     * Must be bigger than 0 (if range is specified).
     * </p>
     */
    int heightStep;

    /**
     * true if width range is specified.
     */
    boolean useWidthRange;

    /**
     * true if height range is specified.
     */
    boolean useHeightRange;

    /**
     * Calculated width values if {@link #useWidthRange} is true.
     * <p>
     * Can be null.
     * </p>
     */
    int[] widthRangeValues;

    /**
     * Calculated height values if {@link #useHeightRange} is true.
     * <p>
     * Can be null.
     * </p>
     */
    int[] heightRangeValues;

    /**
     * The number of generated images.
     * <p>
     * Must be bigger than 0 (for fixed size).
     * </p>
     */
    int count;

    /**
     * The path where images will be saved.
     * <p>
     * Can be null.
     * </p>
     */
    File path;

    /**
     * File name creator, which is used for saving images.
     * <p>
     * Must not be null (if path is specified).
     * </p>
     */
    FileNamePolicy fileNamePolicy;

    /**
     * Callbacks while saving images.
     * <p>
     * Can be null.
     * </p>
     */
    SaveCallback saveCallback;

    void apply(@NonNull RigParams from) {
        generator = from.generator;
        palette = from.palette;
        generateCallback = from.generateCallback;
        quality = from.quality;
        width = from.width;
        height = from.height;
        widthFrom = from.widthFrom;
        widthTo = from.widthTo;
        widthStep = from.widthStep;
        heightFrom = from.heightFrom;
        heightTo = from.heightTo;
        heightStep = from.heightStep;
        useWidthRange = from.useWidthRange;
        useHeightRange = from.useHeightRange;
        widthRangeValues = from.widthRangeValues;
        heightRangeValues = from.heightRangeValues;
        count = from.count;
        path = from.path;
        fileNamePolicy = from.fileNamePolicy;
        saveCallback = from.saveCallback;
    }

    @Override
    public String toString() {
        return "RigParams{" +
                "generator=" + generator +
                ", palette=" + palette +
                ", generateCallback=" + generateCallback +
                ", quality=" + quality +
                ", width=" + width +
                ", height=" + height +
                ", widthFrom=" + widthFrom +
                ", widthTo=" + widthTo +
                ", widthStep=" + widthStep +
                ", heightFrom=" + heightFrom +
                ", heightTo=" + heightTo +
                ", heightStep=" + heightStep +
                ", useWidthRange=" + useWidthRange +
                ", useHeightRange=" + useHeightRange +
                ", widthRangeValues=" + Arrays.toString(widthRangeValues) +
                ", heightRangeValues=" + Arrays.toString(heightRangeValues) +
                ", count=" + count +
                ", path=" + path +
                ", fileNamePolicy=" + fileNamePolicy +
                ", saveCallback=" + saveCallback +
                '}';
    }
}
