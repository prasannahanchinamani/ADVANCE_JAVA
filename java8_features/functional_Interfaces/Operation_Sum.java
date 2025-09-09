package java8_features.functional_Interfaces;
//Functional Interface
public interface Operation_Sum {
     int sum(int a,int b);

     // java 8 features with default method
     default void result(int a,int b){
          System.out.println("Result:"+sum(a,b));
     }
}
