import { Routes } from '@angular/router';
import { PublisherComponent } from './components/publisher/publisher.component';
import { SubcriberComponent } from './components/subcriber/subcriber.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'publisher', component: PublisherComponent },
    { path: 'subcriber', component: SubcriberComponent },
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: '**', component: NotfoundComponent}
];
