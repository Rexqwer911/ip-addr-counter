# Counting Unique IP Addresses with BitSet
## This Java program efficiently counts the number of unique IP addresses present in a given input file. It leverages the BitSet data structure for optimized storage and retrieval.
### Functionality:
1. Input: The program expects a text file containing one IP address per line as input.
2. Processing:
   - It reads the input file character by character using buffering.
   - Each character is processed, and, using bit shifts, we convert each IP to its integer representation.
   - Depending on whether the resulting integer is positive or negative, it is stored either in bitSetPos or bitSetNeg respectively, since the bitset can only accept non-negative integers, and when converting IP we can get a negative value due to the signedness of int.
   - BitSet efficiently stores the presence of each unique integer using a bit, which greatly reduces memory usage compared to storing real IP addresses.
3. Output:
   The program prints the total count of unique IP addresses found in the input file.
   Additionally, it displays the time taken (in milliseconds) to process the file.
### Advantages of using BitSet:
- Memory Efficiency: BitSet uses individual bits to represent the presence or absence of an element, leading to significant memory savings compared to storing the actual IP addresses or using other data structures like HashSet.
- Fast Lookup: Checking if an element is present in the BitSet is a constant-time operation (O(1)), making it extremely efficient for large datasets.
- Counting accuracy: compared to using a bloom filter, which cannot give the exact number of unique IP addresses, using a bitset we can always count the exact number of unique IP addresses.
### How to Use:
1. Input File: Prepare a text file where each line contains a single IP address.
2. Modify File Path: Update the inputFile variable in the code to point to the location of your input file.
3. Compile and Run: Compile the Java code and run the program. The output will display the count of unique IP addresses and the processing time.
### IMPORTANT NOTE:
- The program assumes the input file contains valid IPv4 addresses.
- The approximate processing time for a 100 Gb file is 5 minutes.
