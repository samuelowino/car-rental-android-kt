package com.owino.mcarretal.adapter;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.owino.mcarretal.database.Vehicle
import com.owino.mcarretal.views.fragments.RegisterFragment
import com.owino.mcarretal.views.fragments.SigninFragment

class AuthenticationPagerAdapter : FragmentPagerAdapter {

    val vehicles = ArrayList<Vehicle>();

    constructor(fragmentManager: FragmentManager) : super(fragmentManager);

    override fun getCount(): Int {
        return vehicles.size;
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return SigninFragment();
            1 -> return RegisterFragment();
            else -> {
                return SigninFragment();
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Register";
            1 -> return  "Signin";
            else -> {
                return "Signin";
            }
        }
        return super.getPageTitle(position)
    }

}