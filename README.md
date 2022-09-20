﻿# JavaLambda

Die Implementierung von anonymen Klassen kann schnell zu schwer lesbarem Java Code führen. In den meisten Fällen ist die Funktionalität der anonymen Klasse sehr speziell und man wünscht sich, einfach diese Funktionalität übergeben zu können. Stattdessen muss sie aber in Form einer anonymen Klasse und dem daraus resultierenden Objekt zur Verfügung gestellt werden. Lambda Expressions ermöglichen und vereinfachen den Umgang mit Funktionen als Methodenparameter deutlich. Ein Beispel sieht so aus : 


 List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
 
 
// Lambda Expression

        Optional<Integer> maxEl = list.stream().reduce(Math::max);

        System.out.println(maxEl);
