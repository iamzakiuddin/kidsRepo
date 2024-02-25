package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;

import java.io.IOException;

public class ImageRotation {
    public static Bitmap fixBitmapOrientation(Uri uri, Bitmap bmp)
            throws IOException {
        ExifInterface ei = new ExifInterface(uri.getPath());
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateBitmap(bmp, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateBitmap(bmp, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateBitmap(bmp, 270);
        }//from  w  ww  .  jav  a 2  s  . c o  m

        return bmp;
    }

    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);

        return Bitmap.createBitmap(source, 0, 0, source.getWidth(),
                source.getHeight(), matrix, true);
    }
}
