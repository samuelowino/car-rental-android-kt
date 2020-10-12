package com.owino.mcarretal.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.owino.mcarretal.Preferences
import com.owino.mcarretal.R
import com.owino.mcarretal.views.MainActivity
import kotlinx.android.synthetic.main.fragment_sigin.*

class RegisterFragment : Fragment() {

    private lateinit var firstNameTextView: EditText
    private lateinit var lastNameTextView: EditText
    private lateinit var passwordTextView: EditText
    private lateinit var emailEditTextView: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeResources(view)
    }

    private fun initializeResources(view: View) {
        firstNameTextView = view.findViewById(R.id.profile_user_first_name_editText);
        lastNameTextView = view.findViewById(R.id.profile_user_last_name_editText)
        passwordTextView = view.findViewById(R.id.profile_password_editText)
        emailEditTextView = view.findViewById(R.id.profile_email_address_editText)
        submitButton = view.findViewById(R.id.register_button)

        submitButton.setOnClickListener {
            Preferences.setUserEmailPref(activity!!.applicationContext, emailEditTextView.text.toString())
            Preferences.setUserPasswordPref(activity!!.applicationContext,passwordTextView.text.toString())
            Toast.makeText(activity?.applicationContext,"Registration successful", Toast.LENGTH_LONG).show()
            val intent = Intent(activity?.applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
