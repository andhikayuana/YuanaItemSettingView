# ItemSettingView

Simple ItemSettingView and Custom

[![Release](https://jitpack.io/v/andhikayuana/YuanaItemSettingView.svg)](https://jitpack.io/#andhikayuana/YuanaItemSettingView) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-YuanaItemSettingView-green.svg?style=flat )]( https://android-arsenal.com/details/1/6902 )
[![License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square)](https://tldrlegal.com/license/mit-license)


![](example.png?raw=true)

## Installation

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```gradle
dependencies {
    implementation 'com.github.andhikayuana:YuanaItemSettingView:1.0.0'
}
```

## Usage

you can use like this
```xml
<id.yuana.itemsettingview.ItemSettingView
        android:id="@+id/itemNotification"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/selectableItemBackground"
        android:padding="10dp"
        app:settingActionIcon="@drawable/ic_arrow_right"
        app:settingDescription="@string/txt_notifications_desc"
        app:settingDescriptionColor="@android:color/holo_green_light"
        app:settingIcon="@drawable/ic_notifications"
        app:settingLabel="@string/txt_notifications"
        app:settingLabelColor="@android:color/holo_green_dark" />
```
```java
ItemSettingView itemSettingView = (ItemSettingView) findViewById(R.id.itemNotification);

/**
 * available method
 */
itemSettingView.setLabel(R.string.your_label);
itemSettingView.setLabel("string label");
itemSettingView.setDescription(R.string.your_descsription);
itemSettingView.setDescription("string description");
itemSettingView.setIcon(ContextCompat.getDrawable(this, R.drawable.your_icon));
itemSettingView.setActionIcon(ContextCompat.getDrawable(this, R.drawable.your_action_icon));
itemSettingView.setLabelColor(R.color.your_color);
itemSettingView.setDescriptionColor(R.color.your_color);

/**
 * custom action here
 * you can pass all extends view like this
 */
Switch switchNotification = new Switch(this);
switchNotification.setChecked(true);
switchNotification.setOnCheckedChangeListener((buttonView, isChecked) -> {
  //your implementation
});

itemSettingView.setCustomViewAction(switchNotification);

// or you can get custom view like this
Switch customViewAction = (Switch) settingNotification.getCustomViewAction();
customViewAction.setChecked(false);
```

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## Todos

1. ?

## License

MIT License

Copyright (c) 2018 Andhika Yuana

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
