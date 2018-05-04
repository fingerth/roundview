# roundview
Round ImageView
> Android之圆角ImageView实现。

> Step 1. Add the JitPack repository to your build file
> 
> Add it in your root build.gradle at the end of repositories:

	
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

> Step 2. Add the dependency

	
```
    dependencies {
	    implementation 'com.github.fingerth:roundview:1.0.0'
	}
```


### 布局xml


```
 <FrameLayout
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="100dp"
        android:background="#fff">


        <ImageView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/colorPrimary" />

        <com.fingerth.round.FingerthRoundView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#0fff"
            fingerth:radius="25dp"
            fingerth:radiusColor="#fff" />


    </FrameLayout>
```
