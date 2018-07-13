from pandas import read_csv

def get_asl() :
    dataFrame = read_csv('./../out/result.csv')
    
    total_entities = len(dataFrame)-1
    total_loc_count = dataFrame.iloc[-1, 2]
    average_loc = total_loc_count / total_entities
    
    return average_loc

f = open("./../out/asl.txt", 'w')
asl = get_asl()
print( asl, end="", file=f )
f.close()
