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

public class Dinner {
    public static void main(String[] args) {
        Table t = new Table();
        Thread p0 = new Philosopher("Pratão", 0, t);//"Plato/Platão"
        Thread p1 = new Philosopher("ArisToledo", 1, t);//Aristóteles
        Thread p2 = new Philosopher("Irineu", 2, t);
        Thread p3 = new Philosopher("Treze Manero", 3, t);
        Thread p4 = new Philosopher("Chuck Norris", 4, t);
        
        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
