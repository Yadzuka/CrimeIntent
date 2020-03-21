package com.example.crime.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null)
            sCrimeLab = new CrimeLab(context);

        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }

    public void deleteCrime(UUID crimeId) {
        Crime crime = getCrime(crimeId);
        mCrimes.remove(crime);
    }

    public Crime getCrime(UUID id) {
        for(Crime crime : mCrimes)
            if(crime.getId().equals(id))
                return crime;
        return null;
    }
}
