# SpaceXLaunches
An Android app that displays upcoming SpaceX launches for the GITMAD Networking lesson.

## Lesson

TODO(dwitt): Add link to presentation here.

This app is a tutorial on how to use the `Retrofit` library to make
HTTP requests within an Android App. To do this, we request upcoming
launches from the SpaceX API.

Read about the SpaceX API here: https://github.com/r-spacex/SpaceX-API

There are several TODO items throughout the code. Complete the TODO
items to make the app functional.

To see the solution code, see the `solution` branch.

## Steps to finish the app:

1. Add the `INTERNET` permission in AndroidManifest.xml.
2. Create a Retrofit service to get upcoming launches in `LaunchesService.kt`.
3. Set the Base URL for the API.
4. Build the retrofit client and set properties.
5. Assign call to the return of `getUpcomingLaunches` in LaunchesService.
6. Set `launchesRetriever` to the `LaunchesRetriever` class instead of null.
7. Call `getUpcomingLaunches` on `launchesRetriever`, passing the callback function as a parameter.
8. Set the type within `Response` to the type we expect the API to return.

## Final Result

The final app will look like this:

![Final app screenshot](https://i.gyazo.com/86e304a0bcc6229ea8222008cb4e76b0.png)
