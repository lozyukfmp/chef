# Шеф-повар
## Определить иерархию овощей. Сделать салат. Посчитать калорийность. Провести сортировку овощей для салата на основе одного из параметров. Найти овощи в салате, соответствующие заданному диапазону параметров.
* Вывести список салатов: ```salad list```
* Вывести салат (отсортированный по выбранному полю) :
  * ```select salad [имя_салата] [-c|-f|-p|-ch]```
  * Пример: ```select salad Light -c``` выведет ингридиенты салата Light , отсортированные по кол-ву калорий.
* Найти ингредиенты (по полю, принадлежащему определённому диапазону) :
  * ```find [-c|-f|-p|-ch][начало_отрезка, конец_отрезка]```
  * Пример: ```find -f[10, 50]``` выведет ингридиенты выбранного салата c параметром жир , лежащем в диапазоне от 10 до 50; 
* ```-c``` - калории
* ```-f``` - жиры
* ```-p``` - белки
* ```-ch``` - углеводы
