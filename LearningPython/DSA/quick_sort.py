


def quick_sort(input_array):
    if(len(input_array) < 2):
        return input_array
    
    pivot = input_array[0]

    less = [i for i in input_array[1:] if i < pivot] 
    greater = [ i for i in input_array[1:] if i > pivot]

    return quick_sort(less) + [pivot]  + quick_sort(greater)

 
input_test = [15, 32, 10, 4, 1] #output: [1, 4, 10, 32, 45]
input_test2 = [50, -15,-6,-95] #output: [-95, -15, -6, 50]

print(quick_sort(input_test))
print(quick_sort(input_test2))
