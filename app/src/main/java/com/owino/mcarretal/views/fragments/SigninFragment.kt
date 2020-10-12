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

class SigninFragment : Fragment() {

    private lateinit var emailEditTextView: EditText
    private lateinit var passwordTextView: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sigin,container,false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeResources(view)
    }

    private fun initializeResources(view: View) {
        emailEditTextView = view.findViewById(R.id.profile_email_editText)
        passwordTextView = view.findViewById(R.id.profile_password_editText)
        submitButton = view.findViewById(R.id.sign_in_button)

        submitButton.setOnClickListener {
            val enteredEmail = emailEditTextView.text.toString()
            val enteredPassword = passwordTextView.text.toString()

            val email:String? = Preferences.getUserEmailPref(activity!!.applicationContext)
            val password:String? = Preferences.getUserPasswordPref(activity!!.applicationContext)

            if (email.equals(enteredEmail) && password.equals(enteredPassword)){
                Toast.makeText(context,"Login successful", Toast.LENGTH_LONG).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(context,"Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }

}
