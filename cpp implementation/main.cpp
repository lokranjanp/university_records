#include <bits/stdc++.h>
using namespace std;

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Base class Student
class Student {
protected:
    string USN;
    string S_name;

public:
    // Parameterized constructor
    Student(string usn, string name) : USN(usn), S_name(name) {}

    // Default constructor
    Student() {}

    // Setters and getters
    void setUSN(string usn) {
        USN = usn;
    }

    string getUSN() const {
        return USN;
    }

    void setName(string name) {
        S_name = name;
    }

    string getName() const {
        return S_name;
    }
};

// Derived class UGStudent
class UGStudent : public Student {
private:
    int semester;
    string branch;

public:
    // Parameterized constructor
    UGStudent(){}
    UGStudent(string usn, string name, int sem, string branch) : Student(usn, name), semester(sem), branch(branch) {}

    // Setters and getters
    void setSemester(int sem) {
        semester = sem;
    }

    int getSemester() const {
        return semester;
    }

    void setBranch(string branch) {
        this->branch = branch;
    }

    string getBranch() const {
        return branch;
    }
};

// Derived class PGStudent
class PGStudent : public Student {
private:
    string specialization;
    string UGDegree;

public:
    PGStudent(){}
    // Parameterized constructor
    PGStudent(string usn, string name, string specialization, string UGDegree)
            : Student(usn, name), specialization(specialization), UGDegree(UGDegree) {}

    // Setters and getters
    void setSpecialization(string specialization) {
        this->specialization = specialization;
    }

    string getSpecialization() const {
        return specialization;
    }

    void setUGDegree(string UGDegree) {
        this->UGDegree = UGDegree;
    }

    string getUGDegree() const {
        return UGDegree;
    }
};

// Functions for UG students operations
void UGOperations(vector<UGStudent>& ugStudents) {
    int choice;
    do {
        cout << "----Operations on the UG Students array----" << endl;
        cout << "Options :\n1. Print all records\n2. Change name\n3. Change USN\n4. Change branch\n5. Skip\n";
        cin >> choice;

        switch (choice) {
            case 1: // Printing the array
                for (int i = 0; i < ugStudents.size(); i++) {
                    cout << "Student " << (i + 1) << endl;
                    cout << "    Name : " << ugStudents[i].getName() << endl;
                    cout << "    USN : " << ugStudents[i].getUSN() << endl;
                    cout << "    Semester : " << ugStudents[i].getSemester() << endl;
                    cout << "    Branch : " << ugStudents[i].getBranch() << endl;
                }
                break;

            case 2: { // Changing Student name
                cout << "\nEnter Student USN whose name is to be changed: ";
                string find;
                cin >> find;
                int target = -1;
                for (int j = 0; j < ugStudents.size(); j++) {
                    if (find == ugStudents[j].getUSN()) {
                        target = j;
                        break;
                    }
                }
                if (target == -1) {
                    cout << "Enter valid USN" << endl;
                } else {
                    cout << "Enter new name: ";
                    string name;
                    cin >> name;
                    ugStudents[target].setName(name);
                    cout << "Name updated to: " << ugStudents[target].getName() << endl;
                }
                break;
            }

            case 3: { // Changing Student USN
                cout << "\nEnter student number whose USN is to be changed: ";
                int i;
                cin >> i;
                i--;
                cout << "Enter new USN: ";
                string usn;
                cin >> usn;
                ugStudents[i].setUSN(usn);
                cout << "USN updated\n";
                break;
            }

            case 4: { // Changing Student Branch
                cout << "\nEnter student USN whose branch is to be changed: ";
                string find_usn;
                cin >> find_usn;
                int target_idx = -1;
                for (size_t j = 0; j < ugStudents.size(); j++) {
                    if (find_usn == ugStudents[j].getUSN()) {
                        target_idx = j;
                        break;
                    }
                }
                if (target_idx == -1) {
                    cout << "Enter valid USN" << endl;
                } else {
                    cout << "Enter new branch: ";
                    string branch;
                    cin >> branch;
                    ugStudents[target_idx].setBranch(branch);
                    cout << "Branch updated to: " << ugStudents[target_idx].getBranch() << endl;
                }
                break;
            }

        }
    } while (choice != 5);
}

// Functions for PG students operations
void PGOperations(vector<PGStudent>& pgStudents) {
    int choice_pg;
    do {
        cout << "----Operations on the PG Students array----" << endl;
        cout << "Options :\n1. Print all records\n2. Change name\n3. Change USN\n4. Change Specialization\n5. Exit\n";
        cin >> choice_pg;

        switch (choice_pg) {
            case 1: // Printing complete array contents
                for (int i_pg = 0; i_pg < pgStudents.size(); i_pg++) {
                    cout << "Student " << (i_pg + 1) << endl;
                    cout << "    Name : " << pgStudents[i_pg].getName() << endl;
                    cout << "    USN : " << pgStudents[i_pg].getUSN() << endl;
                    cout << "    Specialization : " << pgStudents[i_pg].getSpecialization() << endl;
                    cout << "    UG Degree : " << pgStudents[i_pg].getUGDegree() << endl;
                }
                break;

            case 2: { // Changing Student name
                cout << "\nEnter Student USN whose name is to be changed: ";
                string find;
                cin >> find;
                int target = -1;
                for (int j = 0; j < pgStudents.size(); j++) {
                    if (find == pgStudents[j].getUSN()) {
                        target = j;
                        break;
                    }
                }
                if (target == -1) {
                    cout << "Enter valid USN" << endl;
                } else {
                    cout << "Enter new name: ";
                    string name;
                    cin >> name;
                    pgStudents[target].setName(name);
                    cout << "Name updated\n";
                }
                break;
            }

            case 3: { // Changing PG USN
                cout << "\nEnter student number whose USN is to be changed: ";
                int i;
                cin >> i;
                i--;
                cout << "Enter new USN: ";
                string usn;
                cin >> usn;
                pgStudents[i].setUSN(usn);
                cout << "USN updated\n";
                break;
            }

            case 4: { // Modifying Student specialization
                cout << "\nEnter Student USN whose specialization is to be changed: ";
                string find_usn;
                cin >> find_usn;
                int target_idx = -1;
                for (int j = 0; j < pgStudents.size(); j++) {
                    if (find_usn == pgStudents[j].getUSN()) {
                        target_idx = j;
                        break;
                    }
                }
                if (target_idx == -1) {
                    cout << "Enter valid USN" << endl;
                } else {
                    cout << "Enter new specialization: ";
                    string new_spec;
                    cin >> new_spec;
                    pgStudents[target_idx].setSpecialization(new_spec);
                    cout << "Specialization updated\n";
                }
                break;
            }

        }
    } while (choice_pg != 5);
}

int main() {
    int number_ug, number_pg;

    cout << "Enter number of UG students: ";
    cin >> number_ug;

    while (number_ug < 3 && number_ug != 0) {
        cout << "Enter number greater than 10: ";
        cin >> number_ug;
    }

    vector<UGStudent> arr_ug();

    cout << "Enter number of PG students: ";
    cin >> number_pg;

    while (number_pg < 3 && number_pg != 0) {
        cout << "Enter number greater than 10: ";
        cin >> number_pg;
    }

    vector<PGStudent> arr_pg();

    // UG student records
    if (number_ug != 0) {
        cout << "Enter details of UG Students:\n";
        for (int i = 0; i < number_ug; i++) {
            string usn, name, branch;
            int sem;
            cout << "Enter name of Student " << (i + 1) << ": ";
            cin >> name;
            cout << "Enter USN: ";
            cin >> usn;
            cout << "Enter semester: ";
            cin >> sem;
            cout << "Enter branch: ";
            cin >> branch;
            arr_ug.emplace_back(usn, name, sem, branch); // Using emplace_back to add UGStudent objects
        }
        UGOperations(arr_ug);
    }

    // PG student records
    if (number_pg != 0) {
        cout << "Enter details of PG Students:\n";
        for (int i = 0; i<number_pg; i++) {
            string usn_pg, name_pg, special, ugdeg;
            cout << "Enter name of Student " << (i + 1) << ": ";
            cin >> name_pg;
            cout << "Enter USN: ";
            cin >> usn_pg;
            cout << "Enter specialization: ";
            cin >> special;
            cout << "Enter UG Degree: ";
            cin >> ugdeg;
            arr_pg.emplace_back(usn_pg, name_pg, special, ugdeg); // Using emplace_back to add PGStudent objects
        }
        PGOperations(arr_pg);
    }

    return 0;
}
