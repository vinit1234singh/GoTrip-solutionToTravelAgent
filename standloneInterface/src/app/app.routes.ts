import { Routes } from '@angular/router';
import { UsersComponent } from './user/user.component';
import { UserDeletionComponent } from './user-deletion/user-deletion.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserDashBoardComponent } from './user-dash-board/user-dash-board.component';
import { ErrorComponent } from './error/error.component';
import { GetSentMessagesComponent } from './get-sent-messages/get-sent-messages.component';
import { MessageComponent } from './message/message.component';
import { TicketComponent } from './ticket/ticket.component';
import { GetTicketComponent } from './get-ticket/get-ticket.component';
import { GetMessageComponent } from './get-message/get-message.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GetEveryTicketComponent } from './get-every-ticket/get-every-ticket.component';
import { filter } from 'rxjs';
import { FilterComponent } from './filter/filter.component';
import { HomePageComponent } from './home-page/home-page.component';
import { SignupComponent } from './signup/signup.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { LeadComponent } from './lead/lead.component';
import { HistoryComponent } from './history/history.component';
import { UserBuyPackageComponent } from './user-buy-package/user-buy-package.component';
import { TourPackageCreateComponent } from './tour-package-create/tour-package-create.component';
import { AdminListPackagesComponent } from './admin-list-packages/admin-list-packages.component';


export const routes: Routes = [
    {path:'register',component:UsersComponent},
    {path:'delete',component:UserDeletionComponent},
    {path:'login',component:UserLoginComponent},
    {path:"userDashBoard",component:UserDashBoardComponent},
    {path:"error",component:ErrorComponent},
    {path:"userInbox",component:GetMessageComponent},
    {path:'ticket',component:TicketComponent},
    {path:'userOutbox',component:GetTicketComponent},
    {path:'dashboard',component:DashboardComponent},
    {path:'adminOutbox',component:GetSentMessagesComponent},
    {path:'messages',component:MessageComponent},
    {path:'adminInbox',component:GetEveryTicketComponent},
    {path:"sent",component:GetSentMessagesComponent},
    {path:'message',component:MessageComponent},
    {path:'adminLogin',component:AdminLoginComponent},
    {path:'admin-signup',component:SignupComponent},
    {path:'updateadmin',component:UpdateProfileComponent},
    {path:'filter', component:FilterComponent},
    {path:'home', component:HomePageComponent},
    {path:'lead',component:LeadComponent},
    {path:'history',component:HistoryComponent},
    {path:'userPackage',component:UserBuyPackageComponent},
    {path:'createPackage',component:TourPackageCreateComponent},
    {path:'listPackage',component:AdminListPackagesComponent},
    {path:'',redirectTo:'/home',pathMatch:'full'},
    {path:'**',component:ErrorComponent}
];
