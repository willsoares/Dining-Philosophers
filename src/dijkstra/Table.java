/*
 * Copyright 2016 Willian Soares.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dijkstra;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table {

    private final int N = 5;
    private final int THINKING = 0;
    private final int HUNGRY = 1;
    private final int EATING = 2;
    private int status[];
    private Semaphore s[] = new Semaphore[]{
        new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0)
    };
    private Semaphore mutex;
    private int left, right;

    public Table() {
        status = new int[5];
        mutex = new Semaphore(1);
    }

    public void takeFork(int i) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        status[i] = HUNGRY;
        test(i);
        mutex.release();
        try {
            s[i].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void putFork(int i){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        status[i] = THINKING;
        test(left(i));
        test(right(i));
        mutex.release();
    }
    
    public int left(int i){
        return (i + N - 1) % N;
    }
    
    public int right(int i){
        return (i + N) % N;
    }
    
    public int getStatus(int i){
        return status[i];
    }

    public void test(int i) {
        int LEFT = (i + N - 1) % N;
        int RIGHT = (i + 1) % N;
        if ((status[i] == HUNGRY) && (status[LEFT] != EATING) && (status[RIGHT] != EATING)) {
            status[i] = EATING;
            s[i].release();
        }
    }
    
    public void showStatus(){
        for(int i = 0; i < this.N; i++){
            System.out.printf("Philosopher "+(i+1));
            switch(status[i]){
                case THINKING: System.out.printf("THINKING "); break;
                case HUNGRY: System.out.printf("HUNGRY "); break;
                case EATING: System.out.printf("EATING "); break;
                default: break;
            }
            System.out.printf("\n");
        }
    }
}
