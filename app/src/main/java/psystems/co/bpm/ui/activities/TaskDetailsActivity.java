package psystems.co.bpm.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewDatabase;
import android.widget.TextView;

import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;
import psystems.co.bpm.injection.zip.DaggerTaskComponent;
import psystems.co.bpm.injection.zip.DaggerTaskDetailsComponent;
import psystems.co.bpm.injection.zip.TaskDetailsComponent;
import psystems.co.bpm.injection.zip.TaskDetailsModule;
import psystems.co.bpm.injection.zip.TasksModule;
import psystems.co.bpm.presenters.tasks.TaskDetailsPresenter;
import psystems.co.bpm.ui.model.UserLoggedData;
import psystems.co.bpm.ui.views.TaskDetailsView;
import psystems.co.bpm.util.SharedPreference;

public class TaskDetailsActivity extends AppCompatActivity implements TaskDetailsView {
    private String taskID;
    private String token;
    private WebView webView;
    private TextView user;
    private JavaScriptInterface JSInterface;
    private String userString;
    private ProgressDialog progressDialog;
    @Inject
    TaskDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        taskID = getIntent().getStringExtra("taskID");
        token = getIntent().getStringExtra("token");
        Log.e("taskID", "taskID=" + taskID);
        userString = getIntent().getStringExtra("userName");
        JSInterface = new JavaScriptInterface(this);
        user = (TextView) findViewById(R.id.tv_user);
        user.setText(userString);
        initViews();

//        CookieSyncManager.createInstance(this);
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.removeAllCookie();
//        cookieManager.setAcceptCookie(true);

        initInjection();
        presenter.startToGetTaskDetailsURL(taskID, token);
    }

    private void initViews()
    {
        webView = (WebView) findViewById(R.id.webView1);
        webView.addJavascriptInterface(JSInterface, "JSInterface");
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setHorizontalScrollBarEnabled(false);
    }

    private void initInjection() {

        TaskDetailsComponent taskDetailsComponent = DaggerTaskDetailsComponent.builder()
                .applicationComponent(((BPMApplication) getApplication()).getComponent())
                .taskDetailsModule(new TaskDetailsModule(this))
                .build();

        taskDetailsComponent.inject(this);

    }

    @Override
    public void isSucess(String taskURL) {

        Log.e("Task Details Activity", "task url=" + taskURL);
         webView.setWebViewClient(new MyWebViewClient());
         webView.loadUrl(taskURL);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (progressDialog == null) {
            progressDialog.dismiss();
        }
        finish();
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null) {

                    progressDialog = new ProgressDialog(TaskDetailsActivity.this);

                    progressDialog.setIndeterminate(true);

                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                    progressDialog.setMessage(getString(R.string.dialog_message));

                }

                progressDialog.show();
            }
        });

    }

    @Override
    public void hideWaitingDialog() {

//        if (progressDialog.isShowing()) {
//            progressDialog.hide();
//        }
    }

    @Override
    public void showErrorInRequest() {
        if (progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressDialog.show();
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss();
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedHttpAuthRequest(WebView view,
                                              HttpAuthHandler handler, String host, String realm) {
            UserLoggedData userLoggedData = (UserLoggedData) SharedPreference.load_SP_Data(TaskDetailsActivity.this, SharedPreference.SP_USER_INFO, UserLoggedData.class);
            Log.e("Task details", "onReceivedHttpAuthRequest" + userLoggedData.getUserName());
            handler.proceed(userLoggedData.getUserName(), userLoggedData.getPassword());
        }
    }


    public class JavaScriptInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        JavaScriptInterface(Context c) {
            mContext = c;
        }

        @android.webkit.JavascriptInterface
        public void changeActivity()
        {
            Log.e("JavaScriptInterface","change actvivity");
            Intent data = new Intent();
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
