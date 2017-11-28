 package psystems.co.bpm.ui.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;
import psystems.co.bpm.api.model.response.LoginDataResponse;
//import psystems.co.bpm.injection.zip.DaggerZipCodeComponent;
import psystems.co.bpm.injection.zip.DaggerZipCodeComponent;
import psystems.co.bpm.injection.zip.ZipCodeComponent;
import psystems.co.bpm.injection.zip.ZipCodeModule;
import psystems.co.bpm.presenters.ZipCodesPresenter;
import psystems.co.bpm.ui.adapter.ZipCodesAdapter;
import psystems.co.bpm.ui.model.UserLoggedData;
import psystems.co.bpm.ui.views.LoginZipsView;
import psystems.co.bpm.util.ActivitySwiping;
import psystems.co.bpm.util.SharedPreference;

 public class LoginActivity extends AppCompatActivity implements LoginZipsView,View.OnClickListener {
     @Inject
     ZipCodesPresenter presenter;

     private ProgressDialog progressDialog;

     private EditText etUserName;

     private EditText etPassword;

     private TextView signin;
     private UserLoggedData userLoggedData;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

         initInjection();

         etUserName = (EditText) findViewById(R.id.tv_username);
         etUserName.setText("mohamed.salem");

         etPassword=(EditText)findViewById(R.id.tv_password);
         etPassword.setText("welcome1");

         signin=(TextView)findViewById(R.id.signin);
         signin.setOnClickListener(this);
         SharedPreference.removeAllKeySP(this);
    }

     private void initInjection() {

         ZipCodeComponent zipCodeComponent = DaggerZipCodeComponent.builder()
                 .applicationComponent(((BPMApplication) getApplication()).getComponent())
                 .zipCodeModule(new ZipCodeModule(this))
                 .build();

         zipCodeComponent.inject(this);

     }

     @Override
     protected void onStart() {
         super.onStart();
         if (SharedPreference.load_SP_Data(this,SharedPreference.SP_USER_INFO,UserLoggedData.class)!=null)
         {
             SharedPreference.removeAllKeySP(this);
         }
     }


     @Override
     public void loginIsSucess(LoginDataResponse loginDataResponse) {
         userLoggedData=new UserLoggedData();
         SharedPreference.removeAllKeySP(this);
         Bundle b=new Bundle();
         userLoggedData.setUserName(etUserName.getText().toString());
         Log.e("LoginActivity","user name="+userLoggedData.getUserName().toString());

         userLoggedData.setPassword(etPassword.getText().toString());

         SharedPreference.save_SP_Data(this,SharedPreference.SP_USER_INFO,userLoggedData);
         Log.e("LoginActivity","saved user name="+SharedPreference.load_SP_Data(this,SharedPreference.SP_USER_INFO,UserLoggedData.class));
         b.putString("userName", loginDataResponse.getWorkFlowContextResponse().getUserDisplayName());
         b.putString("token", loginDataResponse.getWorkFlowContextResponse().getToken());
         ActivitySwiping.goTOAnotherActivityWithBundle(LoginActivity.this,MainActivity.class,b);
     }

     @Override
     public void showWaitingDialog() {
         if (progressDialog == null) {

             progressDialog = new ProgressDialog( this );

             progressDialog.setIndeterminate( true );

             progressDialog.setProgressStyle( ProgressDialog.STYLE_SPINNER );

           //  progressDialog.setTitle( getString( R.string.dialog_title ) );

             progressDialog.setMessage( getString( R.string.dialog_message ) );

         }

         progressDialog.show();
     }

     @Override
     public void hideWaitingDialog() {
         if (progressDialog.isShowing()) {

             progressDialog.hide();

         }
     }


     @Override
     public void showUserNameORPasswordErrorMessage() {
         Toast.makeText(this, R.string.enter_user_name, Toast.LENGTH_SHORT).show();
     }

     @Override
     public void showErrorInRequest() {
         Toast.makeText(this, R.string.request_error, Toast.LENGTH_SHORT).show();
     }

     @Override
     public void onClick(View view) {
         if (view==signin)
         {
             presenter.makeSearch(etUserName.getText().toString(),etPassword.getText().toString().trim());
         }
     }
 }
