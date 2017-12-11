package psystems.co.bpm.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;
import psystems.co.bpm.injection.zip.DaggerTaskInitiateURLComponent;
import psystems.co.bpm.injection.zip.TaskInitiateURLComponent;
import psystems.co.bpm.injection.zip.TaskInitiateURLModule;
import psystems.co.bpm.presenters.tasks.TaskInitiateURLPresenter;
import psystems.co.bpm.ui.model.UserLoggedData;
import psystems.co.bpm.ui.views.TaskInitiateUrlView;
import psystems.co.bpm.util.SharedPreference;

public class TaskInitiatiableActivity extends AppCompatActivity implements TaskInitiateUrlView {
    private WebView webView;
   // private String token;
    private String initcompositeDN;
    private JavaScriptInterface JSInterface;
    private ProgressDialog progressDialog;
    @Inject
    TaskInitiateURLPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_initiatiable);
       // token = getIntent().getStringExtra("token");
        initcompositeDN=getIntent().getStringExtra("initcompositeDN");
        JSInterface = new TaskInitiatiableActivity.JavaScriptInterface(this);
        initInjection();
        initViews();
        presenter.startToGetTasksInitiateURL(SharedPreference.loadToken(this),initcompositeDN);
    }

    private void initInjection() {

        TaskInitiateURLComponent taskInitiateURLComponent= DaggerTaskInitiateURLComponent.builder()
                .applicationComponent(((BPMApplication) getApplication()).getComponent())
                .taskInitiateURLModule(new TaskInitiateURLModule(this)).build();
        taskInitiateURLComponent.inject(this);

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


    @Override
    public void isSucess(String taskUrl) {
        Log.e("Task Details Activity", "task url=" + taskUrl);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(taskUrl);
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null) {

                    progressDialog = new ProgressDialog(TaskInitiatiableActivity.this);

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
            UserLoggedData userLoggedData = (UserLoggedData) SharedPreference.load_SP_Data(TaskInitiatiableActivity.this, SharedPreference.SP_USER_INFO, UserLoggedData.class);
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
