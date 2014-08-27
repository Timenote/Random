package com.terro;

import com.terro.entities.UserRandomResponse;
import com.terro.services.UserServices;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by TeRRo on 27/08/14.
 */
public class Main {

    public static void main(String[] args) {
        RandomUser randomUser = new RandomUser();
        randomUser.setIsDebug(false);

        UserServices userServices = randomUser.userServices();

        // Get one user
        final UserRandomResponse result = userServices.user();
        print(result);

        // Get one collections of users
        UserRandomResponse collectionResult = userServices.listUsers(20);
        print(collectionResult);

        // Get one user with gender
        UserRandomResponse resultGender = userServices.userWithGender(UserServices.MALE);
        print(resultGender);

        // Get one collection of users with gender
        UserRandomResponse collectionResultGender = userServices.listUsersWithGender(20, UserServices.FEMALE);
        print(collectionResultGender);

        // Get one user asynchronous
        userServices.userAsynchronous(listener);

        // Get one collections of users asynchronous
        userServices.listUserAsynchronous(10, listener);

        // Get one user with gender asynchronous
        userServices.userWithGenderAsynchronous(UserServices.MALE, listener);

        // Get one collection of users with gender
        userServices.listUsersWithGenderAsynchronous(10, UserServices.FEMALE, listener);
    }


    static Callback<UserRandomResponse> listener = new Callback<UserRandomResponse>() {
        @Override
        public void success(UserRandomResponse result, Response response) {
            print(result);
        }

        @Override
        public void failure(RetrofitError retrofitError) {

        }
    };

    public static void print (UserRandomResponse result) {
        System.out.println(result.toString());
    }

}
