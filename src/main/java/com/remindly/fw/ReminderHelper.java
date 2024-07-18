package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String title) {
        type(By.id("reminder_title"), title);
    }

    public void tapOnSaveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {
        pause(500);

        if ((!getSelectedMonth().equals(month))) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }

    public String getSelectedMonth() {
        return isTextPresent(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period, String year) {
        pause(500);

        if ((!getSelectedYear().equals(year))) {
            if (period.equals("future")) {
                swipeUntilRequiredYear(year, 0.6, 0.5);
            } else if (period.equals("past")) {
                swipeUntilRequiredYear(year, 0.5, 0.6);
            }
        }

        tap(By.id("month_text_view"));
    }

    public void swipeUntilRequiredYear(String year, double startPoint, double stopPoint) {
        while (!getYear().equals(year)) {
            swipeInElement(By.className("android.widget.ListView"), startPoint, stopPoint);
            getYear();
        }
    }

    public String getYear() {
        return isTextPresent(By.id("month_text_view"));
    }

    public String getSelectedYear() {
        return isTextPresent(By.id("date_picker_year"));
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {
        pause(500);

        if (timeOfDay.equals("am")) {
            tapWithCoordinates(285, 1332);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(804, 1337);
        }

        tapWithCoordinates(xHour, yHour);
        tapWithCoordinates(xMin, yMin);
    }

    public void turnSwitchOff() {
        tap(By.id("repeat_switch"));
    }

    public void tapOnRepetitionInterval() {
        tap(By.id("repeat_no_text"));
    }

    public void enterRepetitionInterval(String repetitionInterval) {
        type(By.xpath("//android.widget.EditText"), repetitionInterval);
    }

    public void tapOnOkButton() {
        tap(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
    }

    public void tapOnTypeOfRepetitions() {
        swipe(0.8, 0.6);
        tap(By.id("repeat_type_text"));
    }

    public void selectTypeOfRepetitions(int index) {
//        pause(1000);
//        List<WebElement> types = driver.findElements(By.className("android.widget.ListView"));
//        types.get(index).click();
        tap(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Day']"));
    }
}
