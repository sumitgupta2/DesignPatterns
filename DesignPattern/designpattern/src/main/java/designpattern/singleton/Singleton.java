package designpattern.singleton;

import java.io.Serializable;

class Singleton implements Cloneable, Serializable {
    private volatile static Singleton singletonObject;
    private Singleton() {
        if(singletonObject!= null)  // Condition to handle Java Reflection
            throw new IllegalStateException("Object already created");
    }
    public static Singleton getInstance() {
        if(singletonObject == null) {           //Condition to handle concurrency
            synchronized(Singleton.class){   
                if(singletonObject == null) {
                    singletonObject = new Singleton();
                }
            }
        }
        return singletonObject;
    }
    protected Object clone() throws CloneNotSupportedException{ //Override method to handle Cloning
        throw new CloneNotSupportedException();
    }
    protected Object readResolve(){  //Override method to handle Serialization/Deserialization
        return singletonObject;
    }
}

