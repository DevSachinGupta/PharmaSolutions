package me.inventosachingupta.aid;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by InventoSachin on 06-07-2017.
 */
public class AgeCalculator {

    public static int calculateAge(LocalDate d){
        int day = 1, month = 0, year = 1, ageYears, ageMonths, ageDays;
        Calendar now = Calendar.getInstance();

        year = d.getYear();
        month = d.getMonthValue();
        day = d.getDayOfMonth();

        ageYears = now.get(Calendar.YEAR) - d.getYear();

        Calendar bd = new GregorianCalendar(year, month, day);
        ageYears = now.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
        if(now.before(new GregorianCalendar(now.get(Calendar.YEAR), month, day))){
            ageYears--;
            ageMonths = (12 - (bd.get(Calendar.MONTH) + 1)) + (bd.get(Calendar.MONTH));
            if(day > now.get(Calendar.DAY_OF_MONTH)){
                ageDays = day - now.get(Calendar.DAY_OF_MONTH);
            }
            else if(day < now.get(Calendar.DAY_OF_MONTH)){
                ageDays = now.get(Calendar.DAY_OF_MONTH) - day;
            }
            else{
                ageDays = 0;
            }
        }
        else if(now.after(new GregorianCalendar(now.get(Calendar.YEAR), month, day))){
            ageMonths = (now.get(Calendar.MONTH) - (bd.get(Calendar.MONTH)));
            if(day > now.get(Calendar.DAY_OF_MONTH))
                ageDays = day - now.get(Calendar.DAY_OF_MONTH) - day;
            else if(day < now.get(Calendar.DAY_OF_MONTH)){
                ageDays = now.get(Calendar.DAY_OF_MONTH) - day;
            }
            else
                ageDays = 0;
        }
        else{
            ageYears = now.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
            ageMonths = 0;
            ageDays = 0;
        }

        return ageYears;
    }
}
