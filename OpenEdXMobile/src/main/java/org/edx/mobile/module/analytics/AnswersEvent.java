package org.edx.mobile.module.analytics;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.crashlytics.android.answers.CustomEvent;

import org.edx.mobile.base.MainApplication;

/**
 * Wrapper class that defines common functions required for Answers custom event.
 */
public class AnswersEvent extends CustomEvent {
    public AnswersEvent(@NonNull String eventName) {
        super(eventName);
        setCustomProperties();
    }

    /**
     * Setting all common properties which requires in every answers event.
     */
    public void setCustomProperties() {
        this.putCustomAttribute(Analytics.Keys.APP, Analytics.Values.APP_NAME);
        boolean isPortrait = MainApplication.instance().getResources()
                .getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        this.putCustomAttribute(Analytics.Keys.DEVICE_ORIENTATION,
                (isPortrait ? Analytics.Values.PORTRAIT : Analytics.Values.LANDSCAPE));
    }

    /**
     * Sets category and labels to BI events.
     *
     * @param category The category.
     * @param label    The label.
     */
    public void addCategoryToBiEvents(@NonNull String category, @Nullable String label) {
        putCustomAttribute(Analytics.Keys.CATEGORY, category);
        if (!TextUtils.isEmpty(label)) {
            putCustomAttribute(Analytics.Keys.LABEL, label);
        }
    }
}
