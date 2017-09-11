package com.kalamansee.customcomponents;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.kalamansee.model.LoginItem;
import com.kalamansee.utils.ProjectUtil;
import com.kalamansee.view.activity.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ashishthakur on 25/08/17.
 */
public class FacebookLogin {

    private final String TAG = "FacebookLogin";

    Context context;
     CallbackManager callbackManager;
    FacebookResponseListener facebookResponseListener;
    List<String> permissionNeeds = Arrays.asList("public_profile", "email", "user_birthday", "user_friends");
    ProgressDialog progressDialog;

    public FacebookLogin(Context context, FacebookResponseListener facebookResponseListener)
    {
        this.context = context;
        callbackManager = CallbackManager.Factory.create();
        this.facebookResponseListener = facebookResponseListener;
    }

    /**
     * This method is responsible to Login with Facebook
     * */
    public void facebookLogin()
    {
        try
        {
            progressDialog = ProjectUtil.showDialog(context);
            callbackManager = CallbackManager.Factory.create();
            // Set permissions
            LoginManager.getInstance().logInWithReadPermissions((LoginActivity)context, permissionNeeds);

            LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {

                    GraphRequest request = GraphRequest.newMeRequest(
                            loginResult.getAccessToken(),
                            new GraphRequest.GraphJSONObjectCallback() {
                                @Override
                                public void onCompleted(
                                        JSONObject jsonObject,
                                        GraphResponse response) {
                                    final LoginItem loginItem = new LoginItem();
                                    // Application code
                                    try {
                                        String socialId = jsonObject.has("id") ? jsonObject.getString("id") : "";
                                        String profilePicture = "https://graph.facebook.com/" + socialId + "/picture?width=500&height=500";
                                        String firstName = jsonObject.has("first_name") ? jsonObject.getString("first_name") : "";
                                        String lastName = jsonObject.has("last_name") ? jsonObject.getString("last_name") : "";
                                        String email = jsonObject.has("email") ? jsonObject.getString("email") : "";

                                        loginItem.setFirstName(firstName);
                                        loginItem.setLastName(lastName);
                                        loginItem.setSocialId(socialId);
                                        loginItem.setProfileImage(profilePicture);
                                        loginItem.setSocialType("1");
                                        loginItem.setEmail(email);

                                        String gender = jsonObject.has("gender") ? jsonObject.getString("gender") : "";
                                        loginItem.setGender(gender);

                                        String birthday = jsonObject.has("birthday") ? jsonObject.getString("birthday") : "";
                                        loginItem.setDob(birthday);
                                        loginItem.setUserName("");

                                    } catch (JSONException e) {
                                        facebookResponseListener.facebookResponse(loginItem);
                                        ProjectUtil.hideProgressDialog(progressDialog);
                                        e.printStackTrace();
                                    }

                                    facebookResponseListener.facebookResponse(loginItem);
                                    ProjectUtil.hideProgressDialog(progressDialog);
                                }
                            });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id,name,email,birthday,gender,cover,friends,picture.type(large),first_name,last_name");
                    request.setParameters(parameters);
                    request.executeAsync();
                }

                @Override
                public void onCancel() {
                    ProjectUtil.hideProgressDialog(progressDialog);
                }

                @Override
                public void onError(FacebookException error) {
                    ProjectUtil.hideProgressDialog(progressDialog);
                }
            });
        }
        catch (Exception ex)
        {
            ProjectUtil.hideProgressDialog(progressDialog);
            ex.printStackTrace();
        }
    }


    public void logout()
    {
        try
        {
            LoginManager.getInstance().logOut();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public interface FacebookResponseListener
    {
        /**
         * This method is responsible to get the result from Facebook after successfully login
         * @param object profile information in Object
         * */
        void facebookResponse(Object object);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
