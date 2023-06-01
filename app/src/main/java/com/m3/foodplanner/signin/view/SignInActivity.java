package com.m3.foodplanner.signin.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.m3.foodplanner.ForgetPasswordActivity;
import com.m3.foodplanner.MainActivity;
import com.m3.foodplanner.R;
import com.m3.foodplanner.signup.view.SignUpActivity;

public class SignInActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 101;
    TextView toSignUp;
    Button loginBtn;
    EditText emailEdit;
    EditText passwordEdit;
    TextView signInGoogle;
    TextView signInFacebook;
    TextView passwordForget;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;


    String emailRegex ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        toSignUp=findViewById(R.id.to_sign_up);
        loginBtn=findViewById(R.id.login_btn);
        emailEdit=findViewById(R.id.sign_in_email_edit_text);
        passwordEdit=findViewById(R.id.sign_in_password_edit_text);
        signInGoogle=findViewById(R.id.loginWithGoogle);
        passwordForget=findViewById(R.id.forget_password);
        progressDialog=new ProgressDialog(this);
//shP
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            // User is already logged in
            goToHome(firebaseUser);
            finish(); // Optional: Close the SignInActivity
        }


        //firebase us/ps
        firebaseAuth=FirebaseAuth.getInstance();

        firebaseUser=firebaseAuth.getCurrentUser();

        //firebase google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient=GoogleSignIn.getClient(this,gso);


        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();

            }
        });
        signInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            progressDialog.setMessage("Google sign in....");
            progressDialog.show();

                Intent signInIntent=googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent,RC_SIGN_IN);
            }
        });
        passwordForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignInActivity.this, ForgetPasswordActivity.class);

                startActivity(intent);

            }
        });
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account =task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            }catch (ApiException e){
                progressDialog.dismiss();
                Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();

            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken){
        AuthCredential credential= GoogleAuthProvider.getCredential(idToken,null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean("isLoggedIn", true);
                            editor.apply();
                            progressDialog.dismiss();

                            firebaseUser= firebaseAuth.getCurrentUser();
                            goToHome(firebaseUser);
                        }
                        else {
                            progressDialog.dismiss();

                            Toast.makeText(SignInActivity.this, ""+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                            finish();


                        }
                    }
                });


    }

    private void goToHome(FirebaseUser user) {
        Intent intent = new Intent( this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();

        startActivity(intent);
    }


    private void performLogin() {
        String email= emailEdit.getText().toString();
        String password =passwordEdit.getText().toString();

        if(!email.matches(emailRegex)){
            emailEdit.setError("enter valid email");}
        else if (password.isEmpty()){

            passwordEdit.setError("enter your password");}
        else {
            progressDialog.setMessage("Login...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        progressDialog.dismiss();
                        Toast.makeText(SignInActivity.this, "sign in is successful", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.putBoolean("isLoggedIn", true);
                        editor.apply();
                        goToHome(firebaseUser);
                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(SignInActivity.this, ""+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

}