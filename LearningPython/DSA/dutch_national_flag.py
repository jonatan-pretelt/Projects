def dutch_flag_partition(pivot_index, A):
    pivot = A[pivot_index]
    smaller, equal, larger = 0, 0, len(A)

    while equal < larger:
        if A[equal] < pivot:
            A[smaller], A[equal] = A[equal], A[smaller]
            smaller, equal = smaller + 1, equal + 1
        elif A[equal] == pivot:
            equal += 1
        else: 
            larger -= 1
            A[equal], A[larger] = A[larger], A[equal]
#[45, -20, -50, 35, 6]
test_input = [ 45, 50, 20,35, 6]
#equal 1 smaller 0
# [-20, 45, -50, 35, 6] 
#equal 2 smaller 1
#[-20, -50, 45, 35, 6]
#equal 3 smaller 2
#[-20, -50, 35, 45, 6]
#equal 4 smaller 3
#[-20, -50, 35, 6, 45]
#equal 5 smaller 4

print(test_input)
dutch_flag_partition(0,test_input)
print(test_input)