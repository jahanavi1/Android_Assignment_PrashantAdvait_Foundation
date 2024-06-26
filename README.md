#Tasks:

* Image Grid: Show a 3-column square image grid. The images should be centercropped.
* Image Loading: Implement asynchronous image loading using this url.
* Display: User should be able to scroll through at least 100 images.
* Caching: Develop a caching mechanism to store images retrieved from the API in
both memory and disk cache for efficient retrieval.
* Error Handling: Handle network errors and image loading failures gracefully when
fetching images from the API, providing informative error messages or placeholders
for failed image loads.
* Implementation to be done in Kotlin or Java using Native technology.

Note : Here, covering all above point and create small app to loading image with 2 ways..

1. Without Thirdparty Using Cache/Disk though
- Using Retrofit though get the record
- Using Jetpack Compose
- Android Clean Architecture
- Error Handling.. when we get empty image url or invalid image url in that case we are showing place holder image
- implemented in Kotlin
- Using asynchronous image(Coroutines)
- Here, Using Lazy Loading.


2. With Thirpary Using Coill
- Using Retrofit though get the record
- Using Jetpack Compose

Flow of the App

SplashScreen
MainScreen - [Navigation purpose]
HomeScreen - [Two Way - 1. Without Thirdparty 2. With Thirdparty]
Screen1 - [Image loading without Third Party]
Screen2 - [Image loading with Third Party]

![img_2.png](img_2.png)
![image](https://github.com/jahanavi1/Android_Assignment_PrashantAdvait_Foundation/assets/29141891/552c6d46-6e6c-4edf-8bd0-69e5ad5429b4)
![image](https://github.com/jahanavi1/Android_Assignment_PrashantAdvait_Foundation/assets/29141891/52368e89-971d-4431-aa94-db6eacbcc766)
