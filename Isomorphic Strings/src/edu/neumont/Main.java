package edu.neumont;

import edu.neumont.Controller.Controller;

public class Main {

    public static void main(String[] args) {
        new Controller().run();
    }






    /*
    C# Demos

        Dictionaries store key vale pairs!
            No Duplicate keys, meaning they are unique
            Searching by the key is super fast
            Java's version is using a Hashmap to set up dictionaries.

        var myDictionary = new Dictionary<string, list<string>>();

        if (!myDictionary.ContainsKey("010")){
            myDictionary.Add("010", new List<string>());
        }

        myDictionary["010"].Add("New String");

        Stacks
            Push things on to it, first on last off.
        Stack<int> myStack = new Stack<int>();

        Queues
            First on first off, last on last off.
        Queue<int> myQueue = new Queue<int>();

     */
}
