## Callables - Runnables -Executors

[x] Executor+Callable Exercici Alumnes que fan un exàmen. Seqüencial i concurrent  
[x] Executor+Runnable Paletes

## Exercici:
Crea un programa que simuli una estació meteorològica senzilla. Hi ha diversos sensors (per exemple, temperatura, humitat, velocitat del vent) que generen lectures aleatòries periòdicament. Cada pocs segons, el programa imprimeix les últimes lectures de tots els sensors.
Requisits:  
 - Cada sensor és una classe que implementa Runnable i actualitza el seu valor a intervals fixos.
 - Una tasca separada imprimeix tots els valors actuals dels sensors a un interval diferent.
 - Utilitza un ScheduledThreadPoolExecutor per programar totes les tasques.

