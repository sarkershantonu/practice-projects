# This package contains probles from main repository

# Link
https://www.devskill.com/CodingProblems/ViewProblem/327

# DCP-327: Critical Encryption : 
A certain mathematician and cryptanalyst after breaking enigma during 2nd world war gave a new encryption mechanism. At that time it was considered unbreakable. Recently, someone was able to break the code. The challenge is whether you can break it on your own or not. Suppose, you are transmitting a list of prime numbers only, you multiply every prime number in the list with a constant greater than 1 which is known only to you and your receiver. Then transmit the modified list. Your receiver can then decrypt the transmission. On the other hand, any interceptor of the transmission will be lost in the ocean on encrypted message without a clue or at least that was expected. 
Now you will be given a list of encrypted numbers, you are to decrypt them. Sometimes the transmitted message may become corrupted that is decrypted numbers might not be prime numbers , these are invalid messages. Also, If there exists only one number in the list, then you can not decrypt it.

# Input:
The first line of input contains an integer T (1<=T<=10) denoting the number of test cases. Next T cases each begins with an integer N (1<=N<=10000) representing the number of element in the list. Next, there will be N non-negative integers which are the transmitted encrypted numbers (each number will be in the range of 0 to 10^16).

# Output:
For each case print the case number and then if the given message cannot be decrypted then print "Can't decrypt" without the quote. Otherwise, if the decrypted message is a valid message according to the statement then print the decrypted message. Otherwise print "Invalid message" without the quote.

# Sample Input

4 
                          
2    
                       
4 10                            

3
0 4 5

2
55 505

1
26

# Sample Output
Case 1: 2 5

Case 2: Invalid message

Case 3: 11 101

Case 4: Can't decrypt

# Solution : TODO