package com.allison.android.linesthoughts.model;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m")
public class LineThought {
    private UUID mId;
    private String mSource;
    private String mThought;
    private String mLine;
    private Date mDate;
    private boolean mIsUnfinished;

    public LineThought() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
