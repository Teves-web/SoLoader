/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.soloader;

import android.os.StrictMode;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Abstract class representing a source of shared libraries.
 */
public abstract class SoSource {

    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
    @Deprecated public static final int LOAD_FLAG_ALLOW_SOURCE_CHANGE = 1 << 1;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 1 << 2;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = (1 << 0);
    public static final int PREPARE_FLAG_FORCE_REFRESH = (1 << 1);
    public static final int PREPARE_FLAG_DISABLE_FS_SYNC_JOB = (1 << 2);

    protected void prepare(int flags) throws IOException {
        /* By default, do nothing */
    }

    public abstract int loadLibrary(String soName, int loadFlags, StrictMode.ThreadPolicy threadPolicy) throws IOException;

    @Nullable
    public abstract File unpackLibrary(String soName) throws IOException;

    @Nullable
    protected File getSoFileByName(String soName) throws IOException {
        return null;
    }

    @Nullable
    public String getLibraryPath(String soFileName) throws IOException {
        return null;
    }

    @Nullable
    public String[] getLibraryDependencies(String soName) throws IOException {
        return null;
    }

    public void addToLdLibraryPath(Collection<String> paths) {
        /* By default, do nothing */
    }

    public String[] getSoSourceAbis() {
        return SysUtil.getSupportedAbis();
    }

    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
