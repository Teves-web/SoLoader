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

import androidx.annotation.NonNull;

/**
 * Custom exception to handle errors related to loading shared objects (SO files).
 */
@DoNotStripAny
public class SoLoaderULError extends UnsatisfiedLinkError {

    private final String soName;

    /**
     * Constructs a new {@code SoLoaderULError} with the specified shared object name and error message.
     *
     * @param soName the name of the shared object that caused the error.
     * @param error the detailed error message.
     */
    public SoLoaderULError(@NonNull String soName, @NonNull String error) {
        super(error);
        this.soName = soName;
    }

    /**
     * Constructs a new {@code SoLoaderULError} with the specified shared object name.
     *
     * @param soName the name of the shared object that caused the error.
     */
    public SoLoaderULError(@NonNull String soName) {
        this.soName = soName;
    }

    /**
     * Retrieves the name of the shared object that caused the error.
     *
     * @return the shared object name.
     */
    @NonNull
    public String getSoName() {
        return soName;
    }
}
