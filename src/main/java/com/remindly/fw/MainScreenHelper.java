package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.Collection;

public class MainScreenHelper extends BaseHelper {
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text"));
    }

    public void confirm() {
        tap(By.id("android:id/button1"));
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public String isReminderTitlePresent() {
        return isTextPresent(By.id("recycle_title"));
    }

    public String isReminderDateTimePresent() {
        return isTextPresent(By.id("recycle_date_time"));
    }


    public String isReminderRepeatOffPresent() {
        return isTextPresent(By.id("recycle_repeat_info"));
    }

    public String isReminderRepetitionIntervalPresent() {
        return isTextPresent(By.id("recycle_repeat_info"));
    }

    public String isReminderRepetitionTypePresent() {
        return isTextPresent(By.id("recycle_repeat_info"));
    }
}

