package com.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class ReactiveTutorial {
    //---------------------------------------------------------------------------------------
                                 //publisher    (Mono)

   //Mono cannot have null    :  Mono.just(null)   then we can use justOrEmpty(null) / Mono.empty()

    private Mono<String> testMono(){
        return Mono.just("Test").log();

    }
//-------------------------------------------------------------------------
                             //publisher      (Flux)

//    private Flux<String> testFlux(){
//        return Flux.just("C","C++","Java");
//
//    }

    //       (works and behave same)


    private Flux<String> testFlux(){
        List<String> data=List.of("C","C++","Java");
        return Flux.fromIterable(data);

    }
//-------------------------------------------------------------------------
                                     //publisher      (Flux)
                                     //TestMap
    private Flux<String> testMap(){
        Flux<String> fluxMapData=Flux.just("C","C++","Java");
        return fluxMapData.map(s ->s.toUpperCase(Locale.ROOT));
    }



//-------------------------------------------------------------------------

                                //publisher      (Flux)
                                //TestFlatMap
    private Flux<String> testFlatMap(){
        Flux<String> fluxMapData=Flux.just("C","C++","Java");
        return fluxMapData.flatMap(s -> Mono.just(s.toUpperCase(Locale.ROOT)));
        //Mono.just(s.toUpperCase(Locale.ROOT))  we added Mono here because we are applying data for one element at a time in flatMap() so we use mono
    }



//-------------------------------------------------------------------------

                                //publisher      (Flux)
                                //TestSkip
    //Example 1
    /*
    private Flux<String> testSkip(){
        Flux<String> fluxSkipData=Flux.just("C","C++","Java","python");
       // return fluxSkipData.skip(2); //skip first 2 element
        return fluxSkipData.delayElements(Duration.ofSeconds(2)).log();//After each element printthere will be delay of 2 second

    }
    */
    //Example 2
  /*
    private Flux<String> testSkip(){
        Flux<String> fluxSkipData=Flux.just("C","C++","Java","python").delayElements(Duration.ofSeconds(2));
        return fluxSkipData.skip(Duration.ofMillis(4040)); //skip first 2 element as for each
                                                         // element it takes 2 seconds so it will skip 4.4 seconds

    }
*/
    //Example 3

    private Flux<String> testSkip(){
        Flux<String> fluxSkipData=Flux.just("C","C++","Java","python").delayElements(Duration.ofSeconds(2));
        return fluxSkipData.skipLast(2); //skip last 2 element as for each


    }

    //-----------------------------------------------------------------------------------------
                                //publisher      (Flux)
                                //TestComplexSkip
    //Example 1  (For Integer)
  /*
    private Flux<Integer> testComplexSkip(){
        Flux<Integer> fluxComplexSkipData=Flux.range(1,20);
        return fluxComplexSkipData; //print from 1 to 20
    }
*/
    //Example 2  (For Integer)
    private Flux<Integer> testComplexSkip(){
        Flux<Integer> fluxComplexSkipData=Flux.range(1,20);
        return fluxComplexSkipData.skipWhile(integer -> integer < 10); //skip data till 10 and print other data
                                                     // can do predicate operations here
    }


//-------------------------------------------------------------------------
                                    //publisher      (Flux)
                                    //TestConcat
   /* private Flux<Integer>TestConcat()
    {
        Flux<Integer> flux1=Flux.range(1,20);
        Flux<Integer> flux2=Flux.range(101,20);
        return Flux.concat(flux1,flux2); //concat flux1 data and flux2 data

    }*/


// -------------------------------------------------------------------------

                                    //publisher      (Flux)
                                    //TestMerge


    /*
    private Flux<Integer>TestMerge()
{
    Flux<Integer> flux1=Flux.range(1,20);
    Flux<Integer> flux2=Flux.range(101,20);
    return Flux.merge(flux1,flux2); //merge flux1 data and flux2 data

}

//-----------------------------------------------------------------------------------
*/

//Q) Both clone and merge work same then what is the different between clone and merge for that
//sol)
private Flux<Integer>TestMerge()
{
    Flux<Integer> flux1=Flux.range(1,5).delayElements(Duration.ofSeconds(1));
    Flux<Integer> flux2=Flux.range(101,5).delayElements(Duration.ofSeconds(1));
    return Flux.merge(flux1,flux2); //merge flux1 data and flux2 data

}
//o/p
    /*
    1
    101
    2
    102
    3
    103
    4
    104
    5
    105
     */

    private Flux<Integer>TestConcat()
    {
        Flux<Integer> flux1=Flux.range(1,5).delayElements(Duration.ofSeconds(1));
        Flux<Integer> flux2=Flux.range(101,5).delayElements(Duration.ofSeconds(1));
        return Flux.concat(flux1,flux2); //concat flux1 data and flux2 data

    }
    /*
    output
    1
    2
    3
    4
    5
    101
    102
    103
    104
     */

/* Note:
If it is in merge both the elements will merge dyamically and print
If it is in concat first it will print first element data after that 2nd element data
  */
// -------------------------------------------------------------------------



//-------------------------------------------------------------------------------

    public static void main(String[] args) throws InterruptedException {
        ReactiveTutorial reactiveTutorial= new ReactiveTutorial();
       //test Mono
        //reactiveTutorial.testMono().subscribe(data -> System.out.println(data));

        //Test Flux
        //reactiveTutorial.testFlux().subscribe(System.out::println);

        //Test Flux  TestMap
        //reactiveTutorial.testMap().subscribe(System.out::println);

        //Test Flux  TestFlatMap
        //reactiveTutorial.testFlatMap().subscribe(System.out::println);

        //Test Flux  TestSkip
       // reactiveTutorial.testSkip().subscribe(System.out::println);
        //Thread.sleep(10_000);

        //Test Flux  TestComplexSkip
       //reactiveTutorial.testComplexSkip().subscribe(System.out::println);

        //Test Flux  TestConcat
        reactiveTutorial.TestConcat().subscribe(System.out::println);
        Thread.sleep(10_000);

        //Test Flux  TestMerge
       // reactiveTutorial.TestMerge().subscribe(System.out::println);
        // Thread.sleep(10_000);
        //note
        /*
         data -> System.out.println(data)
            (works and behave same)
             System.out::println
         */

 ;   }
}
