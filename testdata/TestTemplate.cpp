#include <iostream>
#include <string.h>

using namespace std;

template <class T>
class TempClass {

    T value;

public:
    TempClass(T item)
    {
        value = item;
    }

    T getValue()
    {
        return value;
    }
};