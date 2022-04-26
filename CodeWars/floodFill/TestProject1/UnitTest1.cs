using NUnit.Framework;
using System;

namespace TestProject1
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test1()
        {
            var expected = new int[,]
                {{1,4,3},
                 {1,4,4},
                 {2,3,4}};

            var actual = new int[,]
              {{1,2,3},
                {1,2,2},
                {2,3,2}};
  
            CollectionAssert.AreEqual(expected, floodFill.Kata.FloodFill(actual, 0, 1, 4));
        }
    }
}