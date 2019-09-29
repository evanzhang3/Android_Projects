package com.example.android.myknightlifeappv2;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {
    String aBlock, bBlock, cBlock, dBlock, eBlock, fBlock, gBlock;
    TextView aBlockText,bBlockText,cBlockText,dBlockText,eBlockText,fBlockText,gBlockText,xBlockText,labOneText, labTwoText, morningActivityText, morningActivityTimeText, lunchText, headerInfo;
    TextView aBlockTimeText,bBlockTimeText,cBlockTimeText,dBlockTimeText,eBlockTimeText,fBlockTimeText,gBlockTimeText,xBlockTimeText,LabOneTimeText,labTwoTimeText, lunchTimeText;
    Date now;
    Calendar cal;
    String pattern = "HH:mm";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    private NotificationManagerCompat notificationManager;
    Date firstBlock,secondBlock,thirdBlock,fourthBlock,fithBlock,sixthBlock,seventhBlockA,seventhBlockB,currentTime;
    String formattedDate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        try{
             firstBlock = sdf.parse("08:10");
             secondBlock = sdf.parse("09:00");
             thirdBlock = sdf.parse("10:20");
             fourthBlock = sdf.parse("11:35");
             fithBlock = sdf.parse("12:30");
             sixthBlock = sdf.parse("13:20");
             seventhBlockA = sdf.parse("14:15");
             seventhBlockB = sdf.parse("14:35");
             currentTime = Calendar.getInstance().getTime();
        }catch(ParseException e) {

        }

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-YYYY");
        formattedDate = df.format(c);

        notificationManager = NotificationManagerCompat.from(getActivity());
        Log.i("Evan","Event2");
        aBlock = getArguments().getString("ABlockInfo");
        bBlock = getArguments().getString("BBlockInfo");
        cBlock = getArguments().getString("CBlockInfo");
        dBlock = getArguments().getString("DBlockInfo");
        eBlock = getArguments().getString("EBlockInfo");
        fBlock = getArguments().getString("FBlockInfo");
        gBlock = getArguments().getString("GBlockInfo");
        Log.i("Evan","OncreateView " + aBlock);
        now = new Date();
        cal = Calendar.getInstance();
        cal.setTime(now);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.MONDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("Assembly");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("8:00 - 8:15");
                if(currentTime.compareTo(firstBlock) == 0) {
                    sendOnChannel1(v,dBlock);
                }
                dBlockText = (TextView)v.findViewById(R.id.BlockOne);
                dBlockText.setText(dBlock);
                dBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                dBlockTimeText.setText("8:20-9:05");
                if(currentTime.compareTo(secondBlock) == 0) {
                    sendOnChannel1(v,bBlock);
                }
                bBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                bBlockText.setText(bBlock);
                bBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                bBlockTimeText.setText("9:10-10:00");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(bBlock + " Lab");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText("10:00-10:20");
                fBlockText = (TextView)v.findViewById(R.id.BlockThree);
                if(currentTime.compareTo(thirdBlock) == 0) {
                    sendOnChannel1(v,fBlock);
                }
                fBlockText.setText(fBlock);
                fBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                fBlockTimeText.setText("10:25-11:10");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText("Lunch");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText("11:15-11:35");
                if(currentTime.compareTo(fourthBlock) == 0) {
                    sendOnChannel1(v,aBlock);
                }
                aBlockText = (TextView)v.findViewById(R.id.BlockFour);
                aBlockText.setText(aBlock);
                aBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                aBlockTimeText.setText("11:40-12:35");
                if(currentTime.compareTo(fithBlock) == 0) {
                    sendOnChannel1(v,"X-Block");
                }
                xBlockText = (TextView)v.findViewById(R.id.BlockFive);
                xBlockText.setText("X-Block");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                xBlockTimeText.setText("12:40-1:25");
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(" ");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText(" ");
                if(currentTime.compareTo(sixthBlock) == 0) {
                    sendOnChannel1(v,cBlock);
                }
                cBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                cBlockText.setText(cBlock);
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                cBlockTimeText.setText("1:30-2:20");
                if(currentTime.compareTo(seventhBlockA) == 0) {
                    sendOnChannel1(v,gBlock);
                }
                gBlockText = (TextView)v.findViewById(R.id.BlockEight);
                gBlockText.setText(gBlock);
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                gBlockTimeText.setText("2:25-3:10");
                break;
            case Calendar.TUESDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("Advisory");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("8:00 - 8:15");
                if(currentTime.compareTo(firstBlock) == 0) {
                    sendOnChannel1(v,eBlock);
                }
                eBlockText = (TextView)v.findViewById(R.id.BlockOne);
                eBlockText.setText(eBlock);
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                cBlockTimeText.setText("8:20-9:05");
                if(currentTime.compareTo(secondBlock) == 0) {
                    sendOnChannel1(v,cBlock);
                }
                bBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                bBlockText.setText(cBlock);
                bBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                bBlockTimeText.setText("9:10-10:00");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(cBlock + " Lab");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText("10:00-10:20");
                if(currentTime.compareTo(thirdBlock) == 0) {
                    sendOnChannel1(v,dBlock);
                }
                dBlockText = (TextView)v.findViewById(R.id.BlockThree);
                dBlockText.setText(dBlock);
                dBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                dBlockTimeText.setText("10:25-11:10");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText("Lunch");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText("11:15-11:35");
                if(currentTime.compareTo(fourthBlock) == 0) {
                    sendOnChannel1(v,bBlock);
                }
                bBlockText = (TextView)v.findViewById(R.id.BlockFour);
                bBlockText.setText(bBlock);
                bBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                bBlockTimeText.setText("11:40-12:35");
                if(currentTime.compareTo(fithBlock) == 0) {
                    sendOnChannel1(v,"X-Block");
                }
                xBlockText = (TextView)v.findViewById(R.id.BlockFive);
                xBlockText.setText("X-Block");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                xBlockTimeText.setText("12:40-1:20");
                if(currentTime.compareTo(sixthBlock) == 0) {
                    sendOnChannel1(v,fBlock);
                }
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(fBlock);
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText("1:25-2:15");
                cBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                cBlockText.setText(fBlock + " Lab");
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                cBlockTimeText.setText("2:15-2:35");
                if(currentTime.compareTo(seventhBlockB) == 0) {
                    sendOnChannel1(v,aBlock);
                }
                gBlockText = (TextView)v.findViewById(R.id.BlockEight);
                gBlockText.setText(aBlock);
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                gBlockTimeText.setText("2:40-3:25");
                break;
            case Calendar.WEDNESDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("Class Meeting");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("8:00 - 8:15");
                if(currentTime.compareTo(firstBlock) == 0) {
                    sendOnChannel1(v,gBlock);
                }
                gBlockText = (TextView)v.findViewById(R.id.BlockOne);
                gBlockText.setText(gBlock);
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                gBlockTimeText.setText("8:20-9:05");
                if(currentTime.compareTo(secondBlock) == 0) {
                    sendOnChannel1(v,eBlock);
                }
                eBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                eBlockText.setText(eBlock);
                eBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                eBlockTimeText.setText("9:10-10:00");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(eBlock + " Lab");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText("10:00-10:20");
                if(currentTime.compareTo(thirdBlock) == 0) {
                    sendOnChannel1(v,cBlock);
                }
                cBlockText = (TextView)v.findViewById(R.id.BlockThree);
                cBlockText.setText(cBlock);
                cBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                cBlockTimeText.setText("10:25-11:10");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText("Lunch");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText("11:15-11:35");
                if(currentTime.compareTo(fourthBlock) == 0) {
                    sendOnChannel1(v,fBlock);
                }
                fBlockText = (TextView)v.findViewById(R.id.BlockFour);
                fBlockText.setText(fBlock);
                fBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                fBlockTimeText.setText("11:40-12:35");
                if(currentTime.compareTo(fithBlock) == 0) {
                    sendOnChannel1(v,"Activities");
                }
                xBlockText = (TextView)v.findViewById(R.id.BlockFive);
                xBlockText.setText("Activities");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                xBlockTimeText.setText("12:40-1:25");
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(" ");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText(" ");
                cBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                cBlockText.setText(" ");
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                cBlockTimeText.setText(" ");
                gBlockText = (TextView)v.findViewById(R.id.BlockEight);
                gBlockText.setText(" ");
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                gBlockTimeText.setText(" ");
                break;
            case Calendar.THURSDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("Free Time");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("8:00 - 8:15");
                if(currentTime.compareTo(firstBlock) == 0) {
                    sendOnChannel1(v,fBlock);
                }
                fBlockText = (TextView)v.findViewById(R.id.BlockOne);
                fBlockText.setText(fBlock);
                fBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                fBlockTimeText.setText("8:20-9:05");
                if(currentTime.compareTo(secondBlock) == 0) {
                    sendOnChannel1(v,aBlock);
                }
                aBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                aBlockText.setText(aBlock);
                aBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                aBlockTimeText.setText("9:10-10:00");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(aBlock + " Lab");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText("10:00-10:20");
                if(currentTime.compareTo(thirdBlock) == 0) {
                    sendOnChannel1(v,"X-Block");
                }
                xBlockText = (TextView)v.findViewById(R.id.BlockThree);
                xBlockText.setText("X-Block");
                dBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                dBlockTimeText.setText("10:25-11:05");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText("Lunch");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText("11:10-11:35");
                if(currentTime.compareTo(fourthBlock) == 0) {
                    sendOnChannel1(v,gBlock);
                }
                gBlockText = (TextView)v.findViewById(R.id.BlockFour);
                gBlockText.setText(gBlock);
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                gBlockTimeText.setText("11:40-12:35");
                if(currentTime.compareTo(fithBlock) == 0) {
                    sendOnChannel1(v,eBlock);
                }
                eBlockText = (TextView)v.findViewById(R.id.BlockFive);
                eBlockText.setText(eBlock);
                eBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                eBlockTimeText.setText("12:40-1:20");
                if(currentTime.compareTo(sixthBlock) == 0) {
                    sendOnChannel1(v,dBlock);
                }
                dBlockText = (TextView)v.findViewById(R.id.BlockSix);
                dBlockText.setText(dBlock);
                dBlockTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                dBlockTimeText.setText("1:25-2:15");
                labTwoText = (TextView)v.findViewById(R.id.BlockSeven);
                labTwoText.setText(dBlock + " Lab");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                labTwoTimeText.setText("2:15-2:35");
                if(currentTime.compareTo(seventhBlockB) == 0) {
                    sendOnChannel1(v,bBlock);
                }
                bBlockText = (TextView)v.findViewById(R.id.BlockEight);
                bBlockText.setText(bBlock);
                bBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                bBlockTimeText.setText("2:40-3:25");
                break;
            case Calendar.FRIDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("Advisory");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("8:00 - 8:15");
                if(currentTime.compareTo(firstBlock) == 0) {
                    sendOnChannel1(v,cBlock);
                }
                cBlockText = (TextView)v.findViewById(R.id.BlockOne);
                cBlockText.setText(cBlock);
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                cBlockTimeText.setText("8:20-9:05");
                if(currentTime.compareTo(secondBlock) == 0) {
                    sendOnChannel1(v,gBlock);
                }
                gBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                gBlockText.setText(gBlock);
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                gBlockTimeText.setText("9:10-10:00");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(gBlock + " Lab");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText("10:00-10:20");
                if(currentTime.compareTo(thirdBlock) == 0) {
                    sendOnChannel1(v,bBlock);
                }
                bBlockText = (TextView)v.findViewById(R.id.BlockThree);
                bBlockText.setText(bBlock);
                bBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                bBlockTimeText.setText("10:25-11:10");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText("Lunch");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText("11:15-11:35");
                dBlockText = (TextView)v.findViewById(R.id.BlockFour);
                dBlockText.setText(dBlock);
                dBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                dBlockTimeText.setText("11:40-12:35");
                if(currentTime.compareTo(fourthBlock) == 0) {
                    sendOnChannel1(v,aBlock);
                }
                aBlockText = (TextView)v.findViewById(R.id.BlockFive);
                aBlockText.setText(aBlock);
                aBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                aBlockTimeText.setText("12:40-1:25");
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(" ");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText(" ");
                if(currentTime.compareTo(fithBlock) == 0) {
                    sendOnChannel1(v,eBlock);
                }
                eBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                eBlockText.setText(eBlock);
                eBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                eBlockTimeText.setText("1:30-2:20");
                if(currentTime.compareTo(sixthBlock) == 0) {
                    sendOnChannel1(v,"X-Block");
                }
                xBlockText = (TextView)v.findViewById(R.id.BlockEight);
                xBlockText.setText("X-Block");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                xBlockTimeText.setText("2:25-3:10");
                break;
            case Calendar.SATURDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("No Classes");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("Today");
                cBlockText = (TextView)v.findViewById(R.id.BlockOne);
                cBlockText.setText(" ");
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                cBlockTimeText.setText(" ");
                gBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                gBlockText.setText(" ");
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                gBlockTimeText.setText(" ");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(" ");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText(" ");
                bBlockText = (TextView)v.findViewById(R.id.BlockThree);
                bBlockText.setText(" ");
                bBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                bBlockTimeText.setText(" ");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText(" ");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText(" ");
                dBlockText = (TextView)v.findViewById(R.id.BlockFour);
                dBlockText.setText(" ");
                dBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                dBlockTimeText.setText(" ");
                aBlockText = (TextView)v.findViewById(R.id.BlockFive);
                aBlockText.setText(" ");
                aBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                aBlockTimeText.setText(" ");
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(" ");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText(" ");
                eBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                eBlockText.setText(" ");
                eBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                eBlockTimeText.setText(" ");
                xBlockText = (TextView)v.findViewById(R.id.BlockEight);
                xBlockText.setText(" ");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                xBlockTimeText.setText(" ");
                break;
            case Calendar.SUNDAY:
                headerInfo = (TextView)v.findViewById(R.id.headerDate);
                headerInfo.setText("Today is " + formattedDate);
                morningActivityText = (TextView) v.findViewById(R.id.MorningActivity);
                morningActivityText.setText("No Classes");
                morningActivityTimeText = (TextView)v.findViewById(R.id.MorningActivityTime);
                morningActivityTimeText.setText("Today");
                cBlockText = (TextView)v.findViewById(R.id.BlockOne);
                cBlockText.setText(" ");
                cBlockTimeText = (TextView)v.findViewById(R.id.BlockOneTime);
                cBlockTimeText.setText(" ");
                gBlockText = (TextView)v.findViewById(R.id.BlockTwo);
                gBlockText.setText(" ");
                gBlockTimeText = (TextView)v.findViewById(R.id.BlockTwoTime);
                gBlockTimeText.setText(" ");
                labOneText = (TextView)v.findViewById(R.id.BlockTwoLab);
                labOneText.setText(" ");
                LabOneTimeText = (TextView)v.findViewById(R.id.BlockTwoLabTime);
                LabOneTimeText.setText(" ");
                bBlockText = (TextView)v.findViewById(R.id.BlockThree);
                bBlockText.setText(" ");
                bBlockTimeText = (TextView) v.findViewById(R.id.BlockThreeTime);
                bBlockTimeText.setText(" ");
                lunchText = (TextView)v.findViewById(R.id.LunchBlock);
                lunchText.setText(" ");
                lunchTimeText = (TextView)v.findViewById(R.id.LunchBlockTime);
                lunchTimeText.setText(" ");
                dBlockText = (TextView)v.findViewById(R.id.BlockFour);
                dBlockText.setText(" ");
                dBlockTimeText = (TextView)v.findViewById(R.id.BlockFourTime);
                dBlockTimeText.setText(" ");
                aBlockText = (TextView)v.findViewById(R.id.BlockFive);
                aBlockText.setText(" ");
                aBlockTimeText = (TextView)v.findViewById(R.id.BlockFiveTime);
                aBlockTimeText.setText(" ");
                labTwoText = (TextView)v.findViewById(R.id.BlockSix);
                labTwoText.setText(" ");
                labTwoTimeText = (TextView)v.findViewById(R.id.BlockSixTime);
                labTwoTimeText.setText(" ");
                eBlockText = (TextView)v.findViewById(R.id.BlockSeven);
                eBlockText.setText(" ");
                eBlockTimeText = (TextView)v.findViewById(R.id.BlockSevenTime);
                eBlockTimeText.setText(" ");
                xBlockText = (TextView)v.findViewById(R.id.BlockEight);
                xBlockText.setText(" ");
                xBlockTimeText = (TextView)v.findViewById(R.id.BlockEightTime);
                xBlockTimeText.setText(" ");
                break;

        }

        return v;
    }
    public void updateEditText(CharSequence aBlockText,CharSequence bBlockText,CharSequence cBlockText,CharSequence dBlockText,CharSequence eBlockText,CharSequence fBlockText,CharSequence gBlockText) {
        Log.i("Evan","UpdateEditText()"+aBlockText.toString());
        aBlock = aBlockText.toString();
        bBlock = bBlockText.toString();
        cBlock = cBlockText.toString();
        dBlock = dBlockText.toString();
        eBlock = eBlockText.toString();
        fBlock = fBlockText.toString();
        gBlock = gBlockText.toString();
    }
    public void sendOnChannel1(View v, String block) {
        String title = "Get to Class";
        Notification notification = new NotificationCompat.Builder(getActivity(), App.CHANNEL_1_ID).setSmallIcon(R.drawable.ic_access_time_black_24dp).setContentTitle(title)
                .setContentText("5 Minutes Until " + block).setPriority(NotificationCompat.PRIORITY_HIGH).build();
        notificationManager.notify(1,notification);
    }
}
