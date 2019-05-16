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
    implementation 'com.github.ma3udmohammadi:Android-Intent-Library:0.2.1'
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
  showAlarms()
  createAlarm(String message, int hour, int minutes, boolean skipUi)
  createAlarm(String message, int hour, int minutes, boolean vibrate, boolean skipUi)
  createAlarm(String message, int hour, int minutes, boolean vibrate, boolean isPm, boolean skipUi)
  ```
  Example
  ```Java
  AlarmIntents.from(this).showAlarms().show();
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
* ### CalculatorIntents(TODO)
  ```Java
  openCalculator()
  ```
  Example
  ```Java
  CalculatorIntents.from(this).openCalculator().show();
  ```
* ### CalendarIntents
* ### CameraIntents
* ### ContactIntents
* ### EmailIntents
* ### EventIntents
* ### FileIntents
* ### GalleryIntents
* ### GeoIntents
* ### MarketIntents
* ### MediaIntents
* ### MessagingIntents
* ### MusicIntents
* ### NoteIntents
* ### PhoneIntents
* ### SearchIntents
* ### SettingIntents
* ### ShareIntents
* ### TextIntents
* ### TimerIntents
