package org.edx.mobile.module.analytics;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.crashlytics.android.answers.CustomEvent;

import org.edx.mobile.base.MainApplication;

public class AnswersEvent extends CustomEvent {
    public AnswersEvent(@NonNull String eventName) {
        super(eventName);
        setCustomProperties();
    }

    public void setCustomProperties() {
        this.putCustomAttribute(Analytics.Keys.APP, Analytics.Values.APP_NAME);
        boolean isPortrait = MainApplication.instance().getResources()
                .getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        this.putCustomAttribute(Analytics.Keys.DEVICE_ORIENTATION,
                (isPortrait ? Analytics.Values.PORTRAIT : Analytics.Values.LANDSCAPE));
    }

    public void addCategoryToBiEvents(@NonNull String category, @Nullable String label) {
        putCustomAttribute(Analytics.Keys.CATEGORY, category);
        if (!TextUtils.isEmpty(label)) {
            putCustomAttribute(Analytics.Keys.LABEL, label);
        }
    }
}
