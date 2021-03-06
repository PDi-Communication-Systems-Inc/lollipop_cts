/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.uirendering.cts.bitmapverifiers;

import android.graphics.Rect;

/**
 * Tests to see if there is rectangle of a certain color, with a background given
 */
public class RectVerifier extends PerPixelBitmapVerifier {
    private int mOuterColor;
    private int mInnerColor;
    private Rect mInnerRect;

    public RectVerifier(int outerColor, int innerColor, Rect innerRect) {
        this(outerColor, innerColor, innerRect, 20);
    }

    public RectVerifier(int outerColor, int innerColor, Rect innerRect, int tolerance) {
        super(tolerance);
        mOuterColor = outerColor;
        mInnerColor = innerColor;
        mInnerRect = innerRect;
    }

    @Override
    protected int getExpectedColor(int x, int y) {
        return mInnerRect.contains(x, y) ? mInnerColor : mOuterColor;
    }
}
