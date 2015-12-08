# cordova-plugin-recentscontrol

## Installation
### Prerequisites
This plugin requires Android API level 21 or higher.

cordova-android 4.x and 5.x are fully compatible with this plugin, as they run at API level 22 and 23 respectively. If you are using an older version of cordova-android, ensure it is version 3.7.1 or higher.

For more information on updating your copy of cordova-cli and/or cordova-android, see [the official docs](https://cordova.apache.org/docs/en/latest/guide/cli/index.html#link-11).

### Installing the plugin

This plugin is not currently available on npm. To install from this repo, run:

```bash
cordova plugin add https://github.com/smcpjames/cordova-plugin-recentscontrol
```

## Configuration
This plugin allows you to set the Recents title bar color and task description for your project.

### config.xml
You can define color and description settings at build time via config.xml. Both color and description preferences are optional; color will default to black, and description to the app name. Under the Android platform tag, set:

``` xml
<preference name="RecentsBackgroundColor" value="#005AAB" />
<preference name="RecentsDescription" value="Foo Bar Baz" />
```

The plugin supports any string from [android.graphics.Color.parseColor()](http://developer.android.com/reference/android/graphics/Color.html#parseColor(java.lang.String)) and hex color strings. Hex strings should be RGB-only, not RGBA.

### JavaScript

You can set color and/or description programmatically. The plugin defines the `RecentsControl` object, which is available after `deviceready`. Methods include:

- RecentsControl.setColor(colorStr)
- RecentsControl.setDescription(desc)
- RecentsControl.setOptions(colorStr, desc)

Arguments are required. setOptions should only be called with non-empty values for `colorStr` and `desc`. See the **config.xml** section above for valid colors.

*Note: if your project includes other platforms, it is recommended to wrap calls to RecentsControl methods in `if(cordova.platformId == 'android')`.*

## Credits

This plugin was originally created by [internrocket, inc](https://internrocket.com/). See License below. This fork was created in order to offer standalone control of Recents without touching the status bar, removing possible "duplication of effort" when also using the official StatusBar plugin.

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
