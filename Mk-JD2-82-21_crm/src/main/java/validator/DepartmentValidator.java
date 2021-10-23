package validator;

import form.DepartmentForm;

import java.util.ArrayList;
import java.util.List;


public class DepartmentValidator {

    public List<String> validate(DepartmentForm departmentForm)  {
        List<String> errors = new ArrayList<String>();
        String name = departmentForm.getName();

        if (name == null || name.trim().isEmpty()) {
            errors.add("Department must have a name");
        }

        return errors;
    }
}
