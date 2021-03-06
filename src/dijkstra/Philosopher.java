/*
 * Copyright 2016 Willian Soares
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

import java.util.Random;

public class Philosopher extends Thread {

    private int chair;
    private Table t;
    Random r = new Random();

    public Philosopher(String name, int chair, Table t) {
        super(name);
        this.chair = chair;
        this.t = t;
    }

    @Override
    public void run() {
        for(int i = 0; i<20; i++) {
            think();
            t.takeFork(chair);
            eat();
            t.putFork(chair);
            t.showStatus();
        }
    }

    /*
    Method used to simulate a philosopher tinking
    */
    public void think() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    /*
    Method used to simulate a philosopher eating
    */
    public void eat() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}

