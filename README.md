PostBoy
========

HTTP client for Android.

Download
--------

Clone repository and import module: postboy into your project.

Use
------
You need to create object of class PostBoy using its build class in order to call webservices.<br/>
<b>Example</b><br/>
```code
Postboy postboy  = new Postboy.Builder(this,RequestType.DELETE_FORM_DATA,"https://jsonplaceholder.typicode.com/posts/1")
                .create();
```
You need to replace this url with your own.

PostBoy.Builder takes three arguments in its constructor.
>* <b>Context:</b> You can pass null if you don't have context.
>* <b>Reqest Type:</b> You need to pass Request Type. e.g GET, POST, PUT or DELETE etc.
>* <b>Link:</b> Http URL of your webservice you want to call.

To listen to call backs you need to attach listener to postboy object.
PostBoy.setListener(PostboyListener) method is use to add listener.<br/>

<b>Example</b><br/>
```code
postboy.setListener(this);
```

To call webservice you need to use method PostBoy.call().<br/>

<b>Example</b><br/>
```code
postboy.call();
```

Supported Request Types:
-
PostBoy supports followin request types:
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
>* PostBoy.setGETValues(@Nullable HashMap<String, String> keyValue)
>* PostBoy.addGETValue(@NonNull String key,@NonNull String value)

<b>POST, PUT, PATCH, DELETE:</b>
>* PostBoy.setPOSTValues(@Nullable HashMap<String, String> keyValue)
>* PostBoy.addPOSTValue(@NonNull String key,@NonNull String value)

Add Files:
-
To add files you can use following methods:
>* PostBoy.setFiles(@Nullable  HashMap<String, File> keyFiles)
>* PostBoy.addFile(@NonNull  String key,@NonNull  File file)

> <b>Note:</b> Never use these methods with GET or X_WWW_FORM_URLENCODED request types

License
=======

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.