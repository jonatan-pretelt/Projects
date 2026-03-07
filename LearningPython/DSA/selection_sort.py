

def find_min(input_list):
    smallest = input_list[0]
    for i in input_list:
        if(i<smallest):
            smallest = i

    return smallest


test = [5,3,5,3,2,1]

test2 = [1,2,3,4,5]


def selection_sort(input_list):
    input_list_copy = input_list.copy()
    sorted_list = []

    for i in range(len(input_list)):
        current_min_index = input_list_copy.index(find_min(input_list_copy))
        sorted_list.append(input_list_copy.pop(current_min_index))
    return sorted_list



print(selection_sort(test))
print(selection_sort(test2))
