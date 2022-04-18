def fold_array(array, runs):
    actRun = 0
    while actRun < runs:
        #--------
        # Variables
        offset = 0
        firstHalf = []
        secHalf = []

        #-----------------------
        # Spliting the arrays
        if len(array) % 2 != 0:
            offset += 1
        for i in range(0, len(array)//2 + offset):
            firstHalf.append(array[i])
        for j in range(len(array)//2 + offset, len(array)):
            secHalf.insert(0, array[j])

        #-------------------------
        # Putting back together
        array = []
        for r in range(0, len(secHalf)):
            array.append(firstHalf[r] + secHalf[r])
        if offset != 0:
            array.append(firstHalf[len(firstHalf) - 1])

        actRun += 1

    return array




arr = [1, 2, 3, 4, 5]

print(fold_array(arr, 2))
