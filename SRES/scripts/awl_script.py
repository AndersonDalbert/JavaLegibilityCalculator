
def get_awl() :
    filename = '../out/GenericClass_Info.txt'
    data = read_file(filename)
    essential_data = slice_data(data)
    dataframe = create_dataframe(essential_data)
    return calculate_average(dataframe)

def read_file(filename) :
    with open(filename) as f :
        data = list(f)
    return data


def slice_data(data) :
    start = data.index('----------- Terms Frequencies -----------\n')
    end = data.index('---------------- Summary ----------------\n')
    return remove_breaklines( data[start+1:end] )


def remove_breaklines(data) :
    new_data = []
    for line in data :
        new_data.append( line[:-1] )
    return new_data


def create_dataframe(data) :
    dataframe = {}
    for line in data:
        elements = line.split(": ")
        dataframe[elements[0]] = float(elements[1])
    return dataframe


def calculate_average(dataframe) :
    total_length = 0
    total_frequency = 0
    for element in dataframe:
        length = len(element)
        frequency = dataframe[element]
        total_length += length * frequency
        total_frequency += frequency       
    return total_length / total_frequency
    
    
f = open("./../out/awl.txt", 'w')
awl = get_awl()
print( awl, end="", file=f )
f.close()
