package com.mag.dictionary.Model.Exceptions;

import androidx.annotation.Nullable;

public class EmptyFieldException extends  Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Field is Empty";
    }
}
