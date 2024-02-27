import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: "create", loadComponent:
            () => import("./component/footballer-form/footballer-form.component").then(mod => mod.FootballerFormComponent)
    },
    {
        path: "edit/:id", loadComponent:
            () => import("./component/footballer-form/footballer-form.component").then(mod => mod.FootballerFormComponent)
    },
    {
        path: "**", loadComponent:
            () => import("./component/footballer-list/footballer-list.component").then(mod => mod.FootballerListComponent)
    },
];