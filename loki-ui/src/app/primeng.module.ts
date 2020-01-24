import { NgModule } from '@angular/core';

import { InputTextModule } from 'primeng/inputtext';
import { FieldsetModule } from 'primeng/fieldset';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';

@NgModule({
    imports: [
        InputTextModule,
        FieldsetModule,
        CardModule,
        ButtonModule,
        DropdownModule
    ],
    exports: [
        InputTextModule,
        FieldsetModule,
        CardModule,
        ButtonModule,
        DropdownModule
    ]
})
export class PrimeNgModule { }
