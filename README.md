PostBoy
========

HTTP client for Android.

Download
--------

Clone repository and import module: postboy into your project.

Use
------
You need to create object of class PostBoy using its Builder class in order to call webservices.<br/>
<b>Example</b><br/>
```code
PostBoy postBoy  = new PostBoy.Builder(this,RequestType.DELETE_FORM_DATA,"https://jsonplaceholder.typicode.com/posts/1")
                .create();
```
You need to replace this url with your own.

PostBoy.Builder takes three arguments in its constructor.
* <b>Context:</b> You can pass null if you don't have context.
* <b>Request Type:</b> You need to pass Request Type. e.g GET, POST, PUT or DELETE etc.
* <b>Link:</b> Http URL of your webservice you want to call.

To listen to call backs you need to attach listener to postBoy object.
PostBoy.setListener(PostBoyListener) method is use to add listener.<br/>

<b>Example</b><br/>
```code
postBoy.setListener(this);
```

To call webservice you need to use method PostBoy.call().<br/>

<b>Example</b><br/>
```code
postBoy.call();
```

Supported Request Types:
-
PostBoy supports following request types:
* RequestType.GET
* RequestType.POST_FORM_DATA
* RequestType.POST_X_WWW_FORM_URLENCODED
* RequestType.PUT_FORM_DATA
* RequestType.PUT_X_WWW_FORM_URLENCODED
* RequestType.PATCH_FORM_DATA
* RequestType.PATCH_X_WWW_FORM_URLENCODED
* RequestType.DELETE_FORM_DATA
* RequestType.DELETE_X_WWW_FORM_URLENCODED

Add Key and its Values:
-
To add GET,POST,PUT,PATCH,DELETE key and values you can use following methods:

<b>GET:</b>
* PostBoy.setGETValues(@Nullable HashMap<String, String> keyValue)
<br/>or
* PostBoy.addGETValue(@NonNull String key,@NonNull String value)

<b>POST, PUT, PATCH, DELETE:</b>
* PostBoy.setPOSTValues(@Nullable HashMap<String, String> keyValue)
<br/>or
* PostBoy.addPOSTValue(@NonNull String key,@NonNull String value)

Add Files:
-
To add files you can use following methods:
* PostBoy.setFiles(@Nullable  HashMap<String, File> keyFiles)
<br/>or
* PostBoy.addFile(@NonNull  String key,@NonNull  File file)

> <b>Note:</b> Never use these file methods with GET or X_WWW_FORM_URLENCODED request types

Add Headers:
-
To add headers you can use following methods:
* PostBoy.setHeader(@Nullable  HashMap<String, String> keyHeaders)
<br/>or
* PostBoy.addHeader(@NonNull  String key,@NonNull  String value)

> <b>Note:</b> Never use these file methods with GET or X_WWW_FORM_URLENCODED request types

Handle Screen Orientation:
-
If you pass instance of AppCompactActivity to PostBoy.Builder constructor, then it will get attached to that activity and it will retain its instance and it will not get destroyed after you change screen orientation.
So, if you call PostBoy.Builder constructor, after screen orientation change, with same HTTP URL, it will return same object and if connection calling is in progress, PostBoy.call() method will return false until its connection request is completed or failed.

This feature is ON by default. You can turn this feature OFF by calling method:
```code
 PostBoy.Builder.setKeepPersistent(boolean keepPersistent)
 ```
 
 PostBoy Default Settings (Optional):
 -
 You can use Class PostBoyConfig to set default values of PostBoy.
 <br/><b>Example</b>
 ```code
         PostBoyConfig postBoyConfig = new PostBoyConfig()
                 .setDefaultConnectionTimeout(1500)
                 .setDefaultReadTimeout(1500)
                 .setDefaultKeepPersistent(false);
         PostBoy.setDefaultConfigs(postBoyConfig);

 ```
> <b>Note:</b> It is better approach to set PostBoy's default settings in Application.onCreate method.

License
=======

    Copyright 2017.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.