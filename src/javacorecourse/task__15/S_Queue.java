package javacorecourse.task__15;

import java.util.ArrayList;

/**
 Задание 15 (5 баллов): Реализовать потокобезопасную типизированную циклическую очередь фиксированной длинны
 (длинна задается через конструктор и не изменяется все время существования объекта очереди)
 и использовать ее при решении задачи производитель-потребитель.
 Производитель через случайные временные интервалы записывает в очередь объекты,
 а потребитель — считывает. Если очередь заполнена, то производитель ожидает пока в ней появиться свободное место.
 Если очередь пуста, то потребитель ожидает, пока в очереди появиться хотя бы один элемент, чтобы его считать.
 */
public class S_Queue <T> {
    private  T[] myQueue;
    private volatile int count;
    int tail, n, head;
    public S_Queue(int n) {
        myQueue = (T[])new Object[n];
        this.n = n;
    }

    public synchronized void put ( T element ) {
            while (count == n)
            {
                try {
                    wait();
                }
                catch (InterruptedException e ) { e.printStackTrace();}
            }
            notify();
            if(tail == n){
                tail = 0;
                myQueue[tail] = element;
                tail++;
                count++;
            }

            else {
                myQueue[tail] = element;
                tail++;
                count++;
            }
        System.out.println(element + " Has been putted.");
    }

    public synchronized T get() {
        T value;
    while (count == 0)
            {
                try {
                    wait();
                }
                catch (InterruptedException e ) { e.printStackTrace();}
            }
            this.notify();
            if(head == n) {
                head  = 0;
                value = myQueue[head];
                myQueue[0] = null;
                head++;
                count--;
            }
            else {
                value = myQueue[head];
                myQueue[head] = null;
                head++;
                count--;
            }
        System.out.println(value + " Has been gotten and removed.");
        return value;
    }
}
