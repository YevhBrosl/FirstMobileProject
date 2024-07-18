package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @Test
    public void addReminderTitlePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void addReminderWithDatePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("past", "MAY", 2);
        app.getReminder().selectDate(0);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("past", "2020");
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("1/5/2020"));
    }

    @Test
    public void addReminderWithTimePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am", 541, 1198, 541, 658);
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("6:00"));
    }

    @Test
    public void addReminderWithRepetitionOffPositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().turnSwitchOff();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepeatOffPresent().contains("Repeat Off"));
    }

    @Test
    public void addReminderWithRepetitionIntervalPositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnRepetitionInterval();
        app.getReminder().enterRepetitionInterval("3");
        app.getReminder().tapOnOkButton();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepetitionIntervalPresent().contains("3"));
    }

    @Test
    public void addReminderWithTypeOfRepetitionPositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnTypeOfRepetitions();
        app.getReminder().selectTypeOfRepetitions(2);
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepetitionTypePresent().contains("Day"));
    }
}
