# SFA Mobile Automation Testing

## Overview
This Maven project contains automation scripts for testing an SFA mobile application on iOS/Android. The scripts automate the process of changing the app's language from English to Arabic and navigating through various screens (Login, Explore by category, Edit Profile).

## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or above
- **Maven**: For managing project dependencies
- **Node.js**: Required for running the Appium server
- **Appium Server**: Make sure it's installed and running
- **Android SDK or Xcode**: For running tests on Android/iOS devices
- **Appium Desktop**: Optional, for managing the Appium server and inspecting app elements
- **Device/Emulator**: Set up and configured with the app installed


    - For Android, set up an Android Virtual Device (AVD) or use a physical device.
    - For iOS, configure an iOS Simulator or use a physical device.

## Running Tests

To run all tests, use:
[testng.xml](testng.xml)
mvn test