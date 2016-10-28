# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/alex/Library/Android/sdk/tools/proguard/proguard-android.txt
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

# Keeping Line Numbers
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# Keeping DBFlow
-keep class * extends com.raizlabs.android.dbflow.config.DatabaseHolder { *; }
#-dontwarn com.raizlabs.android.dbflow.** # skip warnings

# Keeping Models
-keep class com.meisterlab.dbflowtest.models.** { *; }
# If you are using serialization http://proguard.sourceforge.net/#manual/usage.html#keepnames
#-keepnames class com.meisterlab.dbflowtest.models.** { *; }


##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------