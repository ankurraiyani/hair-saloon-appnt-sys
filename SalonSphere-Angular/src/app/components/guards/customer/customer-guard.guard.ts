import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthserviceService } from '../../services/common/authservice.service';

export const customerGuardGuard: CanActivateFn = (route, state) => {

  const authService = inject(AuthserviceService)
  const router = inject(Router);

  //if the user is login and the role is cutomer then return true
  if( authService.isLogin() && authService.getRole() == 'customer'){
    return true;
  }
  
  //otherwise  redirect to login page and return false
  router.navigate(['/login']);
  return false;
};
