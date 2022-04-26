using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace floodFill
{
    public class Kata
    {
        static void Main(String[] args) {
            var actual = new int[,]
              {{1,2,3},
                {1,2,2},
                {2,3,2}};

            var array = FloodFill(actual, 0, 1, 4);
            foreach (var item in array)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
            Console.WriteLine("Press to exit... ");
            while (Console.ReadKey().Key != ConsoleKey.Enter)
            {
                //run loop until Enter is press
            }

        }
        // int[,] means that it is a 2D array.. I am just a bozo.. Oops 
        public static int[,] FloodFill(int[,] array, int y, int x, int newValue)
        {
            // The int x & y are the starting coordinates
            if(y < array.Length && x < array.Length)
            {
                int preValue = array[y, x];
                array[y, x] = newValue;
                FloodFillR(array, y, x, newValue, preValue);
            }
            return array;
        }

        private static int[,] FloodFillR(int[,] array, int y, int x, int newValue, int preValue)
        {

            return array;
        }

        private static 

    }
}