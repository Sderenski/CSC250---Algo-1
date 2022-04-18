def order_weight(strng):
    # the weight of the numbers is the digits added up
    # Meaning that 101 would equal a weight of 2.
    # So a dictionary of key/value pairs. The key is the sum, while the value is the number string
    # Have to parse the numbers into a list and do a way to add them up
    strList = strng.split(" ")
    strDic = {}

    # The code to split up the array list into a dictionary
    for i in range(0, len(strList)):
        sum = 0
        for l in range(0, len(strList[i])):
            sum = sum + int(strList[i][l])

        if sum in strDic:
            tempList = strDic[sum]
            tempList.append(strList[i])
            tempList.sort()
            strDic[sum] = tempList
        else:
            strDic[sum] = [strList[i]]

    # List them back out in an array
    listKeys = getKeys(strDic)
    listKeys.sort()

    finalStr = ""
    for key in listKeys:
        if isinstance(strDic[key], list):
            for item in strDic[key]:
                finalStr += str(item) + " "

    finalStr = finalStr.strip()
    return finalStr



def getKeys(dict):
    list = []
    for key in dict.keys():
        list.append(key)
    return list


order_weight("103 123 4444 99 2000")
order_weight("2000 10003 1234000 44444444 9999 11 11 22 123")
