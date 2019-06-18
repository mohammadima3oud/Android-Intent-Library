[![platform](https://img.shields.io/badge/platform-android-green.svg )](http://developer.android.com/index.html)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android--Intent--Library-green.svg?style=flat )]( https://android-arsenal.com/details/1/7687 )
[![JitPack](https://img.shields.io/github/tag/asyl/ArcAnimator.svg?label=maven)](https://jitpack.io/#ma3udmohammadi/Android-Intent-Library)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)

# Android-Intent-Library
A library which will save you a lot of time from writing the same intent creation code. it consist of many intent creation codes like Share, Contacts, Email and etc,  which you can easily use.

<!--- 
    <table>
	<tbody>
		<tr>
			<td align="center">AllIntents</td>
			<td align="center">SettingIntent</td>
            <td align="center">DialIntent</td>
		</tr>
		<tr>
			<td align="center">
				<img src="" width="341" height="326"/>
			</td>
			<td align="center">
				<img src="" width="341" height="326"/>
			</td>
			<td align="center">
				<img src="" width="341" height="326"/>
			</td>
		</tr>
	</tbody>
</table>
--->
## Contents
* [How to include](#how-to-include)
* [Usage](#usage)
* [List of Intents](#list-of-intents)
* [FAQ](#faq)
* [Hall of Fame](#hall-of-fame)
* [Changelog](#changelog)
* [Contribution](#contribution)
* [License](#license)

## How to include
Add the repository to your project **build.gradle**:

```Gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

And add the library to your module **build.gradle**:

```Gradle
dependencies {
    implementation 'com.github.ma3udmohammadi:Android-Intent-Library:1.0.0'
}
```

## Usage
### Showing the intent immediately


```Java
SettingIntents.from(this).setting().show();
SettingIntents.from(this).applicationSetting().show();
```

### Build the intent and show it your self

```Java
startActivity(SettingIntents.from(this).setting().build());
startActivity(SettingIntents.from(this).applicationSetting().build());
```

## List of Intents
* ### AlarmIntents
  ```Java
  openAlarms()
  createAlarm(String message, int hour, int minutes, boolean skipUi)
  createAlarm(String message, int hour, int minutes, boolean skipUi, boolean vibrate)
  createAlarm(String message, int hour, int minutes, boolean skipUi, boolean vibrate, boolean isPm)
  ```
  Example
  ```Java
  AlarmIntents.from(this).openAlarms().show();
  ```
* ### BrowserIntents
  ```Java
  openBrowser()
  openLink(String url)
  openLink(Uri uri)
  openGoogle()
  ```
  Example
  ```Java
  BrowserIntents.from(this).openBrowser().show();
  ```
* ### CalculatorIntents
  ```Java
  openCalculator()
  ```
  Example
  ```Java
  CalculatorIntents.from(this).openCalculator().show();
  ```
* ### CalendarIntents
  ```Java
  openCalendar()
  ```
  Example
  ```Java
  CalendarIntents.from(this).openCalendar().show();
  ```
* ### CameraIntents
  ```Java
  openPhotoCamera()
  openVideoCamera()
  capturePhoto(Uri location, String fileName)
  captureVideo(Uri location, String fileName)
  ```
  Example
  ```Java
  startActivityForResult(CameraIntents.from(this).openPhotoCamera().build(), RequestTag.IMAGE_CAMERA);
  ```
* ### ContactIntents
  ```Java
  openContacts()
  viewContact(String name)
  editContact(String name)
  editContact(String name, String newEmail)
  insertContact(String name, String phone, String email, String company, String job, String notes)
  pickContact()
  pickSpecificContactData()
  ```
  Example
  ```Java
  ContactIntents.from(this).openContacts().show();
  ```
* ### EmailIntents
  ```Java
  openEmail()
  sendEmail(String to, String subject, String message)
  sendEmail(String[] to, String subject, String message)
  sendEmail(String[] addresses, String[] cc, String[] bcc, String subject, String message)
  ```
  Example
  ```Java
  EmailIntents.from(this).openEmail().show();
  ```
* ### EventIntents
  ```Java
  createEvent(String title, String description)
  createEvent(String title, String description, String location, long begin, long end, int color, boolean allDay)
  ```
  Example
  ```Java
  EventIntents.from(this).createEvent("Birthday", "Make a birthday cake").show();
  ```
* ### FileIntents
  ```Java
  fileChooser()
  pickFile()
  pickImageFile()
  pickImageFile(Boolean allowMultiple, Boolean localOnly)
  ```
  Example
  ```Java
  startActivityForResult(FileIntents.from(this).fileChooser().build(), RequestTag.FILE_CHOOSE);
  ```
* ### GalleryIntents
  ```Java
  openGallery()
  pickImage()
  ```
  Example
  ```Java
  startActivityForResult(GalleryIntents.from(this).pickImage().build(), RequestTag.PICK_IMAGE);
  ```
* ### MapIntents
  ```Java
  locationOf(String address, String placeTitle)
  locationOf(float latitude, float longitude)
  locationOf(float latitude, float longitude, String placeName)
  navigateTo(String address)
  navigateTo(float latitude, float longitude)
  streetViewOf(float latitude, float longitude)
  streetViewOf(float latitude, float longitude, float zoom)
  streetViewOf(float latitude, float longitude, float zoom, int mapZoom)
  showLocationServices()
  ```
  Example
  ```Java
  MapIntents.from(this).locationOf("Champ de Mars, Avenue Anatole France, Paris, France", "Eiffel Tower").show();
  ```
* ### MarketIntents
  ```Java
  showThisAppInMarket()
  showThisAppInGooglePlay()
  showThisAppInAmazon()
  showInMarket(String packageName)
  showInGooglePlay(String packageName)
  showInAmazon(String packageName)
  showGooglePlay()
  searchAppInGooglePlay(String appName)
  ```
  Example
  ```Java
  MarketIntents.from(this).showInMarket("com.instagram.android").show();
  ```
* ### MediaIntents
  ```Java
  playAudio(String url)
  showImage(String url)
  playVideo(String url)
  playYouTubeVideo(String videoId)
  ```
  Example
  ```Java
  MediaIntents.from(this).playYouTubeVideo("gOzdLhJG2EQ").show();
  ```
* ### MessagingIntents
  ```Java
  openMessages()
  createEmptySms()
  createEmptySms(String phoneNumber)
  createEmptySms(String[] phoneNumbers)
  createSms(String body)
  createSms(String body, String phoneNumber)
  createSms(String body, String[] phoneNumbers)
  ```
  Example
  ```Java
  MessagingIntents.from(this).createEmptySms().show();
  ```
* ### MusicIntents
  ```Java
  openPlayMusic()
  ```
  Example
  ```Java
  MusicIntents.from(this).openPlayMusic().show();
  ```
* ### PhoneIntents
  ```Java
  showDialNumber()
  showDialNumber(String phoneNumber)
  callNumber(String phoneNumber)
  ```
  Example
  ```Java
  PhoneIntents.from(this).showDialNumber().show();
  ```
* ### SearchIntents
  ```Java
  searchInGooglePlay(String query)
  searchWeb(String query)
  ```
  Example
  ```Java
  SearchIntents.from(this).searchInGooglePlay("Instagram").show();
  ```
* ### SettingIntents
  ```Java
  setting()
  apnSetting()
  bluetoothSetting()
  dateSetting()
  displaySetting()
  localeSetting()
  securitySetting()
  wifiSetting()
  wirelessSetting()
  accessibilitySetting()
  applicationSetting()
  captioningSetting()
  castSetting()
  dreamSetting()
  airplaneModeSetting()
  inputMethodSetting()
  locationSourceSetting()
  internalStorageSetting()
  memoryCardSetting()
  homeSetting()
  nfcSetting()
  nfcSharingSetting()
  nfcPaymentSetting()
  printSetting()
  privacySetting()
  searchSetting()
  soundSetting()
  syncSetting()
  webViewSetting()
  vpnSetting()
  applicationDetailSetting(String packageName)
  applicationDevelopmentSetting()
  batterySaverSetting()
  dataRoamingSetting()
  deviceInfoSetting()
  hardKeyboardSetting()
  manageApplicationSetting()
  manageWriteSetting()
  networkOperatorSetting()
  notificationListenerSetting()
  usageAccessSetting()
  userDictionarySetting()
  voiceInputSetting()
  vrListenerSetting()
  wifiIpSetting()
  ignoreBatteryOptimizationSetting()
  manageAllApplicationSetting()
  manageDefaultAppsSetting()
  inputMethodSubtypeSetting()
  notificationPolicyAccessSetting()
  ignoreBackgroundDataRestrictionsSetting(String packageName)
  ```
  Example
  ```Java
  SettingIntents.from(this).setting().show();
  ```
* ### ShareIntents
  ```Java
  shareText(String subject, String message)
  shareText(String subject, String message, String chooserDialogTitle)
  ```
  Example
  ```Java
  ShareIntents.from(this).shareText("Subject example","message example").show();
  ```
* ### TimerIntents
  ```Java
  createTimer(String subject, int seconds, boolean skipUi)
  ```
  Example
  ```Java
  TimerIntents.from(this).createTimer("Run", 180, false).show();
  ```
* ### VoiceRecorderIntents
  ```Java
  openVoiceRecorder()
  ```
  Example
  ```Java
  startActivityForResult(VoiceRecorderIntents.from(this).openVoiceRecorder().build(), RequestTag.RECORD_VOICE);
  ```
  
## FAQ
**some intents will return data, which should be handeled in onActivityResult, use .build and startActivityForResult for them.**
  Example
  ```Java
  startActivityForResult(VoiceRecorderIntents.from(this).openVoiceRecorder().build(), RequestTag.RECORD_VOICE);
  ```
  
**Android-Intent-Library doesn't handle the returned data, you need to handle them your self in onActivityResult.**

## Hall of Fame
<!---
<table>
    <tbody>
        <tr>
            <td align="center">
                <a href="https://play.google.com/store/apps/details?id=com.arthurivanets.owly">
	                <img src="https://lh3.googleusercontent.com/FHaz_qNghV02MpQBEnR4K3yVGsbS_0qcUsEHidzfujI3V01zyLp6yo7oK0-ymILdRk9k=s360" width="70" height="70"/>
                </a>
            </td>
            <td align="center"><b>Owly</b></td>
        </tr>
    </tbody>
</table>
--->
> Using Android-Intent-Library in your app and want it to get listed here? Email me at: ma3udmohammadi@gmail.com

## Changelog
See the [CHANGELOG.md](CHANGELOG.md) file.

## Contribution
See the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## License
    Copyright 2019 ma3udmohammadi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
