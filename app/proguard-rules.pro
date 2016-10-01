# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\ANDROID\adt-bundle-windows-x86_64-20140624\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keepattributes EnclosingMetho
-dontoptimize
-dontpreverify

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-dontwarn com.google.**
-keep class com.google.protobuf.** {*;}
-keep public class * extends android.os.IInterface
-keep class de.greenrobot.event.** {*;}
-keepclassmembers class ** {
    public void onEvent*(**);
    void onEvent*(**);
}
-keep class com.alipay.android.app.IAliPay{*;}
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.lib.ResourceMap{*;}
