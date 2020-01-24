import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  // @Input()
  dynamicForm: FormGroup;

  //@Input()
  formData: any;

  firstNameId: any = 'firstName'

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.dynamicForm = this.formBuilder.group({
      contacts: this.formBuilder.group({
        firstName: new FormControl('')
      })
    });

    this.formData = {
      "formName": "myForm",
      "components": [
        {
          "label": "Columns",
          "groupName": "contacts",
          "columns": [
            {
              "components": [
                {
                  "label": "First Name",
                  "groupName": "contacts",
                  "formControlName": "firstName",
                  "spellcheck": true,
                  "tableView": true,
                  "validate": {
                    "required": true,
                    "unique": false,
                    "multiple": false
                  },
                  "key": "textField",
                  "type": "textfield",
                  "input": true,
                  "hideOnChildrenHidden": false
                }
              ],
              "width": 6,
              "offset": 0,
              "push": 0,
              "pull": 0
            }
          ],
          "tableView": false,
          "key": "columns",
          "type": "columns",
          "input": false,
          "path": "columns"
        }
      ]
    };

  }

  getCondition(innerForm: string, errorType: string) {
    return (!innerForm) ? "dynamicForm.get(component.formControlName).hasError('" + errorType + "')" :
      "dynamicForm.get('" + innerForm + "').get('address1').hasError('" + errorType + "')";
  }

  save() {
    console.log(this.dynamicForm);
    if (this.dynamicForm.valid) {
      console.log(this.dynamicForm.value);
    } else {
      console.log('not valid');
    }
  }
}