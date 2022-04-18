def number_of_rectangles(m, n):
    sum = 0
    for x in range(1, m + 1):
        for y in range(1, n + 1):
            sum = sum + (x * y)

    return sum

number_of_rectangles(4, 4)
