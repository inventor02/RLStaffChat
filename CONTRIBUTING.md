# Contributing to RLStaffChat

So you want to contribute? Great! Before you jump in, please read the contributing guidelines in this document and familiarize yourself with them to avoid any...nasty surprises.

## Code Style

There's no dedicated code style for this project however please use common sense and follow the code style that's already present. This includes:

```java
public class MyClass {
    public void myMethod() {
        if(condition) { // no space before the brackets
            makeItSo = true;
        }
        
        try {
            thisMethodHere();
        } catch(Exception e) { // again, no space before brackets; exception is referred to as "e"
            getLogger().severe("Houston, we have a problem.");
        }
    }
}
```

## Pull Requests

Please include a detailed summary of your changes in a pull request. **Test changes before requesting to merge them.**