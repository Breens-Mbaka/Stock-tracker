package com.moringaschool.stocktracker.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moringaschool.stocktracker.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateUserAccount extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.button)
    Button mRegisterUser;
    @BindView(R.id.editTextTextEmailAddress)
    EditText mEmail;
    @BindView(R.id.editTextTextPersonName)
    EditText mNameEditText;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.textView10)
    TextView mLoginTextView;
    @BindView(R.id.firebaseProgressBar)
    ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView)
    TextView mLoadingSignUp;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_account);
        ButterKnife.bind(this);

        mRegisterUser.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginTextView) {
            Intent intent = new Intent(CreateUserAccount.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v == mRegisterUser) {
            registerNewUser();
        }
    }

    private void registerNewUser() {
        mName = mNameEditText.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();

        //validating user input is valid before registering user
        boolean validEmail = validEmail(email);
        boolean validName = validName(mName);
        boolean validPassword = validPassword(password);
        if(!validEmail || !validName || !validPassword) {return;}

        showProgressBar();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        hideProgressBar();

                        if (task.isSuccessful()) {
                            createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()));
                        } else {
                            Toast.makeText(CreateUserAccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CreateUserAccount.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    private boolean validEmail(String email) {
        boolean correctEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if(!correctEmail) {
            mEmail.setError("Please enter a valid email address");
            return false;
        }
        return correctEmail;
    }

    private boolean validName(String name) {
        if (name.equals("")) {
            mNameEditText.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean validPassword(String password) {
        if (password.length() < 6) {
            mPassword.setError("Please create a password containing at least 6 characters");
            return false;
        }
        return true;
    }

    //when user engages with activity attach the authentication state listener
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
        mLoadingSignUp.setText("Sign Up process in Progress");
    }

    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }

    private void createFirebaseUserProfile(final FirebaseUser user) {
        UserProfileChangeRequest addName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();
        user.updateProfile(addName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreateUserAccount.this, "Your display name has been added", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}