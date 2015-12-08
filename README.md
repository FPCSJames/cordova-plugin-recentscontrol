# cordova-plugin-recentscolor: Recents title bar color for Android 5.0+

## Installation
### Prerequisites
This plugin requires Android API level 21 or higher.

cordova-android 4.x and 5.x are fully compatible with this plugin, as they run at API level 22 and 23 respectively. If you are using an older version of cordova-android, you must install cordova-android 3.7.1 or higher. 

For more information on updating your copy of cordova-cli and/or cordova-android, see [the official docs](https://cordova.apache.org/docs/en/latest/guide/cli/index.html#link-11).

### config.xml
The plugin supports any string from [android.graphics.Color.parseColor()](http://developer.android.com/reference/android/graphics/Color.html#parseColor(java.lang.String)) and hex color strings.

Set your preferred color in your project's config.xml, within the Android platform tag:

``` xml
<preference name="RecentsBackgroundColor" value="#005AAB" />
```

*Note: Android currently does not support opacity settings for Recents. Hex strings should be RGB-only.*

## Credits

This plugin was originally created by [internrocket, inc](https://internrocket.com/). See License below.

## License
[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Copyright (c) 2015 internrocket, inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
