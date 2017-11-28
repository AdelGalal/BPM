package psystems.co.bpm.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
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
    String userString;
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
        user = (TextView) findViewById(R.id.tv_user);
        user.setText(userString);
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
       // webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setHorizontalScrollBarEnabled(false);

        //  WebViewDatabase.getInstance(this).clearHttpAuthUsernamePassword();
//        WebSettings ws = webView.getSettings();
//        ws.setSaveFormData(false);
//        ws.setSavePassword(false);
//

//        CookieSyncManager.createInstance(this);
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.removeAllCookie();
//        cookieManager.setAcceptCookie(true);


       // webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        initInjection();
        presenter.startToGetTaskDetailsURL(taskID, token);
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
        Log.e("Task Details Activity", "isSucess");
        Log.e("Task Details Activity", "task url=" + taskURL);
        //String html = "<iframe width=\"400\" height=\"500\" style=\"border: 1px solid #cccccc;\" src=\"" + taskURL + " ></iframe>";
        String html = "<iframe width=\"400\" height=\"500\" style=\"border: 1px solid #cccccc;\"src=\\\"\" + taskURL + \"?width=400&height=500&results=60&dynamic=true\" ></iframe>";
       // webView.loadDataWithBaseURL(null,html, "text/html","UTF-8", null);
        webView.setWebViewClient(new MyWebViewClient());
       // String data_html = "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"target-densitydpi=high-dpi\" /> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" href=\"hdpi.css\" /></head> <body style=\"background:white;margin:0 0 0 0; padding:0 0 0 0;\"> <iframe style=\"background:black;\" width=' "+400+"' height='"+400+"' src=\""+taskURL+"\" frameborder=\"0\"></iframe> </body> </html> ";
//
      webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
//      webView.loadDataWithBaseURL(null,("<iframe width=\"400\" height=\"400\" src=\"" +
//               taskURL+" " + "frameborder=\"0\" allowfullscreen\"></iframe>"), "text/html", "utf-8",null);

   //     webView.loadUrl(taskURL);


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

        if (progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    @Override
    public void showErrorInRequest() {

    }

    //////////////////////////////////////////
//    public String send() {
//        try {
//            // -- Create client.
//            HttpParams httpParameters = new BasicHttpParams();
//            // Set the timeout in milliseconds until a connection is established.
//            int timeoutConnection = 10000;
//            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
//            // Set the default socket timeout (SO_TIMEOUT)
//            // in milliseconds which is the timeout for waiting for data.
//            int timeoutSocket = 10000;
//            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
//
//            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
//            HttpGet httpGet;
//            HttpPost httpPost;
//            HttpDelete httpDelete;
//            HttpResponse httpResponse;
//
//            String authHeader;
//            if( authenticateData != null ) {
//                // -- Set basic authentication in header.
//                String base64EncodedCredentials = Base64.encodeToString(
//                        (authenticateData.username + ":" + authenticateData.password).getBytes("US-ASCII"), Base64.URL_SAFE|Base64.NO_WRAP);
//                authHeader = "Basic " + base64EncodedCredentials;
//            } else {
//                authHeader = null;
//            }
//
//            // -- Send to server.
//            if( method == GET ) {
//                httpGet = new HttpGet(url);
//                if( authHeader != null ) {
//                    httpGet.setHeader("Authorization", authHeader);
//                }
//                httpResponse = httpClient.execute(httpGet);
//            }
//            else if( method == POST) {
//                httpPost = new HttpPost(url);
//                if( authHeader != null ) {
//                    httpPost.setHeader("Authorization", authHeader);
//                }
//                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                httpResponse = httpClient.execute(httpPost);
//            }
//            else if( method == DELETE) {
//                httpDelete = new HttpDelete(url);
//                httpDelete.setHeader("Content-Length", "0");
//                if( authHeader != null ) {
//                    httpDelete.setHeader("Authorization", authHeader);
//                }
//                httpResponse = httpClient.execute(httpDelete);
//            }
//            else {
//                return null;
//            }
//
//            // -- Method 1 for obtaining response.
//        /*
//        InputStream is = httpResponse.getEntity().getContent();
//        // -- Convert response.
//        Scanner scanner = new Scanner(is);
//        // -- TODO: specify charset
//        String response = scanner.useDelimiter("\\A").next();
//
//        */
//
//            // -- Method 2 for obtaining response.
//            String response = new BasicResponseHandler().handleResponse(httpResponse);
//
//
//            return response;
//
//        }
//        catch(SocketTimeoutException exception) {
//            exception.printStackTrace();
//        }
//        catch(ConnectTimeoutException exception) {
//            exception.printStackTrace();
//        }
//        catch(NoHttpResponseException exception) {
//            exception.printStackTrace();
//        }
//        catch(UnknownHostException exception) {
//            exception.printStackTrace();
//        }
//        catch(ClientProtocolException exception) {
//            exception.printStackTrace();
//        }
//        catch(IOException exception) {
//            exception.printStackTrace();
//        }
//
//        return null;
//
//    }
    //////////////////////////////////////////

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
            Log.e("should", "shouldOverrideUrlLoading");
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedHttpAuthRequest(WebView view,
                                              HttpAuthHandler handler, String host, String realm) {
            Log.e("Task details", "onReceivedHttpAuthRequest");
            UserLoggedData userLoggedData = (UserLoggedData) SharedPreference.load_SP_Data(TaskDetailsActivity.this, SharedPreference.SP_USER_INFO, UserLoggedData.class);
            Log.e("Task details", "onReceivedHttpAuthRequest" + userLoggedData.getUserName());
            handler.proceed(userLoggedData.getUserName(), userLoggedData.getPassword());
        }
    }

    public class WebAppInterface {

        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page
         */
        @JavascriptInterface
        public void nextScreen(String pro_cat_id) {

            Log.e("java script", "welcomeeeeeee");
        }
    }
}
