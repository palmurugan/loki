import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  customerForm: FormGroup;
  customerFormData = CUSTOMER_FORM_DATA;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.customerForm = this.formBuilder.group({
      contacts: this.formBuilder.group({
        firstName: new FormControl('', [Validators.required])
      })
    });
  }

  save() {
    if (this.customerForm.valid) {
      console.log(this.customerForm.value);
    } else {
      console.log('not valid');
    }
  }

}

const CUSTOMER_FORM_DATA: any = {
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
}