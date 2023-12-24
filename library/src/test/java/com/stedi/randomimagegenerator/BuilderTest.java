package com.stedi.randomimagegenerator;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

import com.stedi.randomimagegenerator.callbacks.GenerateCallback;
import com.stedi.randomimagegenerator.callbacks.SaveCallback;
import com.stedi.randomimagegenerator.generators.FlatColorGenerator;
import com.stedi.randomimagegenerator.generators.Generator;

import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.*;

public class BuilderTest {
    private final SaveCallback emptySaveCallback = new SaveCallback() {
        @Override
        public void onSaved(@NonNull Bitmap bitmap, @NonNull File file) {

        }

        @Override
        public void onFailedToSave(@NonNull Bitmap bitmap, @NonNull Exception e) {

        }
    };

    private final GenerateCallback emptyGenerateCallback = new GenerateCallback() {
        @Override
        public void onGenerated(@NonNull ImageParams imageParams, @NonNull Bitmap bitmap) {

        }

        @Override
        public void onFailedToGenerate(@NonNull ImageParams imageParams, @NonNull Exception e) {

        }
    };

    @Test
    public void buildFixedSize() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 10);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 1);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedWidthHeight() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedWidth(10)
                .setFixedHeight(10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 10);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 1);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedSizeWithOverride() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(20, 20)
                .setFixedWidth(10)
                .setFixedHeight(10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 10);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 1);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedWidthRangeHeight() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedWidth(10)
                .setHeightRange(10, 100, 10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.heightFrom, 10);
        assertEquals(rig.params.heightTo, 100);
        assertEquals(rig.params.heightStep, 10);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedHeightRangeWidth() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedHeight(10)
                .setWidthRange(10, 100, 10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.height, 10);
        assertEquals(rig.params.widthFrom, 10);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 10);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildRangeWidthHeight() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setWidthRange(10, 100, 10)
                .setHeightRange(100, 10, 10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.widthFrom, 10);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 10);
        assertEquals(rig.params.heightFrom, 100);
        assertEquals(rig.params.heightTo, 10);
        assertEquals(rig.params.heightStep, 10);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedSizeWithRangeOverride() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(20, 20)
                .setWidthRange(10, 100, 10)
                .setHeightRange(100, 10, 10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.widthFrom, 10);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 10);
        assertEquals(rig.params.heightFrom, 100);
        assertEquals(rig.params.heightTo, 10);
        assertEquals(rig.params.heightStep, 10);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildRangeWithFixedSizeOverride() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setWidthRange(10, 100, 10)
                .setHeightRange(100, 10, 10)
                .setFixedSize(20, 20)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 20);
        assertEquals(rig.params.height, 20);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 1);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFixedSizeCount() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 10)
                .setCount(10)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 10);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 10);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildCountThenRange() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setCount(10)
                .setWidthRange(10, 100, 10)
                .setHeightRange(100, 10, 20)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.widthFrom, 10);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 10);
        assertEquals(rig.params.heightFrom, 100);
        assertEquals(rig.params.heightTo, 10);
        assertEquals(rig.params.heightStep, 20);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildRangeWithFixedSizeOverrideAndCount() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setWidthRange(10, 100, 10)
                .setHeightRange(100, 10, 20)
                .setFixedSize(10, 100)
                .setCount(5)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertNull(rig.params.generateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 5);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFullWithCallback() {
        Generator generator = new FlatColorGenerator();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .build();


        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality.getFormat(), Bitmap.CompressFormat.PNG);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 2);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFullWithQuality() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 2);
        assertNull(rig.params.path);
        assertNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFullWithSavePath() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .setFileSavePath("BuilderTest")
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 2);
        assertEquals(rig.params.path.getPath(), "BuilderTest");
        assertNotNull(rig.params.fileNamePolicy);
        assertNull(rig.params.saveCallback);
        assertNotNull(rig.params.palette);
    }

    @Test
    public void buildFullWithSaveCallack() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .setFileSavePath("BuilderTest")
                .setFileSaveCallback(emptySaveCallback)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 2);
        assertEquals(rig.params.path.getPath(), "BuilderTest");
        assertNotNull(rig.params.fileNamePolicy);
        assertNotNull(rig.params.palette);
        assertSame(rig.params.saveCallback, emptySaveCallback);
    }

    @Test
    public void buildFullWithFileNamePolicy() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();
        FileNamePolicy fileNamePolicy = new DefaultFileNamePolicy();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .setFileSavePath("BuilderTest")
                .setFileSaveCallback(emptySaveCallback)
                .setFileNamePolicy(fileNamePolicy)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.width, 10);
        assertEquals(rig.params.height, 100);
        assertFalse(rig.params.useHeightRange);
        assertNull(rig.params.heightRangeValues);
        assertFalse(rig.params.useWidthRange);
        assertNull(rig.params.widthRangeValues);
        assertEquals(rig.params.count, 2);
        assertNotNull(rig.params.palette);
        assertEquals(rig.params.path.getPath(), "BuilderTest");
        assertSame(rig.params.fileNamePolicy, fileNamePolicy);
        assertSame(rig.params.saveCallback, emptySaveCallback);
    }

    @Test
    public void buildFullWithRangeOverride() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();
        FileNamePolicy fileNamePolicy = new DefaultFileNamePolicy();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .setFileSavePath("BuilderTest")
                .setFileSaveCallback(emptySaveCallback)
                .setFileNamePolicy(fileNamePolicy)
                .setHeightRange(100, 1000, 10)
                .setWidthRange(50, 100, 25)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.widthFrom, 50);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 25);
        assertEquals(rig.params.heightFrom, 100);
        assertEquals(rig.params.heightTo, 1000);
        assertEquals(rig.params.heightStep, 10);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertNotNull(rig.params.palette);
        assertEquals(rig.params.path.getPath(), "BuilderTest");
        assertSame(rig.params.fileNamePolicy, fileNamePolicy);
        assertSame(rig.params.saveCallback, emptySaveCallback);
    }

    @Test
    public void buildFullWithPalette() {
        Generator generator = new FlatColorGenerator();
        Quality quality = Quality.png();
        FileNamePolicy fileNamePolicy = new DefaultFileNamePolicy();
        RigPalette palette = RigPalette.blackAndWhite();

        Rig rig = new Rig.Builder()
                .setGenerator(generator)
                .setPalette(palette)
                .setFixedSize(10, 100)
                .setCount(2)
                .setCallback(emptyGenerateCallback)
                .setQuality(quality)
                .setFileSavePath("BuilderTest")
                .setFileSaveCallback(emptySaveCallback)
                .setFileNamePolicy(fileNamePolicy)
                .setHeightRange(100, 1000, 10)
                .setWidthRange(50, 100, 25)
                .build();

        assertNotNull(rig);
        assertNotNull(rig.params);
        assertSame(rig.params.generator, generator);
        assertSame(rig.params.generateCallback, emptyGenerateCallback);
        assertSame(rig.params.quality, quality);
        assertEquals(rig.params.widthFrom, 50);
        assertEquals(rig.params.widthTo, 100);
        assertEquals(rig.params.widthStep, 25);
        assertEquals(rig.params.heightFrom, 100);
        assertEquals(rig.params.heightTo, 1000);
        assertEquals(rig.params.heightStep, 10);
        assertTrue(rig.params.useHeightRange);
        assertNotNull(rig.params.heightRangeValues);
        assertTrue(rig.params.useWidthRange);
        assertNotNull(rig.params.widthRangeValues);
        assertEquals(rig.params.path.getPath(), "BuilderTest");
        assertSame(rig.params.fileNamePolicy, fileNamePolicy);
        assertSame(rig.params.saveCallback, emptySaveCallback);
        assertSame(rig.params.palette, palette);
    }
}
