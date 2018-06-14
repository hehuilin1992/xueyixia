package com.allison.android.linesthoughts.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.allison.android.linesthoughts.R;
import com.allison.android.linesthoughts.model.LineThought;

public class LineThoughtFragment extends Fragment {
    private LineThought mLineThought;
    private EditText mLineSource;
    private EditText mLineContent;
    private EditText mThoughtContent;
    private Button mDateButton;
    private CheckBox mUnfinishedCheckBox;
    private boolean mIsUnfinished;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLineThought = new LineThought();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.line_thought_fragment, container, false);
        mLineSource = (EditText) v.findViewById(R.id.line_source);
        mLineContent = (EditText) v.findViewById(R.id.line_content);
        mThoughtContent = (EditText) v.findViewById(R.id.thought_content);
        mDateButton = (Button) v.findViewById(R.id.thought_date);
        mUnfinishedCheckBox = (CheckBox) v.findViewById(R.id.thought_unfinished);

        mDateButton.setText(mLineThought.getDate().toString());
        mDateButton.setEnabled(false);

        mUnfinishedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mLineThought.setUnfinished(isChecked);
            } });

        mLineSource.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // no-op
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mLineThought.setSource(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // no-op
            }
        });

        mLineContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // no-op
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mLineThought.setLine(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // no-op
            }
        });

        mThoughtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // no-op
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mLineThought.setThought(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // no-op
            }
        });

        return v;
    }
}
