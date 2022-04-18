try:
    foodName1 = input("Enter in food item name: ")
    if foodName1.isnumeric():
        raise ValueError('Name is a number and not a string')

except ValueError as excpt:
    print(f'{excpt}, could not Cal total')
