# Tatooine - Frontend

## Project Overview
Finding tattoo artists is a bit tedious when you have to look for them across various social media platforms. As the final group project on the Java Development Bootcamp at Northcoders, my team developed a full-stack mobile app (tatooine) to address this challenge. The app serves as a platform that brings tattoo artists together, where they post pictures of their works with details like the fee and duration included. Other users can see these posts and get the work contacts of the artist behind any tattoo artwork they might be interested in.

## Frontend Overview
The frontend of this project is an Android application. It has functionalities like new user sign-up, post filtering by tattoo style, adding and editing posts, uploading pictures from the local device, and updating a user's profile.

## Running the App
To run the app, fork and clone the repo. 

Then, connect your Android device to your IDE ([Android Studio](https://developer.android.com/studio) recommended) or use the Android emulator.

When the app is up, you can interact with it. (If no data are showing on the home page upon starting the app, then it means the cloud instances of the API and database have been pulled down to eliminate the cost.)

## Layouts
The app comprises different pages, which are listed below as different activities representing different functionalities.

### Home activity
A RecyclerView of all posts in the app. Users can filter the posts by specific styles. A bottom navigation is present here and in most of the other pages, from which a user can navigate between the home page (landing activity), add post page, and profile page.<br/>
<img src="https://github.com/user-attachments/assets/d818bcc3-fbc9-45a6-ae32-11fa310385c6" width="300" height="650"/> <br/>

### Add Post activity
This page allows a signed-in user to create a new post by uploading a picture, selecting the styles of the tattoo artwork from a dropdown list of predefined styles, and stating the fee and duration.<br/>
<img src="https://github.com/user-attachments/assets/85d1c4cc-e030-429c-9216-91e17235ee40"  width="300" height="650"/> <br/>

### Update Post activity
This page allows a signed-in user to update an existing post.<br/>
<img src="https://github.com/user-attachments/assets/fd6decaa-7c6c-474e-ab99-0d76a8344fcc"  width="300" height="650"/> <br/>

### Sign-up/Sign-in Activity
The page for artists to create accounts or sign in to the app to access all functionalities. This page is accessible when a user clicks the Profile button on the bottom navigation bar.<br/>
<img src="https://github.com/user-attachments/assets/79b1658a-11a0-4b79-b334-07b1d736e14c"  width="300" height="650"/> <br/>

### Profile activity
This is the page that shows the details of a registered user, including their profile picture, name, work email, location, and a RecyclerView of their posts.<br/>

<img src="https://github.com/user-attachments/assets/be4eb8d8-b8e5-4b06-aeb5-ae9f6d336c6b" width="300" height="650"/> <br/>

### Update Profile
Here, the user can update their profile.<br/> 
<img src="https://github.com/user-attachments/assets/5aa20c1e-0e95-4bbd-a931-b571895cdb64" width="300" height="650"/> <br/>


## Technologies and Approaches Used
- MVVM architecture
- Layouts written in XML and Material Design
- Functionalities written in Java
- Cloudinary for remote image storage
- Retrofit for HTTP request
- Glide for loading images

## Authors
- Home activity, search functionality, add post activity, update post activity, bottom navigation bar, plus their functionality: Israel Peters (me) 
- Profile activity, sign-up/sign-in activity, edit post activity, plus their functionalities: Jackson M.

