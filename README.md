# ClimbersBeta

Climbers Beta is a mobile application that helps rock climbers find places to climb outdoors, including a discussion board for climbers to communicate with each other, and descriptions of outdoor climbing routes.

This application helps climbers have a better experience when outdoor climbing by having information available for all the best outdoor crags(rock formations for climbing), detailed descriptions for routes of all types including: bouldering, sport and traditional climbing from fellow climbers. 

This application requires internet access, and Android 4.1. 

Running this application requires the following dependencies: 
(to be added in the build.gradle(module:app))


implementation 'com.loopj.android:android-async-http:1.4.9'

implementation 'com.google.android.gms:play-services-maps:$googlePlayVersion'

implementation 'com.google.android.gms:play-services-location:$googlePlayVersion'

implementation 'com.github.bumptech.glide:glide:4.8.0'

annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'

 implementation 'com.loopj.android:android-async-http:1.4.9'

implementation 'com.android.support:recyclerview-v7:28.0.0'    
 
Will also need to go to sdk manager and enable the following:  
-google play services  
-cmake  
-lldb  
-ndk  


implementation 'org.parceler:parceler-api:1.1.12'


annotationProcessor 'org.parceler:parceler:1.1.12'
 
 Will also need to go to sdk manager and enable the following:  
 -google play services  
 -cmake  
 -lldb  
 -ndk  

<img src="https://github.com/gjc129/ClimbersBeta/blob/master/Route%20Example.png" width=250><br>
