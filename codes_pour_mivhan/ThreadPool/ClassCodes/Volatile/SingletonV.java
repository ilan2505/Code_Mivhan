package Volatile;

public class SingletonV {
	public static volatile SingletonV instance;
	public static SingletonV getInstance(){
		if (instance == null){
			synchronized (SingletonV.class) {
				if (instance == null){
					instance = new SingletonV();
				}
			}
		}
		return instance;
	}
}
/*
synchronized(this) is synchronized on the current object, 
so only one thread can access each instance, 
but different threads can access different instances. 
E.g. you can have one instance per thread.
This is typically useful to prevent multiple threads 
from updating an object at the same time, 
which could create inconsistent state.

synchronized(SomeClass.class) is synchronized on the class 
of the current object (or another class if one wished) 
so only one thread at a time can access any instances of that class.
This might be used to protect data that is shared across 
all instances of a class (an instance cache, perhaps) 
from getting into an inconsistent state 
 */
