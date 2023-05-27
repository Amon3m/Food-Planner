package com.m3.foodplanner.signup.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.m3.foodplanner.MainActivity;
import com.m3.foodplanner.R;
import com.m3.foodplanner.model.SignUpModel;
import com.m3.foodplanner.signin.SignInActivity;

public class SignUpActivity extends AppCompatActivity {
    TextView toSignIn;
    EditText usernameEdit;
    EditText emailEdit;
    EditText passwordEdit;
    Button signupBtn;
    ProgressDialog progressDialog;
    String emailRegex ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    String userRegex ="^(?![0-9])[a-zA-Z0-9_]{3,15}$";
    String passwordRegex="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    FirebaseDatabase db;
    DatabaseReference reference;

    SharedPreferences sharedPreferences;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toSignIn=findViewById(R.id.to_sign_in_txt);
        usernameEdit=findViewById(R.id.sign_up_username_edit_text);
        emailEdit=findViewById(R.id.sign_up_email_edit_text);
        passwordEdit=findViewById(R.id.sign_up_password_edit_text);
        signupBtn=findViewById(R.id.signup_btn);
        progressDialog=new ProgressDialog(this);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);


        firebaseAuth=FirebaseAuth.getInstance();

        firebaseUser=firebaseAuth.getCurrentUser();

        toSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuth();

            }
        });
    }

    private void performAuth() {
        String userName =usernameEdit.getText().toString();
        String email= emailEdit.getText().toString();
        String password =passwordEdit.getText().toString();
        if (!userName.matches(userRegex)){
            usernameEdit.setError("enter valid user name");}
        else if(!email.matches(emailRegex)){
            emailEdit.setError("enter valid email");}
        else if (!password.matches(passwordRegex)){

            passwordEdit.setError("- At least 8 characters.\n" +
                    "- At least one letter (uppercase or lowercase).\n" +
                    "- At least one digit.");}
        else {
            progressDialog.setMessage("Registration...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
//                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                                .setDisplayName(userName)
//                                .build();
//                        firebaseUser.updateProfile(profileUpdates);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", userName);
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.putBoolean("isLoggedIn", true);
                        editor.apply();
                        //firebase Realtime Database
                        SignUpModel user=new SignUpModel(userName,email);
                        db=FirebaseDatabase.getInstance();
                        reference=db.getReference("Users");
                        reference.child(userName).setValue(user);


                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "sign up is successful", Toast.LENGTH_SHORT).show();
                        goToHome();
                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(SignUpActivity.this, ""+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

    private void goToHome() {
        Intent intent = new Intent( this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
