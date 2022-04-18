import re
from collections import defaultdict

dr = ("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010;\n"
"+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
"+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
"+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
"<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222!\n"
"<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
"<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
"<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
"<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
"+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
"<P Salinge> Main Street, +1-098-512-2222, Denve\n")

PHONERE = "([\d]{0,2}[-][\d]{3}[-][\d]{3}[-][\d]{4})"
NAMERE = "([\w]+[ ]?['?\w]+(?=>))"

phoneBook = {}
dupEnt = []

def phone(strng, num):
    global phoneBook
    phoneBook = {}
    # Creating the regex values
    rP = re.compile(PHONERE)
    rN = re.compile(NAMERE)
    phNums = rP.findall(strng)
    phName = rN.findall(strng)

    # Trying to filter out to get the addresses
    addressStr = rP.sub("", strng)
    addressStr = rN.sub("", addressStr)
    addressList = [re.sub(r"[^a-zA-Z0-9.-]+", ' ', k).strip() for k in addressStr.split("\n")]

    # Assigning values to the dictionary
    for dIndex in range(0, len(phNums)):
        if phNums[dIndex] in phoneBook:
            dupEnt.append(phNums[dIndex])
        else:
            phoneBook[phNums[dIndex]] = {'name': phName[dIndex], 'address': addressList[dIndex]}

    if num in phoneBook and not num in dupEnt:
        return f"Phone => {num}, Name => {phoneBook[num]['name']}, Address => {phoneBook[num]['address']}"
    elif num in phoneBook and num in dupEnt:
        return f"Error => Too many people: {num}"
    else:
        return f"Error => Not found: {num}"
