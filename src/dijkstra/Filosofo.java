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


public class Filosofo {
    Random r = new Random();

    public void pensar() throws InterruptedException{
        int pensar;
        pensar = r.nextInt();
        Thread.sleep(pensar);
    }
    
    public void comer() throws InterruptedException{
        int comer;
        comer = r.nextInt();
        Thread.sleep(comer);
    }
    
    public void pegarGarfo(){
        
    }
    
    public void porGarfo(){
        
    }
    
    public void acaoFilosofo(){
        while(true){
            pensar();
            pegarGarfo();
            comer();
            porGarfo();
            
        }
    }
    
}
