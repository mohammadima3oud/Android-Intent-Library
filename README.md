# Android-Intent-Library

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
    implementation 'com.github.ma3udmohammadi:Android-Intent-Library:0.2.2'
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
  
  ```
  Example
  ```Java
  
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
  
  ```
  Example
  ```Java
  
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
* ### GeoIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### MarketIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### MediaIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### MessagingIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### MusicIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### NoteIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### PhoneIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### SearchIntents
  ```Java
  
  ```
  Example
  ```Java
  
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
  
  ```
  Example
  ```Java
  
  ```
* ### TextIntents
  ```Java
  
  ```
  Example
  ```Java
  
  ```
* ### TimerIntents
  ```Java
  createTimer(String subject, int seconds, boolean skipUi)
  ```
  Example
  ```Java
  TimerIntents.from(this).createTimer("Run", 180, false).show();
  ```
